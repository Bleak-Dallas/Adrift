/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.Adrift;
import byu.cit260.adrift.enums.Item;
import byu.cit260.adrift.enums.SceneType;
import byu.cit260.adrift.enums.ShipType;
import byui.cit260.adrift.exceptions.ShipControlException;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Scene;
import byui.cit260.adrift.model.Ship;
import java.io.PrintWriter;


public class ShipControl {
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    Game game = Adrift.getCurrentGame();
    Map map = game.getMap();
    Location[][] locations = map.getLocations();
    Scene[] scenes = game.getScenes();
    InventoryItem[] inventoryList = game.getInventory();
    Ship[] ship = game.getShip();
    private final double currentShipIron = ship[ShipType.iron.ordinal()].getShipItemAmount();
    private final double currentShipCopper = ship[ShipType.copper.ordinal()].getShipItemAmount();
    private final double currentShipUranium = ship[ShipType.uranium.ordinal()].getShipItemAmount();
    private final double requiredShipIron = ship[ShipType.iron.ordinal()].getRequiredShipAmount();
    private final double requiredShipCopper = ship[ShipType.copper.ordinal()].getRequiredShipAmount();
    private final double requiredShipUranium = ship[ShipType.uranium.ordinal()].getRequiredShipAmount();
    private final double currentAmountIC = currentShipIron + currentShipCopper;
    private final double requiredAmountIC = requiredShipIron + requiredShipCopper;
    private final PrintWriter console = Adrift.getOutFile();;
      

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
        double currentInventoryIron = inventoryList[Item.iron.ordinal()].getQuantityInStock();
        double shipCurrentIron = ship[ShipType.iron.ordinal()].getShipItemAmount();
        double shipIronRequired = ship[ShipType.iron.ordinal()].getRequiredShipAmount();
        double shipIronAfter = ironToBeAssigned + shipCurrentIron;
        double shipIronUnnassigned = shipIronRequired - shipCurrentIron;
        double ironAmountAfterRepair = currentInventoryIron - ironToBeAssigned;
        
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
        double currentInventoryCopper = inventoryList[Item.copper.ordinal()].getQuantityInStock();
        double shipCurrentCopper = ship[ShipType.copper.ordinal()].getShipItemAmount();
        double shipCopperRequired = ship[ShipType.copper.ordinal()].getRequiredShipAmount();
        double shipCopperAfter = copperToBeAssigned + shipCurrentCopper;
        double shipCopperUnnassigned = shipCopperRequired - shipCurrentCopper;
        double copperAmountAfterRepair = currentInventoryCopper - copperToBeAssigned;
        
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
        double currentInventoryUranium = inventoryList[Item.uranium.ordinal()].getQuantityInStock();
        double shipCurrentUranium = ship[ShipType.uranium.ordinal()].getShipItemAmount();
        double shipUraniumRequired = ship[ShipType.uranium.ordinal()].getRequiredShipAmount();
        double shipUraniumAfter = uraniumToBeAssigned + shipCurrentUranium;
        double shipUraniumUnnassigned = shipUraniumRequired - shipCurrentUranium;
        double uraniumAmountAfterRepair = currentInventoryUranium - uraniumToBeAssigned;
        
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
        int totalDistance = game.getTotalDistanceTraveled();
        double fluxCapacitor = inventoryList[Item.fluxcapacitor.ordinal()].getQuantityInStock();
        double shipCurrentIron = ship[ShipType.iron.ordinal()].getShipItemAmount();
        double shipIronRequired = ship[ShipType.iron.ordinal()].getRequiredShipAmount();
        double shipCurrentCopper = ship[ShipType.copper.ordinal()].getShipItemAmount();
        double shipCopperRequired = ship[ShipType.copper.ordinal()].getRequiredShipAmount();
        double shipCurrentUranium = ship[ShipType.uranium.ordinal()].getShipItemAmount();
        double shipUraniumRequired = ship[ShipType.uranium.ordinal()].getRequiredShipAmount();
        String finishScene;
        
        if(shipCurrentIron == shipIronRequired && shipCurrentCopper == shipCopperRequired 
                && shipCurrentUranium == shipUraniumRequired && fluxCapacitor == 1) {
            finishScene = scenes[SceneType.finish.ordinal()].getDescription();
            this.console.println(finishScene);
            this.console.println(ANSI_BLUE + "\nYour total distance traveled is: " + totalDistance +  " kilometers"+ ANSI_RESET);
        } else {
            this.console.println(ANSI_RED + "\nYou have not met all the requirements in order to"
                               + ANSI_RED + "\nlaunch the ship. To launch the ship all repairs must"
                               + ANSI_RED + "\nbe completed and the secret item must be retrieved." + ANSI_RESET);
        }
        
    }

}
    

