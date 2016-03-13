/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;


public class InventoryControl {
  
    public double calculateO2Needed(double currentO2,int currentLocation,int destination){
        
        double numberOfSpacesTraveled = 0;
         
        if (destination < 1 || destination > 25){
            return -1;
        }

        if (currentLocation  < destination) {
            numberOfSpacesTraveled = destination - currentLocation; 
            
        }

        if (currentLocation > destination){
            numberOfSpacesTraveled = currentLocation - destination;
            
        }

        double remainingO2 =  currentO2 - (numberOfSpacesTraveled * .25);
        return remainingO2;
    
    }   
    
    
    public double calculateFuelNeeded(double currentFuel,int currentLocation,int destination){
        
        double numberOfSpacesTraveled = 0;
         
        if (destination < 1 || destination > 25){
            return -1;
        }

        if (currentLocation  < destination) {
            numberOfSpacesTraveled = destination - currentLocation; 
            
        }

        if (currentLocation > destination){
            numberOfSpacesTraveled = currentLocation - destination;
            
        }

        double remainingFuel =  currentFuel - (numberOfSpacesTraveled * .25);
        return remainingFuel;
    
    }   
    
    public double calculateCaloriesNeeded(double currentCalories,int currentLocation,int destination){
        
        double numberOfSpacesTraveled = 0;
         
        if (destination < 1 || destination > 25){
            return -1;
        }

        if (currentLocation  < destination) {
            numberOfSpacesTraveled = destination - currentLocation; 
            
        }

        if (currentLocation > destination){
            numberOfSpacesTraveled = currentLocation - destination;
            
        }

        double remainingCalories =  currentCalories - (numberOfSpacesTraveled * .25);
        return remainingCalories;
    
    }   
    

    
    public int packElevator(int elevatorCapacity, int elevatorCapacityUsed, int noOfItems){
        
        int remainingCapacity;
        
         
        if (noOfItems <= 0){ // check to see if itmems less than or equal to zero
            System.out.println("Please enter a value greater than zero");
            return -1;
        }

        if (noOfItems > 12) { // check to see if items exceed 12
            System.out.println("You may only have 12 items");
            return -1;
            
        }

        if (elevatorCapacityUsed < elevatorCapacity){ // check remaining elevator capacity
            remainingCapacity = elevatorCapacity - elevatorCapacityUsed;
            System.out.println("Remaining capacity in elevator is " + remainingCapacity);
            return remainingCapacity;
            
        }
        
        if (elevatorCapacityUsed == elevatorCapacity){ // check to see if elevator is full
            System.out.println("Elevator is Full");
            remainingCapacity = elevatorCapacity - elevatorCapacityUsed;
            return remainingCapacity;
        }
        
        elevatorCapacityUsed = noOfItems;
        remainingCapacity = elevatorCapacity - elevatorCapacityUsed;
        return remainingCapacity;
    
    }
    

    
    }
    
