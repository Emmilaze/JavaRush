package com.javarush.task.task22.task2211;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String read = args[0];
        String write = args[1];
        byte[] buffer = new byte[]{};
        byte[] array = Files.readAllBytes(Paths.get(read));
        Charset utf8 = StandardCharsets.UTF_8;
        Charset windows1251 = Charset.forName("Windows-1251");
        String s = new String(array, windows1251);
        buffer = s.getBytes(utf8);

        FileOutputStream fos = new FileOutputStream(new File(write));
        fos.write(buffer);
    }
}
