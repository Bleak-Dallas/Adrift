/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.Adrift;
import byu.cit260.adrift.enums.Item;
import byui.cit260.adrift.exceptions.InventoryControlException;
import byui.cit260.adrift.model.Buggy;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;

/**
 *
 * @author Dallas
 */
public class BuggyControl {
Game game = Adrift.getCurrentGame();
Map map = game.getMap();
Location[][] locations = map.getLocations();
InventoryItem[] inventoryList = game.getInventory();
    Buggy buggy = game.getBuggy();
    int loadedWeight = buggy.getLoadedWeight();
    int maxWeight = buggy.getMaxWeight();
    double fuelCapacity = buggy.getFuelCapacity();
    double fuelLevel = buggy.getFuelLevel();
    int fuelInventory = inventoryList[Item.fuel.ordinal()].getQuantityInStock();
    int fuelAfterFill;
    int currentWeight;
    int currentFuel;
    int currentLoc;
    int destination;
    boolean calledBefore = false;
    
    
    public int calWeight(int noOfItems) {
        currentWeight = loadedWeight + noOfItems;

        if(currentWeight > maxWeight) {
            System.out.println("\nYou cannot load" + noOfItems + " more items."
                             + "\nBuggy would be overweight");
            return -1;
        }
        
        if(currentWeight <= maxWeight) {
            buggy.setLoadedWeight(currentWeight);
                System.out.println("\nYour buggy's current weight is " + currentWeight
                                 + "\n out of a max weight of " + maxWeight);

        }
    return currentWeight;
    }
    
    public int fillFuel(int noOfItems) {
        currentFuel = (int) (fuelLevel + noOfItems);
        fuelAfterFill = fuelInventory - noOfItems;


        if(currentFuel > fuelCapacity) {
            System.out.println("\nYou cannot put " + noOfItems + " gallon/s of gas in the"
                             + "\nbuggy it would overfill the buggy.");
            return -1;
        }
        
        if(fuelInventory < noOfItems) {
            System.out.println("\nHey dummmy you do not have enough fuel in your inventory"
                             + "\nto put " + noOfItems + " gallons in the buggy");
            return -1;
        }
        
        if(currentFuel <= fuelCapacity) {
            buggy.setFuelLevel(currentFuel);
            inventoryList[Item.fuel.ordinal()].setQuantityInStock(fuelAfterFill);
                System.out.println("\nYour buggy's current fuel level is " + currentFuel
                                 + "\n out of a max fuel level of " + fuelCapacity);
            calledBefore = true;

        }
    return currentFuel;

    }
    
    public double calcFuel(Location currentLocation, int row, int column) {
        currentLoc = currentLocation.getScene().getDistanceTraveled();
        destination = locations[row][column].getScene().getDistanceTraveled();
        double remainingFuel;

        double numberOfSpacesTraveled = 0;
         
        if (destination < 1 || destination > 25){
            System.out.println("your x and y coordinates must be between 1 and 25");
        }

        if (currentLoc  < destination) {
            numberOfSpacesTraveled = destination - currentLoc; 
            
        }

        if (currentLoc > destination){
            numberOfSpacesTraveled = currentLoc - destination;
            
        }
        
        
        if(calledBefore == false) {
            remainingFuel =  fuelLevel - (numberOfSpacesTraveled * .25);
             buggy.setFuelLevel(remainingFuel);
        } else {
            remainingFuel =  currentFuel - (numberOfSpacesTraveled * .25);
            buggy.setFuelLevel(remainingFuel);
        }
        
        return remainingFuel;

        }

}
