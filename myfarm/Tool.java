package myfarm;

import myfarm.board.Tile;
import myfarm.TileStatus;

public class Tool {
    private final String name;
    private final int cost;
    private final float expGain;

    public Tool(String name, int cost, float expGain) {
        this.name = name;
        this.cost = cost;
        this.expGain = expGain;
    }

    public Tile toolAction (Tile farmLot) {
        switch (name) {
            case "Watering Can" -> {
                System.out.println("Tile watered.");
                farmLot.setWaterLevel(farmLot.getWaterLevel() + 1);
            }
            case "Plow" -> {
                System.out.println("Tile is now plowed.");
                farmLot.setStatus(TileStatus.PLOWED);
            }
        }

        return farmLot;
    }

    public String getName() {
        return name;
    }

    public float getExpGain() {
        return expGain;
    }
}
