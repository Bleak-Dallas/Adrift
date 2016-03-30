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

/**
 *
 * @author Dallas
 */
class ChooseDrillView extends View{
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    
    public ChooseDrillView() {
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
        Game game = Adrift.getCurrentGame();
        Tools[] toolInventory = game.getToolInventory();
        Elevator elevator = game.getElevator();
        InventoryControl inventoryControl = new InventoryControl();
        int choice = 0;
        
        try {
        choice = (char) Integer.parseInt(value); // change char to int
        }    catch (NumberFormatException nf){
            ErrorView.display(this.getClass().getName(),
                    ANSI_RED + "\nYou must enter a valid number" + nf.getMessage() + ANSI_RESET);
        }
    
        try {
            inventoryControl.checkinput(choice);
        } catch (InventoryControlException ex) {
            this.console.println(ex);
        }
 
        int currentNoOfItems = elevator.getNoOfItems();
        elevator.setNoOfItems(choice + currentNoOfItems);
        int noOfItems = elevator.getNoOfItems();
        int capacity = elevator.getElevatorCapacity();
        try {
            inventoryControl.packElevator(capacity, noOfItems);
        } catch (InventoryControlException ex) {
            ErrorView.display(this.getClass().getName(),ex.getMessage());
        }
        elevator.setElevatorCapacityUsed(noOfItems);
        
        Tools drill = new Tools();
        drill.setDescription("Drill    ");
        drill.setQuantityInStock(choice);
        drill.setRequiredAmount(3);
        drill.setRequiredResource("Iron    ");
        toolInventory[ToolType.drill.ordinal()] = drill;
  

        return true;

    }

    
}
