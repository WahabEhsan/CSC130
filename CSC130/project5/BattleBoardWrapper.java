package project5;

import java.util.ArrayList;
import project5.Square.HitStatus;

/**
 * This class is a wrapper around the BattleBoard class that does not provide access
 * to the ships or their location. This is to prevent the AI from using that data
 * to cheat.
 */
public class BattleBoardWrapper {
	private final BattleBoard battleBoard;

	public BattleBoardWrapper(BattleBoard board) {
		this.battleBoard = board;
	}

	public boolean fireAtLocation(int row, int col) {
		return battleBoard.fireAtLocation(row, col);
	}

	public HitStatus getHitStatus(int row, int col) {
		return battleBoard.getHitStatus(row, col);
	}

	public int getNumberOfShips() {
		return battleBoard.getNumberOfShips();
	}

	public boolean areAllShipsSunk() {
		//returns true if all of the Ships on the BattleBoard have been sunk by enemy fire.
		return battleBoard.areAllShipsSunk();
	}
	
	public boolean isShipSunk(int shipIndex){
		return battleBoard.isShipSunk(shipIndex);
	}	
		
	public ArrayList<Ship> getAllSunkenShips(){
		return battleBoard.getAllSunkenShips();
	}
	
	public int getNumberOfRows() {
		//returns the number of rows in the BattleBoard.
		return battleBoard.getNumberOfRows();
	}

	public int getNumberOfColumns() {
		//returns the number of columns in the BattleBoard.
		return battleBoard.getNumberOfColumns();
	}
}
