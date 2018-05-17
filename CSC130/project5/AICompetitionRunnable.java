
package project5;

public class AICompetitionRunnable implements Runnable {
   private Thread t;
   private Battleship game;
   private final int turnDelay;
	
   AICompetitionRunnable(Battleship game, int turnDelay) {
      this.game = game;
		this.turnDelay = turnDelay;
   }
   
   public void run() {
      //System.out.println("Starting AI competition");
      try {
			while(!game.isGameFinished()){
				game.player2Turn();
				Thread.sleep(turnDelay);
				game.player1Turn();
				Thread.sleep(turnDelay);
			}
      } catch (InterruptedException e) {
         System.out.println("Thread interrupted.");
      }
      //System.out.println("Game over. Thread exiting.");
   }
   
   public void start () {      
      if (t == null) {
         t = new Thread (this);
         t.start ();
      }
   }
	
	public int getTurnDelay(){
		return turnDelay;
	}
}
