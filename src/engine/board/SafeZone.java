//class
package engine.board;

import java.util.ArrayList;
import model.Colour;

public class SafeZone {
	
	
	
	// private final attributes
	private final Colour colour;
	private final ArrayList<Cell> cells;
	
	
	
	// getters, read only
	public Colour getColour() {
		return colour;
	}

	public ArrayList<Cell> getCells() {
		return cells;
	}
	
	
	
	//constructor
	public SafeZone(Colour colour){
		this.colour = colour;
        this.cells = new ArrayList<>(4); // four cells
        cells.add(new Cell(CellType.SAFE)); //populate
        cells.add(new Cell(CellType.SAFE));
        cells.add(new Cell(CellType.SAFE));
        cells.add(new Cell(CellType.SAFE));
        //O(n) to avoid loop, it's still O(n) in loop but why not 
	}




}
