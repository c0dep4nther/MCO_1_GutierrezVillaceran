package myfarm.board;

public class Tile {
    private boolean isPlowed;
    private boolean isWithered;
    private boolean seedPlanted;
    private boolean harvestReady;

    // tile constructor
    public Tile() {
        isPlowed = false;
        isWithered = false;
        seedPlanted = false;
        harvestReady = false;
    }

    // plow tile using the Plow class
    public void plowTile() {
        isPlowed = true;
    }


}
