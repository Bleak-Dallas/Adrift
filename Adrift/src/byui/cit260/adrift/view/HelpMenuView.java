/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;


/**
 *
 * @author Dallas
 */
public class HelpMenuView extends View {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    
    public HelpMenuView() {
        super("\n"
            + "\n----------------------------------------"
            + "\n | Help Menu                           |"
            + "\n ---------------------------------------"
            + "\nG - What is the goal of the game"
            + "\nM - How to move your character"
            + "\nF - Calculating Fuel"
            + "\nO - Calculating O2"
            + "\nT - Construction Tools"
            + "\nH - Mining Resources"
            + "\nD - Delivering resources to facility"
            + "\nS - Repairing the ship"
            + "\nQ - Quit help menu"
            + "\n---------------------------------------");
    }
        

    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered
        
        switch (choice) {
            case 'G': //Goal of the game
                System.out.println(ANSI_BLUE + "Survive on a desolate asteroid by mining"
                    + ANSI_BLUE    + "resources to repair and refuel your ship. Return"
                    + ANSI_BLUE    + "classidied item to Earth" + ANSI_RESET);
                break;
            case 'M': //Move character
                System.out.println(ANSI_BLUE + "To move character simply enter the desired"
                    + ANSI_BLUE    + "location coordinates" + ANSI_RESET);
                break;
            case 'F': // calculate fuel
                System.out.println(ANSI_BLUE + "To calculate fuel input current location and"
                    + ANSI_BLUE    + "desired location" + ANSI_RESET);
                break;
            case 'O': // calculate O2
                System.out.println(ANSI_BLUE + "To calculate O2 input current location and"
                    + ANSI_BLUE    + "desired location" + ANSI_RESET);
                break;
            case 'T': // manufacture tools
                System.out.println(ANSI_BLUE + "To construct tool enter the desired tool"
                    + ANSI_BLUE    + "and robot will display if you have all the required"
                    + ANSI_BLUE    + "resources to manufacture the tool." + ANSI_RESET);
                break;
                case 'H': // Mine resorces
                System.out.println(ANSI_BLUE + "To mine resources enter desired location"
                    + ANSI_BLUE    + "and choose which resource and amount you would like"
                    + ANSI_BLUE    + "to mine." + ANSI_RESET);
                break;
                case 'D': // Deliver resorces
                System.out.println(ANSI_BLUE + "You must deliver resources to the facility"
                    + ANSI_BLUE    + "in order to make tools, repair the ship, or refuel"
                    + ANSI_BLUE    + " the ship." + ANSI_RESET);
                break;
                case 'S': // Repair ship
                System.out.println(ANSI_BLUE + "You must repair the hull of the ship with"
                     + ANSI_BLUE   + "resources mined on the asteriod before you can launch." + ANSI_RESET);
                break;
                case 'Q': //Exit the help menu
                return true;
                default:
                    
                System.out.println(ANSI_RED + "\n*** Invalid selection *** Try Again" + ANSI_RESET);
                break;
        }
        
        return false;
    }
    
}
