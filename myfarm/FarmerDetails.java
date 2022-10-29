package myfarm;

import myfarm.board.Board;

import java.util.ArrayList;

public class FarmerDetails {
    private Board playerBoard;
    private ArrayList<Plants> plants;
    static int seedCount=0;
    static int fertilizerCount=5;
    static int objectCoins=100;
    static int farmerLevel=0;
    static RegisterFarmer farmerStatus=RegisterFarmer.FARMER;



    public FarmerDetails(){
        this.playerBoard=new Board();
        this.plants=new ArrayList<Plants>();
    }
    public void addSeeds(String name, String type, float harvestTime, int waterNeeded, int waterBonus,
                         int fertilizerNeeded, int fertilizerBonus, int harvestCost, int produceCountMax,
                         int seedCost, int sellPrice) {
            this.plants.add(new Plants(name,type,harvestTime, waterNeeded,waterBonus,fertilizerNeeded,
                    fertilizerBonus,harvestCost,produceCountMax, seedCost,sellPrice));
    }

    public void AddWater(){
        //code to water plants
    }
    public void PlowLand(){
        objectCoins=objectCoins-2;
        //code to plow land
    }

    public void Harvest(){
        //code to harvest including increasing of Objectcoins
    }

    public void BuySeeds(){
        //code to bawas objectcoins based on price of seed
        //factor in status of farmer like bonus ganon
    }


}
