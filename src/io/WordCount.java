package io;/*
WHAT?
Program to find word count and line count in a file (like linux commmand  "wc")

Refer:
https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html


HOW?
1. get the filename
2. create new BufferedReader for the given file
3. read a line
4. increment line count
5. split line into words and increment word count
6. find character count in the line and increment character count
7. goto step 3 till end of file is reached.
8. print line count, word count and character count
9. done

*/

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {

	static void countWord(String fileName)  {

		BufferedReader reader  =  null;
		int wordCnt = 0;
		int lineCnt = 0;
		int charCnt = 0;
		String line = null;

		try {
			reader = new BufferedReader( new FileReader(fileName));

			while(( line = reader.readLine()) != null ) { // null will be returned when it reaches end of file
				lineCnt++;
				String[] words = line.split("\\s+"); //space or tabs
				wordCnt += words.length;
				charCnt += line.length();
			}
		}catch(IOException ie ) {
			ie.printStackTrace();
		}finally {
			closeStream(reader);
		}
		System.out.println(lineCnt + "\t" + wordCnt + "\t" + charCnt);
	}


	private static void closeStream(Closeable stream) {
		if( stream != null ) {
			try {
				stream.close();
			}catch(IOException ie1) {}
		}
	}



	public static void main(String[] args) {

		if( args.length != 1 ) {
			System.out.println("usage: java WordCount file");
			System.exit(-1);
		}

		countWord(args[0]);
	}

}
