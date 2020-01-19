package com.javarush.task.task18.task1813;

import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream fileOutputStream;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.fileOutputStream=fileOutputStream;
    }

    @Override
    public void write(byte [] a, int off, int lenght) throws IOException {
        fileOutputStream.write(a, off, lenght);
    }

    @Override
    public void write(byte [] b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    protected void finalize() throws IOException
    {
        super.finalize();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    public void close() throws IOException {
        fileOutputStream.flush();
        fileOutputStream.write("JavaRush © All rights reserved.".getBytes());
        fileOutputStream.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
