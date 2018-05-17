
package project5;

import java.util.ArrayList;
import project5.Square.HitStatus;

/**
 * Model template for the human player's and computer's boards in Battleship.
 * 
 * @author Wahab Ehsan
 */
public class BattleBoard {
    //Private fields for BAttleBoard
    private int numberOfRows;
    private int numberOfColumns;
    private int maximumNumberOfShips;
    private int numberOfShipOnBoard;
    private Square[][] square;
    private Ship[] ship;
    private ArrayList<Ship> sunkenShips;

    /**
     * Checks the Hit status of the Square with the row and col provided
     * @param row Row of the grid to find hit status
     * @param col column of the grid to find hit status
     * @return The Hit status 
     */
    public HitStatus getHitStatus(int row, int col) {
        if (row < 0 || col < 0 || row >= numberOfRows || col >= numberOfColumns) {
            throw new IllegalArgumentException("Error");
        }
        return square[row][col].getHitStatus();

    }

    /**
     * Adds a ship to the given coordinates in the grid if its possible.
     * 
     * @param length length of the ship
     * @param isHorizontal the orientation of the ship
     * @param startRow The start row provided
     * @param startCol The start column provided
     * @return boolean value if the ship was successful in adding or not
     */
    public boolean addShip(int length, boolean isHorizontal, int startRow, int startCol) {
        //Checks if the ship is placable
        if (isHorizontal) { //if the ship is horizontal runs these statements 
            for (int i = 0; i < length; i++) { //runs loop equavalent to length given for ship
                if (startCol + i >= numberOfColumns) {//if the startCol and the length adds up to a 
                    return false;                     //higher number than numberOfColumns then returns false
                }
                if (square[startRow][startCol + i].hasShip()) {//if there is a ship already where the ship 
                    return false;                              //is about to be placed returns false 
                }
            }
        } else { //else runs these statements
            for (int i = 0; i < length; i++) { //runs loop equavalent to length given for ship
                if (startRow + i >= numberOfRows) {//if the startCol and the length adds up to a
                    return false;                  //higher number than numberOfColumns then returns false
                }
                if (square[startRow + i][startCol].hasShip()) {//if there is a ship already where the ship 
                    return false;                              //is about to be placed returns false
                }
            }
        }
        //Adds the ship
        if (isHorizontal) { //if the ship is horizontal runs these statements 
            Ship newShip = new Ship(length, isHorizontal, startRow, startCol);//creates ship object
            numberOfShipOnBoard++; //increments numberofships
            square[startRow][startCol].addShip(newShip);//adds ship at the startRow and startCol
            for (int i = 0; i < length; i++) { //runs loops for the length of ship given
                Ship shipp = square[startRow][startCol].getShip(); //gets the ship from the Start point 
                square[startRow][startCol + i].addShip(shipp);//uses the ship from start and adds them to rest of squares till loop ends

            }
            ship[numberOfShipOnBoard - 1] = newShip;//adds the ship to the ship[] array 
            return true;//returns true for success for adding ship
        } else {//else runs these statements
            Ship newShip = new Ship(length, isHorizontal, startRow, startCol);//creates ship object
            numberOfShipOnBoard++;//increments numberofships
            square[startRow][startCol].addShip(newShip);//adds ship at the startRow and startCol
            for (int i = 0; i < length; i++) {//runs loops for the length of ship given
                Ship shipp = square[startRow][startCol].getShip(); //gets the ship from the Start point 
                square[startRow + i][startCol].addShip(shipp);//uses the ship from start and adds them to rest of squares till loop ends
            }
                    ship[numberOfShipOnBoard - 1] = newShip;//adds the ship to the ship[] array 
            return true;//returns true for success for adding ship
        }
    }

    /**
     * Gets the number of ships on board
     * @return the integer value of ships on board
     */
    public int getNumberOfShips() {
        return numberOfShipOnBoard;

    }

    /**
     * Gets the ship[] array
     * @return ship[] array
     */
    public Ship[] getShips() {
        return ship;

    }

    /**
     * When called on fires at location if possible.
     * @param row Row where want to fire
     * @param col Column where want to fire
     * @return boolean value if fire at was successful
     */
    public boolean fireAtLocation(int row, int col) {
        if (row < 0 || col < 0 || row >= numberOfRows || col >= numberOfColumns) {
            throw new IllegalArgumentException("Error"); 
        } //throws illegalargumentexception if row is greater then numberOfRows or is negative, same way for columns
        HitStatus status = square[row][col].getHitStatus();  //sets status as HitStatus of the coordinate given
        
        if (status.equals(HitStatus.NOT_YET_HIT)) { //if Not yet hit
            square[row][col].fireAt(); //calls fireAt in the location
            if (square[row][col].hasShip()) { //if has ship
                Ship shipReturn = square[row][col].getShip(); //gets the ship
                if (shipReturn.isSunk()) { //if the gotten ship is sunk 
                    sunkenShips.add(shipReturn); //adds the ship to the sunkenship array list
                }
            }
            return true;//return true for successful fire
        }
        return false; //false if not fire successful
    }

    /**
     * Checks the array if the ship is sunk or not
     * @param shipIndex the Index of array that want to be checked
     * @return boolean value if ship sunk or not
     */
    public boolean isShipSunk(int shipIndex) {
        return ship[shipIndex].isSunk(); 
    }

    /**
     * The Array list of sunken ships
     * @return The array list with sunken ships
     */
    public ArrayList<Ship> getAllSunkenShips() {
        return sunkenShips; 

    }

    /**
     * Checks if all ships are sunk
     * @return boolean value if all ships sunk or not
     */
    public boolean areAllShipsSunk() {
        int count = 0;
        for(int i = 0; i < ship.length; i++){//loop for length of ship[] array
           if(ship[i].isSunk()){ //if ship is sunk 
               count++;//increments counter
           }
        }        
        return maximumNumberOfShips == count;//if counter equals Max ships return true 

    }

    /**
     * Gets the Number of Rows
     * @return the integer value of rows in the board
     */
    public int getNumberOfRows() {
        return numberOfRows;

    }
    /**
     * Gets the Number of Columns
     * @return the integer value of column in the board
     */
    public int getNumberOfColumns() {
        return numberOfColumns;

    }
    /**
     * Gets the Number of Columns
     * @return the string value of the board 
     */
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                //String out = .toString();
                output += square[i][j] + " ";
            }
            output += "\n";
        }
        return output;

    }

    /**
     * The main constructor for BattleBoard class
     * @param numberOfRows Number of rows in the board 
     * @param numberOfColumns Number of columns in the board
     * @param maximumNumberOfShips Maximum number of ships allowed on board
     */
    public BattleBoard(int numberOfRows, int numberOfColumns, int maximumNumberOfShips) {

        if (numberOfRows < 1 || numberOfColumns < 1 || maximumNumberOfShips < 0) {
            throw new IllegalArgumentException("Error");
        }//if numberOfRow or numberOfCol less then 1, or maximumNumberofShip less then 0 throws exception
        this.maximumNumberOfShips = maximumNumberOfShips;
        this.numberOfShipOnBoard = 0;
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
        this.square = new Square[numberOfRows][numberOfColumns];
        this.ship = new Ship[maximumNumberOfShips];
        this.sunkenShips = new ArrayList<Ship>();
        for (int i = 0; i < square.length; i++) {//loops through the 2d array
            for (int j = 0; j < square[i].length; j++) {
                square[i][j] = new Square();//adds new Square to each coordinate
            }
        }
    }
}
