import java.util.Scanner;

/**
 *This program is a guessing game that can be continued or can quit  
 * @author WahabEhsan
 */
public class GuessNumber {
    /**
     * This method calls and runs while loop for userInterface, also allows user to quit or continue
     * @param args 
     */
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        boolean loop = true; 
        while(loop){ //runs loop until false
        
            userInterface(input);
            int in;
            do{
            System.out.println("Would you like to continue? 0 to quit, 1 to continue");
            in = input.nextInt();
            
                if (in == 1){  //if input 1, continues the while loop
                    break;
                }
                else if(in == 0){ //if input 0, makes variable loop eqauls to false
                    loop = false;
                }
                
                }while (in != 0);
            
            }
        
    }    
    /**
     * This method uses Scanner as parameter and tells whether guess is high, low, right or invalid.
     * @param input User input integer as a guess
     */
    
    public static void userInterface(Scanner input){
    
        int number = (int)(Math.random()*50); //generates number between 0 and 50
        
        System.out.print("Enter a guess between 0 and 50: ");
        int guess = input.nextInt();

        while(guess != number){
            
            if(guess > 50 || guess < 0){ //if guess is not between 0 and 50, user has to enter guess again
                System.out.print("Invalid guess, Enter value between 0 and 50: ");
                guess = input.nextInt();
            }
            
            else if(guess > number){ //if your guess too big
                System.out.print("Your guess is greater than the number, try again: ");
                guess = input.nextInt();

            }
            else if(guess < number){ //if your guess too small
                System.out.print("Your guess is less than the number, try again: ");
                guess = input.nextInt();
            }
            if(guess == number){ //if you get it right
                System.out.println("You got it!");
                
            }
        }           
    }         
}
          
    

