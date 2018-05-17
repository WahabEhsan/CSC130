package project5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The main engine for playing the battleship game.
 * @author Dan Longo 
 * @author Matt Stallmann
 * @author Suzanne Balik
 * @author David Sturgill
 */
public class Battleship {
	/** Number of rows on the game board. */
	public static final int ROWS = 8;

	/** Number of columns on the game board. */
	public static final int COLS = 8;

	/** Number of ships on the game board. */
	public static final int NUMBER_OF_SHIPS = 4;

	/** Length of each ship, in order. */
	public static final int [] SHIP_LENGTHS = { 1, 2, 3, 4 };

	/** Name for each ship, in the same order as length. */
	public static final String [] SHIP_NAMES = {"Submarine", "Destroyer", "Cruiser", "Battleship"};

	/** Current state of the human board. */
	private BattleBoard player1Board;

	/** Wrapper for the BattleBoard, to prevent the AI from cheating */
	private BattleBoardWrapper player1BoardWrapper;
	
	/** Object that's making moves for the computer. If a Human is playing, this will remain null*/
	private BattleAI player1AI;	
		
	/** Number of squares that were hit at the end of the previous turn */
	private AtomicInteger player1BoardLastHitCount = new AtomicInteger(0); //make it an object so we can pass it around
	
	/** Current state of the computer board. */
	private BattleBoard player2Board;
	
	/** Wrapper for the BattleBoard, to prevent the AI from cheating */
	private BattleBoardWrapper player2BoardWrapper;	
	
	/** Object that's making moves for the computer. */
	private BattleAI player2AI;
	
	/** Number of squares that were hit at the end of the previous turn */
	private AtomicInteger player2BoardLastHitCount = new AtomicInteger(0); //make it an object so we can pass it around
	
	/** True if all the human's ships have been placed (i.e., when we're playing the game.) */
	private boolean donePlacingShips = false;

	/** True if the next ship that's to be placed will be horizontal. */
	private boolean horizontal = true;

	/** Index of the ship that will be placed next. */
	private int shipIndex = 0;

	/** True if the whole game is over. */
	private boolean finished = false;

	/** Status message that's of interest to the user. */
	private String status = "";

	/** Background thread for making two AIs play the game */
	private AICompetitionRunnable aiGame;
	
	/** Will hold the name of the winning player. Used for AI testing and ranking. */
	private String winner;
	
	/** Will hold the name of the losing player. Used for AI testing and ranking. */	
	private String loser;

	/**
	 * Constructor - sets up
	 *  - boards for human and computer
	 *  - panels for displaying these boards
	 *  - an AI program for the computer
	 *  - the GUI
	 * @param seed the random seed that is used for the computer's AI; if it's
	 * 0, the random sequence is unpredictable and not repeatable.
	 */
	public Battleship( long seed ) {
		this();//call the default constructor
//		humanBoard = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
//		humanBoardWrapper = new BattleBoardWrapper(humanBoard);
//		computerBoard = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
//		status = "Place " + SHIP_NAMES[0] + ", length = " + SHIP_LENGTHS[0]; 
		player2AI = new RandomBattleAI( player2Board, seed );
	}

	/**
	 * Just like the one-parameter constructor, but don't supply a seed to the game AI.
	 */
	public Battleship() {
		player1Board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
		player1BoardWrapper = new BattleBoardWrapper(player1Board);
		
		player2Board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
		player2BoardWrapper = new BattleBoardWrapper(player2Board);
		player2AI = new RandomBattleAI( player2Board );
		
		status = "Place " + SHIP_NAMES[0] + ", length = " + SHIP_LENGTHS[0];
	}
	
	/**
	 * Creates a new Battleship game with the specified AI class opponent for the human player
	 * 
	 * @param aiClassName the name of the AI class to use
	 */
	public Battleship(String aiClassName){
		this(); //call the default constructor
		player2Board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
		player2BoardWrapper = new BattleBoardWrapper(player2Board);
		player2AI = (BattleAI)getAIClassInstance(aiClassName, player2Board);		
	}

	/**
	 * Creates a new Battleship game with two computer players
	 * 
	 * @param aiClassName1 the name of the AI class to use for player 1 (left)
	 * @param aiClassName2 the name of the AI class to use for player 2 (right)
	 */
	public Battleship(String aiClassName1, String aiClassName2, int turnDelay){
		player1Board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
		player1BoardWrapper = new BattleBoardWrapper(player1Board);
		player1AI = (BattleAI)getAIClassInstance(aiClassName1, player1Board);
		donePlacingShips = true; //ship placement happens in the AI constructor
		
		player2Board = new BattleBoard(ROWS, COLS, NUMBER_OF_SHIPS);
		player2BoardWrapper = new BattleBoardWrapper(player2Board);
		player2AI = (BattleAI)getAIClassInstance(aiClassName2, player2Board);
		status = " ";
		
		aiGame = new AICompetitionRunnable(this, turnDelay);
		aiGame.start();
	}
	
	private BattleAI getAIClassInstance(String aiClassName, BattleBoard board) {
		try {
			Class classType = Class.forName(this.getClass().getPackage().getName() + "." + aiClassName);	
			Constructor constructor = classType.getConstructor(BattleBoard.class);			
			BattleAI aiInstance = (BattleAI)constructor.newInstance(board);
			return aiInstance;
		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
			System.out.println("Unable to load/create the class: " + aiClassName);
			ex.printStackTrace();
			System.exit(1);
		}
		return null;
	}

	/**
	 * @return the computer player's board
	 */
	BattleBoard getPlayer2Board() {
		return player2Board;
	}

