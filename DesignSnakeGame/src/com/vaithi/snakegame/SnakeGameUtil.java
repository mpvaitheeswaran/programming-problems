package com.vaithi.snakegame;

import java.util.*;

public class SnakeGameUtil {

    public static final String GRID_HEAD = "HEAD";
    public static final String GRID_TAIL = "TAIL";
    public static final String GRID_FOOD = "FOOD";
    public static final String SNAKE = "S";
    public static final String FOOD = "F";

    public static Map<String, String> initializeGrid(GameSettings settings) {
        Map<String, String> gridMap = new HashMap<>();

        //Initial position is 0,0
        gridMap.put(GRID_HEAD, "0,0");
        gridMap.put(GRID_TAIL, "0,0");

        Queue<String> foodList = settings.getFoodPositions();
        String initialFoodPosition = foodList.peek();
        gridMap.put(GRID_FOOD, initialFoodPosition);
        foodList.remove(initialFoodPosition);
        settings.setFoodPositions(foodList);
        return gridMap;
    }

    public static void printCurrentGrid(GameSettings settings, Map<String, String> gridMap) {
        int width = settings.getWidth(); // Column
        int height = settings.getHeight(); //row

        Queue<String> snakePositions = settings.getSnakePositions();
        String foodPosition = gridMap.get(GRID_FOOD);

        StringBuilder gridBuilder = new StringBuilder();
        for (int row = 0; row < height; row++) {
            gridBuilder.append("|");
            for (int column = 0; column < width; column++) {
                String rowColumnPair = String.valueOf(row) + "," + String.valueOf(column);
                if (snakePositions.contains(rowColumnPair)) {
                    gridBuilder.append(SNAKE + "|");
                } else if (rowColumnPair.equalsIgnoreCase(foodPosition)) {
                    gridBuilder.append(FOOD + "|");
                } else {
                    gridBuilder.append(" |");
                }
            }
            gridBuilder.append(System.lineSeparator());
        }

        System.out.println(gridBuilder.toString());

    }

    public static void moveRight(GameSettings settings, Map<String, String> gridMap) {
        Deque<String> snakePositions = settings.getSnakePositions();
        String headPosition = snakePositions.peekFirst();
        int headRow = Integer.parseInt(headPosition.split(",")[0]);
        int headColumn = Integer.parseInt(headPosition.split(",")[1]);

        String newHeadRowColumnPair = String.valueOf(headRow) + "," + String.valueOf(headColumn + 1);

        snakePositions.addFirst(newHeadRowColumnPair);
        snakePositions.removeLast();

    }

    public static void moveLeft(GameSettings settings, Map<String, String> gridMap) {
        Deque<String> snakePositions = settings.getSnakePositions();
        String headPosition = snakePositions.peekFirst();
        int headRow = Integer.parseInt(headPosition.split(",")[0]);
        int headColumn = Integer.parseInt(headPosition.split(",")[1]);

        String newHeadRowColumnPair = String.valueOf(headRow) + "," + String.valueOf(headColumn - 1);

        snakePositions.addFirst(newHeadRowColumnPair);
        snakePositions.removeLast();

    }

    public static void moveUp(GameSettings settings, Map<String, String> gridMap) {
        Deque<String> snakePositions = settings.getSnakePositions();
        String headPosition = snakePositions.peekFirst();
        int headRow = Integer.parseInt(headPosition.split(",")[0]);
        int headColumn = Integer.parseInt(headPosition.split(",")[1]);

        String newHeadRowColumnPair = String.valueOf(headRow - 1) + "," + String.valueOf(headColumn);

        snakePositions.addFirst(newHeadRowColumnPair);
        snakePositions.removeLast();

    }

    public static void moveDown(GameSettings settings, Map<String, String> gridMap) {
        Deque<String> snakePositions = settings.getSnakePositions();
        String headPosition = snakePositions.peekFirst();
        int headRow = Integer.parseInt(headPosition.split(",")[0]);
        int headColumn = Integer.parseInt(headPosition.split(",")[1]);

        String newHeadRowColumnPair = String.valueOf(headRow + 1) + "," + String.valueOf(headColumn);

        snakePositions.addFirst(newHeadRowColumnPair);
        snakePositions.removeLast();

    }

    public static int moveSnake(GameSettings settings, String moveCommand) {
        Deque<String> snakePositions = settings.getSnakePositions();
        String headPosition = snakePositions.peekFirst();
        int headRow = Integer.parseInt(headPosition.split(",")[0]);
        int headColumn = Integer.parseInt(headPosition.split(",")[1]);
        String newHeadRowColumnPair = "";
        if ("R".equalsIgnoreCase(moveCommand))
            newHeadRowColumnPair = String.valueOf(headRow) + "," + String.valueOf(headColumn + 1);
        else if ("L".equalsIgnoreCase(moveCommand))
            newHeadRowColumnPair = String.valueOf(headRow) + "," + String.valueOf(headColumn - 1);
        else if ("U".equalsIgnoreCase(moveCommand))
            newHeadRowColumnPair = String.valueOf(headRow - 1) + "," + String.valueOf(headColumn);
        else if ("D".equalsIgnoreCase(moveCommand))
            newHeadRowColumnPair = String.valueOf(headRow + 1) + "," + String.valueOf(headColumn);

        snakePositions.addFirst(newHeadRowColumnPair);
        snakePositions.removeLast();

        String currentFoodPosition = settings.getFoodPositions().peek();

        if (currentFoodPosition.equalsIgnoreCase(newHeadRowColumnPair)) {
            return 1;
        } else if (headRow > settings.getHeight() || headRow < 0 || headColumn > settings.getWidth() || headColumn < 0)
            return -1;
        else
            return 0;
    }
}
