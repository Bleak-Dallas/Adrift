/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byu.cit260.adrift.enums.ToolType;
import byui.cit260.adrift.control.InventoryControl;
import byui.cit260.adrift.exceptions.InventoryControlException;
import byui.cit260.adrift.model.Elevator;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Tools;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dallas
 */
class ChooseO2TanksView extends View{

    public ChooseO2TanksView() {
    super("\n"
            + "\n ======================================="
            + "\n  How how many O2 tanks would you like, "
            + "\n  you may choose 1-4"
            + "\n ======================================="
            + "\n1 - 1"
            + "\n2 - 2"
            + "\n3 - 3"
            + "\n4 - 4"
            + "\n---------------------------------------");
    }

 
    @Override
    public boolean doAction(String value) {
        int choice = 0;
       // value = value.toUpperCase(); // convert to all upper case
        choice = (char) Integer.parseInt(value); // change char to int
        Game game = Adrift.getCurrentGame();
        Tools[] toolInventory = game.getToolInventory();
        Elevator elevator = game.getElevator();
        InventoryControl inventoryControl = new InventoryControl();
        
        Tools O2tank = new Tools();
        O2tank.setDescription("O2Tank  ");
        O2tank.setQuantityInStock(choice);
        O2tank.setRequiredAmount(3);
        O2tank.setRequiredResource("Aluminum");
        toolInventory[ToolType.O2tank.ordinal()] = O2tank;
    
        int currentNoOfItems = elevator.getNoOfItems();
        elevator.setNoOfItems(choice + currentNoOfItems);
        int noOfItems = elevator.getNoOfItems();
        elevator.setElevatorCapacityUsed(noOfItems);
        int capacityUsed = elevator.getElevatorCapacityUsed();
        int capacity = elevator.getElevatorCapacity();
        try {
            inventoryControl.packElevator(capacity, capacityUsed, noOfItems);
        } catch (InventoryControlException ex) {
            System.out.println(ex.getMessage());
        }
  

        return true;

    }
    
}
