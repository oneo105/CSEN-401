// class
package model.player;

import java.util.ArrayList;
import model.card.Card;
import model.Colour;

public class Player {
	
	
	//Attributes
	private final String name;
	private final Colour colour;
	private ArrayList<Card> hand;
	private final ArrayList<Marble> marbles;
	private Card selectedCard;
	private final ArrayList<Marble> selectedMarbles;

	
	
	//getters and setters
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public String getName() {
		return name;
	}

	public Colour getColour() {
		return colour;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public ArrayList<Marble> getMarbles() {
		return marbles;
	}

	public Card getSelectedCard() {
		return selectedCard;
	}

	
	
	public Player(String name, Colour colour) {
		this.name = name;
		this.colour = colour;
		hand = new ArrayList <Card> ();
		selectedMarbles = new ArrayList <Marble> ();
		marbles = new ArrayList <Marble> ();
		marbles.add(new Marble(colour));
		marbles.add(new Marble(colour));
		marbles.add(new Marble(colour));
		marbles.add(new Marble(colour));
		selectedCard = null; 
	}

	
}
