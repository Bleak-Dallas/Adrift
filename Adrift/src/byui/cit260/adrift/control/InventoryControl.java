/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import byui.cit260.adrift.exceptions.InventoryControlException;



public class InventoryControl {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
  
    public double calculateO2Needed(double currentO2,int currentLocation,int destination)
                    throws InventoryControlException {
        
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

        double remainingO2 =  currentO2 - (numberOfSpacesTraveled * .25);
                if(remainingO2 < 0){
                    System.out.println(ANSI_RED + "\n\nIf you take this trip your remaining O2 would be " 
                                        + ANSI_RED + remainingO2 + ". You would die!!" + ANSI_RESET);
                }
                else{
                    System.out.println(ANSI_GREEN + "\n\nIf you take this trip your remaining O2 would be " + remainingO2 + ANSI_RESET);
                }
        return remainingO2;
    
    }   
    
    
    public double calculateFuelNeeded(double currentFuel,int currentLocation,int destination)
                        throws InventoryControlException {
        
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

        double remainingFuel =  currentFuel - (numberOfSpacesTraveled * .25);
                if(remainingFuel < 0){
                    System.out.println(ANSI_RED + "\n\nIf you take this trip your remaining fuel would be " 
                                      + ANSI_RED + remainingFuel + ". You would die!!" + ANSI_RESET);
                }
                else{
                    System.out.println(ANSI_GREEN + "\n\nIf you take this trip your remaining fuel would be " + remainingFuel + ANSI_RESET);
                }
        return remainingFuel;
    
    }   
    
    public double calculateCaloriesNeeded(double currentCalories,int currentLocation,int destination)
                            throws InventoryControlException {
        
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

        double remainingCalories =  currentCalories - (numberOfSpacesTraveled * .25);
                if(remainingCalories < 0){
                    System.out.println(ANSI_RED + "\n\nIf you take this trip your remaining food would be " 
                                        + remainingCalories + ". You would die!!" + ANSI_RESET);
                }
                else{
                    System.out.println(ANSI_GREEN + "\n\nIf you take this trip your remaining food would be " + remainingCalories + ANSI_RESET);
                }
        return remainingCalories;
    
    }   
    

    
    public int packElevator(int elevatorCapacity, int elevatorCapacityUsed, int noOfItems)
                            throws InventoryControlException {
        
        int remainingCapacity;
        
         
        if (noOfItems <= 0){  
// check to see if itmems less than or equal to zero
            throw new InventoryControlException(ANSI_RED + "\nPlease enter a value greater than zero" + ANSI_RESET);
        }

        if (noOfItems > 12) { // check to see if items exceed 12
            throw new InventoryControlException(ANSI_RED + "\n\nYou may only have 12 items" + ANSI_RESET);
            
        }

        if (elevatorCapacityUsed < elevatorCapacity){ // check remaining elevator capacity
            remainingCapacity = elevatorCapacity - elevatorCapacityUsed;
            System.out.println(ANSI_GREEN +"Remaining capacity in elevator is " + remainingCapacity + ANSI_RESET);
            return remainingCapacity;
            
        }
        
        if (elevatorCapacityUsed == elevatorCapacity){ // check to see if elevator is full
            System.out.println(ANSI_RED + "Elevator is Full" + ANSI_RESET);
            remainingCapacity = elevatorCapacity - elevatorCapacityUsed;
            return remainingCapacity;
        }
        
        elevatorCapacityUsed = noOfItems;
        remainingCapacity = elevatorCapacity - elevatorCapacityUsed;
        return remainingCapacity;
    
    }
    
    public void checkinput(int choice) throws InventoryControlException {
        
         if(choice < 1 || choice > 4) {
                throw new InventoryControlException(ANSI_RED + "\nYou must enter a number from 1-4" + ANSI_RESET);
        }
        
    }
    

    
    }
    
