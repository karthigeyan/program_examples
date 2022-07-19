package net.echo_nio; /**
Refer: http://rox-xmlrpc.sourceforge.net/niotut/#The server

*/

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Set;


class EchoServer {

    private static final  int MESG_BUF_SIZE = 4096;
	private Selector selector;
	private int port;

	public EchoServer(int port) {
		this.port = port;
	}


	
	public void startServer() {
		try {
			ServerSocketChannel serverChannel = ServerSocketChannel.open();
			selector = Selector.open();
			
			serverChannel.socket().bind(new InetSocketAddress(port),100);
			serverChannel.configureBlocking(false);
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);

			listen();

		}catch(Exception ie) {
			ie.printStackTrace();
		}
	}

	private void listen() throws Exception
	{
		while(true) {

			selector.select();
			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> it = keys.iterator();

			while (it.hasNext()) {
				SelectionKey key =  it.next();
				it.remove();

				try {
					if(key.isAcceptable()) {
						handleAccept(key);
					} else if(key.isReadable()) {
						handleEchoRequest(key);
					}
				} catch(Exception e) {
					e.printStackTrace();
					close(key);
				}
			}
		}
	}

	private static class EchoMessage
	{
		int length;
		byte[] mesgBuf;
		ByteBuffer buffer=ByteBuffer.allocate(MESG_BUF_SIZE);
		int bytesRead;
		boolean headerRead = false;
		String clientHost;
	}


	private  void handleEchoRequest(SelectionKey key) throws Exception {

		CharsetEncoder enc = Charset.forName("UTF-8").newEncoder();
		EchoMessage echoMsg =(EchoMessage)key.attachment();
		ByteBuffer buff=echoMsg.buffer;
		SocketChannel channel=(SocketChannel)key.channel();


		int bytesRead=channel.read(buff);
		if(bytesRead==-1) {
			close(key);
			return;
		}

		if( buff.position() >= 4) {
			//convert into integer;
			echoMsg.headerRead = true;
			byte[] lbuf = new byte[4];
			for(int i=0; i<4; i++) {
				lbuf[i] = buff.get(i);
			}
			echoMsg.length = byteArrayToInt(lbuf);
		}
		if( echoMsg.headerRead  && ( buff.position() == echoMsg.length+4) ) {
			byte[] array;
			buff.flip();
			array = buff.array();
			String mesg = new String(array,4,echoMsg.length);
			System.out.println(echoMsg.clientHost + " "  +  mesg);

			channel.write(enc.encode(CharBuffer.wrap(mesg+"\n")));
			//clear echoMesg 
			echoMsg.buffer.clear();
			echoMsg.headerRead = false;
			echoMsg.bytesRead = 0;
			echoMsg.length = 0;
			return;
		}
		if(!buff.hasRemaining()) {
			System.out.println("buffer full...");
			close(key);
			return;
		}

		key.interestOps(SelectionKey.OP_READ);
	}

	private void handleAccept(SelectionKey key) throws Exception {
		ServerSocketChannel serverSocket=(ServerSocketChannel)key.channel();
		SocketChannel socketCh=serverSocket.accept();
		socketCh.configureBlocking(false);
		SelectionKey readKey=socketCh.register(selector, SelectionKey.OP_READ);
		EchoMessage echoMesg = new EchoMessage();
		InetSocketAddress saddr = (InetSocketAddress)socketCh.getRemoteAddress();
		echoMesg.clientHost = "[" + saddr.getHostString() + ":" + saddr.getPort() + "]";
		readKey.attach(echoMesg);
		System.out.println("handleAccept complete with "+key);
	}

	 private int byteArrayToInt(byte[] bytes) throws Exception {
		 if( bytes.length <4) {
			 throw new Exception("can not convert byte array to integer");
		 }
		 return bytes[0] << 24 | (bytes[1] & 0xFF) << 16 | (bytes[2] & 0xFF) << 8 | (bytes[3] & 0xFF);
	 }


	private  void close(SelectionKey key) {
		try {
			Channel ch=key.channel();
			key.cancel();
			ch.close();
		} catch(Exception excp) {
			excp.printStackTrace();
		}
	}

	public static void main(String args[] ) throws Exception{

		int port;
		if( args.length != 1) {
			System.out.println("usage: java EchoServer port");
			System.exit(-1);
		}
		port = Integer.parseInt(args[0]);
			
		EchoServer server=new EchoServer(port);
		server.startServer();
	}
	
}
