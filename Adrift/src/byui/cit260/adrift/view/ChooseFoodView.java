/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byu.cit260.adrift.enums.Item;
import byui.cit260.adrift.control.InventoryControl;
import byui.cit260.adrift.model.Elevator;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;

/**
 *
 * @author Dallas
 */
public class ChooseFoodView extends View{

    public ChooseFoodView() {
    super("\n"
            + "\n ======================================="
            + "\n  How much food would you like, you may"
            + "\n  choose 1-4"
            + "\n ======================================="
            + "\n1 - 1"
            + "\n2 - 2"
            + "\n3 - 3"
            + "\n4 - 4"
            + "\n---------------------------------------");
    }

 
    @Override
    public boolean doAction(String value) {
        
       // value = value.toUpperCase(); // convert to all upper case
        char choice = (char) Integer.parseInt(value); // change char to int
        Game game = Adrift.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();
        Elevator elevator = game.getElevator();
        InventoryControl inventoryControl = new InventoryControl();
        
        
        InventoryItem food = new InventoryItem();
        food.setDescription("Food    ");
        food.setQuantityInStock(choice);
        food.setRequiredAmount(0);
        inventory[Item.food.ordinal()] = food;
    
        int currentNoOfItems = elevator.getNoOfItems();
        elevator.setNoOfItems(choice + currentNoOfItems);
        int noOfItems = elevator.getNoOfItems();
        elevator.setElevatorCapacityUsed(noOfItems);
        int capacityUsed = elevator.getElevatorCapacityUsed();
        int capacity = elevator.getElevatorCapacity();
        inventoryControl.packElevator(capacity, capacityUsed, noOfItems);
  

        return true;

    }

}
