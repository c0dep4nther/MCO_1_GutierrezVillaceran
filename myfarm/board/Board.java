package myfarm.board;

import java.util.HashMap;

public class Board {

//    use hashmap to store integer as key and then tile as value
    private HashMap<Integer, Tile> tiles = new HashMap<>();

//    board constructor
    public Board() {
        for (int i = 1; i <= 50; i++) {
            tiles.put(i, new Tile());
        }
    }

    public HashMap<Integer, Tile> getTiles() {
        return tiles;
    }

    public Tile.TileStatus getTileStatus(int tileNumber) {
        return tiles.get(tileNumber).getStatus();
    }
}
