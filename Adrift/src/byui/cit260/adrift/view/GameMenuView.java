/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;
import java.util.Scanner;
/**
 *
 * @author Autumn
 */
public class GameMenuView {
    
        private final String GAMEMENU = "\n"
            + "\n----------------------------------------"
            + "\n | Game Menu                           |"
            + "\n ---------------------------------------"
            + "\nV - View Map"
            + "\nI - View Inventory"
            + "\nS - View Ship Status"
            + "\nL - View Contents of Coordinate"
            + "\nM - Move To Coordinate"
            + "\nE - Estimate Resources Needed"
            + "\nF - Calculate Fuel"
            + "\nO - Calculate O2"
            + "\nC - Construct Tools"
            + "\nR - Mine Resources"
            + "\nD - Deliver Resource"
            + "\nW - Repair Ship"
            + "\nJ - Launch Ship"
            + "\nH - Help"
            + "\nQ - Exit to Main Menu"
            + "\n---------------------------------------";
        
        void displayGameMenu() {
          
        char selection = ' ';
        do {
            
            System.out.println(GAMEMENU); //To change body of generated methods, choose Tools | Templates.
    
            String input = this.getInput();
            selection = input.charAt(0);
        
            this.doAction(selection);
        
        } while (selection != 'Q');
    }

    private String getInput() {
        boolean valid = false;
        String input = null;
        Scanner keyboard = new Scanner(System.in);
        
        while (!valid){
            System.out.println("Enter menu selection");
            
            input = keyboard.nextLine();
            input= input.trim();
            
            if (input.length() < 1) {
                System.out.println("Invalid selection - the menu item must not be blank");
                continue;
            }
            break;
        }
        
        return input;
    }

    private void doAction(char choice) {
        switch (choice) {
            case 'V': // view map
                System.out.println("view map");
                break;
                
            case 'I': // view inventory
                System.out.println("view inventory");
                break;
                
            case 'S': // view Ship status
                System.out.println("view Ship status");
                break;
                
            case 'L': // View Contents of Coordinate
                System.out.println("View Contents of Coordinate");
                break;
                
            case 'M': // Move To Coordinate
                System.out.println("Move To Coordinate");
                break;
                
            case 'E': // Estimate Resources needed
                System.out.println("Estimate Resources needed");
                break;
                
            case 'F': // Calculate Fuel
                System.out.println("Calculate Fuel");
                break;
                
            case 'O': // Calculate O2
                System.out.println("Calculate O2");
                break;
                
            case 'C': // Construct Tools
                System.out.println("Construct Tools");
                break;
                
            case 'R': // Mine Resources
                System.out.println("Mine Resources");
                break;
                
            case 'D': // Deliver resources
                System.out.println("Deliver resources");
                break;
                
            case 'W': // Repair ship
                System.out.println("Repair ship");
                break;
                
            case 'J': // Launch ship
                System.out.println("Launch ship");
                break;
                
            case 'H': // help
                System.out.println("HELP!!!");
                break;
                
            case 'Q': //Exit the game menu
                GameMenuView gameMenu = new GameMenuView (); //display the game menu
                gameMenu.displayMenu();
                
            default:
                System.out.println("\n*** Invalid selection *** Try Again");
                break;
        }     
    }

    void displayMenu() {
         //To change body of generated methods, choose Tools | Templates.
    }
}
