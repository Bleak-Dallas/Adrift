/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.Adrift;
import byu.cit260.adrift.enums.ShipType;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Ship;

/**
 *
 * 
 */
public class ShipControl {
    
    Game game = Adrift.getCurrentGame();
    Ship[] ship = game.getShip();
    private int currentShipIron = ship[ShipType.iron.ordinal()].getShipItemAmount();
    private int currentShipCopper = ship[ShipType.copper.ordinal()].getShipItemAmount();
    private int currentShipUranium = ship[ShipType.uranium.ordinal()].getShipItemAmount();
    private int requiredShipIron = ship[ShipType.iron.ordinal()].getRequiredShipAmount();
    private int requiredShipCopper = ship[ShipType.copper.ordinal()].getRequiredShipAmount();
    private int requiredShipUranium = ship[ShipType.uranium.ordinal()].getRequiredShipAmount();
    int currentAmountIC = currentShipIron + currentShipCopper;
    int requiredAmountIC = requiredShipIron + requiredShipCopper;
    
    

    static Ship[] createShipList() {
        
        Ship[] shipItems = new Ship[ShipType.values().length];
        Ship iron = new Ship();
        iron.setDescription("Iron");
        iron.setShipItemAmount(5);
        iron.setRequiredShipAmount(20);
        iron.setRepairLevel(0);
        iron.setFuelLevel(0);
        shipItems[ShipType.iron.ordinal()] = iron;
        
        Ship copper = new Ship();
        copper.setDescription("Copper");
        copper.setShipItemAmount(5);
        copper.setRequiredShipAmount(10);
        copper.setRepairLevel(0);
        copper.setFuelLevel(0);
        shipItems[ShipType.copper.ordinal()] = copper;
        
        Ship uranium = new Ship();
        uranium.setDescription("Uranium");
        uranium.setShipItemAmount(5);
        uranium.setRequiredShipAmount(20);
        uranium.setRepairLevel(0);
        uranium.setFuelLevel(0);
        shipItems[ShipType.uranium.ordinal()] = uranium;
        
        Ship shipstatus = new Ship();
        shipstatus.setDescription("Ship Status");
        shipstatus.setShipItemAmount(0);
        shipstatus.setRequiredShipAmount(0);
        shipstatus.setRepairLevel(0);
        shipstatus.setFuelLevel(0);
        shipItems[ShipType.shipstatus.ordinal()] = shipstatus;
        
        return shipItems;
    }

    public void shipStatus() {


    }
    
}
