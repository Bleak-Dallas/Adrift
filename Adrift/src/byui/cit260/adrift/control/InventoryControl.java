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
    
//    public void resourceInventory(){
//    
//    }
    
    public double packElevator(int elevatorCapacity, int elevatorCapacityUsed, int noOfItems){
        
        double remainingCapacity;
        
         
        if (noOfItems <= 0){ // check to see if itmems less than or equal to zero
            return -1;
        }

        if (noOfItems > 12) { // check to see if items exceed 12
            return -1;
            
        }

        if (elevatorCapacityUsed < elevatorCapacity){ // check remaining elevator capacity
            elevatorCapacityUsed = noOfItems * 1000;
            remainingCapacity = elevatorCapacity - elevatorCapacityUsed;
            System.out.println("Remaining capacity in elevator is " + remainingCapacity);
            return remainingCapacity;
            
        }
        
        if (elevatorCapacityUsed == elevatorCapacity){ // check to see if elevator is full
            System.out.println("Elevator is Full");
            remainingCapacity = elevatorCapacity - elevatorCapacityUsed;
            return remainingCapacity;
        }
        
        elevatorCapacityUsed = noOfItems * 1000;
        remainingCapacity = elevatorCapacity - elevatorCapacityUsed;
        return remainingCapacity;
    
    }
    
//    public int getAmountToManufacture(String inventoryType, int quantityInStock) {
//        
//        int resourcesNeeded = 0;
//        
//        return resourcesNeeded;
//    
//    }
//    
//    public double calculateIronNeededShip(double damageLevel, int quantityInStock){
//    
//        int resourcesNeeded = 0;
//        
//        return resourcesNeeded;
//    
//    }
//    
//    public double calculateFuelNeededShip(double fuelCapacity, double fuelLevel, int quantityInStock){
//    
//        int resourcesNeeded = 0;
//        
//        return resourcesNeeded;
//    
//    }
//    
//    public double calculateAluminumNeededO2Tank(String inventoryType, int quantityInStock){
//    
//        int resourcesNeeded = 0;
//        
//        return resourcesNeeded;
//    
//    }
    
//    public String getInventoryList(String inventoryType, int quantityInStock){
//            
//    String resourcesAvailable = null;
//        
//    return resourcesAvailable;
//    
//    }
    
    /*public int addToInventory(String inventoryType, int quantityInStock){
        
    int resourcesNeeded = 0;
        
    return resourcesNeeded;    
    
    }
    */
    
    /*public int removeFromInventory(String inventoryType, int quantityInStock){
        
    int resourcesNeeded = 0;
        
    return resourcesNeeded;    
    
    }
   */
    
    }
    
