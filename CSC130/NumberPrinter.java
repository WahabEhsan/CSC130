/**
 * 
 * @author WahabEhsan
 * This program prints numbers in different patterns 
 */
public class NumberPrinter {
    public static void main (String [] args){
    part1();//Runs part1
    part2();//Runs part2
    part3();//Runs part3
    }
    public static void part1(){ /** Prints first three lines of number
     * 
     */
        for(int k = 0; k<=2; k++){ // Makes three lines of numbers
            for(int i = 0; i<=9; i++){ // Numbers incremented by one
                for(int j = 0; j<=2; j++){ // Numbers repeated 3 time on the same line      
                    System.out.print(i);
                }   
            }
            System.out.println(""); /** Moves the numbers to another line
             * 
             */
        }
    }
    public static void part2(){ /** Prints the next three lines of number
     * 
     */ 
        for(int k = 0; k<=2; k++){ // Makes three lines of numbers
            for(int i = 9; i>=0; i--){ // Numbers decremented by one
                for(int j = 0; j<=4; j++){ // Numbers repeated 5 time on the same line  
                    System.out.print(i);
                }
            }
            System.out.println(""); /** Moves the numbers to another line
             * 
             */
        }
    }
    public static void part3(){ /**Prints the next three lines of number 
     * 
     */
        for(int k = 0; k <=2; k++){ // Makes three lines of numbers
            for(int i = 9; i>=1; i--){ // Number decremented 9 to 1
                for(int j = i + 1; j>=2; j--){ // Makes the numbers appear as many as thry are
                    System.out.print(i);
                }
            }
            System.out.println(""); /** Moves the numbers to another line
             * 
             */
        }
    }
}