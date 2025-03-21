//Class
package model.player;

import model.Colour;

public class Marble {
	
	
	
	//Attributes / Private final
	private final Colour colour;
	
	
	
	//getter read only
		public Colour getColour() {
			return colour;
		}

		
		
	//Constructor
	public Marble(Colour colour) {
	this.colour = colour;
	}
	
}