package com.vaithi.snakegame;

import java.util.*;

public class SnakeGame {
    public static void main(String[] args) {

        Queue<String> foodsList = new LinkedList<>();
        foodsList.add("2,2");

        Deque<String> snakePositions = new LinkedList<>();
        snakePositions.add("0,0");
        snakePositions.add("1,0");
        snakePositions.add("1,1");
        snakePositions.add("1,2");
        snakePositions.add("2,2");
        snakePositions.add("2,1");

        Deque<String> snakePositionsLeft = new LinkedList<>();
        snakePositionsLeft.add("2,2");
        snakePositionsLeft.add("1,2");
        snakePositionsLeft.add("1,1");
        snakePositionsLeft.add("1,0");
        snakePositionsLeft.add("0,0");

        Deque<String> snakePositionsUp = new LinkedList<>();
        snakePositionsUp.add("1,0");
        snakePositionsUp.add("1,1");
        snakePositionsUp.add("1,2");
        snakePositionsUp.add("2,2");
        snakePositionsUp.add("2,1");

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

//        SnakeGameUtil.moveUp(settings,gridMap);
//        SnakeGameUtil.printCurrentGrid(settings,gridMap);
//
//        SnakeGameUtil.moveUp(settings,gridMap);
//        SnakeGameUtil.printCurrentGrid(settings,gridMap);

        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Move the Snake:");
            String moveCommand = sc.next();
            int result = -1;
            if("Q".equalsIgnoreCase(moveCommand))
                break;
            else
                result = SnakeGameUtil.moveSnake(settings,moveCommand);

            if(result==1){
                // add new tail.
            }

        }
    }
}
