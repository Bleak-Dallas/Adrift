/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.Adrift;
import byu.cit260.adrift.enums.ToolType;
import byui.cit260.adrift.exceptions.InventoryControlException;
import byui.cit260.adrift.model.Buggy;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Player;
import byui.cit260.adrift.model.Tools;
import java.io.PrintWriter;
import java.text.NumberFormat;



public class InventoryControl {
    Game game = Adrift.getCurrentGame();
    Buggy buggy = game.getBuggy();
    Player player = game.getPlayer();
    Tools[] tool = game.getToolInventory();
    private final PrintWriter console = Adrift.getOutFile();
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    NumberFormat defaultFormat = NumberFormat.getPercentInstance();
  
    public double calculateO2Needed(double currentO2,int currentLocation,int destination)
                    throws InventoryControlException {
        int currentO2tanks = tool[ToolType.O2tank.ordinal()].getQuantityInStock();
        double remainingO2;
        double o2Percent;
        double numberOfSpacesTraveled = 0;
         
        if (destination < 1 || destination > 25){
            throw new InventoryControlException(ANSI_RED + "your x and y coordinates must be between 1 and 25" + ANSI_RESET);
        }

        if (currentLocation  < destination) {
            numberOfSpacesTraveled = destination - currentLocation; 
            
        }

        if (currentLocation > destination){
            numberOfSpacesTraveled = currentLocation - destination;
            
        }

        remainingO2 =  currentO2 - (numberOfSpacesTraveled * .25);
        o2Percent = remainingO2 / currentO2tanks;
                if(remainingO2 < 0){
                    this.console.println(ANSI_RED + "\n\nIf you take this trip your remaining O2 would be " 
                                        + ANSI_RED + defaultFormat.format(o2Percent) + ". You would die!!" + ANSI_RESET);
                }
                else{
                    this.console.println(ANSI_GREEN + "\n\nIf you take this trip your remaining O2 would be " + defaultFormat.format(o2Percent) + ANSI_RESET);
                }
        return remainingO2;
    
    }   
    
    
    public double calculateFuelNeeded(double currentFuel,int currentLocation,int destination)
                        throws InventoryControlException {
        
        double fuelCapacity = buggy.getFuelCapacity();
        double fuelPercent;
        double remainingFuel;
        
        double numberOfSpacesTraveled = 0;
         
        if (destination < 1 || destination > 25){
            throw new InventoryControlException(ANSI_RED + "your x and y coordinates must be between 1 and 25" + ANSI_RESET);
        }

        if (currentLocation  < destination) {
            numberOfSpacesTraveled = destination - currentLocation; 
            
        }

        if (currentLocation > destination){
            numberOfSpacesTraveled = currentLocation - destination;
            
        }

        remainingFuel =  currentFuel - (numberOfSpacesTraveled * .25);
        fuelPercent = remainingFuel / fuelCapacity;
                if(remainingFuel < 0){
                    this.console.println(ANSI_RED + "\n\nIf you take this trip your remaining fuel would be " 
                                      + ANSI_RED + defaultFormat.format(fuelPercent) + ". You would die!!" + ANSI_RESET);
                }
                else{
                    this.console.println(ANSI_GREEN + "\n\nIf you take this trip your remaining fuel would be " + defaultFormat.format(fuelPercent) + ANSI_RESET);
                }
        return remainingFuel;
    
    }   
    
    public double calculateCaloriesNeeded(double currentCalories,int currentLocation,int destination)
                            throws InventoryControlException {
        
        double remainingCalories;
        double numberOfSpacesTraveled = 0;
         
        if (destination < 1 || destination > 25){
            throw new InventoryControlException(ANSI_RED +"your x and y coordinates must be between 1 and 25" + ANSI_RESET);
        }

        if (currentLocation  < destination) {
            numberOfSpacesTraveled = destination - currentLocation; 
            
        }

        if (currentLocation > destination){
            numberOfSpacesTraveled = currentLocation - destination;
            
        }

        remainingCalories =  currentCalories - (numberOfSpacesTraveled * .25);
                if(remainingCalories < 0){
                    this.console.println(ANSI_RED + "\n\nIf you take this trip your remaining food would be " 
                                        + remainingCalories + ". You would die!!" + ANSI_RESET);
                }
                else{
                    this.console.println(ANSI_GREEN + "\n\nIf you take this trip your remaining food would be " + remainingCalories + ANSI_RESET);
                }
        return remainingCalories;
    
    }   
    

    
    public boolean packElevator(int elevatorCapacity, int noOfItems)
                            throws InventoryControlException {
        
        int remainingCapacity;
        
        if (noOfItems <= 0){  
        // check to see if itmems less than or equal to zero
            throw new InventoryControlException(ANSI_RED + "\nPlease enter a value greater than zero" + ANSI_RESET);
        }

        if (noOfItems > 10) { // check to see if items exceed 10
            throw new InventoryControlException(ANSI_RED + "\n\nYou may only have 10 items" + ANSI_RESET);
        }
        
        if (noOfItems == elevatorCapacity){ // check to see if elevator is full
            throw new InventoryControlException(ANSI_RED + "\nElevator is now Full" + ANSI_RESET);
        }

        if (noOfItems < elevatorCapacity){ // check remaining elevator capacity
            remainingCapacity = elevatorCapacity - noOfItems;
            this.console.println(ANSI_GREEN +"Remaining capacity in elevator is " + remainingCapacity + ANSI_RESET);
            return true;
        }
        
        return true;
 
    }
    
    public void checkinput(int choice) throws InventoryControlException {
        
         if(choice < 1 || choice > 4) {
                throw new InventoryControlException(ANSI_RED + "\nYou must enter a number from 1-4" + ANSI_RESET);
        }
        
    }
    

    
    }
    
