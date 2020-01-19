package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        for (int i = 0; i < threads.length; i++) {
            switch (threads[i].getState()) {
                case NEW:
                    threads[i].start();
                    break;
                case TERMINATED:
                    System.out.println(threads[i].getPriority());
                    break;
                case RUNNABLE: threads[i].isInterrupted();
                    break;
                case WAITING:
                case TIMED_WAITING:
                case BLOCKED:
                    threads[i].interrupt();
                    break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
