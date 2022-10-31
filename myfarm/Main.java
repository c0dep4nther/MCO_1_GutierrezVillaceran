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
        Tile gameTile;

        System.out.println("Welcome to MyFarm!");

        FarmerDetails player = new FarmerDetails();
        Board gameBoard = new Board();

        while (true) {
            // print the board (key, value) in 10x5
            for (int i = 1; i <= 50; i++) {
                System.out.print(i + "\t[" + gameBoard.getTileStatus(i) + "]\t" );
                if (i % 10 == 0) {
                    System.out.println();
                }
            }

            // ask player to choose a tile
            System.out.println("Choose a tile to view its details: ");
            int tileNumber = input.nextInt();

            // get the tile from the board using the tile number
            gameTile = gameBoard.getTile(tileNumber);

            // on the chosen tile print the details
            System.out.println("Tile " + tileNumber + " details: ");

            // print the tile details
            System.out.println("Status: " + gameTile.getStatus());

            // if the status not UNPLOWED, show the tile details
            if (gameTile.getStatus() != TileStatus.UNPLOWED) {
                System.out.println("Crop: " + gameTile.getCropName());

            }
        }
    }
}

// 1 - turnip, 2 carrot, 3 rose, 4 stargazer
