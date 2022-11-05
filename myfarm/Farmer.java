package myfarm;

import myfarm.board.Board;
import myfarm.board.Tile;

import java.util.Scanner;

public class Farmer {
    private float exp = 0;
    private int level = 1;
    private int money = 100;
    private FarmerType type = FarmerType.FARMER;

    public Board useTool(Tool object, Board farmLand) {
        Scanner input = new Scanner(System.in);
        int tileNumber = input.nextInt();
        Tile farmLot = farmLand.getTile(tileNumber);

        System.out.println("Using " + object.getName() + "...");
        object.toolAction(farmLot);
        exp += object.getExpGain();

        // set status to board
        farmLand.getTile(tileNumber).setStatus(farmLot.getStatus());

        System.out.println("Press enter to continue...");
        input.nextLine();
        input.nextLine();

        return farmLand;
    }

    public Board plantSeed(Plant seed,  Board farmLand) {
        Scanner input = new Scanner(System.in);
        int dayCount = farmLand.getDayCount();
        int harvestTime = seed.getHarvestTime();
        int tileNumber = input.nextInt();
        Tile farmLot = farmLand.getTile(tileNumber);

        // if tile is plowed and empty, plant seed
        if (farmLot.getStatus() == TileStatus.PLOWED) {
            farmLot.setCrop(seed);
            farmLot.setStatus(TileStatus.PLANTED);
            farmLot.setHarvestDate(dayCount, harvestTime);
            money -= seed.getSeedCost();
            System.out.println("You planted " + seed.getName() + " which costs " + seed.getSeedCost() + " Objectcoins.");
            System.out.println("Harvest is in " + harvestTime + " days.");
        } else {
            System.out.println("You can't plant a seed on a tile that is occupied or isn't plowed.");
        }

        System.out.println("Press enter to continue...");
        input.nextLine();
        input.nextLine();

        return farmLand;
    }

    // TODO: finalize method for harvesting
    public Board harvestPlant(Board farmLand) {
        Scanner input = new Scanner(System.in);
        int dayCount = farmLand.getDayCount();
        int tileNumber = input.nextInt();
        Tile farmLot = farmLand.getTile(tileNumber);

        // if tile is planted and harvest date is reached, harvest plant
        if (farmLot.getStatus() == TileStatus.PLANTED && farmLot.getHarvestDate() == dayCount) {
            money += farmLot.getCrop().getSellPrice();
            System.out.println("You harvested " + farmLot.getCrop().getName() + " and sold it for " + farmLot.getCrop().getSellPrice() + " Objectcoins.");
            farmLot.setStatus(TileStatus.PLOWED);
        } else {
            System.out.println("You can't harvest a plant that isn't planted or isn't ready to be harvested.");
        }

        System.out.println("Press enter to continue...");
        input.nextLine();
        input.nextLine();

        return farmLand;
    }
}
