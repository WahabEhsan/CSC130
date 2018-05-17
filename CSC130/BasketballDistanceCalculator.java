import java.util.Scanner;
/**
 * This program calculates the distance of a ball after entering height and rebound fraction
 * @author WahabEhsan
 */
public class BasketballDistanceCalculator {
    
    /**
     * The main method prompt user with input for height and rebound fraction 
     * also throws exceptions if entered anything invalid
     * then prints distance
     * @param args 
     */
    public static void main(String [] args){
        
        Scanner input = new Scanner(System.in);//creates new scanner object
        
        System.out.print("Enter initial height : ");
        
        double height = input.nextDouble();//sets input equal to height
        
            if(height < 0){
                
                throw new IllegalArgumentException("Enter a positive number please."); //thrown exception if number negative 
        }
        
        System.out.print("Enter rebound fraction (0 < r < 1) : ");
        
        double rebound = input.nextDouble();//sets input equal to rebound
        
            if(rebound > 1 || rebound < 0){
                
                throw new IllegalArgumentException("Enter a number between 0 and 1 please");//thrown exception if number greater then 1 or less then 0
        }
        
        double distance = calculateTotalDistance(height, rebound); //parameters entered and sets distance as variable
        
        System.out.printf("Distance: %.2f ft.\n", distance); //prints the distance with two decimal 
        
    }

	public static final double MAX = 1000;//Maximum times the sums are going to be added cumulativily  
	
    /**
     * This method calculates the total distance of a ball with rebound fraction
     * and initial height given with a for loop and then returns distance
     * @param height initial height before ball thrown
     * @param rebound rebound fraction 
     * @return distance in feet
     */
    
    public static double calculateTotalDistance(double height, double rebound){
        
        double sum = height;
        
        for(int i = 1; i <= MAX; i++){ //this loop adds up all the cumulative 
        
            sum = sum + (2 * height * Math.pow(rebound, i)); //the sum being updated after the addition of previous sum
        
        }
        double distance = sum; //adds the final sum and the height
        
        return distance;
    }
}
