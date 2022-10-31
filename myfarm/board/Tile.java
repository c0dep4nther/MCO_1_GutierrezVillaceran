package myfarm.board;

import myfarm.Plants;
import myfarm.TileStatus;

public class Tile {
    private boolean isPlowed;
    private boolean isWithered;
    private boolean seedPlanted;
    private boolean harvestReady;
    private TileStatus status;
    private Plants cropName;
    private Plants cropType;
    private int waterLevel;
    private int fertilizerLevel;

    // tile constructor
    public Tile() {
        isPlowed = false;
        isWithered = false;
        seedPlanted = false;
        harvestReady = false;
        status = TileStatus.UNPLOWED;
        cropName = null;
        cropType = null;
        waterLevel = 0;
        fertilizerLevel = 0;
    }

    // plow tile using the Plow class
    public void plowTile() {
        isPlowed = true;
    }

//    getters
    public boolean isPlowed() {
        return isPlowed;
    }

    public boolean isWithered() {
        return isWithered;
    }

    public boolean isSeedPlanted() {
        return seedPlanted;
    }

    public boolean isHarvestReady() {
        return harvestReady;
    }

    public TileStatus getStatus() {
        return status;
    }

    public Plants getCropName() {
        return cropName;
    }

    public Plants getCropType() {
        return cropType;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public int getFertilizerLevel() {
        return fertilizerLevel;
    }

//    setters
    public void setPlowed(boolean plowed) {
        isPlowed = plowed;
    }

    public void setWithered(boolean withered) {
        isWithered = withered;
    }

    public void setSeedPlanted(boolean seedPlanted) {
        this.seedPlanted = seedPlanted;
    }

    public void setHarvestReady(boolean harvestReady) {
        this.harvestReady = harvestReady;
    }

    public void setCropName(Plants cropName) {
        this.cropName = cropName;
    }

}
