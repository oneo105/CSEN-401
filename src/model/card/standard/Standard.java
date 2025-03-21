// subclass of Card
// inherits the other attributes of Card
package model.card.standard;

import engine.GameManager;
import engine.board.BoardManager;
import model.card.Card;

public class Standard extends Card{
	
	
	
	//private and final attributes
	private final int rank;
	private final Suit suit;
	
	
	
	//getters as read only
	public int getRank() {
		return rank;
	}



	public Suit getSuit() {
		return suit;
	}
	
	

	//constructor that uses super of main class.
	public Standard(String name, String description, int rank, Suit suit, BoardManager boardManager, GameManager gameManager) {
		super(name, description, boardManager, gameManager);
		this.rank = rank;
		this.suit = suit;
	}
	
}
