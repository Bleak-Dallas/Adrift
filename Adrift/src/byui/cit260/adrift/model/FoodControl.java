/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.model;

import adrift.Adrift;
import byu.cit260.adrift.enums.Item;


/**
 *
 * @author Dallas
 */
public class FoodControl {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
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
        System.out.println(ANSI_BLUE + "\nYour current food level is: " + playerCurrentFooodLevel + ANSI_RESET);
    }

    public double fillFood(int noOfItems) {
       foodAfterAdding = (int) (currentPlayerFood + noOfItems);
       foodInvetoryAfterEating = currentFoodInventory - noOfItems;



        if(currentPlayerFood > maxPlayerFood) {
            System.out.println("\nYou cannot eat " + noOfItems + " food you would get sick."
                             + "\nYou can only eat a max of " + maxPlayerFood + " food."
                             + "\nCheck your current food level first.");
            return -1;
        }
        
        if(currentFoodInventory < noOfItems) {
            System.out.println("\nHey dummmy you do not have enough food in your inventory"
                             + "\nto eat " + noOfItems + " food.");
            return -1;
        }
        
        if(currentPlayerFood <= maxPlayerFood) {
            player.setCurrentCalorieLevel(foodAfterAdding);
            inventoryList[Item.food.ordinal()].setQuantityInStock(foodInvetoryAfterEating);
                System.out.println(ANSI_BLUE +"\nYour current food level is " + currentPlayerFood
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
            remainingFood =  currentPlayerFood - (numberOfSpacesTraveled * .25);
             player.setCurrentCalorieLevel(remainingFood);
        } else {
            remainingFood =  foodAfterAdding - (numberOfSpacesTraveled * .25);
            player.setCurrentCalorieLevel(remainingFood);
        }
        
        return remainingFood;

        }
    
}
