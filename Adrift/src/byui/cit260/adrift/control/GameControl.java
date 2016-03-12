/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.Adrift;
import byu.cit260.adrift.enums.ActorType;
import byui.cit260.adrift.model.Buggy;
import byui.cit260.adrift.model.Constants;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;
import byu.cit260.adrift.enums.Item;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Player;
import byui.cit260.adrift.model.Scene;
import byui.cit260.adrift.model.Ship;
import java.awt.Point;

/**
 *
 * 
 */
public class GameControl {

    public static void createNewGame(Player player) {
        Game game = new Game();  // create new game
        Adrift.setCurrentGame(game); // save in Adrfit
        
        game.setPlayer(player);
        
        // create the inventory list and save in game
        InventoryItem[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);
        
        Ship ship = new Ship(); // create new ship
        game.setShip(ship); // save ship in game
        
        Buggy buggy = new Buggy(); // create new buggy
        game.setBuggy(buggy);// save buggy in game
       
        Map map = MapControl.createMap(); // create and initialize map
        game.setMap(map); // save map in game
        
        Scene[] scenes = MapControl.createScenes(); //create scenes
        game.setScenes(scenes); //save scenes
        
        // move actors to starting location in the map
//        ActorType actors = MapControl.assignScenesToLocations(map, scenes);
//        game.setActors(actors);
        
    }

    private static InventoryItem[] createInventoryList() { 
        // create array(list) of inventory items
        InventoryItem[] inventory = new InventoryItem[Constants.NUMBER_OF_INVENTORY_ITEMS];
        InventoryItem shovel = new InventoryItem();
        shovel.setDescription("Shovel  ");
        shovel.setQuantityInStock(0);
        shovel.setRequiredAmount(0);
        inventory[Item.shovel.ordinal()] = shovel;

        InventoryItem drill = new InventoryItem();
        drill.setDescription("Drill    ");
        drill.setQuantityInStock(0);
        drill.setRequiredAmount(0);
        inventory[Item.drill.ordinal()] = drill;
        
        InventoryItem hammer = new InventoryItem();
        hammer.setDescription("Hammer  ");
        hammer.setQuantityInStock(0);
        hammer.setRequiredAmount(0);
        inventory[Item.hammer.ordinal()] = hammer;
        
        InventoryItem O2tank = new InventoryItem();
        O2tank.setDescription("O2Tank  ");
        O2tank.setQuantityInStock(0);
        O2tank.setRequiredAmount(0);
        inventory[Item.O2tank.ordinal()] = O2tank;
        
        InventoryItem food = new InventoryItem();
        food.setDescription("Food    ");
        food.setQuantityInStock(0);
        food.setRequiredAmount(0);
        inventory[Item.food.ordinal()] = food;
        
        InventoryItem water = new InventoryItem();
        water.setDescription("Water    ");
        water.setQuantityInStock(0);
        water.setRequiredAmount(0);
        inventory[Item.water.ordinal()] = water;
        
        InventoryItem oil = new InventoryItem();
        oil.setDescription("Oil      ");
        oil.setQuantityInStock(0);
        oil.setRequiredAmount(0);
        inventory[Item.oil.ordinal()] = oil;
        
        InventoryItem fuel = new InventoryItem();
        fuel.setDescription("Fuel    ");
        fuel.setQuantityInStock(0);
        fuel.setRequiredAmount(0);
        inventory[Item.fuel.ordinal()] = fuel;
        
        InventoryItem iron = new InventoryItem();
        iron.setDescription("Iron    ");
        iron.setQuantityInStock(0);
        iron.setRequiredAmount(0);
        inventory[Item.iron.ordinal()] = iron;
        
        InventoryItem aluminum = new InventoryItem();
        aluminum.setDescription("Aluminum");
        aluminum.setQuantityInStock(0);
        aluminum.setRequiredAmount(0);
        inventory[Item.aluminum.ordinal()] = aluminum;
        
        InventoryItem ice = new InventoryItem();
        ice.setDescription("Ice       ");
        ice.setQuantityInStock(0);
        ice.setRequiredAmount(0);
        inventory[Item.ice.ordinal()] = ice;
        
        InventoryItem copper = new InventoryItem();
        copper.setDescription("Copper   ");
        copper.setQuantityInStock(0);
        copper.setRequiredAmount(0);
        inventory[Item.copper.ordinal()] = copper;
        
        InventoryItem uranium = new InventoryItem();
        uranium.setDescription("Uranium ");
        uranium.setQuantityInStock(0);
        uranium.setRequiredAmount(0);
        inventory[Item.uranium.ordinal()] = uranium;
        
        return inventory;

    }

    public static InventoryItem[] getSortedInventoryList() {
          InventoryItem[] originalInventoryList =
                Adrift.getCurrentGame().getInventory();
        
        InventoryItem[] inventoryList = originalInventoryList.clone();
        
        InventoryItem tempInventoryItem;
        int i;
        for ( i =0; i < inventoryList.length-1; i++) {
            for (int j = 0; j < inventoryList.length-1-i; j++){
                if (inventoryList[j].getDescription().
                        compareToIgnoreCase(inventoryList[j + 1].getDescription()) > 0) {
                    tempInventoryItem  = inventoryList[j];
                    inventoryList[j] = inventoryList[j+1];
                    inventoryList[j+1] = tempInventoryItem;
                }
            }
        }
        return inventoryList;
    }

    

    public void saveGame(String actor) {

    }
    
    public void loadGame(String actor) {

    }
    
    public void initializeMap() {

    }

    public void createNewPlayer() {

    }
    
}
