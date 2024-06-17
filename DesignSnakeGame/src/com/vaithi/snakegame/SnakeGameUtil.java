package com.vaithi.snakegame;

import java.util.*;

public class SnakeGameUtil {

    public static final String GRID_HEAD = "HEAD";
    public static final String GRID_TAIL = "TAIL";
    public static final String GRID_FOOD = "FOOD";
    public static final String SNAKE = "S";
    public static final String FOOD = "F";
    public static Map<String,String> initializeGrid(GameSettings settings){
        Map<String,String> gridMap = new HashMap<>();

        //Initial position is 0,0
        gridMap.put(GRID_HEAD,"0,0");
        gridMap.put(GRID_TAIL,"0,0");

        List<String> foodList = settings.getFoodPositions();
        String initialFoodPosition = foodList.get(0);
        gridMap.put(GRID_FOOD,initialFoodPosition);
        foodList.remove(initialFoodPosition);
        settings.setFoodPositions(foodList);
        return gridMap;
    }

    public static void printCurrentGrid(GameSettings settings,Map<String,String> gridMap){
        int width = settings.getWidth(); // Column
        int height = settings.getHeight(); //row

        Queue<String> snakePositions = settings.getSnakePositions();
        String foodPosition = gridMap.get(GRID_FOOD);

        StringBuilder gridBuilder = new StringBuilder();
        for(int row=0;row<height;row++){
            gridBuilder.append("|");
            for(int column=0;column<width;column++){
                String rowColumnPair = String.valueOf(row)+","+String.valueOf(column);
                if(snakePositions.contains(rowColumnPair)){
                    gridBuilder.append(SNAKE+"|");
                } else if (rowColumnPair.equalsIgnoreCase(foodPosition)) {
                    gridBuilder.append(FOOD+"|");
                }else {
                    gridBuilder.append(" |");
                }
            }
            gridBuilder.append(System.lineSeparator());
        }

        System.out.println(gridBuilder.toString());

    }

    public static void moveRight(GameSettings settings,Map<String,String> gridMap){
        Deque<String> snakePositions = settings.getSnakePositions();
        String headPosition = snakePositions.peekFirst();
        int headRow = Integer.parseInt(headPosition.split(",")[0]);
        int headColumn = Integer.parseInt(headPosition.split(",")[1]);

        String newHeadRowColumnPair = String.valueOf(headRow)+","+String.valueOf(headColumn+1);

        // Changing the tail position.
        String tailPosition = snakePositions.peekLast();
        int tailRow = Integer.parseInt(tailPosition.split(",")[0]);
        int tailColumn = Integer.parseInt(tailPosition.split(",")[1]);

        int newTailRow = tailRow;
        int newtailColumn = tailColumn;

        if((headRow+tailRow)%2==0){
            //Move farward
            if(tailColumn>=settings.width-1){
                if(headRow>tailRow)
                    tailRow += 1;
                else
                    tailRow -= 1;
            }else{
                tailColumn +=1;
            }
        }else {
            //move Backward
            if(tailColumn<=0){
                if(headRow>tailRow)
                    tailRow += 1;
                else
                    tailRow -= 1;
            }else{
                tailColumn -=1;
            }
        }

        String newTailRowColumnPair = String.valueOf(tailRow)+","+String.valueOf(tailColumn);

        snakePositions.addFirst(newHeadRowColumnPair);
        snakePositions.removeLast();

        if(!snakePositions.peekLast().equalsIgnoreCase(newTailRowColumnPair)){
            // Don't add last element if the new element are equals.
            snakePositions.addLast(newTailRowColumnPair);
        }

    }

    public static void moveLeft(GameSettings settings,Map<String,String> gridMap){
        Deque<String> snakePositions = settings.getSnakePositions();
        String headPosition = snakePositions.peekFirst();
        int headRow = Integer.parseInt(headPosition.split(",")[0]);
        int headColumn = Integer.parseInt(headPosition.split(",")[1]);

        String newHeadRowColumnPair = String.valueOf(headRow)+","+String.valueOf(headColumn-1);

        // Changing the tail position.
        String tailPosition = snakePositions.peekLast();
        int tailRow = Integer.parseInt(tailPosition.split(",")[0]);
        int tailColumn = Integer.parseInt(tailPosition.split(",")[1]);

        int newTailRow = tailRow;
        int newtailColumn = tailColumn;

        if((headRow+tailRow)%2==0){
            //move Backward
            if(tailColumn<=0){
                if(headRow>tailRow)
                    tailRow += 1;
                else
                    tailRow -= 1;
            }else{
                tailColumn -=1;
            }

        }else {
            //Move farward
            if(tailColumn>=settings.width-1){
                if(headRow>tailRow)
                    tailRow += 1;
                else
                    tailRow -= 1;
            }else{
                tailColumn +=1;
            }
        }

        String newTailRowColumnPair = String.valueOf(tailRow)+","+String.valueOf(tailColumn);

        snakePositions.addFirst(newHeadRowColumnPair);
        snakePositions.removeLast();

        if(!snakePositions.peekLast().equalsIgnoreCase(newTailRowColumnPair)){
            // Don't add last element if the new element are equals.
            snakePositions.addLast(newTailRowColumnPair);
        }

    }

    private static List<String> getSnakePositions(Map<String, String> gridMap) {
        List<String> snakePositions = new ArrayList<>();
        snakePositions.add("0,0");
        return snakePositions;
    }
}
