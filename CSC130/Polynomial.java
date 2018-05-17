/**
 *This program solves an equation for y
 * @author Wahab Ehsan
 */

public class Polynomial{
	/**
	 *This method runs the printPolynomialSolution three times
	 */
	public static void main(String [] args){
		printPolynomialSolution(15);
		printPolynomialSolution(3);
		printPolynomialSolution(7);
		
		
		
	}
        /**
         * Solves the equation
         * @param x The variable that is given to find y 
         */
	
	public static void printPolynomialSolution(double x){
		
		double y = ((12.3 * Math.pow(x, 4)) - (9.1 * Math.pow(x, 3)) + (19.3 * Math.pow(x, 2)) - (4.6 * x) + 34.2);
		
		System.out.println(y); //Prints the answer
		
	}
}