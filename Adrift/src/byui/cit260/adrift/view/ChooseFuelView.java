/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byu.cit260.adrift.enums.Item;
import byui.cit260.adrift.control.InventoryControl;
import static byui.cit260.adrift.control.InventoryControl.ANSI_RED;
import static byui.cit260.adrift.control.InventoryControl.ANSI_RESET;
import byui.cit260.adrift.exceptions.InventoryControlException;
import byui.cit260.adrift.model.Elevator;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dallas
 */
class ChooseFuelView extends View{
    
    
    public ChooseFuelView() {
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
    try {
        choice = (char) Integer.parseInt(value); // change char to int
       }    catch (NumberFormatException nf){
            System.out.println(ANSI_RED + "\nYou must enter a valid number" + ANSI_RESET);
        }
        Game game = Adrift.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();
        Elevator elevator = game.getElevator();
        InventoryControl inventoryControl = new InventoryControl();
        
        
        InventoryItem fuel = new InventoryItem();
        fuel.setDescription("Fuel    ");
        fuel.setQuantityInStock(choice);
        fuel.setRequiredAmount(0);
        inventory[Item.fuel.ordinal()] = fuel;
    
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
