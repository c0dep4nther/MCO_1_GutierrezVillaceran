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
    private int maxProduce;
    private int seedCost;
    private int sellPrice;

    public Plants(String name, String type, float harvestTime, int waterNeeded,
                  int fertilizerNeeded, int harvestCost, int maxProduce,
                  int seedCost, int sellPrice) {
        this.name = name;
        this.type = type;
        this.harvestTime = harvestTime;
        this.waterNeeded = waterNeeded;
        this.fertilizerNeeded = fertilizerNeeded;
        this.harvestCost = harvestCost;
        this.maxProduce = maxProduce;
        this.seedCost = seedCost;
        this.sellPrice = sellPrice;

        switch (name) {
            case "Turnip", "Carrot", "Rose" -> {
                waterBonus = 2;
                fertilizerBonus = 1;
            }
            case "Stargazer" -> {
                waterBonus = 3;
                fertilizerBonus = 1;
            }
        }
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

    public int getMaxProduce() {
        return maxProduce;
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

    public void setMaxProduce(int maxProduce) {
        this.maxProduce = maxProduce;
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
                maxProduce + ", seedCost=" + seedCost + ", sellPrice=" + sellPrice + "]";
    }
}
