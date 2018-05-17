import java.util.Scanner;
/**
 *
 * @author WahabEhsan
 */
public class MinMaxFinder {
    
    /**
     * 
     * Main method ask user for five inputs and runs largest and smallest method
     */
    public static void main(String [] args){
        Scanner Input = new Scanner(System.in);
            //int a = Input.nextInt();
            System.out.print("Next Integer? ");
            int a = Input.nextInt();
            System.out.print("Next Integer? ");
            int b = Input.nextInt();
            System.out.print("Next Integer? ");
            int c = Input.nextInt();
            System.out.print("Next Integer? ");
            int d = Input.nextInt();
            System.out.print("Next Integer? ");
            int e = Input.nextInt();
        
        //for(int i = 0; i <= 4; i++){       
            
        largest(a, b, c, d, e);
        smallest(a, b, c, d, e);
        //}
        
        
    }
    /**
     * 
     * @param a integer a
     * @param b integer b
     * @param c integer c
     * @param d integer d
     * @param e integer e
     * @return min value
     */
    
    public static int smallest(int a, int b, int c, int d, int e){
        
        int min = Integer.MAX_VALUE;
        
                
        if(a < b && a < c && a < d && a < e) //if a smallest then sets a as min
            min = a;
        else if(b < a && b < c && b < d && b < e) 
            min = b;
        else if(c < a && c < b && c < d && c < e)
            min = c;
        else if(d < a && d < b && d < c && d < e)
            min = d;
        else
            min = e;
        System.out.printf("Smallest number is " + min + ". "); //prints the smallest number
        
        return min;
        
    }
     /**
     * 
     * @param a integer a
     * @param b integer b
     * @param c integer c
     * @param d integer d
     * @param e integer e
     * @return max value
     */
    
    public static int largest(int a, int b, int c, int d, int e){
        
        int max = Integer.MIN_VALUE;
        
        if(a > b && a > c && a > d && a > e)//if a largest then sets it as max
            max = a;
        else if(b > a && b > c && b > d && b > e)
            max = b;
        else if(c > a && c > b && c > d && c > e)
            max = c;
        else if(d > a && d > b && d > c && d > e)
            max = d;
        else
            max = e;
        
       
        System.out.printf("Largest number is " + max + ". ");//prints the largest number
        
        return max;
        
            
    }
}
