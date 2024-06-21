package com.vaithi.snakegame;

import java.util.*;

public class SnakeGame {
    public static void main(String[] args) {

        Deque<String> foodsList = new LinkedList<>();
        foodsList.add("1,2");
        foodsList.add("0,1");

        System.out.println("***Welcome to snake Game***");

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter the board width :");
            int width = Integer.parseInt(sc.next());

            System.out.println("Enter the board Height :");
            int height = Integer.parseInt(sc.next());

            GameSettings settings = new GameSettings(width,height, foodsList);

            SnakeGameUtil.printCurrentGrid(settings,null);

            while(true){
                System.out.println("Move the Snake:");
                String moveCommand = sc.next();

                if(!SnakeGameUtil.MOVE_INPUT_LIST.contains(moveCommand.toUpperCase())){
                    System.out.println("***Invalid Command please enter correct input "+SnakeGameUtil.MOVE_INPUT_LIST);
                    continue;
                }
                if("Q".equalsIgnoreCase(moveCommand))
                    break;

                int result = SnakeGameUtil.moveSnake(settings,moveCommand);

                SnakeGameUtil.printCurrentGrid(settings,null);

                if(result<0){
                    // Game over
                    System.out.println("***Game Over***");
                    break;
                }

                if(settings.getFoodPositions().isEmpty() || (width*height)==settings.getSnakePositions().size()){
                    System.out.println("***YOU Won the Game***");
                    break;
                }

            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("***Invalid input please start again***");
        }
    }
}
