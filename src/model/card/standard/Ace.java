// subclass of Card --> Standard
// inherits the other attributes of Card --> Standard

package model.card.standard;

import engine.GameManager;
import engine.board.BoardManager;



//constructor uses super with rank 1
public class Ace extends Standard {
	public Ace(String name, String description, Suit suit, BoardManager boardManager, GameManager gameManager) {
		super(name, description, 1, suit, boardManager, gameManager);
	}

}
