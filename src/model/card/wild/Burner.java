// subclass of Card --> Wild
// inherits the other attributes of Card --> Wild
package model.card.wild;

import engine.GameManager;
import engine.board.BoardManager;

public class Burner extends Wild{
	public Burner(String name, String description, BoardManager boardManager, GameManager gameManager){
		super(name, description, boardManager, gameManager);
	}

}
