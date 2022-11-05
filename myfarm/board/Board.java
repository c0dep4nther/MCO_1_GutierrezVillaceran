package myfarm.board;

import myfarm.TileStatus;

import java.util.HashMap;

public class Board {
    // use hashmap to store integer as key and then tile as value
    private final HashMap<Integer, Tile> tiles = new HashMap<>();
    private int dayCount = 1;

    // board constructor
    public Board() {
        for (int count = 1; count <= 50; count++) {
            tiles.put(count, new Tile());
        }
    }

    public void endDay() {
        int fertilizerNeed;
        int fertilizerLevel;
        int harvestDate;
        int waterNeed;
        int waterLevel;
        TileStatus cropStatus;
        Tile farmLot;

        // increment day
        dayCount++;

        // for each tile, check if it's planted and if harvest date is reached
        for (int i = 1; i <= 50; i++) {
            farmLot = tiles.get(i);
            waterLevel = farmLot.getWaterLevel();
            fertilizerLevel = farmLot.getFertilizerLevel();
            waterNeed = farmLot.getCrop().getWaterNeed();
            fertilizerNeed = farmLot.getCrop().getFertilizerNeed();
            cropStatus = farmLot.getStatus();
            harvestDate = farmLot.getHarvestDate();

            if (cropStatus == TileStatus.PLANTED && harvestDate == dayCount) {
                // check if water and fertilizer needed is met
                if (waterLevel >= waterNeed && fertilizerLevel >= fertilizerNeed) {
                    farmLot.setStatus(TileStatus.HARVESTABLE);
                } else {
                    farmLot.setStatus(TileStatus.WITHERED);
                }
            }
        }
    }

    //method to access the tile value
    public Tile getTile(int tileNumber) {
        return tiles.get(tileNumber);
    }

    public TileStatus getTileStatus(int tileNumber) {
        return tiles.get(tileNumber).getStatus();
    }

    public int getDayCount() {
        return dayCount;
    }

    public void displayBoard() {
        for (int i = 1; i <= 50; i++) {
            if (getTileStatus(i)==TileStatus.PLANTED){
                System.out.print(i + "\t[" + getTile(i).getCropName().toUpperCase() + "]\t");
            } else {
                System.out.print(i + "\t[" + getTileStatus(i) + "]\t");
            }

            if (i % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}