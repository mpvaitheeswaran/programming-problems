package com.vaithi.snakegame;

import java.util.*;

public class SnakeGameUtil {

    public static final String GRID_HEAD = "HEAD";
    public static final String GRID_TAIL = "TAIL";
    public static final String GRID_FOOD = "FOOD";
    public static final String SNAKE = "S";
    public static final String FOOD = "F";
    public static final int GAME_OVER = -1;
    public static final int EAT_FOOD = 1;
    public static final int MOVED = 0;

    public static final List<String> MOVE_INPUT_LIST = Arrays.asList("R","L","U","D");

    public static void printCurrentGrid(GameSettings settings, Map<String, String> gridMap) {
        int width = settings.getWidth(); // Column
        int height = settings.getHeight(); //row

        Queue<String> snakePositions = settings.getSnakePositions();

        StringBuilder gridBuilder = new StringBuilder();
        for (int row = 0; row < height; row++) {
            gridBuilder.append("|");
            for (int column = 0; column < width; column++) {
                String rowColumnPair = String.valueOf(row) + "," + String.valueOf(column);
                if (snakePositions.contains(rowColumnPair)) {
                    gridBuilder.append(SNAKE + "|");
                } else if (rowColumnPair.equalsIgnoreCase(settings.getFoodPositions().peek())) {
                    gridBuilder.append(FOOD + "|");
                } else {
                    gridBuilder.append(" |");
                }
            }
            gridBuilder.append(System.lineSeparator());
        }

        System.out.println(gridBuilder.toString());

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


        String currentFoodPosition = settings.getFoodPositions().peek();

        if (currentFoodPosition.equalsIgnoreCase(newHeadRowColumnPair)) {
            // If snake eat food don't remove tail.
            settings.getFoodPositions().removeFirst();
            return EAT_FOOD;
        } else if (headRow > settings.getHeight()-1 || headRow < 0 || headColumn > settings.getWidth()-1 || headColumn < 0)
            // Game over
            return GAME_OVER;
        else{
            // If snake moved remove tail.
            snakePositions.removeLast();
            return MOVED;
        }
    }
}
