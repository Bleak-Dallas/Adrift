/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;


import adrift.Adrift;
import byui.cit260.adrift.control.GameControl;
import byui.cit260.adrift.control.ShipControl;
import byui.cit260.adrift.control.ToolsControl;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Tools;


/**
 *
 * @author Autumn
 */
public class GameMenuView extends View {
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    Game game = Adrift.getCurrentGame();
    Map map = game.getMap();
    
    public GameMenuView(){
    super ("\n"
            + "\n----------------------------------------"
            + "\n | Game Menu                           |"
            + "\n ---------------------------------------"
            + "\nV - View Map"
            + "\nI - View Inventory"
            + "\nB - View Tool Inventory"
            + "\nS - View Ship Status"
            + "\nL - View Contents of Coordinate"
            + "\nM - Move To New Sector"
            + "\nF - Calculate Fuel"
            + "\nO - Calculate O2"
            + "\nC - Calculate Calories"
            + "\nT - Construct Tools"
            + "\nR - Repair Ship"
            + "\nJ - Launch Ship"
            + "\nP - Print reports"
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
                
            case 'B': // view inventory
                this.displayToolInventory();
                break;
                
            case 'L': // View Contents of Coordinate
                this.viewResourceSceneType();
                break;
                
            case 'M': // Move To New Sector
                this.moveLocation();
                break;
                
            case 'F': // Calculate Fuel
                this.displayCalcFuel();
                break;
                
            case 'O': // Calculate O2
                this.displayCalcO2();
                break;
                
            case 'C': //Calculate Calories
                this.displayCalcCalories();
                break;
                
            case 'T': // Construct Tools
                this.constructTools();
                break;
                
            case 'R': // Repair ship
                this.repairShip();
                break;
                
            case 'J': // Launch ship
                this.launchShip();
                break;
                
            case 'P': // Print Reports
                this.printReports();
                break;
                
            case 'H': // help
                this.displayHelpMenu();
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

   
    private void constructTools() {
        ConstructToolsView constructToolsMenu = new ConstructToolsView ();//display the construct tools menu
        constructToolsMenu.display();
    }

    private void displayCalcFuel() {
        CalculateFuelView calcFuel = new CalculateFuelView();
        calcFuel.display();
    }
    
    private void displayCalcO2() {
        CalculateO2View calcO2 = new CalculateO2View();
        calcO2.display();
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
        
        this.console.println("\n*************************************************"
                            + "\n|          List of Inventory Items              |"
                            + "\n*************************************************\n");
        this.console.println("Description" + "\t\t" +
                            "In Stock");
        
        // for each inventory item
        for(InventoryItem item: inventory) {
            // Display the description, the required amount and the amount in stock
            this.console.println(item.getDescription() + "\t\t" +
                               item.getQuantityInStock());
        }
    }

    private void displayMap() {
        Location[][] locations = map.getLocations();

        String menu = ""
            + "\n***********************************************************************"
            + "\n\t\t\t" + map.getName() + "   -   " + map.getDescription()
            + "\n***********************************************************************";
            
            this.console.println(menu);
        
        for(int row = 0; row < locations.length; row++) {
            // Add header
            for (int column = 0; column < locations[row].length; column++) {
                this.console.print("|```````````````|");
            }
        
            this.console.println("");  // go to next line of row
            
            // Put row,col information in the map
            for(int col = 0; col < locations[row].length; col++) {
                this.console.print("|===== " + row + "," + col + " =====|");
            }
            this.console.println(""); // Go to next liine
            
            for (Location location :locations[row]) {
                // We have 16 spaces to work with
                int nameLength = 6;
                        
                int spaces = 15 - nameLength;
                
                this.console.print("|");
                
                 // Left Pad the name
                if(spaces > 0) {
                    for(int i = 0;i < spaces/2; i++) {
                        this.console.print(" ");
                    }
                }
                
                // Display location name
                this.console.print(" Sector");
                
                // Right Pad
                if(spaces > 0) {
                    for(int i = 0;i < spaces/2; i++) {
                        this.console.print(" ");
                    }
                }
                this.console.print("|");
            }
            
            this.console.println("");
            for(int col = 0; col < locations[row].length; col++) {
                this.console.print("|***************|");
            }
            
            this.console.println("");

                for (int column = 0; column < locations[row].length; column++)
                    if(locations[row][column] == game.getCurrentLocation()) {
                        this.console.print(ANSI_GREEN + "|__You're Here__|" + ANSI_RESET);
                    } else if (locations[row][column].isVisited()) {
                        this.console.print(ANSI_RED + "|____Visited____|" + ANSI_RESET);
                    } else {
                        this.console.print("|__Not Visited__|");
                    }
                
      
            
            this.console.println("");
            for(int col = 0; col < locations[row].length; col++) {
                this.console.print("|***************|");
            }

            
            this.console.println("");
            
        }
    }

    private void viewShipStatus() {
        ShipStatusView shipStauts = new ShipStatusView();
        shipStauts.dislpayShipStatus();
    }

    private void displayToolInventory() {
       // get sorted list of inventory items for the current game
        Tools[] toolInventory = ToolsControl.getSortedToolList();
        
        this.console.println("\n*************************************************"
                            + "\n|          List of Tools              |"
                            + "\n*************************************************\n");
        this.console.println("Description" + "\t\t" +
                            "In Stock"   + "\t" +
                            "Resource"   + "\t" +
                            "Amount Required");
        
        // for each inventory item
        for(Tools item: toolInventory) {
            // Display the description, the required amount and the amount in stock
            this.console.println(item.getDescription() + "\t\t" +
                               item.getQuantityInStock() + "\t\t" +
                               item.getRequiredResource() + "\t\t" +
                               item.getRequiredAmount());
            
        }
    }
    
    private void viewResourceSceneType() {
         Location[][] locations = map.getLocations();
         
        this.console.println("\n*************************************************"
                            + "\n|          List of Resource Items              |"
                            + "\n*************************************************\n");
        this.console.println("Sector" + "\t\t" +
                           "Description" + "\t\t" +
                           "Available");
        
         
        
        // for each inventory item
        
        for(int row = 0; row < map.getLocations().length; row++) {
            // Add header
            for (int column = 0; column < map.getLocations()[row].length; column++) {
                
            // Display the description, the required amount and the amount in stock
            this.console.println(row + "," + column + "\t\t" +
                               locations[row][column].getScene().getResourceDescription() + "\t\t" +
                               locations[row][column].getScene().getResourceAmount());
            }

        }
    }

    private void moveLocation() {
        MoveLocationView moveLocation = new MoveLocationView();
        moveLocation.display();
    }

    private void printReports() {
        PrintReportView printReport = new PrintReportView (); //display the game menu
        printReport.display();
    }

    private void repairShip() {
        RepairShipView repairShip = new RepairShipView();
        repairShip.display();
    }

    private void launchShip() {
        ShipControl shipControl = new ShipControl();
        shipControl.launchShip();
    }
    
}

        