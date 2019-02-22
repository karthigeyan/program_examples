package io; /**
WHAT?
Program to find files which matches the given pattern as command line argument(like find -name "*.java" in Linux)

Refer: http://docs.oracle.com/javase/7/docs/api/java/lang/String.html
	   https://docs.oracle.com/javase/7/docs/api/java/io/File.html

HOW?
1. get directory name and pattern 
2. convert pattern into regular expression pattern.eg '*' will be converted into '.*' 
3. get file list for the given directory
4. iterate each file 
5. if it is a regular file and check whether it matches the given pattern. if it maches then print the file name
6. if it is a directory then goto step 3( recursive call)
7. done

*/
import java.io.*;
public class FindFile {

	public static void findFile(File  dir, final String pattern) {

		if (dir.isDirectory()) {

			File[] files = dir.listFiles();

			for (File file : files) {
				if (file.isFile()) {
					if( file.getName().matches(pattern)) { //check whether file name matches the given pattern
						System.out.println(file.getAbsoluteFile());
					}
				} else {
					findFile(file,pattern); //recursive call if it is a directory
				}
			}
		}

	}


	public static void main(String[] args) {
		if( args.length != 2 ) {
			System.out.println("usage: java FindFile directory pattern");
			System.exit(-1);
		}
		
		String pattern = args[1];
		File dir = new File(args[0]);

		if( ! dir.isDirectory() ) {
			System.out.println("Ivalid Argument: Directory is expected");
			System.exit(-1);
		}
		pattern = pattern.replace("*", ".*"); // change * into .* for regular expression pattern
		findFile(dir,  pattern);
	}
}
