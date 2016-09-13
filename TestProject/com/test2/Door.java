package com.test2;

import java.util.*;

public class Door{
    boolean open = false;
    boolean hasGrandPrize = false;
    boolean chosenByContestant = false;
    Door door1, door2, door3;
    static Random r = new Random();
    double win = 0;
    

void setUpGame () {
    door1 = new Door();
    door2 = new Door();
    door3 = new Door();
    
    int grandPrizeDoor = r.nextInt(3);
    switch(grandPrizeDoor) {
        case 0: door1.hasGrandPrize = true; break;
        case 1: door2.hasGrandPrize = true; break;
        case 2: door3.hasGrandPrize = true; break;
    }
}
    
void contestantChooseDoor() {
    int contestantDoor = r.nextInt(3);
    switch(contestantDoor){
    case 0: door1.chosenByContestant = true; break;
    case 1: door2.chosenByContestant = true; break;
    case 2: door3.chosenByContestant = true; break;
    }
}

void openDoor(){
        if (door1.hasGrandPrize == true) {
            if (door1.chosenByContestant == true){
                door2.open = true;} //assume that Monte chooses the door with the lowest number. 
            else if (door2.chosenByContestant == true) {
                door3.open = true;}
            else if (door3.chosenByContestant == true) {
                door2.open = true;}
        }
            else if (door2.hasGrandPrize == true) {
                if (door1.chosenByContestant == true) {
                    door3.open = true;}
                else if (door2.chosenByContestant == true) {
                    door1.open = true;}
                else if (door3.chosenByContestant == true) {
                    door1.open = true;}
            }
            else if (door3.hasGrandPrize == true) {
                if (door1.chosenByContestant == true) {
                    door2.open = true;}
                else if (door2.chosenByContestant == true) {
                    door1.open = true;}
                else if (door3.chosenByContestant == true) {
                    door1.open = true;}
            }
    }
public double toSwitch() {
    if (door1.hasGrandPrize == true){
        if ((door2.chosenByContestant == true) || (door3.chosenByContestant == true)) {
            win++;}
        else if (door2.chosenByContestant == true){
            if ((door1.chosenByContestant == true) ||(door3.chosenByContestant == true)) {
                win++;}
        }
        else if (door3.chosenByContestant == true){
            if ((door1.chosenByContestant == true) || (door2.chosenByContestant == true)) {
                win++;}
        }
    }   
        return win;
    }

public double notSwitch(){
        if (door1.hasGrandPrize == true&&door1.chosenByContestant == true){
            
                return 1;}
        else if (door2.hasGrandPrize == true&&door2.chosenByContestant == true){
               
                	return 1;}
        
        else if (door3.hasGrandPrize == true&&door3.chosenByContestant == true){
        	
        	return 1;}
        
        else 
        	return 0;
		
    }
}