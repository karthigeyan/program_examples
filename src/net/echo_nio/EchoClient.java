package net.echo_nio;

import java.io.*;
import java.net.*;
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
		DataOutputStream out = null;
		BufferedReader br = null;
		BufferedReader bin=null;

		try {
			client = new Socket(serverHostName, port);
			out  = new DataOutputStream(client.getOutputStream());
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
				byte[] buf = inputStr.getBytes();
				out.writeInt(buf.length);
				out.write(buf,0,buf.length);

				System.out.println("From server: "+br.readLine());
			}
		} catch(IOException ie) {
			ie.printStackTrace();
		} finally {
			closeStream(br);
			closeStream(out);
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
