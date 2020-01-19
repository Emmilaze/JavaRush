package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        try {
            System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        }catch (TooShortStringException e){
        }
    }

    public static String getPartOfString(String string) {
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        String[] arr = string.split(" ");
        if(arr.length <= 4) throw new TooShortStringException();
        return String.format("%s %s %s %s", arr[1], arr[2], arr[3], arr[4]);
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
