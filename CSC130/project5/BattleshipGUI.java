package project5;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 * Provides GUI for Battleship game
 * @author Dan Longo
 * @author Matt Stallmann
 * @author Suzanne Balik
 * @author David Sturgill
 */
public class BattleshipGUI extends JFrame implements ActionListener {

	/** Font for all the UI controls. */
	private static final Font DEFAULT_FONT = new Font("Arial", 1, 20);

	/** Space around the game grids. */
	private static final int GRID_PADDING = 8;

	/** Reference to the game we're playing. */
	private Battleship game;

	/** GUI object showing the board for player 1 (typically Human). */
	private Grid player1Grid;

	/** GUI object showing the board for player 2 (AI). */
	private Grid player2Grid;

	/** Button for switching to horizontal ship orientation. */
	private JButton hButton;

	/** Button for switching to vertical ship orientation. */
	private JButton vButton;

	/** Label showing the current status message. */
	private JLabel message;
	
	/** South end of the window is a box, with a row for two buttons and another row for the status message. */
	private Box southBox;

	/** Buttons for horizontal and vertical */
	private Box buttonBox;
	
	/** 
	 * Make a GUI for the battleship game.
	 * @param game Game object that keeps up with the current state of the game.
	 */
	public BattleshipGUI( Battleship game, boolean bothPlayersAreAI) {
		this.game = game;

		// Ships are visible on the human grid but not on the computer grid
		// (last argument)
		player1Grid = new Grid( game.getPlayer1Board(), this, true );
		player2Grid = new Grid( game.getPlayer2Board(), this, bothPlayersAreAI );
		setTitle( "Battleship Game" );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout( new BorderLayout() );

		Box gamePanel = new Box( BoxLayout.X_AXIS );
		add(gamePanel, BorderLayout.CENTER);

		// Add human and computer panels to the game; the human panel has a
		// title, grid, and buttons; the computer panel has only a title and a
		// grid
		Box player1Box = new Box( BoxLayout.Y_AXIS );
		Box player2Box = new Box( BoxLayout.Y_AXIS );
		gamePanel.add( Box.createRigidArea( new Dimension( GRID_PADDING, 0 ) ) );
		gamePanel.add( player1Box );
		gamePanel.add( Box.createRigidArea( new Dimension( GRID_PADDING, 0 ) ) );
		gamePanel.add( player2Box );
		gamePanel.add( Box.createRigidArea( new Dimension( GRID_PADDING, 0 ) ) );

		// Add three parts to the human panel
		JLabel player1Label = new JLabel( game.getPlayer1Name() );
		player1Label.setAlignmentX( Component.CENTER_ALIGNMENT );
		player1Label.setFont( DEFAULT_FONT );
		player1Box.add( player1Label );
		player1Box.add( player1Grid );

		// Add two parts to the computer panel
		JLabel player2Label = new JLabel( game.getPlayer2Name() );
		player2Label.setAlignmentX( Component.CENTER_ALIGNMENT );
		player2Label.setFont( DEFAULT_FONT );
		player2Box.add( player2Label );
		player2Box.add( player2Grid );

		// South end of the window is a box, with a row for two buttons and
		// another row for the status message.
		southBox = new Box( BoxLayout.Y_AXIS );

		// Buttons for horizontal and vertical
		buttonBox = new Box( BoxLayout.X_AXIS );
		buttonBox.setAlignmentX( Component.CENTER_ALIGNMENT );
		hButton = new JButton("Horizontal");
		hButton.setFont( DEFAULT_FONT );
		hButton.addActionListener(this);
		vButton = new JButton("Vertical");
		vButton.setFont( DEFAULT_FONT );
		vButton.addActionListener(this);
		buttonBox.add( hButton );
		buttonBox.add( vButton );
		buttonBox.add(Box.createHorizontalGlue());
		southBox.add( buttonBox );

		message = new JLabel( "Game begins", SwingConstants.RIGHT );
		message.setAlignmentX( Component.CENTER_ALIGNMENT );
		message.setFont( DEFAULT_FONT );
		southBox.add( message );

		add( southBox, BorderLayout.SOUTH );

		updateStatus();

		pack();
		setVisible(true);
		
		if(bothPlayersAreAI){ //if both players are controlled by an AI, we need to continually refrsh the board, since no clicks will be firing the refresh command
			Thread thread = new Thread("New Thread") {
				public void run(){
					try {
						while(!game.isGameFinished()){
							Thread.sleep(game.getTurnDelay());
							updateStatus();
							repaint();
						}
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}					
				}
			};
			thread.start();			
		}
	}

