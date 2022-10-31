package myfarm;

import myfarm.board.Board;

import java.util.ArrayList;

public class FarmerDetails {

    private int seedCount=0;
    private int fertilizerCount=5;
    private int objectCoins=100;
    private int farmerLevel=0;
    private RegisterFarmer farmerStatus=RegisterFarmer.FARMER;
    private int experience=0;

    public void addWater(Tools tool){
        //code to water plants
        objectCoins=objectCoins-tool.getCost();
    }
    public void plowLand(Tools tool){
        objectCoins=objectCoins- tool.getCost();
        //code to plow land
    }
    /**method to increase money and experience when harvesting*/
    public void harvestPlant(Plants plant, int numOfHarvest){
        int sellingPrice=0;
        setExperience(experience+1); //increases experience when harvesting

        //NOT SURE SA COMPUTATION NG WATER, FERTILIZER, AND CROP BONUS
        sellingPrice=farmerStatus.getBonusLimits()+plant.getSellPrice()+plant.getFertilizerBonus()+ plant.getWaterBonus();
        setObjectCoins(objectCoins+sellingPrice*numOfHarvest);

    }

    /**method to reduce money when buying seeds*/
    public void buySeeds(Plants plant,int numberOfSeeds){
        int newCost=plant.getSeedCost()-farmerStatus.getBuying();
        setObjectCoins(getObjectCoins()-newCost*numberOfSeeds);
        setSeedCount(seedCount+numberOfSeeds);
    }

    public int getSeedCount() {
        return seedCount;
    }

    public void setSeedCount(int seedCount) {
        this.seedCount = seedCount;
    }

    public int getFertilizerCount() {
        return fertilizerCount;
    }

    public void setFertilizerCount(int fertilizerCount) {
        this.fertilizerCount = fertilizerCount;
    }

    public int getObjectCoins() {
        return objectCoins;
    }

    public void setObjectCoins(int objectCoins) {
        this.objectCoins = objectCoins;
    }

    public int getFarmerLevel() {
        return farmerLevel;
    }

    public void setFarmerLevel(int experience) {
        this.farmerLevel = this.experience/100;
    }

    public RegisterFarmer getFarmerStatus() {
        return farmerStatus;
    }

    public void setFarmerStatus(RegisterFarmer farmerStatus) {
        this.farmerStatus = farmerStatus;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


}
