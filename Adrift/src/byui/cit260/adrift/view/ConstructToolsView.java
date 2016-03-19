/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import static byui.cit260.adrift.control.InventoryControl.ANSI_RED;
import static byui.cit260.adrift.control.InventoryControl.ANSI_RESET;
import byui.cit260.adrift.control.ToolsControl;

/**
 *
 * @author Dallas
 */
class ConstructToolsView extends View{
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
                GameMenuView gameMenu = new GameMenuView(); //display the game menu
                gameMenu.display();
                
            default:
                System.out.println(ANSI_RED + "\n*** Invalid selection *** Try Again" + ANSI_RESET);
                break;
        } 
        return true;         
    }

    private void makeDrill() {
//        ToolsControl drill = new ToolsControl();
//        drill.resourcesNeeded();
    }

    private void makeShovel() {
        System.out.println("\n*** makeShovel function called ***");
    }

    private void makeHammer() {
        System.out.println("\n*** makeHammer function called ***");
    }

    private void makeO2Tank() {
        System.out.println("\n*** makeO2Tank function called ***");
    }
        
}
