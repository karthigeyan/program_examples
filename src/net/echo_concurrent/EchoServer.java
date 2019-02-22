package net.echo_concurrent;

import java.io.*;
import java.net.*;

public class EchoServer {

	private int port;
	private ServerSocket ss = null;
	
	public EchoServer(int port) {
		this.port = port;
	}

	public void startServer() {
		try {
			ss  = new ServerSocket(port);
			acceptClient();
		} catch(IOException ie) {
			ie.printStackTrace();
		}
	}

	public void acceptClient() {
		try {
			while(true) {
				Socket clientSock = ss.accept();
				System.out.println("Connection Established...");
				Thread clientThread = new Thread(new EchoHandler(clientSock));
				clientThread.start();
			}
		} catch(IOException ie) {
			ie.printStackTrace();
		}finally {
			closeStream(ss);
		}
	}

	static void closeStream(Closeable stream) {
		if( stream != null ) {
			try {
				stream.close();
			}catch(IOException ie1) {}
		}
	}

	class EchoHandler implements Runnable {

		Socket clientSock = null;
		BufferedReader br = null;
		PrintWriter pw = null;

		public EchoHandler(Socket clientSock) {
			this.clientSock = clientSock;
		}

		public void run() {
			try {
				String line;
				br = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
				pw = new PrintWriter(clientSock.getOutputStream());

				while( (line = br.readLine()) != null) {
					System.out.println("From client: "+line);
					pw.println(line);
					pw.flush();
				}
				System.out.println("Connection closed...");
			} catch(IOException ie) {
				ie.printStackTrace();
			}
			finally {
				closeStream(pw);
				closeStream(br);
				closeStream(clientSock);
			}
		}
	}

	public static void main(String[] args) {
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


