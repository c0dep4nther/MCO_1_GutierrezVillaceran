package myfarm;

import myfarm.board.Board;
import myfarm.board.Tile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final Scanner input = new Scanner(System.in);
    public static String register="";

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
        /** CODE TO SHOW AND UPDATE FARMER'S TYPE*/
        //display table of benefits of farmer types
        displayFarmerType();

        //Change farmer's registry
        //Checks eligibility for Honorable Farmer registration
        if((player.getFarmerLevel()>=RegisterFarmer.HONORABLE.getLevelRequirement())
                &&(player.getFarmerStatus()==RegisterFarmer.DISTINGUISHED)){

            System.out.println();
            System.out.println("ELIGIBLE FOR HONORABLE FARMER REGISTRATION");

            //asks user input whether to update farmer type
            System.out.println("Would you like to register for Honorable Farmer? Y(yes) N(no)");
            register=input.nextLine();
            if(register.equals("Y")||register.equals("y")) {

                //checks if player has enough money to update registration
                if (player.getObjectCoins() >= RegisterFarmer.HONORABLE.getRegistrationFee()) {
                    player.setFarmerStatus(RegisterFarmer.HONORABLE);

                    //prints updated farmer type
                    System.out.println("Updated Farmer Type: " + player.getFarmerStatus().getFarmerType());

                    //Subtracts registration fee from player's money
                    player.setObjectCoins(player.getObjectCoins() - RegisterFarmer.HONORABLE.getRegistrationFee());
                    System.out.println("TEMP: Updated Money count " + player.getObjectCoins());

                } else {
                    System.out.println("Not enough money!");
                    System.out.println("Come back again next time!");
                }
            }
        }
        //Checks eligibility for Distinguished Farmer registration
        else if(player.getFarmerLevel()>=RegisterFarmer.DISTINGUISHED.getLevelRequirement()
                &&(player.getFarmerStatus()==RegisterFarmer.REGISTERED)){
            //insert code for checking money
            System.out.println();
            System.out.println("ELIGIBLE FOR DISTINGUISHED FARMER REGISTRATION");

            //asks user input whether to update farmer type
            System.out.println("Would you like to register for Distinguished Farmer? Y(yes) N(no)");
            register=input.nextLine();
            if(register.equals("Y")||register.equals("y")) {

                //checks if player has enough money to update registration
                if (player.getObjectCoins() >= RegisterFarmer.DISTINGUISHED.getRegistrationFee()) {
                    player.setFarmerStatus(RegisterFarmer.DISTINGUISHED);

                    //prints updated farmer type
                    System.out.println("Updated Farmer Type: " + player.getFarmerStatus().getFarmerType());

                    //Subtracts registration fee from player's money
                    player.setObjectCoins(player.getObjectCoins() - RegisterFarmer.DISTINGUISHED.getRegistrationFee());
                    System.out.println("TEMP: Updated Money count " + player.getObjectCoins());
                } else {
                    System.out.println("Not enough money!");
                    System.out.println("Come back again next time!");
                }
            }
        }

        //Checks eligibility for Registered Farmer registration
        else if (player.getFarmerLevel()>=RegisterFarmer.REGISTERED.getLevelRequirement()
                &&(player.getFarmerStatus()==RegisterFarmer.FARMER)){

            System.out.println();
            //insert code for checking money
            System.out.println("ELIGIBLE FOR REGISTERED FARMER REGISTRATION");

            //asks user input whether to update farmer type
            System.out.println("Would you like to register for Registered Farmer? Y(yes) N(no)");
            register=input.nextLine();
            if(register.equals("Y")||register.equals("y")){

                //checks if player has enough money to update registration
                if(player.getObjectCoins()>=RegisterFarmer.REGISTERED.getRegistrationFee()){
                    player.setFarmerStatus(RegisterFarmer.REGISTERED);

                    //prints updated farmer type
                    System.out.println("Updated Farmer Type: "+player.getFarmerStatus().getFarmerType());

                    //Subtracts registration fee from player's money
                    player.setObjectCoins(player.getObjectCoins()-RegisterFarmer.REGISTERED.getRegistrationFee());
                    System.out.println("TEMP: Updated Money count "+player.getObjectCoins());
                }
                else{
                    System.out.println("Not enough money!");
                    System.out.println("Come back again next time!");
                }
            }
            else{
                System.out.println("Come back again next time!");
            }
        }
        // ask player to choose a tile

//        // loop through board and access the tile object
//        for (int i = 1; i <= 50; i++) {
//            // get the tile object
//            Tile tile = gameBoard.getTiles().get(i);
//        }
    }
    public static void displayFarmerType(){
        System.out.println();
        System.out.println();
        System.out.printf("%-30s%-20s%-20s%-35s%-20s%-20s%n","Farmer Type","Level Requirement","Earning/Buying",
                "Water/Fertilizer bonus limits","Harvest time","Registration Fee");
        for(RegisterFarmer register: RegisterFarmer.values())
            System.out.printf("%-30s%-20s+/-%-17s+%-35s%-20s%-20s%n", register.getFarmerType(),register.getLevelRequirement(),
                    register.getEarning(),register.getBonusLimits(),register.getHarvestTime(),register.getRegistrationFee());
    }
}

// 1 - turnip, 2 carrot, 3 rose, 4 stargazer
