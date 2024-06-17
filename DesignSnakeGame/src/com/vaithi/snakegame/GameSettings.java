package com.vaithi.snakegame;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameSettings {

    int width;
    int height;
    List<String> foodPositions;
    Deque<String> snakePositions;

    public GameSettings(int width, int height, List<String> foodPositions) {
        this.width = width;
        this.height = height;
        this.foodPositions = foodPositions;
        this.snakePositions = new LinkedList<>();
        this.snakePositions.add("0,0");
    }

    public Deque<String> getSnakePositions() {
        return snakePositions;
    }

    public void setSnakePositions(Deque<String> snakePositions) {
        this.snakePositions = snakePositions;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<String> getFoodPositions() {
        return foodPositions;
    }

    public void setFoodPositions(List<String> foodPositions) {
        this.foodPositions = foodPositions;
    }
}
