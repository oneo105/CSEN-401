package engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;  // Recommended for shuffling colours
import model.Colour;
import model.card.Card;
import model.card.Deck;
import engine.board.Board;
import engine.board.BoardManager;
import model.player.CPU;
import model.player.Player;

//testing the git

public class Game implements GameManager {

    // Attributes
    private final Board board;
    private final ArrayList<Player> players;
    private final ArrayList<Card> firePit;
    private int currentPlayerIndex;
    private int turn;
    
    // Getters
    public Board getBoard() {
        return board;
    }
    
    public ArrayList<Player> getPlayers() {
        return players;
    }
    
    public ArrayList<Card> getFirePit() {
        return firePit;
    }
    
    // Constructor
    public Game(String playerName) throws IOException {
        // Create an ArrayList of colours in a fixed order
        ArrayList<Colour> randColour = new ArrayList<Colour>(4);
        randColour.add(Colour.RED);
        randColour.add(Colour.BLUE);
        randColour.add(Colour.YELLOW);
        randColour.add(Colour.GREEN);
        
        // Shuffle the colours to randomize their order.
        // Suggestion: use Collections.shuffle for a uniform shuffle.
        Collections.shuffle(randColour);
        
        // Initialize board using the randomized colour order and pass this game as GameManager.
        board = new Board(randColour, this);
        
        // Load the card pool from CSV
        Deck.loadCardPool((BoardManager) board, this);
        
        // Create a human player with the first colour and CPU players with the rest.
        Player user = new Player(playerName, randColour.get(0));
        CPU cpu1 = new CPU("CPU 1", randColour.get(1), (BoardManager) board);
        CPU cpu2 = new CPU("CPU 2", randColour.get(2), (BoardManager) board);
        CPU cpu3 = new CPU("CPU 3", randColour.get(3), (BoardManager) board);
        
        // Initialize players list and add players
        players = new ArrayList<Player>();
        players.add(user);
        players.add(cpu1);
        players.add(cpu2);
        players.add(cpu3);
        
        // Distribute 4 cards to each player's hand using the Deck.drawCards() method.
        user.setHand(Deck.drawCards());
        cpu1.setHand(Deck.drawCards());
        cpu2.setHand(Deck.drawCards());
        cpu3.setHand(Deck.drawCards());
        
        // Initialize game tracking variables
        currentPlayerIndex = 0;
        turn = 0;
        firePit = new ArrayList<Card>();
    }
}
