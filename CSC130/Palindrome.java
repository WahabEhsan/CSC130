import java.util.*;
/**  
* Determines if a user entered String is a palindrome,  
* which means the String is the same forward and reverse.  
* The determination is case-insensitive 
 * @author WahabEhsan
 */
 public class Palindrome {
/**  
 * Calls the userInterface() method to handle all UI.  
 * @param args command line arguments (not used)  
 */
   public static void main(String [] args){
	   
		userInterface();
   }       
  /**     
   * Prompts the user for a String, which is read in     
   */   
	public static void userInterface(){    
            
		Scanner in = new Scanner(System.in); 
                System.out.print("Enter a string: ");
		String text = in.next();    
		if (isPalindrome(text)) {
                    System.out.println(text + " is a palindrome");
                } 
		else {
                    System.out.println(text + " is NOT a palindrome");
		}

	}
/**  
 * Checks to see if the input text is a palindrome  
 * @param text String to determine if palindrome  
 * @return true if String is a palindrome, false otherwise  
 * @throws IllegalArgumentException if the string is  
 * empty or has a length of 1 
 */
        
    public static boolean isPalindrome(String text){
		
                text = text.toLowerCase();
		int length = text.length();
		String reverse = "";
		for (int i = length - 1; i >=0; i--){
			reverse = reverse + text.charAt(i);
		}	
			if(length <= 1){
				throw new IllegalArgumentException ("Please enter String with more then one letter");
		}	
			if(text.equals(reverse)){
				return true;
			}
		
			printPalindrome(text);
		
		return false;
    } 
    
    public static String printPalindrome(String text){
	   	
		return text;
		
	}
}
