package myfarm;

public class Plants {
    private String name;
    private String type;
    private float harvestTime;
    private int waterNeeded;
    private int waterBonus;
    private int fertilizerNeeded;
    private int fertilizerBonus;
    private int harvestCost;
    private int produceCountMax;
    private int seedCost;
    private int sellPrice;

    public Plants(String name, String type, float harvestTime, int waterNeeded, int waterBonus,
                  int fertilizerNeeded, int fertilizerBonus, int harvestCost, int produceCountMax,
                  int seedCost, int sellPrice) {
        this.name = name;
        this.type = type;
        this.harvestTime = harvestTime;
        this.waterNeeded = waterNeeded;
        this.waterBonus=waterBonus;
        this.fertilizerNeeded = fertilizerNeeded;
        this.fertilizerBonus=fertilizerBonus;
        this.harvestCost = harvestCost;
        this.produceCountMax = produceCountMax;
        this.seedCost = seedCost;
        this.sellPrice = sellPrice;
    }

//    getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public float getHarvestTime() {
        return harvestTime;
    }

    public int getWaterNeeded() {
        return waterNeeded;
    }

    public int getFertilizerNeeded() {
        return fertilizerNeeded;
    }

    public int getHarvestCost() {
        return harvestCost;
    }

    public int getProduceCountMax() {
        return produceCountMax;
    }

    public int getSeedCost() {
        return seedCost;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public int getWaterBonus() {return waterBonus;}

    public int getFertilizerBonus() {return fertilizerBonus;}

    //    setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHarvestTime(float harvestTime) {
        this.harvestTime = harvestTime;
    }

    public void setWaterNeeded(int waterNeeded) {
        this.waterNeeded = waterNeeded;
    }
    public void setWaterBonus(int waterBonus) {this.waterBonus = waterBonus;}
    public void setFertilizerNeeded(int fertilizerNeeded) {
        this.fertilizerNeeded = fertilizerNeeded;
    }
    public void setFertilizerBonus(int fertilizerBonus) {this.fertilizerBonus = fertilizerBonus;}
    public void setHarvestCost(int harvestCost) {
        this.harvestCost = harvestCost;
    }

    public void setProduceCountMax(int produceCountMax) {
        this.produceCountMax = produceCountMax;
    }

    public void setSeedCost(int seedCost) {
        this.seedCost = seedCost;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return "myfarm.Plants [name=" + name + ", type=" + type + ", harvestTime=" +
                harvestTime + ", waterNeeded=" + waterNeeded + ", fertilizerNeeded=" +
                fertilizerNeeded + ", harvestCost=" + harvestCost + ", produceCountMax=" +
                produceCountMax + ", seedCost=" + seedCost + ", sellPrice=" + sellPrice + "]";
    }
}
