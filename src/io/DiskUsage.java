package io;/*
WHAT?
Program to find disk usage  of the given directory(like du command in Linux).

Refer: https://docs.oracle.com/javase/7/docs/api/java/io/File.html

HOW?
1. get the directory name
2. check wether it is a file or directory
3. if it file and get file size return
4. else if it is directory and get list of files in that directory
5. iterate file list 
6. if it is file and add file size 
7. else if it is  directory then recursively call this algorithm
8. print disk usage
9. done

*/

import java.io.File;
import java.util.Arrays;

public class DiskUsage{

	public static long findDiskUsage(File dir ) {

		long usage = 0;

		if (dir.isFile()) {
			usage = dir.length();

		} else {  // it is a directory

			File[] files = dir.listFiles();
			Arrays.stream(files).map(file -> {
				System.out.println(file.getName());
				return file.listFiles();
			});
			Arrays.stream(files).forEach(System.out::println);
			System.out.println("Length : "+ files.length);

			for (File file : files) {
				if (file.isFile()) {
					usage += file.length();
				} else {
					usage += findDiskUsage(file); //recursive call if it is a directory
				}
			}
		}
		return usage;
	}

	public static void main(String[] args) {
		if( args.length != 1 ) {
			System.out.println("usage: java DiskUsage directory");
			System.exit(-1);
		}

		System.out.println(findDiskUsage( new File(args[0])));

	}
}
