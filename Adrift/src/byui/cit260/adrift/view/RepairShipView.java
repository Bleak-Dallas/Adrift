/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import byui.cit260.adrift.control.ShipControl;
import byui.cit260.adrift.exceptions.ShipControlException;
import java.io.IOException;

/**
 *
 * @author Dallas
 */
public class RepairShipView extends View{
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    ShipControl shipControl = new ShipControl();
    
    public RepairShipView() {
        super("\n"
            + "\n----------------------------------------"
            + "\n |          Repair Ship                |"
            + "\n ---------------------------------------"
            + "\nIn order to repair your ship you must"
            + "\nassign iron from your inventory to the"
            + "\nship until the hull is completely "
            + "\nrepaired. Additionally you will need to"
            + "\nassign copper to fix wiring and uranium"
            + "\nto fix or make fuel cells."
            + "\n"
            + "\nC - Check ship status"
            + "\nH - Repair Hull"
            + "\nW - Repair Wiring"
            + "\nF - Repair fuel cells"
            + "\nQ - Quit to move to location menu"
            + "\n---------------------------------------");
    }
         @Override
    public boolean doAction(String value) {
       value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered 
    
        switch (choice) {
            case 'C': //check ship status
                ShipStatusView shipStatus = new ShipStatusView();
                shipStatus.dislpayShipStatus();
                break;
            case 'H':
                this.repairHull();
                break;
            case 'W':
                this.repairWiring();
                break;
            case 'F':
                this.repairFuelCells();
                break;
            case 'Q': //Quit the game
                return true;
            default:
                ErrorView.display(this.getClass().getName(),
                        ANSI_RED + "\n*** Invalid selection *** Try Again" + ANSI_RESET);
                break;
        }     
        return false;
    }

    public void repairHull() {
        
        boolean valid = false;
        String input = null;  // Integer.parseInt(numberAsString)
        int ironToBeAssigned = 0;
         
        while (!valid){
            this.console.println(ANSI_BLUE +"\nEnter the amount of iron you want to give for "
                               + ANSI_BLUE + "\nhull repairs" + ANSI_RESET);
        try {
                input = this.keyboard.readLine();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),
                                    "Enter valid selection" + ex.getMessage());
            }
            input= input.trim();
             
            if (input.length() < 1) {
                ErrorView.display(this.getClass().getName(),
                        ANSI_RED + "Invalid selection - the menu item must not be blank" + ANSI_RESET);
                continue;
             }
        try {
            ironToBeAssigned = Integer.parseInt(input);
        } catch (NumberFormatException nf){
            ErrorView.display(this.getClass().getName(),
                    ANSI_RED + "\nYou must enter a valid number" + nf.getMessage() + ANSI_RESET);
        }
            break;
        }
        try {
            shipControl.repairHull(ironToBeAssigned);
        } catch (ShipControlException ex) {
            ErrorView.display(this.getClass().getName(),ex.getMessage());
        }
    }
    
    private void repairWiring() {
        
        boolean valid = false;
        String input = null;  // Integer.parseInt(numberAsString)
        int copperToBeAssigned = 0;
         
        while (!valid){
            this.console.println(ANSI_BLUE +"\nEnter the amount of copper you want to give for "
                               + ANSI_BLUE + "\nwiring repairs" + ANSI_RESET);
        try {
                input = this.keyboard.readLine();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),
                                    "Enter valid selection" + ex.getMessage());
            }
            input= input.trim();
             
            if (input.length() < 1) {
                ErrorView.display(this.getClass().getName(),
                        ANSI_RED + "Invalid selection - the menu item must not be blank" + ANSI_RESET);
                continue;
             }
        try {
            copperToBeAssigned = Integer.parseInt(input);
        } catch (NumberFormatException nf){
            ErrorView.display(this.getClass().getName(),
                    ANSI_RED + "\nYou must enter a valid number" + nf.getMessage() + ANSI_RESET);
        }
            break;
        }
        try {
            shipControl.repairShipWiring(copperToBeAssigned);
        } catch (ShipControlException ex) {
            ErrorView.display(this.getClass().getName(),ex.getMessage());
        }
    }

    private void repairFuelCells() {
        
            boolean valid = false;
        String input = null;  // Integer.parseInt(numberAsString)
        int uraniumToBeAssigned = 0;
         
        while (!valid){
            this.console.println(ANSI_BLUE +"\nEnter the amount of uranium you want to give for "
                               + ANSI_BLUE + "\nfuel cell repairs" + ANSI_RESET);
        try {
                input = this.keyboard.readLine();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),
                                    "Enter valid selection" + ex.getMessage());
            }
            input= input.trim();
             
            if (input.length() < 1) {
                ErrorView.display(this.getClass().getName(),
                        ANSI_RED + "Invalid selection - the menu item must not be blank" + ANSI_RESET);
                continue;
             }
        try {
            uraniumToBeAssigned = Integer.parseInt(input);
        } catch (NumberFormatException nf){
            ErrorView.display(this.getClass().getName(),
                    ANSI_RED + "\nYou must enter a valid number" + nf.getMessage() + ANSI_RESET);
        }
            break;
        }
        try {
            shipControl.repairFuelCells(uraniumToBeAssigned);
        } catch (ShipControlException ex) {
            ErrorView.display(this.getClass().getName(),ex.getMessage());
        }
    }
    
}
