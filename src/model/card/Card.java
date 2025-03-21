// abstract class
package model.card;

import engine.GameManager;
import engine.board.BoardManager;

abstract public class Card{
	
	
	
	//private and protected attributes final
	private final String name;
	private final String description;
	protected BoardManager boardManager;
	protected GameManager gameManager;

	
	
	//getters only
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	
	
	//constructor 
	public Card(String name, String description, BoardManager boardManager, GameManager gameManager) {
		this.name = name;
		this.description = description;
		this.boardManager = boardManager;
		this.gameManager = gameManager;
	
	}


	
}
