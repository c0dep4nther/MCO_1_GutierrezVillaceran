package myfarm;

public class Plants {
    private String name;
    private String type;
    private int harvestTime;
    private int waterNeeded;
    private int fertilizerNeeded;
    private int harvestCost;
    private int produceCount;
    private int seedCost;
    private int sellPrice;

    public Plants(String name, String type, int harvestTime, int waterNeeded,
                  int fertilizerNeeded, int harvestCost, int produceCount,
                  int seedCost, int sellPrice) {
        this.name = name;
        this.type = type;
        this.harvestTime = harvestTime;
        this.waterNeeded = waterNeeded;
        this.fertilizerNeeded = fertilizerNeeded;
        this.harvestCost = harvestCost;
        this.produceCount = produceCount;
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

    public int getHarvestTime() {
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

    public int getProduceCount() {
        return produceCount;
    }

    public int getSeedCost() {
        return seedCost;
    }

    public int getSellPrice() {
        return sellPrice;
    }

//    setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHarvestTime(int harvestTime) {
        this.harvestTime = harvestTime;
    }

    public void setWaterNeeded(int waterNeeded) {
        this.waterNeeded = waterNeeded;
    }

    public void setFertilizerNeeded(int fertilizerNeeded) {
        this.fertilizerNeeded = fertilizerNeeded;
    }

    public void setHarvestCost(int harvestCost) {
        this.harvestCost = harvestCost;
    }

    public void setProduceCount(int produceCount) {
        this.produceCount = produceCount;
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
                fertilizerNeeded + ", harvestCost=" + harvestCost + ", produceCount=" +
                produceCount + ", seedCost=" + seedCost + ", sellPrice=" + sellPrice + "]";
    }
}
