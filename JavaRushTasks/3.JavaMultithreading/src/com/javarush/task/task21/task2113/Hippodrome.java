package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;
    public static void main(String [] args){
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Cherry", 3, 0));
        horses.add(new Horse("Blueberry", 3, 0));
        horses.add(new Horse("Nelly", 3, 0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run(){
        for(int i=0; i<100; i++){
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move(){
        for(int i=0; i<horses.size(); i++){
            horses.get(i).move();
        }
    }

    public void print(){
        for(int i=0; i<horses.size(); i++){
            horses.get(i).print();
        }
        for(int i=0; i<10; i++){
            System.out.println();
        }
    }

    public Horse getWinner(){
        horses.sort(Comparator.comparing(Horse::getDistance));
        return horses.get(horses.size()-1);
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
