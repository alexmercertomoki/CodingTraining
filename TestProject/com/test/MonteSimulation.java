package com.test;
import java.util.*;

   class Door{
    boolean open;
    boolean hasGrandPrize;
    boolean chosenByContestant;
   }
   class Game{
	   Door door1,door2,door3;
	   static Random r = new Random();
	  // static Random r2 = new Random();

		 void setUpGame() {
		        door1 = new Door();door2 = new Door();door3 = new Door();
		        // initialize all the Door variables to false
		        
		        int grandPrizeDoor = r.nextInt(3);
		        switch(grandPrizeDoor) {
		        case 0:
		            door1.hasGrandPrize = true; break;
		        case 1:  
		        	door2.hasGrandPrize = true; break;
		        case 2:  
		        	door3.hasGrandPrize = true; break;
		        default:
		        	break;
		        }
        }
	
		    void contestantChooseDoor() {
		        
		        int contestantDoor = r.nextInt(3);
		        switch(contestantDoor) {
		        case 0: door1.chosenByContestant = true; break;
		        case 1: door2.chosenByContestant = true; break;
		        case 2: door3.chosenByContestant = true; break;
		        }
		 }

		   void switchDoor(int CSwi){
			   if(CSwi==1){
				   if(door1.open==true){
					   
					   boolean aSwitch=door3.chosenByContestant;
					   door3.chosenByContestant=door2.chosenByContestant;
					   door2.chosenByContestant=aSwitch;
					  
				   }
				   else if(door2.open==true){
					   
					   boolean aSwitch=door1.chosenByContestant;
					   door1.chosenByContestant=door3.chosenByContestant;
					   door3.chosenByContestant=aSwitch;
					   
				   }
				   else if(door3.open==true){
					   
					   boolean aSwitch=door2.chosenByContestant;
					   door2.chosenByContestant=door1.chosenByContestant;
					   door1.chosenByContestant=aSwitch;
					   
				   }
			   } 
			   
		   }
		   
		   void monteOpen(){
			   int i=0,j=0,k=0;
			   if(door1.chosenByContestant!=true&&door1.hasGrandPrize!=true){
			       i++;
			   }
			   if(door2.chosenByContestant!=true&&door2.hasGrandPrize!=true){
				   j++;
			   }
			   if(door3.chosenByContestant!=true&&door3.hasGrandPrize!=true){
				   k++;
			   }
			   if(i==1&&j==1){
				    int doorToOpen = r.nextInt(2);
			        switch(doorToOpen) {
			        case 0:
			            door1.open = true;
			            break;
			            case 1:  
			        	door2.open = true;
			        	break;
			        }
			   }
			   if(i==1&&k==1){
				   int doorToOpen = r.nextInt(2);
				   switch(doorToOpen) {
				   case 0:
					   door1.open = true; break;
				   case 1:  
					   door3.open = true; break;
				   }
			   }
			   if(j==1&&k==1){
				   int doorToOpen = r.nextInt(2);
				   switch(doorToOpen) {
				   case 0:
					   door2.open = true; break;
				   case 1:  
					   door3.open = true; break;
				   }
			   }
			   else if(i==1){
				   door1.open=true;
			   }
			   else if(j==1){
				   door2.open=true;
			   }
			   else if(k==1){
				   door3.open=true;
			   }
			
		   }
		   
		 int winOrNot(){
			 
			 if((door1.chosenByContestant==door1.hasGrandPrize)&&(door1.chosenByContestant==true)){
				 return 1;
			 }
			 else if((door2.chosenByContestant==door2.hasGrandPrize)&&(door2.chosenByContestant==true)){
				 return 1;
			 }
			 else if((door3.chosenByContestant==door3.hasGrandPrize)&&(door3.chosenByContestant==true)){
				 return 1;
			 }
			 else 
				 return 0;
		 }
		   
		 void printStateOfDoors() {
		        System.out.println("Door 1 is " +
		            (door1.open ? "    open, " : "not open, ") +
		            (door1.hasGrandPrize ? "is     the grand prize, and " : "is not the grand prize, and ") +
		            (door1.chosenByContestant ? "is     chosen." : "is not chosen.") );
		        System.out.println("Door 2 is " +
		            (door2.open ? "    open, " : "not open, ") +
		            (door2.hasGrandPrize ? "is     the grand prize, and " : "is not the grand prize, and ") +
		            (door2.chosenByContestant ? "is     chosen." : "is not chosen.") );
		        System.out.println("Door 3 is " +
		            (door3.open ? "    open, " : "not open, ") +
		            (door3.hasGrandPrize ? "is     the grand prize, and " : "is not the grand prize, and ") +
		            (door3.chosenByContestant ? "is     chosen." : "is not chosen.") );
		    }

   }
   
   

public class MonteSimulation {

	public static void main(String[] args) {
	
		
		Scanner keyboard = new Scanner(System.in);
		int CSwitch,WinTime;
		double Result=0;
		System.out.println("DO U want to always switch choice or NOT? press 1 and enter to switch any other INTEGERS not to");
		CSwitch= keyboard.nextInt();
		
		
		for(int i=0;i<10000;i++){
	    //System.out.println(CSwitch);
	    //Game theGame = new Game();
        // theGame.setUpGame();
        // theGame.printStateOfDoors();
        // theGame.contestantChooseDoor();
        //theGame.printStateOfDoors();
		Game theGame = new Game();
		theGame.setUpGame();
		theGame.contestantChooseDoor();
		theGame.monteOpen();
		theGame.switchDoor(CSwitch);
		WinTime=theGame.winOrNot();
		Result+=WinTime;
	//	System.out.println(Result);
	//	theGame.printStateOfDoors();
		
	   }
		
		
		if(CSwitch==1)
	   System.out.println("The winning percentage is: "+ Result*100/10000+"% when you switch");
		else
	   System.out.println("The winning percentage is: "+ Result*100/10000+"% when you do not switch");
		
	}

}















