
package project5;

/**
 * The Square class represents a location in a BattleBoard's grid 
 * 
 * @author Wahab Ehsan
 */
public class Square {
    //Private fields for Square class
    private Ship SHIP;
    private HitStatus hitStatus;
    
    /**
     * Makes HitStatus. 
     */
    public enum HitStatus {
        HIT, //hit and occupied
        MISSED, //hit and unoccupied
        NOT_YET_HIT// not yet hit
    }
    
    /**
     * When called on, fires at it.
     */
    public void fireAt(){
        if(hasShip()){//if square has ship 
            SHIP.hit();//calls hit method from Ship.java
            this.hitStatus = HitStatus.HIT;//sets hitstatus to HIT
        } else {         
            this.hitStatus = HitStatus.MISSED;//else to Missed
        }
    }

    /**
     * Gets the ship located at square if any
     * @return The ship object if present
     */
    public Ship getShip(){
        if(hasShip()){//if has ship
            return SHIP;//returns ship
        }
        return null;//or returns null
    
    }
    
    /**
     * Checks to see id Square contains Ship
     * @return boolean value if has ship or not
     */
    public boolean hasShip(){
        if(SHIP != null){//if ship not null return true
            return true;
        }
        return false;        
    }
    
    /**
     * Adds the ship given to the square
     * @param ship the ship that is to be at this square
     */
    public void addShip(Ship ship){
        this.SHIP = ship;
    }
    
    /**
     * Gets the hit status of the square
     * @return the hitStatus at the moment called
     */
    public HitStatus getHitStatus(){
        return hitStatus;
    }
    /**
     * Gets the hit status of the square
     * @return the string value depending on the state of square at the moment called
     */
    @Override
    public String toString(){
        String out = "";
        if(hitStatus == HitStatus.NOT_YET_HIT && hasShip()){
            int length = SHIP.getLength();//if square has ship and not hit yet 
            out = Integer.toString(length);
        } else if(this.hitStatus == HitStatus.HIT){//if square has ship and is hit
            out = "R";
        } else if (this.hitStatus == HitStatus.MISSED){//if square has no ship ans is not hit
            out = "W";
        } else {//if ship is not hit yet
            out = "-";
        }
        return out;  
    }

    /**
     * The Constructor for Square class.
     */
    public Square(){
        this.hitStatus = HitStatus.NOT_YET_HIT;
    }
    
}
