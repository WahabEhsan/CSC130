/**
 * This program prints strings in reverse
 * @author Wahab Ehsan
 */
import java.util.Scanner; //Allows to use scanner

public class PrintReverse{
    /**
     * This method runs the reverse methods and allows user to type String to get a reverse String
     * 
     */
    public static void main(String [] args){
        
        reverse("Hello There!");
        reverse("Wahab Ehsan");
        reverse("I worked alone");
                
        Scanner input = new Scanner(System.in);
        
            System.out.println("Enter String to reverse it :");
        
	String reverse = " "; //Creates the variable for String reverse
        
        String words = input.nextLine(); //Sets variable to input value 
        
            int length = words.length();
        
        for (int i = length - 1; i >= 0; i--){
    
            reverse = reverse + words.charAt(i) ; //Change variable reverse and returns char values 
        
            }
        
            System.out.print(reverse);
		
	}
    /**
     * This method prints "Hello There!" in reverse
     * @param words variable for String given in main method
     */
    public static void reverse(String words){
        
        String reverse = " "; //Creates the variable for String reverse
        
        //String words; //Sets variable for "Hello There!"
        
            int length = words.length();
        
        for (int i = length - 1; i >= 0; i--){
    
            reverse = reverse + words.charAt(i) ; //Change variable reverse and returns char values 
        
        }
            System.out.println(reverse);
        
    }
	
}