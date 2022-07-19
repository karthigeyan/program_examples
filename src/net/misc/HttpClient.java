package net.misc; /**
Basic HTTP get request implementation using plain socket programming.

Refer:
http://www.ntu.edu.sg/home/ehchua/programming/webprogramming/HTTP_Basics.html
http://www.slideshare.net/ChuongMai/http-protocol-basic?related=2
http://www.jmarshall.com/easy/http/
http://www.slideshare.net/bipin/http-protocol-and-other-stuff-by-bipin-upadhyay?related=3

ToDo:
1. implement HTTP POST request
*/


import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
public class HttpClient {

	public static void getRequest(String host, int port, String infile, String outfile) {

		BufferedOutputStream fileOut = null;
		Socket socket = null;
		PrintWriter sockOut = null;
		InputStream sockIn = null;


		try {

			fileOut = new BufferedOutputStream(new FileOutputStream(outfile));
			socket = new Socket(host, port);
			sockIn = socket.getInputStream();

			sockOut = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

			//basic http get request format
			String getReq = "GET /" + infile + " HTTP/1.0\n\n";

			sockOut.println(getReq); // send request to server
			sockOut.flush();  

			byte[] buffer = new byte[4096];
			int bytesRead;
			//read http reponse from the server
			while((bytesRead = sockIn.read(buffer)) != -1) {
				fileOut.write(buffer, 0, bytesRead);
			}

		}
		catch (Exception e) {    
			e.printStackTrace();
		} finally {
			closeStream(socket);
			closeStream(fileOut);
		}


	}

	private static void closeStream(Closeable stream) {
		if( stream != null ) {
			try {
				stream.close();
			}catch(IOException ie) {}
		}
	}



	public static void main(String[] args) {
		String host = "localhost"; //url eg.  www.google.com
		int port = 8000; // 80 default
		String infile = ""; // "index.html"; // http get request  filename or could be empty string
		String outfile = "index.html"; // localfile where http response will be saved.

		getRequest(host, port, infile, outfile);

	}
}
