package myfarm;

import myfarm.board.Board;
import myfarm.board.Tile;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final Scanner input = new Scanner(System.in);
    public static String register="";

    // using a list to store the crops
    public static final List<Plants> seedList = new ArrayList<>(Arrays.asList(
            new Plants("Turnip", "Root crop", 2,1,0,1,2,5,6,5f),
            new Plants("Carrot","Root crop",3,1,0,1,2,10,9,7.5f),
            new Plants("Rose","Flower",1,1,0,1,1,5,5,2.5f),
            new Plants("Tulips","Flower",2,2,0,1,1,10,9,5)
    ));

    public static void main(String[] args) {
        Tile gameTile;
        System.out.println("Welcome to MyFarm!");

        FarmerDetails player = new FarmerDetails();
        Board gameBoard = new Board();

        while (true) {
            //Prints out farmer's details
            player.displayFarmerDetails();

            //ask player to choose to which they should perform an action to
            System.out.println();
            System.out.println("Enter a number to choose which to perform an action: ");
            System.out.println("1-Tile");
            System.out.println("2-Update farmer registry");
            int actionNumber=input.nextInt();
            input.nextLine();
            boolean validInput=true;
            boolean tileContinue=true;

            while (validInput){

               if(actionNumber==1){
                   while(tileContinue){
                       gameBoard.displayBoard();
                       validInput=false;

                       // ask player to choose a tile
                       System.out.println();
                       System.out.println("Choose a tile to perform an action: ");
                       int tileNumber = input.nextInt();
                       input.nextLine();

                       // get the tile from the board using the tile number
                       gameTile = gameBoard.getTile(tileNumber);
                       int tileAction=0;

                       while(tileAction!=10){
                           //ask player to choose which action to perform
                           //will only show Plow action if tile is unplowed
                           /**REMINDER: PUT CODE TO RESTRICT ACTION IF NOW SHOWN, INVALID IF NOT SHOWN*/
                           System.out.println("TILE ACTIONS FOR TILE #"+tileNumber+":");
                           if(gameTile.getStatus() == TileStatus.UNPLOWED){
                               System.out.println("1-Plow tile");
                           }
                           else if((gameTile.getStatus() != TileStatus.UNPLOWED) && (gameTile.getStatus()!=TileStatus.PLANTED)){
                               System.out.println("2 - Plant seed");
                           }
                           else if(gameTile.getStatus()==TileStatus.PLANTED){
                               System.out.println("3 - Water");
                               System.out.println("4 - Fertilize");
                           }
                           System.out.println("10-Exit");
                           tileAction=input.nextInt();
                           input.nextLine();

                           if(tileAction==1){
                               gameTile.setStatus(TileStatus.PLOWED);
                               gameBoard.displayBoard();
                               gameTile.displayTileDetails(tileNumber);
                           }
                           else if(tileAction==2){
                               //display seeds that can be planted
                               displaySeeds();
                               System.out.println();

                               //asks user to input which seed to plant
                               System.out.println("Choose which seed to plant: 1 - Turnip, 2 - Carrot, 3 - Rose, 4 - Stargazer");
                               int seedChoice=input.nextInt();
                               input.nextLine();

                               //plants the seed chosen
                               if(seedChoice==1){

                                   //sets the tile status to planted
                                   gameTile.setStatus(TileStatus.PLANTED);
                                   gameTile.setCropName(seedList.get(0));

                                   //prints the seed chosen and its cost, updates money and seed count
                                   player.buySeeds(seedList.get(0));

                               }
                               else if(seedChoice==2){
                                   //sets the tile status to planted
                                   gameTile.setStatus(TileStatus.PLANTED);
                                   gameTile.setCropName(seedList.get(1));

                                   //prints the seed chosen and its cost, updates money and seed count
                                   player.buySeeds(seedList.get(1));
                               }
                               else if(seedChoice==3){
                                   //sets the tile status to planted
                                   gameTile.setStatus(TileStatus.PLANTED);
                                   gameTile.setCropName(seedList.get(2));

                                   //prints the seed chosen and its cost, updates money and seed count
                                   player.buySeeds(seedList.get(2));
                               }
                               else if(seedChoice==4){
                                   //sets the tile status to planted
                                   gameTile.setStatus(TileStatus.PLANTED);
                                   gameTile.setCropName(seedList.get(3));

                                   //prints the seed chosen and its cost, updates money and seed count
                                   player.buySeeds(seedList.get(3));
                               }
                                gameBoard.displayBoard();
                                gameTile.displayTileDetails(tileNumber);
                           }
                           else if(tileAction==3){
                               //Water
                               gameTile.setWaterLevel(gameTile.getCropName().getWaterBonus());
                               gameTile.displayTileDetails(tileNumber);
                           }
                           else if(tileAction==4){
                               //Fertilize
                               if(player.getFertilizerCount()!=0){
                                   gameTile.setFertilizerLevel(player,gameTile.getCropName().getFertilizerBonus());
                                   gameTile.displayTileDetails(tileNumber);
                               }
                               else{
                                   //Buy fertilizer
                                   player.buyFertilizer();
                               }

                           }
                       }

                       System.out.println("Return to main menu? Y/N");
                       String tileDecision=input.nextLine();
                       if(tileDecision.equals("Y")||tileDecision.equals("y")){
                           tileContinue=false;
                       }
                       else{
                           tileContinue=true;
                       }
                   }
               }
               else if(actionNumber==2){
                   /** CODE TO SHOW AND UPDATE FARMER'S TYPE*/
                   //display table of benefits of farmer types
                   player.displayFarmerType();

                   //Change farmer's registry
                   //Checks eligibility for Honorable Farmer registration
                   if ((player.getFarmerLevel() >= RegisterFarmer.HONORABLE.getLevelRequirement())
                           && (player.getFarmerStatus() == RegisterFarmer.DISTINGUISHED)) {

                       System.out.println();
                       System.out.println("ELIGIBLE FOR HONORABLE FARMER REGISTRATION");

                       //asks user input whether to update farmer type
                       System.out.println("Would you like to register for Honorable Farmer? Y(yes) N(no)");
                       register = input.nextLine();
                       if (register.equals("Y") || register.equals("y")) {

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
                   else if (player.getFarmerLevel() >= RegisterFarmer.DISTINGUISHED.getLevelRequirement()
                           && (player.getFarmerStatus() == RegisterFarmer.REGISTERED)) {
                       //insert code for checking money
                       System.out.println();
                       System.out.println("ELIGIBLE FOR DISTINGUISHED FARMER REGISTRATION");

                       //asks user input whether to update farmer type
                       System.out.println("Would you like to register for Distinguished Farmer? Y(yes) N(no)");
                       register = input.next();
                       if (register.equals("Y") || register.equals("y")) {

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
                   else if (player.getFarmerLevel() >= RegisterFarmer.REGISTERED.getLevelRequirement()
                           && (player.getFarmerStatus() == RegisterFarmer.FARMER)) {

                       System.out.println();
                       //insert code for checking money
                       System.out.println("ELIGIBLE FOR REGISTERED FARMER REGISTRATION");

                       //asks user input whether to update farmer type
                       System.out.println("Would you like to register for Registered Farmer? Y(yes) N(no)");
                       register = input.nextLine();
                       if (register.equals("Y") || register.equals("y")) {

                           //checks if player has enough money to update registration
                           if (player.getObjectCoins() >= RegisterFarmer.REGISTERED.getRegistrationFee()) {
                               player.setFarmerStatus(RegisterFarmer.REGISTERED);

                               //prints updated farmer type
                               System.out.println("Updated Farmer Type: " + player.getFarmerStatus().getFarmerType());

                               //Subtracts registration fee from player's money
                               player.setObjectCoins(player.getObjectCoins() - RegisterFarmer.REGISTERED.getRegistrationFee());
                               System.out.println("TEMP: Updated Money count " + player.getObjectCoins());
                           } else {
                               System.out.println("Not enough money!");
                               System.out.println("Come back again next time!");
                           }
                       } else {
                           System.out.println("Come back again next time!");
                       }
                   }
                   validInput=false;
               }
               else{
                   System.out.println("Invalid input. Try again!");
               }

            }

        }
    }

    //display seeds that can be planted
    public static void displaySeeds() {
        int counter = 1;
        System.out.printf("%-20s%-20s%-20s%-30s%-40s%-20s%-20s%-20s%-20s%n", "Seed Name", "Crop Type", "Harvest Time(days)",
                "Water Needed (Bonus Limit)", "Fertilizer Needed (Bonus Limit)", "Products Produced", "Seed Cost","Selling Price","Experience Yield");
        for (Plants p : seedList) {
            System.out.printf("%d. %-17s%-20s%-20s%s(%s)%27s(%s)%37s-%-18s%-20s%-20s%-20s%n",
                    counter,p.getName(),p.getType(),p.getHarvestTime(),p.getWaterNeeded(),p.getWaterBonus(),
                    p.getFertilizerNeeded(),p.getFertilizerBonus(),p.getMinProduce(),p.getMaxProduce(),p.getSeedCost(),p.getSellPrice(),p.getSeedCost(),p.getExpYield());
            counter++;
        }
    }
}