	/**
	 * Update the status of the GUI based on any changes in the game object.
	 */
	private void updateStatus() {
		if ( game.donePlacingShips() ) {
			// Kill the ship highlight and disable the vertical/horizontal buttons.
			player1Grid.setHoverShape( null );
			hButton.setEnabled( false );
			vButton.setEnabled( false );
			southBox.remove( buttonBox );
		} else {
			int len = game.placingLength();
			boolean horiz = game.placingHorizontal();
			player1Grid.setHoverShape( new Dimension( horiz ? len : 1, horiz ? 1 : len ) );
		}

		message.setText(game.getStatus());
		repaint();
	}

	/**
	 * Callback from the Grid objects, for when the button gets pressed.
	 * This is really an example of cyclic dependency, but, we'd need to use
	 * some more object-oriented features to do a good job fixing it.
	 * @param grid Grid object that was clicked on.
	 * @param row row of the grid that was clicked
	 * @param column column of the grid that was clicked
	 */
	public void gridPress( Grid grid, int row, int column ) {
		if ( grid == player1Grid ) {
			game.selectPlayer1GridSquare( row, column );
		}
		else {
			game.selectPlayer2GridSquare( row, column );
		}
		updateStatus();
		repaint();
	}

	/**
	 * Cranks up the game. The rest is driven by mouse events.
	 * @param args command-line arguments, possibly including a seed.
	 */
	public static void main( String args[] ) {
		if (args.length == 0) {
			new BattleshipGUI(new Battleship(), false);
		} else if (args.length == 1) { //either sending a seed to the RandomBattleAI, or wanting to use a different AI class
			try {
				int seed = Integer.parseInt(args[0]);
				new BattleshipGUI(new Battleship(seed), false);
			}
			catch (NumberFormatException e) { //it must be an AI name; load the AI
				String aiClassName = args[0];
				new BattleshipGUI(new Battleship(aiClassName), false); //use reflection to load the AI
			}
		} else if (args.length == 2){
			startAIGame(args, 1000); //start with a default turn delay of 1 second 
		} else if (args.length == 3){
			int turnDelay = Integer.parseInt(args[2]);			
			startAIGame(args, turnDelay); 
		} else {
			usageMessage();
			System.exit(1);
		}
	}

	private static void startAIGame(String[] args, int turnDelay) {
		String aiClassName1 = args[0];
		String aiClassName2 = args[1];
		new BattleshipGUI(new Battleship(aiClassName1, aiClassName2, turnDelay), true); //use reflection to load the AI
	}

	/**
	 * Callback used to respond to button presses.
	 * @param e event capturing information about the button press.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == hButton) {
			game.setHorizontal(true);
		}
		if (e.getSource() == vButton) {
			game.setHorizontal(false);
		}
		updateStatus();
	}

	/**
	 * Prints a message about how the program should be used
	 */
	private static void usageMessage() {
		System.out.println( "Usage: \n"
				  + "java BattleShipGUI <seed>\n"
				  + "or:\n"
				  + "java BattleShipGUI <NameOfAIClass>\n"
				  + "or:\n"
				  + "java BattleShipGUI <NameOfFirstAIClass> <NameOfSecondAIClass>\n"
				  + "or:\n"
				  + "java BattleShipGUI <NameOfFirstAIClass> <NameOfSecondAIClass> turnDelay" );
	}
}


