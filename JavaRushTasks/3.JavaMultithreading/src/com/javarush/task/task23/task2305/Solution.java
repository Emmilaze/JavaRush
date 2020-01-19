package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] array = new Solution[2];
        Solution sol1 = new Solution();
        sol1.innerClasses = new InnerClass[]{};
        Solution sol2 = new Solution();
        sol2.innerClasses = new InnerClass[]{};
        array[0] = sol1;
        array[1] = sol2;
        return array;
    }

    public static void main(String[] args) {

    }
}
