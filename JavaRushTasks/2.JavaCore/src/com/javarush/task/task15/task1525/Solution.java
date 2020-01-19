package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.javarush.task.task15.task1525.Statics.FILE_NAME;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println(lines);
    }

    static {
        try {
            Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8).forEach(s -> lines.add(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
