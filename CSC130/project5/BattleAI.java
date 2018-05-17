package project5;

/**
 * An interface that all AI opponents must implement. This interface contains
 * behaviors for placing the ships, and firing at the other player.
 */

public interface BattleAI {
	
	/** sets up ships in a random fashion */
	public void setUpShips();

	/** Chooses a position for firing at the board of the opposing player */
	public void fireAtOpponentBoard(BattleBoardWrapper opponentBoard);
}






