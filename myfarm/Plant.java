package myfarm;

public class Plant {
    private final String name;
    private final String type;
    private final int harvestTime;
    private final int waterNeed;
    private final int waterBL;
    private final int fertilizerNeed;
    private final int fertilizerBL;
    private final int maxProduce;
    private final int minProduce;
    private final int seedCost;
    private final int sellPrice;
    private final float expGain;

    public Plant(String name, String type, int harvestTime,
                 int waterNeed, int waterBL, int fertilizerNeed, int fertilizerBL, int maxProduce,
                 int minProduce, int seedCost, int sellPrice,
                 float expGain) {
        this.name = name;
        this.type = type;
        this.harvestTime = harvestTime;
        this.waterNeed = waterNeed;
        this.waterBL = waterBL;
        this.fertilizerNeed = fertilizerNeed;
        this.fertilizerBL = fertilizerBL;
        this.maxProduce = maxProduce;
        this.minProduce = minProduce;
        this.seedCost = seedCost;
        this.sellPrice = sellPrice;
        this.expGain = expGain;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHarvestTime() {
        return harvestTime;
    }

    public int getWaterNeed() {
        return waterNeed;
    }

    public int getWaterBL() {
        return waterBL;
    }

    public int getFertilizerNeed() {
        return fertilizerNeed;
    }

    public int getFertilizerBL() {
        return fertilizerBL;
    }

    public int getMaxProduce() {
        return maxProduce;
    }

    public int getMinProduce() {
        return minProduce;
    }

    public int getSeedCost() {
        return seedCost;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public float getExpGain() {
        return expGain;
    }
}
