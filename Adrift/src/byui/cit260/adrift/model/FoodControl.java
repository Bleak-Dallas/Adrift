/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.model;

import adrift.Adrift;
import byu.cit260.adrift.enums.Item;
import byui.cit260.adrift.exceptions.FoodControlException;
import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 *
 * @author Dallas
 */
public class FoodControl {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    private final BufferedReader keyboard = Adrift.getInFile();
    private final PrintWriter console = Adrift.getOutFile();
    Game game = Adrift.getCurrentGame();
    Map map = game.getMap();
    Player player = game.getPlayer();
    Location[][] locations = map.getLocations();
    InventoryItem[] inventoryList = game.getInventory();
    int currentFoodInventory = inventoryList[Item.food.ordinal()].getQuantityInStock();
    double currentPlayerFood = player.getCurrentCalorieLevel();
    double maxPlayerFood = player.getMaxCalorieLevel();
    boolean calledBefore = false;
    double foodAfterAdding;
    int foodInvetoryAfterEating;
    int currentLoc;
    int destination;
    
     public void checkFood() {
        double playerCurrentFooodLevel = player.getCurrentCalorieLevel();
        this.console.println(ANSI_GREEN + "\nYour current food level is: " + playerCurrentFooodLevel + ANSI_RESET);
    }

    public double fillFood(int noOfItems) throws FoodControlException{
       foodAfterAdding = (int) (currentPlayerFood + noOfItems);
       foodInvetoryAfterEating = currentFoodInventory - noOfItems;



        if(foodAfterAdding > maxPlayerFood) {
            throw new FoodControlException(ANSI_RED + "\nYou cannot eat " + noOfItems + " food you would get sick."
                             + ANSI_RED +"\nYou can only eat a max of " + maxPlayerFood + " food."
                             + ANSI_RED +"\nCheck your current food level first." + ANSI_RESET);
        }
        
        if(currentFoodInventory < noOfItems) {
            throw new FoodControlException(ANSI_RED + "\nHey dummmy you do not have enough food in your inventory"
                                         + ANSI_RED +  "\nto eat " + noOfItems + " food." + ANSI_RESET);
        }
        
        if(currentPlayerFood <= maxPlayerFood) {
            player.setCurrentCalorieLevel(foodAfterAdding);
            inventoryList[Item.food.ordinal()].setQuantityInStock(foodInvetoryAfterEating);
                this.console.println(ANSI_BLUE +"\nYour current food level is " + currentPlayerFood
                                + ANSI_BLUE + "\n out of a max food level of " + maxPlayerFood + ANSI_RESET);
            calledBefore = true;

        }
    return foodAfterAdding;
    }
    
     public double calcFood(Location currentLocation, int row, int column) {
         
        currentLoc = currentLocation.getScene().getDistanceTraveled();
        destination = locations[row][column].getScene().getDistanceTraveled();
        double remainingFood;
        double numberOfSpacesTraveled = 0;

        if (currentLoc  < destination) {
            numberOfSpacesTraveled = destination - currentLoc; 
            
        }

        if (currentLoc > destination){
            numberOfSpacesTraveled = currentLoc - destination;
            
        }
        
        
        if(calledBefore == false) {
            remainingFood =  currentPlayerFood - (numberOfSpacesTraveled * .25);
             player.setCurrentCalorieLevel(remainingFood);
        } else {
            remainingFood =  foodAfterAdding - (numberOfSpacesTraveled * .25);
            player.setCurrentCalorieLevel(remainingFood);
        }
        
        return remainingFood;

        }
    
}
