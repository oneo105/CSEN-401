package engine.board;

import java.util.ArrayList;
import engine.GameManager;
import model.Colour;

public class Board implements BoardManager {

    // Attributes
    private final GameManager gameManager;
    private final ArrayList<Cell> track;
    private final ArrayList<SafeZone> safeZones;
    private int splitDistance;
    
    // Getter and Setter for splitDistance
    public void setSplitDistance(int splitDistance) {
        this.splitDistance = splitDistance;
    }
    
    public int getSplitDistance() {
        return splitDistance;
    }
    
    public GameManager getGameManager() {
        return gameManager;
    }
    
    public ArrayList<Cell> getTrack() {
        return track;
    }
    
    public ArrayList<SafeZone> getSafeZones() {
        return safeZones;
    }
    
    // Constructor: initializes the board as specified
    public Board(ArrayList<Colour> colourOrder, GameManager gameManager) {
        this.gameManager = gameManager;
        track = new ArrayList<Cell>(100);
        safeZones = new ArrayList<SafeZone>(4);
        splitDistance = 3;
        
        // Set the track with the correct type of cells
        for (int i = 0; i < 100; i++) {
            if (i == 0 || i == 25 || i == 50 || i == 75)
                track.add(new Cell(CellType.BASE));
            else if (i == 23 || i == 48 || i == 73 || i == 98)
                track.add(new Cell(CellType.ENTRY));
            else
                track.add(new Cell(CellType.NORMAL));
        }

        
        // Change 8 random NORMAL track cells to be flagged as trap cells
        for (int j = 0; j < 8; j++) {
            assignTrapCell();
        }
        
        // Create 4 SafeZones with the provided colour order
        safeZones.add(new SafeZone(colourOrder.get(0)));
        safeZones.add(new SafeZone(colourOrder.get(1)));
        safeZones.add(new SafeZone(colourOrder.get(2)));
        safeZones.add(new SafeZone(colourOrder.get(3)));
    }
    
    // assignTrapCell: Randomizes a cell position and flags it as trap if it is a NORMAL cell and not already a trap
    private void assignTrapCell() {
        int rand = (int)(Math.random() * 100);
        // Repeat until a cell is found that is NORMAL and not already a trap
        while (track.get(rand).getCellType() != CellType.NORMAL || track.get(rand).isTrap()) {
            rand = (int)(Math.random() * 100);
        }
        track.get(rand).setTrap(true);
    }
}