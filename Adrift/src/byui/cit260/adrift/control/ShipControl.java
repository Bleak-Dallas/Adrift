/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.Adrift;
import byu.cit260.adrift.enums.Item;
import byu.cit260.adrift.enums.ShipType;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Ship;

/**
 *
 * 
 */
public class ShipControl {
    
        Game game = Adrift.getCurrentGame();
    Ship[] ship = game.getShip();
    InventoryItem[] inventoryList = game.getInventory();
    private int currentIron = inventoryList[Item.iron.ordinal()].getQuantityInStock();
    private int currentCopper = inventoryList[Item.copper.ordinal()].getQuantityInStock();
    private int currentUranium = inventoryList[Item.uranium.ordinal()].getQuantityInStock();
    private double damageLevel = 30.0;
    

    static Ship[] createShipList() {
        Ship[] shipItems = new Ship[ShipType.values().length];
        Ship iron = new Ship();
        iron.setDescription("Iron");
        iron.setShipItemAmount(0);
        iron.setRequiredShipAmount(20);
        shipItems[ShipType.iron.ordinal()] = iron;
        
        Ship copper = new Ship();
        copper.setDescription("Copper");
        copper.setShipItemAmount(0);
        copper.setRequiredShipAmount(10);
        shipItems[ShipType.copper.ordinal()] = copper;
        
        Ship uranium = new Ship();
        uranium.setDescription("Uranium");
        uranium.setShipItemAmount(0);
        uranium.setRequiredShipAmount(20);
        shipItems[ShipType.uranium.ordinal()] = uranium;

        

        return shipItems;
    }
    
    public void damageLevel() {
        
       

        

    }
    public void fuelLevel() {

    }
}
