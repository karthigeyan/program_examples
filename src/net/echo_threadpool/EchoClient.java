package net.echo_threadpool;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class EchoClient
{
	private String serverHostName;
	private int port;

	public EchoClient(String host, int port ) {
		serverHostName = host;
		this.port = port;
	}

	private void  sendRequest() {

		Socket client = null;
		PrintWriter pw  = null;
		BufferedReader br = null;
		BufferedReader bin=null;

		try {
			client = new Socket(serverHostName, port);
			pw = new PrintWriter(client.getOutputStream());
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		} catch(IOException ie) {
			ie.printStackTrace();
		}

		try {
			String inputStr;
			while(true) {
				System.out.print(">> ");
				bin = new BufferedReader(new InputStreamReader(System.in));
				inputStr = bin.readLine();
				pw.println(inputStr);
				pw.flush();
				System.out.println("From server: "+br.readLine());
			}
		} catch(IOException ie) {
			ie.printStackTrace();
		} finally {
			closeStream(br);
			closeStream(pw);
			closeStream(bin);
			closeStream(client);
		}
	}

	private void closeStream(Closeable stream) {
		if( stream != null ) {
			try {
				stream.close();
			}catch(IOException ie1) {}
		}
	}



	public static void main(String[] args)
	{

		int port;
		String host;
		if( args.length != 2) {
			System.out.println("usage: java EchoClient server_hostname port");
			System.exit(-1);
		}
		host = args[0];
		port = Integer.parseInt(args[1]);

		EchoClient client = new EchoClient(host, port);
		client.sendRequest();

	}

}
