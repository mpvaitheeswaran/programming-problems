package com.vaithi.snakegame;

import java.util.*;

public class SnakeGame {
    public static void main(String[] args) {

        List<String> foodsList = new ArrayList<>();
        foodsList.add("2,2");

        Deque<String> snakePositions = new LinkedList<>();
        snakePositions.add("0,0");
        snakePositions.add("1,0");
        snakePositions.add("1,1");
        snakePositions.add("1,2");
        snakePositions.add("2,2");
        snakePositions.add("2,1");

        Deque<String> snakePositionsLeft = new LinkedList<>();
        snakePositionsLeft.add("2,1");
        snakePositionsLeft.add("2,2");
        snakePositionsLeft.add("1,0");
        snakePositionsLeft.add("1,1");
        snakePositionsLeft.add("1,2");

        snakePositionsLeft.add("0,0");
        GameSettings settings = new GameSettings(3,3, foodsList);
        settings.setSnakePositions(snakePositionsLeft);

        Map<String, String> gridMap = SnakeGameUtil.initializeGrid(settings);

        SnakeGameUtil.printCurrentGrid(settings,gridMap);

//        SnakeGameUtil.moveRight(settings,gridMap);
//
//        SnakeGameUtil.printCurrentGrid(settings,gridMap);
//
//        SnakeGameUtil.moveRight(settings,gridMap);
//
//        SnakeGameUtil.printCurrentGrid(settings,gridMap);
//
//        SnakeGameUtil.moveRight(settings,gridMap);
//
//        SnakeGameUtil.printCurrentGrid(settings,gridMap);

        SnakeGameUtil.moveLeft(settings,gridMap);
        SnakeGameUtil.printCurrentGrid(settings,gridMap);
        SnakeGameUtil.moveLeft(settings,gridMap);
        SnakeGameUtil.printCurrentGrid(settings,gridMap);
    }
}
