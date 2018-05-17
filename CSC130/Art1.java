/**
*This program creates art that depicts a stick figure in front of an open door to a house
*@author WahabEhsan
*/

public class Art1 {
/**
*This main method runs part 1 and 2
*/  
  public static void main(String [] args){
  
  	part1();
    
   	part2();
    
	}
/**
*This method uses for loop to make the roof of the house
*/
    public static void part1(){
    
		for (int i = 1; i <= 15; i += 2){ 
      
    	
    	for (int j = 0; j < i; j++){
        	System.out.print("*");
          
    		}
          
    		System.out.println("");
			
        	}
      
    	}
/**
*This method creates the outer wall, the door and the stick figure   
*/
    public static void part2(){
	
    System.out.println("\\"); //Outer wall
    System.out.println("\\");
    System.out.println("\\");
    for(int i = 0; i <= 16; i++){ //loop created to display top of the door

    	System.out.print("-");

	}
    System.out.println("");
    System.out.println("\\\t\t| \t(\")");  //The door and the stick figure
    System.out.println("\\\t\t|\t-|-");
    System.out.println("\\\t  o     | \t |");
    System.out.println("\\\t\t|\t /\\");
    System.out.println("\\\t\t|\t/  \\");
		
    }
 
}

