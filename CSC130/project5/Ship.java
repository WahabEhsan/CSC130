
package project5;

/**
 * Object for the Ship that is going to be used in the Square.java and BattleBoard.java
 * 
 * @author Wahab Ehsan
 */
public class Ship {
    //Private fields for Ship calss
    private int length;
    private int hit;
    private int startRow;
    private int startCol;
    private boolean isHorizontal;
     
    /**
     * Gets the length of the ship after wrapping.
     * @return The length of the ship after it has been wrapped for security 
     */
    public int getLength(){
        int lengthwrap = length; //wrap for length
        return lengthwrap;
        
    }

    /**
     * Boolean value if horizontal or vertical placing for ship.
     * 
     * @return if the ship is horizontal or not
     */
    public boolean isHorizontal(){
        return isHorizontal;
        
    }

    /**
     * Gets the integer value of Start row.
     * @return the integer value of Start row
     */
    public int getStartRow(){
        return startRow;
        
    }
    /**
     * Gets the integer value of Start column.
     * @return the integer value of Start column
     */
    public int getStartCol(){
        return startCol;
        
    }

    /**
     * Updates the hit field when ever called on.
     */
    public void hit(){
        hit++;//increment by 1
    }

    /**
     * Checks if hit is equal to the length.
     * @return boolean value if sunk or not
     */
    public boolean isSunk(){
        if(hit == length){//if hit is equal to length returns true
            return true;
        }
        return false;
        
    }
    /**
     * Makes a string containing the ships information
     * @return string of information about ship
     */
    @Override
    public String toString(){
        String info;
        boolean sunk = isSunk();
        info = "Lenght:[" + length + "], Location:[" + startRow + ", " + startCol
                + "], IsHorizontal:[" + isHorizontal + "], TimesHit:[" + hit 
                + "], isSunk:[" + sunk + "]";
        return info;
    
    }

    /**
     * The Main constructor for the Ship method
     * @param length The length of the ship
     * @param isHorizontal orientation of the ship 
     * @param startRow The staring row for the ship
     * @param startCol the starting column of the ship
     */
    public Ship(int length, boolean isHorizontal, int startRow, int startCol){
        if(length < 1 || startRow < 0 || startCol < 0){
            throw new IllegalArgumentException("Invalid integers");
        } //if length less then 1, or startrow and startcol less then 0, throws exception 
        this.length = length;
        this.isHorizontal = isHorizontal;
        this.startCol = startCol;
        this.startRow = startRow;
        this.hit = 0;
    }
}
