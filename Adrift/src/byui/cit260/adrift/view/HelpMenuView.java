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
                System.out.println("Survive on a desolate asteroid by mining"
                        + "resources to repair and refuel your ship. Return"
                        + "classidied item to Earth");
                break;
            case 'M': //Move character
                System.out.println("To move character simply enter the desired"
                        + "location coordinates");
                break;
            case 'F': // calculate fuel
                System.out.println("To calculate fuel input current location and"
                        + "desired location");
                break;
            case 'O': // calculate O2
                System.out.println("To calculate O2 input current location and"
                        + "desired location");
                break;
            case 'T': // manufacture tools
                System.out.println("To construct tool enter the desired tool"
                        + "and robot will display if you have all the required"
                        + "resources to manufacture the tool.");
                break;
                case 'H': // Mine resorces
                System.out.println("To mine resources enter desired location"
                        + "and choose which resource and amount you would like"
                        + "to mine.");
                break;
                case 'D': // Deliver resorces
                System.out.println("You must deliver resources to the facility"
                        + "in order to make tools, repair the ship, or refuel"
                        + " the ship.");
                break;
                case 'S': // Repair ship
                System.out.println("You must repair the hull of the ship with"
                        + "resources mined on the asteriod before you can launch.");
                break;
                case 'Q': //Exit the help menu
                MainMenuView mainMenu = new MainMenuView (); //display the game menu
                mainMenu.display();
                default:
                    
                System.out.println("\n*** Invalid selection *** Try Again");
                break;
        }
        
        return false;
    }
    
}
