package myfarm.board;

import myfarm.Plant;
import myfarm.TileStatus;

public class Tile {
    private TileStatus status;
    private Plant crop;
    private String cropName;
    private String cropType;
    private int waterLevel;
    private int fertilizerLevel;
    private int harvestDate;

    // tile constructor
    public Tile() {
        status = TileStatus.UNPLOWED;
        crop = null;
        cropName = null;
        cropType = null;
        waterLevel = 0;
        fertilizerLevel = 0;
    }

    // getters
    public TileStatus getStatus() {
        return status;
    }

    public Plant getCrop() {
        return crop;
    }

    public String getCropName() {
        return cropName;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public int getHarvestDate() {
        return harvestDate;
    }

    public int getFertilizerLevel() {
        return fertilizerLevel;
    }

    // setters
    public void setStatus(TileStatus status) {
        this.status = status;
    }

    public void setWaterLevel(int waterLevel) {
        if (crop == null){
            return;
        }
        this.waterLevel = waterLevel;
    }

    public void setHarvestDate(int harvestDate, int harvestTime) {
        // get harvest time from crop
        // add it to day count from board
        this.harvestDate = harvestDate + harvestTime;
    }

    public void setCrop(Plant crop) {
        this.crop = crop;
        this.cropName = crop.getName();
        this.cropType = crop.getType();
    }
}
