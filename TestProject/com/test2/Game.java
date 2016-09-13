package com.test2;

import java.util.*;


public class Game {
    
    static String answer;
    
    public static void main(String[] args) {    
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter y if you always want to switch; n if never switch.");
        answer = keyboard.nextLine();
        keyboard.close();
        double winResult=0;
        Door chosenDoor;
        chosenDoor = new Door(); //if new door inside , win will always be 0
        for (int i=1; i<=10000; i++) {
            
            chosenDoor.setUpGame();
            chosenDoor.contestantChooseDoor();
            chosenDoor.openDoor();
   
            if (answer.equals("N")){
            	winResult+=chosenDoor.notSwitch();
            }
            else if (answer.equals("Y")){
            	winResult+=chosenDoor.toSwitch();
            }
    
         }
//		        System.out.println(winResult);
//		        if(answer.equals("N")){
//		            winResult= chosenDoor.notSwitch();
//		         }
//		          else if (answer.equals("Y")){
//		             winResult= chosenDoor.toSwitch();
//		        }
//      
         
        System.out.println("You have a " + winResult/10000*100 + "% chance of winning the grand prize.");
    }
  
}
