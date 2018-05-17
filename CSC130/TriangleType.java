import java.util.Scanner;
/**
 *This program asks fro three sides and tells what triangle it is and the max side
 * @author WahabEhsan
 */
public class TriangleType {
    /**
     * 
     * main method that prompts user three times and runs the triangleType and maxSide method 
     */
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Side a? "); //input for a
        int a = in.nextInt();
        System.out.print("Side b? "); //input for b
        int b = in.nextInt();
        System.out.print("Side c? "); //input for c
        int c = in.nextInt();
        
        triangleType(a, b, c);
        maxSide(a, b, c);
       
       
    }
    /**
     * Tells which type of angle it is from the info given
     * @param a side a
     * @param b side b
     * @param c side c
     * @return triangle type
     */
    
    public static String triangleType(int a, int b, int c){
        String triangle = "";
        
        if(a==b && b==c && c==b) //if sides all equal then equilateral
            triangle = "Equilateral";
        else if(a==b || b==c || c==a)
            triangle = "Isosceles"; //if two sides equal to each other then isosceles
        else 
            triangle = "Scalene"; //if no side equal then scalene
        System.out.println("Triangle : " + triangle);
        return triangle;
    }
    /**
     * Finds the max side 
     * @param a side a
     * @param b side b
     * @param c side c
     * @return max value
     */
    public static int maxSide(int a, int b, int c){
        int max = Integer.MIN_VALUE;
        
        if(a > b && a > c) //if a is bigger then b and c then max is a
            max = a;
        if(b > a && b > c) // if b is bigger then c and a then max is b
            max = b;
        else //otherwise the max is c
            max = c;
        System.out.println("Max side : " + max);
        return max;
        
    }
}
