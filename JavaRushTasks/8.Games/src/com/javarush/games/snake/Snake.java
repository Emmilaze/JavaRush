package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList<>();
    private final static String HEAD_SIGN = "\\uD83D\\uDC7E";
    private final static String BODY_SIGN = "\\u26AB";
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

    public Snake(int x, int y) {
        GameObject gameObject1 = new GameObject(x, y);
        GameObject gameObject2 = new GameObject(x + 1, y);
        GameObject gameObject3 = new GameObject(x + 2, y);
        snakeParts.add(gameObject1);
        snakeParts.add(gameObject2);
        snakeParts.add(gameObject3);
    }

    public void draw(Game game) {
        if (isAlive)
            game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y, Color.NONE, HEAD_SIGN, Color.NONE, 75);
        else
            game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y, Color.NONE, HEAD_SIGN, Color.RED, 75);
        for (int i = 1; i < snakeParts.size(); i++) {
            if (isAlive)
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, Color.NONE, 75);
            else
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, Color.RED, 75);
        }
    }

    public void setDirection(Direction direction) {
        switch (direction) {
            case RIGHT:
                if (this.direction == Direction.LEFT) return;
                if(snakeParts.get(0).y==snakeParts.get(1).y) return;
                break;
            case LEFT:
                if (this.direction == Direction.RIGHT) return;
                if(snakeParts.get(0).y==snakeParts.get(1).y) return;
                break;
            case UP:
                if (this.direction == Direction.DOWN) return;
                if(snakeParts.get(0).x==snakeParts.get(1).x) return;
                break;
            case DOWN:
                if (this.direction == Direction.UP) return;
                if(snakeParts.get(0).x==snakeParts.get(1).x) return;
                break;
        }
        this.direction = direction;
    }

    public void move(Apple apple) {
        GameObject gameObject = createNewHead();
        if (gameObject.x >= SnakeGame.WIDTH || gameObject.y >= SnakeGame.WIDTH || gameObject.x < 0 || gameObject.y < 0) {
            isAlive = false;
            return;
        }
        if (checkCollision(gameObject)) {
            isAlive = false;
        } else {
            if (gameObject.x == apple.x && gameObject.y == apple.y) {
                apple.isAlive = false;
                snakeParts.add(0, gameObject);
            } else {
                snakeParts.add(0, gameObject);
                removeTail();
            }
        }
    }

    public GameObject createNewHead() {
        GameObject head = snakeParts.get(0);
        GameObject newObject = null;
        if (direction.equals(Direction.DOWN))
            newObject = new GameObject(head.x, head.y + 1);
        if (direction.equals(Direction.LEFT))
            newObject = new GameObject(head.x - 1, head.y);
        if (direction.equals(Direction.UP))
            newObject = new GameObject(head.x, head.y - 1);
        if (direction.equals(Direction.RIGHT))
            newObject = new GameObject(head.x + 1, head.y);

        return newObject;
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public boolean checkCollision(GameObject gameObject) {
        for (int i = 0; i < snakeParts.size(); i++) {
            if (gameObject.x == snakeParts.get(i).x && gameObject.y == snakeParts.get(i).y)
                return true;
        }
        return false;
    }

    public int getLength(){
        return snakeParts.size();
    }
}

