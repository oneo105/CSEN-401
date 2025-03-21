package model.card;

import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import engine.GameManager;
import engine.board.BoardManager;
import model.card.standard.Suit;
import model.card.standard.Ten;
import model.card.wild.Burner;
import model.card.wild.Saver;
import model.card.standard.Standard;
import model.card.standard.Ace;
import model.card.standard.Five;
import model.card.standard.Four;
import model.card.standard.Jack;
import model.card.standard.King;
import model.card.standard.Queen;
import model.card.standard.Seven;

public class Deck {
    
    // final private attribute, static as member of class (not instance)
    private final static String CARDS_FILE = "Cards.csv";
    private static ArrayList<Card> cardsPool;
    
    // Method 1: Loads the CSV file
    public static void loadCardPool(BoardManager boardManager, GameManager gameManager) throws IOException {
    	cardsPool = new ArrayList<Card> ();
    	//VVIP to be initialized inside
		Card newCard = null;

    	BufferedReader br = new BufferedReader(new FileReader(CARDS_FILE));
        String line;
        try {
        	while((line = br.readLine()) != null) {
        		String[] row = line.split(",");
        		if(row.length != 4 && row.length != 6) {
        			throw new IOException(line);
        		}
        		int code = Integer.parseInt(row[0]);
        		int frequency = Integer.parseInt(row[1]);
        		
        		switch (code) {
        		 case 0:
                     newCard = new Standard(row[2],row[3], Integer.parseInt(row[4]), Suit.valueOf(row[5]), boardManager, gameManager);
                     break;
                 case 1:
                     newCard = new Ace(row[2],row[3], Suit.valueOf(row[5]), boardManager, gameManager);
                     break;
                 case 13:
                     newCard = new King(row[2],row[3], Suit.valueOf(row[5]), boardManager, gameManager);
                     break;
                 case 12:
                     newCard = new Queen(row[2],row[3], Suit.valueOf(row[5]), boardManager, gameManager);
                     break;
                 case 11:
                     newCard = new Jack(row[2],row[3], Suit.valueOf(row[5]), boardManager, gameManager);
                     break;
                 case 4:
                     newCard = new Four(row[2],row[3], Suit.valueOf(row[5]), boardManager, gameManager);
                     break;
                 case 5:
                     newCard = new Five(row[2],row[3], Suit.valueOf(row[5]), boardManager, gameManager);
                     break;
                 case 7:
                     newCard = new Seven(row[2],row[3], Suit.valueOf(row[5]), boardManager, gameManager);
                     break;
                 case 10:
                     newCard = new Ten(row[2],row[3], Suit.valueOf(row[5]), boardManager, gameManager);
                     break;
                 case 14:
                	 newCard = new Burner(row[2],row[3], boardManager, gameManager);
                     break;
                 case 15:
                	 newCard = new Saver(row[2],row[3], boardManager, gameManager);
                     break;
        		}
        		for (int i = 0; i <frequency; i++) {
        			cardsPool.add(newCard);
        		}

        		
        	}
        	
        }
        catch(Exception e) {
        	
        }
        finally {
        	br.close();
        }
    	
    }
    
    
    
    

          
    
    
    /* Skeleton Code
     * public static void loadCardPool(BoardManager boardManager, GameManager gameManager) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader(CARDS_FILE));
        String line;
        try {
        	while((line = br.readLine()) != null) {
        		String[] row = line.split(",");
        	}
        	
        }
        catch(Exception e) {
        	
        }
        finally {
        	br.close();
        }
    	
    }
     */
    

    
    
    // Method 2: Shuffles the card pool and draws 4 cards
    
    //4 failures 
    public static ArrayList<Card> drawCards() {
        // Shuffle the deck
        Collections.shuffle(cardsPool);
        // Determine how many cards to draw (up to 4)
        // Prepare a list to hold the drawn cards
        ArrayList<Card> drawn = new ArrayList<>();
        // Remove the first 'drawCount' cards from cardsPool and add them to drawn
        for (int i = 0; i < 4; i++) {
            drawn.add(cardsPool.remove(0));
        }
        return drawn;
    }
    


    
    
    // Main testing method (commented out)
    /*
    public static void main(String[] args) {
        try {
            // Mock implementations for BoardManager and GameManager interfaces
            BoardManager boardManager = new BoardManager() {
                @Override
                public int getSplitDistance() {
                    return 3;
                }
            };
            GameManager gameManager = new GameManager() {};
            
            // Load the card pool from CSV
            loadCardPool(boardManager, gameManager);
            
            // Print full deck before drawing
            System.out.println("Full Deck (" + cardsPool.size() + " cards):");
            for (int i = 0; i < cardsPool.size(); i++) {
                Card card = cardsPool.get(i);
                System.out.println((i + 1) + ". " + card.getName());
            }
            
            // Draw 4 random cards
            ArrayList<Card> drawnCards = drawCards();
            
            // Print drawn cards
            System.out.println("\nDrawn Cards:");
            for (int i = 0; i < drawnCards.size(); i++) {
                Card card = drawnCards.get(i);
                System.out.println((i + 1) + ". " + card.getName());
            }
            
            // Print remaining deck after drawing
            System.out.println("\nRemaining Deck (" + cardsPool.size() + " cards):");
            for (int i = 0; i < cardsPool.size(); i++) {
                Card card = cardsPool.get(i);
                System.out.println((i + 1) + ". " + card.getName());
            }
            
        } catch (IOException e) {
            System.err.println("Error loading card pool: " + e.getMessage());
        }
    }
    */
}