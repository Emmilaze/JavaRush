package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = "";
        try {
            path = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(path));
        String file = "";
        try {
            file = reader.readLine();
            zipFileManager.createZip(Paths.get(file));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
