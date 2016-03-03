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
public class GameMenuView extends View {
    public GameMenuView(){
    super ("\n"
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
            + "\nC - Calculate Calories"
            + "\nT - Construct Tools"
            + "\nR - Mine Resources"
            + "\nD - Deliver Resource"
            + "\nW - Repair Ship"
            + "\nJ - Launch Ship"
            + "\nH - Help"
            + "\nQ - Exit to Main Menu"
            + "\n---------------------------------------");
    }
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered
        
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
                this.displayCalcFuel();
                break;
                
            case 'O': // Calculate O2
                System.out.println("Calculate O2");
                break;
                
            case 'C': //Calculate Calories
                this.displayCalcCalories();
                break;
                
            case 'T': // Construct Tools
                this.constructTools();
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
                gameMenu.display();
                
            default:
                System.out.println("\n*** Invalid selection *** Try Again");
                break;
        }     
        return false;
    }

   
    private void constructTools() {
        ConstructToolsView constructToolsMenu = new ConstructToolsView ();//display the construct tools menu
        constructToolsMenu.displayconstructToolsMenu();
    }

    private void displayCalcFuel() {
        CalculateFuelView calcFuel = new CalculateFuelView();
        calcFuel.display();
    }

    private void displayCalcCalories() {
        CalculateCaloriesView calcCalories = new CalculateCaloriesView();
        calcCalories.display();
    }
}
