package myfarm.board;

import myfarm.TileStatus;

import java.util.HashMap;

public class Board {

//    use hashmap to store integer as key and then tile as value
    private final HashMap<Integer, Tile> tiles = new HashMap<>();

//    board constructor
    public Board() {
        for (int i = 1; i <= 50; i++) {
            tiles.put(i, new Tile());
        }
    }

    //method to access the tile value
    public Tile getTile(int tileNumber) {
        return tiles.get(tileNumber);
    }

    public TileStatus getTileStatus(int tileNumber) {
        return tiles.get(tileNumber).getStatus();
    }
}
