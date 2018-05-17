import java.util.Scanner;
/**
 * This program calculates and list football's distance from different angles
 * @author WahabEhsan
 */
public class FootballDistanceCalculator {
    /**
     * 
     * Main method prompts user input and runs calculateDistance method, also throws exceptions 
     */
    
    public static void main(String [] args){
        
        Scanner input = new Scanner(System.in);//makes new scanner object
        
            System.out.print("Enter initial velocity (mi/hr) : ");
        
        double v = input.nextDouble();//sets put equal to v for velocity
        
               if(v < 0){
                   
                    throw new IllegalArgumentException("Enter a positive number please.");
                    
        }//throws exception if number negative
               
            System.out.print("Enter initial height (ft) : ");
        
        double h = input.nextDouble(); //sets input equal to h for height
        
               if(h < 0){
                   
                    throw new IllegalArgumentException("Enter a positive number please.");
                    
        }//throws exception if number negative
               
            System.out.print("Enter angle (deg) : ");
        
        double a = input.nextDouble(); //sets input equal to a for angle
        
                if(a > 90 || a < 0){
                    
                    throw new IllegalArgumentException("Enter a valid number please.");
                    
        }//throws exception if number not between 90 and 0
                
        double distance = calculateDistance(a, v, h);//sets distance equal to the answer of the method and parameters are the input that were given earlier

            System.out.printf("Distance: %.2f ft.\n", distance);//prints distance with two decimal places

    }

    public static final double GRAVITATIONAL_ACCELERATION = 32.174;  //feet per sec^2
    
    public static final double FeetsInMile = 5280;//5280 feets in one mile
    
 /**
  * Calculates the distance a projectile travels
  * @param angle angle at which projectile is thrown in degrees
  * @param velocity initial velocity of projectile in miles/hour
  * @param height initial height of projectile in feet
  * @return distance traveled by projectile in feet
  */ 
    
    public static double calculateDistance(double angle, double velocity, double height){
    
        double i = Math.toRadians(angle); //Changes angle into Radians
        
        double fps = (velocity * FeetsInMile) / (3600);//conversion from miles per hour to feets per second 
        
        //the 3600 is 60 times 60, the units were time and they canceled out
        
        double r = ((fps * Math.cos(i)) / (GRAVITATIONAL_ACCELERATION)); //First part of the equation
        
        double c = fps * Math.sin(i); //Velocity times sin of angle 
        
        double g = 2 * GRAVITATIONAL_ACCELERATION * height; //Gravity and height multiplied by two 
        
        double p = (c + Math.sqrt((Math.pow(c, 2)) + (g))); // Second part of equation
        
        double distance = r * p; //First and second part of equation being multiplied

        return distance; //returns the distance to the main method
        
    }
}

