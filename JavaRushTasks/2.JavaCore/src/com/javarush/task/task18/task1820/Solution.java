package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream reading = new FileInputStream(reader.readLine());
        FileOutputStream writing = new FileOutputStream(reader.readLine());
        reader.close();
        if (reading.available() > 0){
            byte[] data = new byte[reading.available()];
            reading.read(data);
        String[] strArrDouble = new String(data).split(" ");
        StringBuilder resultStrLong = new StringBuilder(data.length);

        for (String strDouble : strArrDouble) {
            resultStrLong.append(Math.round(Double.valueOf(strDouble)));
            resultStrLong.append(" ");
        }
        writing.write(resultStrLong.toString().getBytes());
        }
        reading.close();
        writing.close();

    }
}
