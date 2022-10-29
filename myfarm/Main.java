package myfarm;

import myfarm.board.Board;
import myfarm.board.Tile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final Scanner input = new Scanner(System.in);

    // using a list to store the crops
    public static final List<Plants> seedList = new ArrayList<>(Arrays.asList(
            new Plants("Turnip", "Vegetable", 1f,
                    1, 0, 1,
                    1, 5, 6),
            new Plants("Carrot", "Vegetable", 1.5f,
                    1, 0, 1,
                    2, 10, 9),
            new Plants("Rose", "Flower", 2.5f,
                    1, 0, 1,
                    3, 15, 12),
            new Plants("Stargazer", "Flower", 2.5f,
                    2, 0, 2,
                    1, 10, 9)
    ));

    public static void main(String[] args) {
        System.out.println("Welcome to MyFarm!");

        /** CODE TO SHOW IN TERMINAL CROPS PLANTED*/
        // instantiate the player
        FarmerDetails player = new FarmerDetails();
        // create a new board
        Board gameBoard = new Board();

        // print the board (key, value) in 10x5
        for (int i = 1; i <= 50; i++) {
            System.out.print(i + "\t[" + gameBoard.getTileStatus(i) + "]\t" );
            if (i % 10 == 0) {
                System.out.println();
            }
        }

        // ask player to choose a tile

//        // loop through board and access the tile object
//        for (int i = 1; i <= 50; i++) {
//            // get the tile object
//            Tile tile = gameBoard.getTiles().get(i);
//        }
    }
}

// 1 - turnip, 2 carrot, 3 rose, 4 stargazer
