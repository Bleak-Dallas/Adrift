/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

/**
 *
 * 
 */
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
    public double packElevator(int elevatorCapacity, int elevatorCapacityUsed, int noOfItems){
        
        int remainingCapacity;
        
         
        if (noOfItems <= 0){ // check to see if itmems less than or equal to zero
            return -1;
        }

        if (noOfItems > 12) { // check to see if items exceed 12
            return -1;
            
        }

        /*if (elevatorCapacityUsed < elevatorCapacity){ // check remaining elevator capacity
            //("Remaining capacity in elevator is " + remainingCapacity)
            return -1;
            
        }
        
        if (elevatorCapacityUsed == elevatorCapacity){ // check to see if elevator is full
            //("Elevator is Full")
            return -1;
            
        }
        */
        
        elevatorCapacityUsed = noOfItems * 1000;
        remainingCapacity = elevatorCapacity - elevatorCapacityUsed;
        return remainingCapacity;
    
    }
    
}
