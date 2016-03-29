/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.Adrift;
import byu.cit260.adrift.enums.Item;
import byui.cit260.adrift.model.Buggy;
import byui.cit260.adrift.exceptions.BuggyControlException;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;
import java.io.PrintWriter;

/**
 *
 * @author Dallas
 */
public class BuggyControl {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    Game game = Adrift.getCurrentGame();
    Map map = game.getMap();
    Location[][] locations = map.getLocations();
    InventoryItem[] inventoryList = game.getInventory();
    Buggy buggy = game.getBuggy();
    int loadedWeight = buggy.getLoadedWeight();
    int maxWeight = buggy.getMaxWeight();
    double fuelCapacity = buggy.getFuelCapacity();
    int fuelInventory = inventoryList[Item.fuel.ordinal()].getQuantityInStock();
    private final PrintWriter console = Adrift.getOutFile();
    int fuelAfterFill;
    int currentWeight;
    double currentFuel;
    int currentLoc;
    int destination;
    boolean calledBefore = false;
    
    
    
    public int calWeight(int noOfItems) 
    
    throws BuggyControlException {
        
        currentWeight = loadedWeight + noOfItems;

        if(currentWeight > maxWeight) {
            throw new BuggyControlException (ANSI_RED + "\nYou cannot load" + noOfItems + " more items."
                                            + ANSI_RED + "\nBuggy would be overweight" + ANSI_RESET);
     
        }
        
        if(currentWeight <= maxWeight) {
            buggy.setLoadedWeight(currentWeight);
                this.console.println(ANSI_GREEN + "\nYour buggy's current weight is " + currentWeight
                            + ANSI_GREEN      + "\n out of a max weight of " + maxWeight + ANSI_RESET);

        }
    return currentWeight;
    }
    
    public double fillFuel(int noOfItems) throws BuggyControlException{
        double fuelLevel = buggy.getFuelLevel();
        currentFuel = fuelLevel + noOfItems;
        fuelAfterFill = fuelInventory - noOfItems;

        
        if(currentFuel > fuelCapacity) {
            throw new BuggyControlException (ANSI_RED + "\nYou cannot put " + noOfItems + " gallon/s of gas in the"
                            + ANSI_RED  + "\nbuggy it would overfill the buggy."+ ANSI_RESET);
      
        }
        
        if(fuelInventory < noOfItems) {
            throw new BuggyControlException (ANSI_RED + "\nHey dummmy you do not have enough fuel in your inventory"
                            + ANSI_RED  + "\nto put " + noOfItems + " gallons in the buggy" + ANSI_RESET);
           
        }
        
        if(currentFuel <= fuelCapacity) {
            buggy.setFuelLevel(currentFuel);
            inventoryList[Item.fuel.ordinal()].setQuantityInStock(fuelAfterFill);
                this.console.println(ANSI_GREEN + "\nYour buggy's current fuel level is " + currentFuel
                                   + ANSI_GREEN + "\n out of a max fuel level of " + fuelCapacity + ANSI_RESET);
            calledBefore = true;

        }
    return currentFuel;

    }
    
    public double calcFuel(Location currentLocation, int row, int column) {
        currentLoc = currentLocation.getScene().getDistanceTraveled();
        destination = locations[row][column].getScene().getDistanceTraveled();
        double fuelLevel = buggy.getFuelLevel();
        double remainingFuel;

        double numberOfSpacesTraveled = 0;
        
         
        if (destination < 1 || destination > 25){
            this.console.println(ANSI_RED + "your x and y coordinates must be between 1 and 25" + ANSI_RESET);
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
