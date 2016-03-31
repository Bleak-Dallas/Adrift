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
import byui.cit260.adrift.model.Player;
import byui.cit260.adrift.model.Tools;


/**
 *
 * @author Dallas
 */
class ChooseO2TanksView extends View{
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";

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
        Game game = Adrift.getCurrentGame();
        Player player = game.getPlayer();
        Tools[] toolInventory = game.getToolInventory();
        Elevator elevator = game.getElevator();
        InventoryControl inventoryControl = new InventoryControl();
        double choice = 0;
        
        try {
        choice = (char) Double.parseDouble(value); // change char to double
        }   catch (NumberFormatException nf){
        ErrorView.display(this.getClass().getName(),
                ANSI_RED + "\nYou must enter a valid number" + ANSI_RESET + nf.getMessage());
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
        
        double playerCurrentO2 = player.getCurrentOxygenLevel();
        player.setCurrentOxygenLevel(playerCurrentO2 + choice);
        
        Tools O2tank = new Tools();
        O2tank.setDescription("O2Tank  ");
        O2tank.setQuantityInStock(choice);
        O2tank.setRequiredAmount(3);
        O2tank.setRequiredResource("Aluminum");
        toolInventory[ToolType.O2tank.ordinal()] = O2tank;

        return true;

    }
    
}
