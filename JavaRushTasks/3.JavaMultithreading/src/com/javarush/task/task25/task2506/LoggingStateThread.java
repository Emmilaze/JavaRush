package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    private final Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
        setDaemon(true);
    }

    @Override
    public void run() {
        String stateTarget = new String();
        while (true) {
            if (!(stateTarget.equals(target.getState().name()))) {
                stateTarget = target.getState().name();
                System.out.println(stateTarget);
                if (stateTarget.equals("TERMINATED")) {
                    break;
                }
            }
        }
    }
}
