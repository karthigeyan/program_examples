package io; /**
Implementing an input stream which limits the number of bytes to be read.

Refer:
http://docs.oracle.com/javase/7/docs/api/java/io/FilterInputStream.html

http://guava-libraries.googlecode.com/git-history/fde657f56c4d75717ffcce670230782d84906c89/guava/src/com/google/common/io/LimitInputStream.java

It extends the FilterInputStream  and override the following methods
1. int available()
2. void mark(int)
3. int read()
4. int read(byte[], int, int)
5. voir reset()
6. long skip(long)
*/


import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class LimitInputStream extends FilterInputStream {

  private long left;
  private long mark = -1;

  public LimitInputStream(InputStream in, long limit) {
    super(in);
    left = limit;
  }

  @Override 
  public int available() throws IOException {
    return (int) Math.min(in.available(), left);
  }

  @Override 
  public synchronized void mark(int readlimit) {
    in.mark(readlimit);
    mark = left;
  }

  @Override 
  public int read() throws IOException {
    if (left == 0) {
      return -1;
    }

    int result = in.read();
    if (result != -1) {
      --left;
    }
    return result;
  }

  @Override 
  public int read(byte[] b, int off, int len) throws IOException {
    if (left == 0) {
      return -1;
    }

    len = (int) Math.min(len, left);
    int result = in.read(b, off, len);
    if (result != -1) {
      left -= result;
    }
    return result;
  }

  @Override 
  public synchronized void reset() throws IOException {
    if (!in.markSupported()) {
      throw new IOException("Mark not supported");
    }
    if (mark == -1) {
      throw new IOException("Mark not set");
    }

    in.reset();
    left = mark;
  }

  @Override 
  public long skip(long n) throws IOException {
    n = Math.min(n, left);
    long skipped = in.skip(n);
    left -= skipped;
    return skipped;
  }


  public static void main(String[] args) throws IOException {

	  if( args.length != 2) {
			System.out.println("usage: java LimitInputStream file limit");
			System.exit(-1);
	  }

	  LimitInputStream lin = null;
	  int limit  = Integer.parseInt(args[1]);

	  try {
		  lin = new LimitInputStream (new FileInputStream(args[0]), limit);
		  byte[] buffer = new byte[128];
		  int bytesRead = 0;

		  while( (bytesRead = lin.read(buffer, 0, 128)) > 0)  {
			  System.out.println("Bytes Read : "  + bytesRead);
		  }

	  }catch(IOException ie) {
		  ie.printStackTrace();
	  }finally {
		  if ( lin != null) {
			  lin.close();
		  }
	  }
  }
}
