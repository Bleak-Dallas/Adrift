/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byu.cit260.adrift.enums.Item;
import byu.cit260.adrift.enums.ToolType;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Tools;

/**
 *
 * @author Dallas
 */
class ConstructToolsView extends View{
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    Game game = Adrift.getCurrentGame();
    Tools[] toolInventory = game.getToolInventory();
    InventoryItem[] inventoryList = game.getInventory();
        
    public ConstructToolsView(){
        super("\n"
            + "\n----------------------------------------"
            + "\n | Tools Menu                           |"
            + "\n ---------------------------------------"
            + "\nD - Mining Drill"
            + "\nS - Shovel"
            + "\nH - Hammer"
            + "\nT - O2 Tank"
            + "\nQ - Exit to Game Menu"
            + "\n---------------------------------------");
    }
    

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered
        switch (choice) {
            case 'D': //make mining drill
                this.makeDrill();
                break;
                
            case 'S': //make shovel
                this.makeShovel();
                break;
                
            case 'H': //make hammer
                this.makeHammer();
                break;
                
            case 'T': //make O2 tank
                this.makeO2Tank();
                break;
                
            case 'Q': //Exit the game menu
                return true;
            default:
                ErrorView.display(this.getClass().getName(),
                        ANSI_RED + "\n*** Invalid selection *** Try Again" + ANSI_RESET);
                break;
        } 
        return false;         
    }

    private boolean makeDrill() {
        double currentAmountOfDrills = toolInventory[ToolType.drill.ordinal()].getQuantityInStock();
        double resourcesRequiredForDrill= toolInventory[ToolType.drill.ordinal()].getRequiredAmount();
        double currentIron = inventoryList[Item.iron.ordinal()].getQuantityInStock();
        
        if(currentIron < resourcesRequiredForDrill) {
            this.console.println(ANSI_RED + "\nSorry you do not have enough iron to make a drill."
                               + ANSI_RED+ "\nA drill takes " + resourcesRequiredForDrill + " iron to make." + ANSI_RESET);
            return false;
        }

        if(currentIron >= resourcesRequiredForDrill) {
            toolInventory[ToolType.drill.ordinal()].setQuantityInStock(currentAmountOfDrills + 1);
            inventoryList[Item.iron.ordinal()].setQuantityInStock(currentIron - resourcesRequiredForDrill);
                this.console.println(ANSI_GREEN + "You have made 1 drill." + ANSI_RESET);
        }
        return true;
    }

    private boolean makeShovel() {
        double currentAmountOfShovels = toolInventory[ToolType.shovel.ordinal()].getQuantityInStock();
        double resourcesRequiredForShovel= toolInventory[ToolType.shovel.ordinal()].getRequiredAmount();
        double currentIron = inventoryList[Item.iron.ordinal()].getQuantityInStock();

        if(currentIron < resourcesRequiredForShovel) {
            this.console.println(ANSI_RED + "\nSorry you do not have enough iron to make a shovel."
                               + ANSI_RED+ "\nA shovel takes " + resourcesRequiredForShovel + " iron to make." + ANSI_RESET);
            return false;
        }

        if(currentIron >= resourcesRequiredForShovel) {
            toolInventory[ToolType.shovel.ordinal()].setQuantityInStock(currentAmountOfShovels + 1);
            inventoryList[Item.iron.ordinal()].setQuantityInStock(currentIron - resourcesRequiredForShovel);
                this.console.println(ANSI_GREEN + "You have made 1 shovel." + ANSI_RESET);
        }
        return true;
    }

    private boolean makeHammer() {
        double currentAmountOfHammers = toolInventory[ToolType.hammer.ordinal()].getQuantityInStock();
        double resourcesRequiredForHammer= toolInventory[ToolType.hammer.ordinal()].getRequiredAmount();
        double currentIron = inventoryList[Item.iron.ordinal()].getQuantityInStock();

        if(currentIron < resourcesRequiredForHammer) {
            this.console.println(ANSI_RED + "\nSorry you do not have enough iron to make a hammer."
                               + ANSI_RED+ "\nA hammer takes " + resourcesRequiredForHammer + " iron to make." + ANSI_RESET);
            return false;
        }

        if(currentIron >= resourcesRequiredForHammer) {
            toolInventory[ToolType.hammer.ordinal()].setQuantityInStock(currentAmountOfHammers + 1);
            inventoryList[Item.iron.ordinal()].setQuantityInStock(currentIron - resourcesRequiredForHammer);
                this.console.println(ANSI_GREEN + "You have made 1 hammer." + ANSI_RESET);
        }
        return true;
    }

    private boolean makeO2Tank() {
        double currentAmountOfO2tanks = toolInventory[ToolType.O2tank.ordinal()].getQuantityInStock();
        double resourcesRequiredForO2tanks= toolInventory[ToolType.O2tank.ordinal()].getRequiredAmount();
        double currentAlluminum = inventoryList[Item.aluminum.ordinal()].getQuantityInStock();

        if(currentAlluminum < resourcesRequiredForO2tanks) {
            this.console.println(ANSI_RED + "\nSorry you do not have enough iron to make an O2 tank."
                               + ANSI_RED+ "\nA o2 tank takes " + resourcesRequiredForO2tanks + " iron to make." + ANSI_RESET);
            return false;
        }

        if(currentAlluminum >= resourcesRequiredForO2tanks) {
            toolInventory[ToolType.O2tank.ordinal()].setQuantityInStock(currentAmountOfO2tanks + 1);
            inventoryList[Item.iron.ordinal()].setQuantityInStock(currentAlluminum - resourcesRequiredForO2tanks);
                this.console.println(ANSI_GREEN + "You have made 1 O2 tank." + ANSI_RESET);
        }
        return true;
    }
        
}
