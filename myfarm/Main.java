package myfarm;

import myfarm.board.Board;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static final HashMap<String, Tool> toolInventory = new HashMap<>();
    static {
        toolInventory.put("W", new Tool("Watering Can", 0, 0.5f));
        toolInventory.put("PL", new Tool("Plow", 0, 0.5f));
    }

    public static final HashMap<Integer, Plant> seedList = new HashMap<>();
    static {
        seedList.put(1, new Plant("Turnip", "Root Crop", 2,
                1, 2,0, 1,2,
                1, 5, 6, 5));
        seedList.put(2, new Plant("Carrot", "Root Crop", 3,
                1,2,0,1,2, 1,
                10, 9, 7.5f));
    }

    public static void main(String[] args) {
        boolean isRunning = true;
        Board farmLand = new Board();
        Farmer player = new Farmer();
        int seedChoice;
        int playerLevel;
        float playerExp;
        float playerMoney;
        Scanner input = new Scanner(System.in);
        String action;

        // ask player on what action to do
        // P plant H harvest W water PL plow S sleep Q quit
        while (isRunning) {
            playerLevel = player.getLevel();
            playerExp = player.getTotalExp();
            playerMoney = player.getMoney();

            System.out.println("Day: " + farmLand.getDayCount()
                    + "\t\tMoney: " + playerMoney);
            System.out.println("Level: " + playerLevel
                    + "\tExp: " + playerExp);
            farmLand.displayBoard();

            System.out.println("It is day " + farmLand.getDayCount() + ". What would you like to do?");
            System.out.println("[P] Plant \t[H] Harvest");
            System.out.println("[W] Water \t[PL] Plow");
            System.out.println("[E] Sleep \t[Q] Quit");
            action = input.nextLine().toUpperCase();

            switch (action) {
                case "P" -> {
                    System.out.println("What would you like to plant?");
                    System.out.println("[1] Turnip");
                    System.out.println("[2] Carrot");
                    seedChoice = input.nextInt();

                    System.out.println("Where would you like to plant it?");
                    farmLand = player.plantSeed(seedList.get(seedChoice), farmLand);
                }
                case "H" -> {
                    System.out.println("Which tile would you like to harvest?");
                    farmLand = player.harvestPlant(farmLand);
                }
                case "W" -> {
                    System.out.println("Which tile would you like to water?");
                    farmLand = player.useTool(toolInventory.get(action), farmLand);
                }
                case "PL" -> {
                    System.out.println("Which tile would you like to plow?");
                    farmLand = player.useTool(toolInventory.get(action), farmLand);
                }
                case "E" -> {
                    System.out.println("You went to sleep.");
                    farmLand.endDay();
                }
                case "Q" -> {
                    System.out.println("You quit the game.");
                    isRunning = false;
                }
                default -> System.out.println("Invalid input.");
            }
        }
    }
}
