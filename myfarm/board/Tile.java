package myfarm.board;

public class Tile {
    enum TileStatus {
        UNPLOWED, PLANTED, WITHERED, HARVESTED
    }
    private boolean isPlowed;
    private boolean isWithered;
    private boolean seedPlanted;
    private boolean harvestReady;
    private TileStatus status;

    // tile constructor
    public Tile() {
        isPlowed = false;
        isWithered = false;
        seedPlanted = false;
        harvestReady = false;
        status = TileStatus.UNPLOWED;
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
}
