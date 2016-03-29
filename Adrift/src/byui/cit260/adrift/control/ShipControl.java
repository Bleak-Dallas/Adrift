/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.Adrift;
import byu.cit260.adrift.enums.Item;
import byu.cit260.adrift.enums.ShipType;
import byui.cit260.adrift.exceptions.ShipControlException;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Ship;


public class ShipControl {
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    Game game = Adrift.getCurrentGame();
    InventoryItem[] inventoryList = game.getInventory();
    Ship[] ship = game.getShip();
    private double currentShipIron = ship[ShipType.iron.ordinal()].getShipItemAmount();
    private double currentShipCopper = ship[ShipType.copper.ordinal()].getShipItemAmount();
    private double currentShipUranium = ship[ShipType.uranium.ordinal()].getShipItemAmount();
    private double requiredShipIron = ship[ShipType.iron.ordinal()].getRequiredShipAmount();
    private double requiredShipCopper = ship[ShipType.copper.ordinal()].getRequiredShipAmount();
    private double requiredShipUranium = ship[ShipType.uranium.ordinal()].getRequiredShipAmount();
    private double currentAmountIC = currentShipIron + currentShipCopper;
    private double requiredAmountIC = requiredShipIron + requiredShipCopper;
      

    static Ship[] createShipList() {
        
        Ship[] shipItems = new Ship[ShipType.values().length];
        Ship iron = new Ship();
        iron.setDescription("Iron");
        iron.setShipItemAmount(0);
        iron.setRequiredShipAmount(20);
        iron.setRepairLevel(0);
        iron.setFuelLevel(0);
        shipItems[ShipType.iron.ordinal()] = iron;
        
        Ship copper = new Ship();
        copper.setDescription("Copper");
        copper.setShipItemAmount(0);
        copper.setRequiredShipAmount(10);
        copper.setRepairLevel(0);
        copper.setFuelLevel(0);
        shipItems[ShipType.copper.ordinal()] = copper;
        
        Ship uranium = new Ship();
        uranium.setDescription("Uranium");
        uranium.setShipItemAmount(0);
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
        double repairLevel = 0;
        double amountNeededIC = 0;
        double amountNeededU;
        double fuelLevel = 0;
       
        if(currentAmountIC < requiredAmountIC) {
            amountNeededIC = requiredAmountIC - currentAmountIC;
            repairLevel = currentAmountIC / requiredAmountIC;

        }
        
        if(currentAmountIC == requiredAmountIC){
            repairLevel = 1;
        }

        if(currentShipUranium < requiredShipUranium) {
            amountNeededU = requiredShipUranium - currentShipUranium;
            fuelLevel = currentShipUranium / requiredShipUranium;

        }
        
        if(currentShipUranium == requiredShipUranium){
            fuelLevel = 1;
  
        }
        
        Ship shipstatus = new Ship();
        shipstatus.setDescription("Ship Status");
        shipstatus.setShipItemAmount(0);
        shipstatus.setRequiredShipAmount(0);
        shipstatus.setRepairLevel(repairLevel);
        shipstatus.setFuelLevel(fuelLevel);
        ship[ShipType.shipstatus.ordinal()] = shipstatus;
    }

    public void repairHull(int ironToBeAssigned) throws ShipControlException {
        int currentInventoryIron = inventoryList[Item.iron.ordinal()].getQuantityInStock();
        int shipCurrentIron = ship[ShipType.iron.ordinal()].getShipItemAmount();
        int shipIronRequired = ship[ShipType.iron.ordinal()].getRequiredShipAmount();
        int shipIronAfter = ironToBeAssigned + shipCurrentIron;
        int shipIronUnnassigned = shipIronRequired - shipCurrentIron;
        int ironAmountAfterRepair = currentInventoryIron - ironToBeAssigned;
        
            if(ironToBeAssigned > currentInventoryIron) {
                throw new ShipControlException(ANSI_RED + "\nYou do not have enough iron in your inventory to assign "
                                             + ANSI_RED + "\n" + ironToBeAssigned + " iron to the hull." + ANSI_RESET);
            }
            
            if(shipIronAfter > shipIronUnnassigned) {
                throw new ShipControlException(ANSI_RED + "\nYou only need to assign " + shipIronUnnassigned + " iron to"
                                             + ANSI_RED + "\ncomplete hull repairs" + ANSI_RESET);
            }
            
            ship[ShipType.iron.ordinal()].setShipItemAmount(shipIronAfter);
            inventoryList[Item.iron.ordinal()].setQuantityInStock(ironAmountAfterRepair);
    }
    
    public void repairShipWiring(int copperToBeAssigned) throws ShipControlException{
        int currentInventoryCopper = inventoryList[Item.copper.ordinal()].getQuantityInStock();
        int shipCurrentCopper = ship[ShipType.copper.ordinal()].getShipItemAmount();
        int shipCopperRequired = ship[ShipType.copper.ordinal()].getRequiredShipAmount();
        int shipCopperAfter = copperToBeAssigned + shipCurrentCopper;
        int shipCopperUnnassigned = shipCopperRequired - shipCurrentCopper;
        int copperAmountAfterRepair = currentInventoryCopper - copperToBeAssigned;
        
            if(copperToBeAssigned > currentInventoryCopper) {
                throw new ShipControlException(ANSI_RED + "\nYou do not have enough iron in your inventory to assign "
                                             + ANSI_RED + "\n" + copperToBeAssigned + " iron to the hull." + ANSI_RESET);
            }
            
            if(shipCopperAfter > shipCopperUnnassigned) {
                throw new ShipControlException(ANSI_RED + "\nYou only need to assign " + shipCopperUnnassigned + " iron to"
                                             + ANSI_RED + "\ncomplete hull repairs" + ANSI_RESET);
            }
            
            ship[ShipType.copper.ordinal()].setShipItemAmount(shipCopperAfter);
            inventoryList[Item.copper.ordinal()].setQuantityInStock(copperAmountAfterRepair);
    }
    public void repairFuelCells(int uraniumToBeAssigned) throws ShipControlException{
        int currentInventoryUranium = inventoryList[Item.uranium.ordinal()].getQuantityInStock();
        int shipCurrentUranium = ship[ShipType.uranium.ordinal()].getShipItemAmount();
        int shipUraniumRequired = ship[ShipType.uranium.ordinal()].getRequiredShipAmount();
        int shipUraniumAfter = uraniumToBeAssigned + shipCurrentUranium;
        int shipUraniumUnnassigned = shipUraniumRequired - shipCurrentUranium;
        int uraniumAmountAfterRepair = currentInventoryUranium - uraniumToBeAssigned;
        
            if(uraniumToBeAssigned > currentInventoryUranium) {
                throw new ShipControlException(ANSI_RED + "\nYou do not have enough iron in your inventory to assign "
                                             + ANSI_RED + "\n" + uraniumToBeAssigned + " iron to the hull." + ANSI_RESET);
            }
            
            if(shipUraniumAfter > shipUraniumUnnassigned) {
                throw new ShipControlException(ANSI_RED + "\nYou only need to assign " + shipUraniumUnnassigned + " iron to"
                                             + ANSI_RED + "\ncomplete hull repairs" + ANSI_RESET);
            }
            
            ship[ShipType.uranium.ordinal()].setShipItemAmount(shipUraniumAfter);
            inventoryList[Item.uranium.ordinal()].setQuantityInStock(uraniumAmountAfterRepair);
        
    }

    public void launchShip() {
         System.out.println("\n***  launchShip function called in ShipControl ***");
    }

}
    

