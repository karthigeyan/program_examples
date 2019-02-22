package net.echo_iterative;/*

*/

import java.io.*;
import java.net.*;
public class EchoServer 
{

	private int port;
	private ServerSocket ss = null;

	public EchoServer(int port)
	{
		this.port = port;
	}

	public void startServer()
	{
		try {
			ss = new ServerSocket(port);
			acceptClient();
		} catch(IOException ie) {
			ie.printStackTrace();
		} finally {
			closeStream(ss);
		}
	}


	private void acceptClient() {

		while(true) {
			try {
				Socket clientSock = ss.accept();
				processClientRequest(clientSock);
			} catch(IOException ie) {
				ie.printStackTrace();
			}
		}

	}

	private void processClientRequest(Socket clientSock) {

		BufferedReader br = null;
		PrintWriter pw = null;
		String str;

		try {
			br = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
			pw = new PrintWriter(clientSock.getOutputStream());
		} catch(IOException ie) {
			ie.printStackTrace();
		}

		try {
			while(true) {
				str = br.readLine();
				System.out.println("From Client: "+str);
				if(str == null) {
					break;
				}
				pw.println(str);
				pw.flush();
			}
			System.out.println("Connection Closed...");

		}
		catch(IOException ie) {
			ie.printStackTrace();
		}
		finally {
			closeStream(pw);
			closeStream(br);
			closeStream(clientSock);
		}
	}

	private void closeStream(Closeable stream) {
		if( stream != null ) {
			try {
				stream.close();
			}catch(IOException ie1) {}
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



