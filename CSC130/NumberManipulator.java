/**
 *This program finds the absolute value and then returns the Maximum value after.
 *@author Wahab Ehsan  
 */
public class NumberManipulator{
	
	/**
	 *The main method returns three times with three answers by running the largerAbsValue method
	 */
	public static void main (String [] args) {
	
	largerAbsValue(11, 2);
	largerAbsValue(13,-14);
	largerAbsValue(0,-6);
	
	}
	/**
	 *This method finds the absolute value of each number then picks the maximum number then displays it
         * @param x x value
         * @param y y value
         * @return MaxValue Returns the max value
	 */
	public static double largerAbsValue(double x, double y){
		
		
		double MaxValue = Math.max(Math.abs(x), Math.abs(y)); 

		
		
		System.out.println(MaxValue); //Prints the max value
		
		return MaxValue;
		
	}
}