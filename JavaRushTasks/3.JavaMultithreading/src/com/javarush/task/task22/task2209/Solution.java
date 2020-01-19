package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        String file = new String(Files.readAllBytes(Paths.get(fileName)));
        String[] words = file.split(" ");
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words==null || words.length==0) return new StringBuilder();//проверки
        if (words.length==1 || words[0].equals("")) return new StringBuilder(words[0]);

        StringBuilder result = new StringBuilder();
        ArrayList<String> wordsList = new ArrayList<String>(Arrays.asList(words));

        while (isYes(wordsList)) { //самое главное в реализации задачи
            Collections.shuffle(wordsList); //перемешиваем слова случайно в цикле, пока не найдется нужная цепочка слов
//            System.out.println(wordsList);
        }

        for (String word: wordsList){ //в списке теперь лежит нужная цепочка
            result.append(word+" ");
        }
        result.deleteCharAt(result.length()-1);//удалили последний пробел
        return result;
    }

    public static boolean isYes(ArrayList<String> wordsList){//метод тупо проверяет цепочку на хотя первое попавшееся несовпадение
        //когда не совпали буквы он возвращает true, чтобы вызвавший его цикл сработал еще раз и перемешал содержимое списка!
        for (int i = 0; i < wordsList.size()-1; i++) {
            String firstWord = wordsList.get(i).toLowerCase();
            String secondWord = wordsList.get(i+1).toLowerCase();
            if (firstWord.charAt(firstWord.length()-1)!=secondWord.charAt(0)) return true;
        }
        return false; //тут вся цепочка получилась!
    }
}
