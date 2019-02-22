package io;/*
WHAT?

Program to copy a file  from source to destination.

Refer:
https://docs.oracle.com/javase/7/docs/api/java/io/FileInputStream.html
https://docs.oracle.com/javase/7/docs/api/java/io/FileOutputStream.html
https://docs.oracle.com/javase/7/docs/api/java/io/BufferedOutputStream.html
https://docs.oracle.com/javase/7/docs/api/java/io/BufferedInputStream.html


HOW?
1. get source and destination file
2. create new FileInputStream for the source file
3. create new FileOutputStream for the destination file
4. read 4k bytes from the input stream and write it into output stream
5. goto step 4 till end of file is reached.
6. done

*/

import java.io.*;

public class FileCopy {

	static void copyFile(String srcFile, String dstFile)  {

		byte buff[] = new byte[4096];
		int n;
		FileInputStream fin =  null;
		FileOutputStream fout = null;

		try {
			fin = new FileInputStream(srcFile);
			fout = new FileOutputStream(dstFile);

			while(( n = fin.read(buff)) >0 ) {

				fout.write(buff, 0, n);
			}

		}catch(IOException ie ) {
			ie.printStackTrace();
		}finally {

			closeStream(fin);
			closeStream(fout);
		}
		System.out.println(srcFile + " has been copied to "+ dstFile);
	}


	static void bufferedFileCopy(String srcFile, String dstFile)  {

		byte buff[] = new byte[4096];
		int n;
		BufferedInputStream bin =  null;
		BufferedOutputStream bout = null;

		try {
			bin = new BufferedInputStream(new FileInputStream(srcFile));
			bout = new BufferedOutputStream(new FileOutputStream(dstFile));

			while(( n = bin.read(buff)) >0 ) {

				bout.write(buff, 0, n);
			}

		}catch(IOException ie ) {
			ie.printStackTrace();
		}finally {

			closeStream(bin);
			closeStream(bout);
		}
		System.out.println(srcFile + " has been copied to "+ dstFile);
	}


	private static void closeStream(Closeable stream) {
		if( stream != null ) {
			try {
				stream.close();
			}catch(IOException ie1) {}
		}
	}



	public static void main(String[] args) {

		if( args.length != 2 ) {
			System.out.println("usage: java FileCopy source_file dest_file");
			System.exit(-1);
		}

		//copyFile(args[0], args[1]);
		bufferedFileCopy(args[0], args[1]);

	}

}
