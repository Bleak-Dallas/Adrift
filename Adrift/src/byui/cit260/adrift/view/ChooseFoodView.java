/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byu.cit260.adrift.enums.Item;
import byui.cit260.adrift.control.InventoryControl;
import byui.cit260.adrift.exceptions.InventoryControlException;
import static byui.cit260.adrift.control.InventoryControl.ANSI_RED;
import static byui.cit260.adrift.control.InventoryControl.ANSI_RESET;
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
        Game game = Adrift.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();
        Elevator elevator = game.getElevator();
        InventoryControl inventoryControl = new InventoryControl();
        double choice = 0;
        
        try {
        choice = (char) Double.parseDouble(value); // change char to double
        } catch (NumberFormatException nf) {
            ErrorView.display(this.getClass().getName(),
                    ANSI_RED + "\nYou must enter a valid number" + nf.getMessage() + ANSI_RESET);
            
        }
        
        try {
            inventoryControl.checkinput(choice);
        } catch (InventoryControlException ex) {
            this.console.println(ex);
            return false;
        }

        double currentNoOfItems = elevator.getNoOfItems();
            if(choice + currentNoOfItems > 10) {
                ErrorView.display(this.getClass().getName(),
                    ANSI_RED + "\nYou may only have 10 items in the elevator" + ANSI_RESET);
                return false;
            }
        elevator.setNoOfItems(choice + currentNoOfItems);
        double noOfItems = elevator.getNoOfItems();
        double capacity = elevator.getElevatorCapacity();
        try {
            inventoryControl.packElevator(capacity, noOfItems);
        } catch (InventoryControlException ex) {
            ErrorView.display(this.getClass().getName(),ex.getMessage());
        }
        elevator.setElevatorCapacityUsed(noOfItems);
        
        InventoryItem food = new InventoryItem();
        food.setDescription("Food    ");
        food.setQuantityInStock(choice);
        food.setRequiredAmount(0);
        inventory[Item.food.ordinal()] = food;
  

        return true;

    }

}