	/**
	 * @return the human player's board.
	 */
	BattleBoard getPlayer1Board() {
		return player1Board;
	}

	/**
	 * @return number of rows of the game board
	 */
	int getNumberOfRows() { return ROWS; }

	/**
	 * @return number of columns of the game board
	 */
	int getNumberOfColumns() { return COLS; }

	/**
	 * @return the number of ships used in the game
	 */
	public int getNumberOfShips() { return NUMBER_OF_SHIPS; } 

	/**
	 * @return the length of the i-th ship
	 */
	public int getShipLength( int i ) {
		return SHIP_LENGTHS[i];
	}

	/**
	 * @return the status of the game
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return true if all the human player's ships have been placed.
	 */
	public boolean donePlacingShips() {
		// Just return the value of the field.
		return donePlacingShips;
	}

	/**
	 * If the player still needs to place a ship, return its length, otherwise
	 * undefined.
	 * @return length of the ship that will be placed next.
	 */
	public int placingLength() {
		return SHIP_LENGTHS[ shipIndex ];
	}

	/**
	 * Reacts to a mousePress in a grid square of player 1's grid
	 * 
	 * @param row the row of the grid in which the mouse was pressed
	 * @param column the column of the grid in which the mouse was pressed
	 */
	public void selectPlayer1GridSquare( int row, int column ) {
		if ( !donePlacingShips ) {
			if ( !player1Board.addShip( SHIP_LENGTHS[shipIndex], 	horizontal, row, column ) ) {
				status = "No room: try again with " + SHIP_NAMES[shipIndex];
			}
			else {
				moveOnToNextShip();
			}
		}
	}

	/**
	 * Reacts to a mousePress in a grid square of player 2's grid 
	 * @param row the row of the grid in which the mouse was pressed
	 * @param column the column of the grid in which the mouse was pressed
	 */
	public void selectPlayer2GridSquare( int row, int column ) {
		if ( donePlacingShips && ! finished ) {
			if ( !player2Board.fireAtLocation( row, column ) ) {
				status = "Square already hit -- try again";
				return;
			} else {
				checkResults( player2Board, player2BoardLastHitCount );
			}
			if ( !finished ) { 
				player2Turn();
			}
			if ( !finished ) {
				//FIX gui.putMessage("Your turn. Fire again.");
				status = "Your turn. Fire again.";
			}
		}
	}

	/**
	 * A ship has been successfully placed -- moves on to the next one
	 */
	public void moveOnToNextShip() {
		shipIndex++;
		if ( shipIndex < NUMBER_OF_SHIPS ) {
			status = "Place " + SHIP_NAMES[shipIndex] + ", length = " + SHIP_LENGTHS[shipIndex];
		}
		else {
			donePlacingShips = true;
			status = "Done placing ships. Firing begins ("  + getPlayer2Name() + " fired first).";
			player2Turn();
		}
	}

	/**
	 * Tell the game whether the currently placed ship will be horizontal.
	 * @param horizontal true if the next ship will be placed horizontally
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * Return true if the currently placed ship will be horizontal.  Undefined if all
	 * ships have been placed.
	 * @return true if the current ship will be placed horizontally.
	 */
	public boolean placingHorizontal() {
		return horizontal;
	}

	/**
	 * Checks the results of firing at a position and lets the GUI know if
	 * either party has won
	 */
	public void checkResults(BattleBoard board, AtomicInteger lastHitCount) {
		//TODO: make sure that the board was only hit once, to prevent AIs from cheating
		int currentHitCount = 0;
		for(int row = 0; row < board.getNumberOfRows(); row++){
			for(int col = 0; col < board.getNumberOfColumns(); col++){
				if( board.getHitStatus(row, col) != Square.HitStatus.NOT_YET_HIT ){ //count any square that was fired at, whether a hit or miss
					currentHitCount++;
				}
			}
		}
		if(currentHitCount > (lastHitCount.get() + 1)){ //the AI fired at the board multiple times- cheating!
			lastHitCount.set(currentHitCount);
			throw new RuntimeException("An AI Cheated by firing multiple times in one turn!");
		}
		lastHitCount.set(currentHitCount);
		
		if ( board.areAllShipsSunk() ) {
			if ( board == player2Board ) {
				status = getPlayer1Name() + " Wins!";
				winner = getPlayer1Name();
				loser = getPlayer2Name();
			}
			else {
				status = getPlayer2Name() + " Wins!";
				winner = getPlayer2Name();
				loser = getPlayer1Name();
			}
			finished = true;
		}
	}

	public void player1Turn() {
		//System.out.println("Player 1 start: " + player2BoardLastHitCount);
		player1AI.fireAtOpponentBoard(player2BoardWrapper);
		checkResults( player2Board, player2BoardLastHitCount );
		//System.out.println("Player 1 end: " + player2BoardLastHitCount);
	}
	
	/**
	 * Computer takes a turn.
	 */
	public void player2Turn() {
		//System.out.println("Player 2 start: " + player1BoardLastHitCount);
		player2AI.fireAtOpponentBoard(player1BoardWrapper);
		checkResults( player1Board, player1BoardLastHitCount );
		//System.out.println("Player 2 end: " + player1BoardLastHitCount);
	} 
	
	public String getPlayer1Name(){
		return player1AI == null ? "Human" : player1AI.getClass().getSimpleName() ;
	}
	
	public String getPlayer2Name(){
		return player2AI.getClass().getSimpleName();
	}
		
	public String getWinnerName(){
		return winner;
	}
	
	public String getLoserName(){
		return loser;
	}
	
	public boolean isGameFinished(){
		return finished;
	}
	
	public int getTurnDelay(){
		return aiGame.getTurnDelay();
	}
} 
