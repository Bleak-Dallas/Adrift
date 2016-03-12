/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;


import byui.cit260.adrift.control.GameControl;
import byui.cit260.adrift.control.MapControl;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;


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
                this.displayMap();
                break;
                
            case 'I': // view inventory
                this.displayInventory();
                break;
                
            case 'S': // view Ship status
                this.viewShipStatus();
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
                this.displayHelpMenu();
                break;
                
            case 'Q': //Exit the game menu
                return true;
                
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

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView (); //display the game menu
        helpMenu.display();
    }

    private void displayInventory() {
        // get sorted list of inventory items for teh current game
        InventoryItem[] inventory = GameControl.getSortedInventoryList();
        
        System.out.println("\n*************************************************"
                            + "\n|          List of Inventory Items              |"
                            + "\n*************************************************\n");
        System.out.println("Description" + "\t\t" +
                            "Required" + "\t" +
                            "In Stock");
        
        // for each inventory item
        for(InventoryItem item: inventory) {
            // Display the description, the required amount and the amount in stock
            System.out.println(item.getDescription() + "\t\t" +
                               item.getRequiredAmount() + "\t\t" +
                               item.getQuantityInStock());
        }
    }

    private void displayMap() {
        Map map = MapControl.createMap();

        Location loc = new Location();
 

        String menu = ""
            + "\n***********************************************************************"
            + "\n\t\t\t" + map.getName() + "   -   " + map.getDescription()
            + "\n***********************************************************************";
            
            System.out.println(menu);
        
        for(int row = 0; row < map.getLocations().length; row++) {
            // Add header
            for (int column = 0; column < map.getLocations()[row].length; column++) {
                System.out.print("|```````````````|");
            }
            System.out.println("");  // go to next line of row
            
            // Put row,col information in the map
            for(int col = 0; col < map.getLocations()[row].length; col++) {
                System.out.print("|===== " + row + "," + col + " =====|");
            }
            System.out.println(""); // Go to next liine
            
            for (Location location : map.getLocations()[row]) {
                // We have 16 spaces to work with
                int nameLength = 6;
                        
                int spaces = 15 - nameLength;
                
                System.out.print("|");
                
                 // Left Pad the name
                if(spaces > 0) {
                    for(int i = 0;i < spaces/2; i++) {
                        System.out.print(" ");
                    }
                }
                
                // Display location name
                System.out.print(" Sector");
                
                // Right Pad
                if(spaces > 0) {
                    for(int i = 0;i < spaces/2; i++) {
                        System.out.print(" ");
                    }
                }
                System.out.print("|");
            }
            
            System.out.println("");
            for(int col = 0; col < map.getLocations()[row].length; col++) {
                System.out.print("|***************|");
            }
            
            System.out.println("");
            for (Location locations : map.getLocations()[row]) {
                
                if(map.locations == map.locations) {
                    System.out.print("|__You're Here__|");
                } else if (loc.isVisited() == true) {
                    System.out.print("|____Visited____|");
                } else {
                    System.out.print("|__Not Visited__|");
                }
                
            }
            
            System.out.println("");
            for(int col = 0; col < map.getLocations()[row].length; col++) {
                System.out.print("|***************|");
            }

            
            System.out.println("");
            
        }
    }

    private void viewShipStatus() {
        System.out.println("\n****  viewShipStatus() function called in GameMenuView ***");
    }
}

        