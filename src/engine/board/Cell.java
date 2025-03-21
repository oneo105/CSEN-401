//Class
package engine.board;

import model.player.Marble;

public class Cell {
	
	
	
	// private attributes
	private Marble marble;
	private CellType cellType;
	private boolean trap;
	
	
	
	//setters and getters, read and write
	public Marble getMarble() {
		return marble;
	}

	public CellType getCellType() {
		return cellType;
	}

	public boolean isTrap() {
		return trap;
	}

	public void setMarble(Marble marble) {
		this.marble = marble;
	}

	public void setCellType(CellType cellType) {
		this.cellType = cellType;
	}

	public void setTrap(boolean trap) {
		this.trap = trap;
	}
	
	
	
	//constructor
	public Cell(CellType cellType){
		marble = null;
		trap = false;
		this.cellType = cellType;
	}


}
