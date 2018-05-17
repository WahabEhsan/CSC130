package project5;

import java.util.*;
import project5.Square.HitStatus;

/**
 * A very stupid computer strategy, everything random. In order to make this
 * smarter, you would need a BattleBoard method that lets the computer know
 * whether the most recent firing hit a ship and/or some information about
 * the progress of the game.
 */
public class RandomBattleAI implements BattleAI{
	private BattleBoard computerBoard;
	private Random rand;
	
	/**
	 * Constructor
	 * initializes instance variables, sets up the random number sequence and
	 * places the ships
	 * @param computerBoard the computer's game board; used for placing the ships
	 * @param seed the random number seed; not used if seed = 0
	 */
	public RandomBattleAI(BattleBoard computerBoard, long seed) {
		this.computerBoard = computerBoard;
		rand = new Random( seed ); //initialize the random number generator with the desired seed
		setUpShips();
	}

	/**
	 * Constructor
	 * initializes instance variables, sets up the random number sequence and
	 * places the ships
	 * @param computerBoard the computer's game board; used for placing the ships
	 */
	public RandomBattleAI(BattleBoard computerBoard) {
		this.computerBoard = computerBoard;
		rand = new Random();
		setUpShips();
	}

	/** sets up ships in a random fashion */
	@Override
	public void setUpShips() {
		for (int i = 0; i < Battleship.NUMBER_OF_SHIPS; i++) {
			boolean successful = false;
			while(!successful) {
				int orientation = rand.nextInt(2);
				boolean horizontal = true;
				if (orientation == 1) {
					horizontal = false;
				}
				int row = rand.nextInt(computerBoard.getNumberOfRows());
				int col = rand.nextInt(computerBoard.getNumberOfColumns());
				if (computerBoard.addShip(Battleship.SHIP_LENGTHS[i], horizontal, row, col)) {
					successful = true;
				}
			}
		}
	}

	/** Chooses a random position for firing at the board of the opposing player */
	@Override
	public void fireAtOpponentBoard(BattleBoardWrapper opponentBoard){
		boolean successful = false;
		while (!successful) {
			int row = rand.nextInt(computerBoard.getNumberOfRows());
			int col = rand.nextInt(computerBoard.getNumberOfColumns());
			if (opponentBoard.getHitStatus(row, col) == HitStatus.NOT_YET_HIT) {
				opponentBoard.fireAtLocation(row, col);
				successful = true;
			}
		}
	}
}






