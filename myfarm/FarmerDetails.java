package myfarm;

import myfarm.board.Board;

import java.util.ArrayList;

public class FarmerDetails {
    private Board playerBoard;
    private ArrayList<Plants> plants;

    public FarmerDetails(){
        this.playerBoard=new Board();
        this.plants=new ArrayList<Plants>();
    }
    public void addSeeds(String name, String type, float harvestTime, int waterNeeded, int waterBonus,
                         int fertilizerNeeded, int fertilizerBonus, int harvestCost, int produceCountMax,
                         int seedCost, int sellPrice) {
            this.plants.add(new Plants(name,type,harvestTime,waterNeeded,waterBonus,fertilizerNeeded,fertilizerBonus,harvestCost,produceCountMax,seedCost,sellPrice));
    }
}
