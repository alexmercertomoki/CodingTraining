package com.cmuHomework2;

/*
 This file: MonteSimulation
 Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
 Course/Section: 95-712
 Assignment: Second Java homwork to simulate a lottery game.
 Description: Simulate the lottery game 10000 times to test the winning rate of switching or not
 Method: Two classes Door and Game, using Math.random() method to generate ramdon numbers, if and else judge all the situations,then adding up 
 all the winning times devide 10000
 Last Modified: 09/10/2014
 Known Bugs: No bugs at present.
 Compiler: JDK 1.6
 */
import java.util.*;
//Door class with three attributes, all booleans.
class Door {
	boolean open;

	boolean hasGrandPrize;

	boolean chosenByContestant;
}
// Game class containing all the methods we need to run the game
class Game {
	Door door1, door2, door3;
    //create radom variables we use r
	static Random r = new Random();
   
	//Setting up
	void setUpGame() {
		door1 = new Door();
		door2 = new Door();
		door3 = new Door();
		
        // randomly set one of the doors has prize
		int grandPrizeDoor = r.nextInt(3);
		switch (grandPrizeDoor) {
		case 0:
			door1.hasGrandPrize = true;
			break;
		case 1:
			door2.hasGrandPrize = true;
			break;
		case 2:
			door3.hasGrandPrize = true;
			break;
		default:
			break;
		}
	}
    
	//radomly select one the the three doors
	void contestantChooseDoor() {

		int contestantDoor = r.nextInt(3);
		switch (contestantDoor) {
		case 0:
			door1.chosenByContestant = true;
			break;
		case 1:
			door2.chosenByContestant = true;
			break;
		case 2:
			door3.chosenByContestant = true;
			break;
		}
	}
   // if you switch or not
	void switchDoor(int CSwi) {
		// if switch
		if (CSwi == 1) {
		    // switching the doors which are not open
			if (door1.open == true) {

				boolean aSwitch = door3.chosenByContestant;
				door3.chosenByContestant = door2.chosenByContestant;
				door2.chosenByContestant = aSwitch;

			} else if (door2.open == true) {

				boolean aSwitch = door1.chosenByContestant;
				door1.chosenByContestant = door3.chosenByContestant;
				door3.chosenByContestant = aSwitch;

			} else if (door3.open == true) {

				boolean aSwitch = door2.chosenByContestant;
				door2.chosenByContestant = door1.chosenByContestant;
				door1.chosenByContestant = aSwitch;

			}
		}

	}
    //simulate how monte open doors
	void monteOpen() {
		// The door to be opened prerequisites: not chosen & not has prize
		int i = 0, j = 0, k = 0;
		if (door1.chosenByContestant != true && door1.hasGrandPrize != true) {
			i++;
		}
		if (door2.chosenByContestant != true && door2.hasGrandPrize != true) {
			j++;
		}
		if (door3.chosenByContestant != true && door3.hasGrandPrize != true) {
			k++;
		}
		//but there are three situations two doors have got prerequisites : 
		//that is the door the contestant chose has the prize which monte should radomly open the other one of the two doors
		
		if (i == 1 && j == 1) {
			int doorToOpen = r.nextInt(2);
			switch (doorToOpen) {
			case 0:
				door1.open = true;
				break;
			case 1:
				door2.open = true;
				break;
			}
		}
		if (i == 1 && k == 1) {
			int doorToOpen = r.nextInt(2);
			switch (doorToOpen) {
			case 0:
				door1.open = true;
				break;
			case 1:
				door3.open = true;
				break;
			}
		}
		if (j == 1 && k == 1) {
			int doorToOpen = r.nextInt(2);
			switch (doorToOpen) {
			case 0:
				door2.open = true;
				break;
			case 1:
				door3.open = true;
				break;
			}
		} 
		//other situations Monte only has one choice to open
		else if (i == 1) {
			door1.open = true;
		} else if (j == 1) {
			door2.open = true;
		} else if (k == 1) {
			door3.open = true;
		}

	}
    
	// To test win or not, the door chosen has prize
	int winOrNot() {

		if ((door1.chosenByContestant == door1.hasGrandPrize)
				&& (door1.chosenByContestant == true)) {
			return 1;
		} else if ((door2.chosenByContestant == door2.hasGrandPrize)
				&& (door2.chosenByContestant == true)) {
			return 1;
		} else if ((door3.chosenByContestant == door3.hasGrandPrize)
				&& (door3.chosenByContestant == true)) {
			return 1;
		} else
			return 0;
	}

}

public class MonteSimulation {

	public static void main(String[] args) {
        //receive the message of switch or not
		Scanner keyboard = new Scanner(System.in);
		int CSwitch=0, WinTime;
		//used to calculate the times of winning
		double Result = 0;
		
		System.out.println("DO U want to always switch choice or NOT? press 1 and enter to switch any other INTEGERS not to");
		
		//	get the integer, if you don't input an integer it will "Kill u"
		try {
			CSwitch = keyboard.nextInt();
		} 
		catch (InputMismatchException e) {
			
			System.out.println("Bang, U R dead,Please restart our program, next time read our instructions!");
			System.exit(0);
			
		}		
		//run the game 10000 times
		for (int i = 0; i < 10000; i++) {
            //new game start
			Game theGame = new Game();
			theGame.setUpGame();
			theGame.contestantChooseDoor();
			theGame.monteOpen();
			theGame.switchDoor(CSwitch);
			WinTime = theGame.winOrNot();
			//adding up all the winning times
			Result += WinTime;

		}
        // print out the results
		if (CSwitch == 1)
			System.out.println("The winning percentage is: " + Result * 100
					/ 10000 + "% when you switch");
		else
			System.out.println("The winning percentage is: " + Result * 100
					/ 10000 + "% when you do not switch");

	}

}
