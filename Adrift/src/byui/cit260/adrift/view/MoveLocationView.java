/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byui.cit260.adrift.control.BuggyControl;
import byui.cit260.adrift.control.ToolsControl;
import byui.cit260.adrift.exceptions.BuggyControlException;
import byui.cit260.adrift.exceptions.FoodControlException;
import byui.cit260.adrift.exceptions.GameControlException;
import byui.cit260.adrift.exceptions.MapControlException;
import byui.cit260.adrift.model.Buggy;
import byui.cit260.adrift.model.FoodControl;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Player;
import java.io.IOException;
import java.text.NumberFormat;

/**
 *
 * @author Dallas
 */
public class MoveLocationView extends View{
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    NumberFormat defaultFormat = NumberFormat.getPercentInstance();
    Game game = Adrift.getCurrentGame();
    Buggy buggy  = game.getBuggy();
    InventoryItem[] inventoryList = game.getInventory();
    BuggyControl buggyControl = new BuggyControl();
    FoodControl foodControl = new FoodControl();
    ToolsControl toolControl = new ToolsControl();
    FacilitySceneView facilityScene = new FacilitySceneView();
    private int row;
    private int column;
    
    public MoveLocationView() {
                super("\n"
                    + "\n----------------------------------------"
                    + "\n |       Move To New Location          |"
                    + "\n ---------------------------------------"
                    + "\nTo move from one location to the next"
                    + "\nyou will need to enter the X and Y "
                    + "\ncoordinates. On the view map screen you"
                    + "\nwill see Sectors like this: 0,2. The"
                    + "\nfirst number is the X coordinate and"
                    + "\nthe second number is the Y coordinate."
                    + "\n"
                    + "\nD - Enter sector coordinates for destination"
                    + "\n" 
                    + "\n --------------------------------------"
                    + "\nC - Check buggy's fuel level"
                    + "\nF - Fill buggy with fuel"
                    + "\nW - Check buggy's weight"
                    + "\nO - Check O2 level"
                    + "\nL - Check food level"
                    + "\nE - Eat food"
                    + "\nQ - Quit to game menu"
                    + "\n---------------------------------------");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered
        
        switch (choice) {
             case 'D': {
            try {
                this.moveToDestination();
            } catch (MapControlException ex) {
                this.console.println(ex);
            }
        }
                 break;
                 
             case 'C': 
                 this.checkFuel();
                 break;
                 
             case 'F': 
        {
            try {
                this.fillBuggy();
            } catch (BuggyControlException ex) {
                this.console.println(ex);
            }
        }
                 break;
                 
            case 'W': 
                 buggyControl.checkBuggyWeight();
                 break;
                 
             case 'O': 
                 this.checkO2();
                 break;
                 
             case 'L': 
                 this.checkFood();
                 break;
                 
             case 'E': {
            try {
                this.fillFood();
            } catch (FoodControlException ex) {
                this.console.println(ex);
            }
        }
                 break;
                 
             case 'Q': //Exit the game
                 return true;
             default:
                ErrorView.display(this.getClass().getName(),
                        ANSI_RED + "\n*** Invalid selection *** Try Again" + ANSI_RESET);
                 break;
         }  
         return false;
    }

    private boolean moveToDestination() throws MapControlException {
        boolean valid = false;
        String input = null;  // Integer.parseInt(numberAsString)
         
        while (!valid){
            this.console.println("Enter X coordinate");
        try {
                input = this.keyboard.readLine();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), 
                                        "Enter valid selection" + ex.getMessage());
                break;
            }
            input= input.trim();
             
            if (input.length() < 1) {
                 ErrorView.display(this.getClass().getName(),
                         ANSI_RED + "Invalid selection - the X coordinate must not be blank" + ANSI_RESET);
                continue;
             }
        try {
            row = Integer.parseInt(input);
        } catch (NumberFormatException nf){
           ErrorView.display(this.getClass().getName(),
                   ANSI_RED + "\nYou must enter a valid number" + nf.getMessage() + ANSI_RESET);
           return false;
        }
            break;
        }
        
        if(row < 0 || row > 4) {
                ErrorView.display(this.getClass().getName(),
                        ANSI_RED + "\n The X coordinate must be between 0 and 4"  + ANSI_RESET);
                return false;
            }
        
         while (!valid){
            this.console.println("Enter Y coordinate");
        try {
                input = this.keyboard.readLine();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),
                        "Enter valid selection" + ex.getMessage());
                break;
            }
            input= input.trim();
             
            if (input.length() < 1) {
                ErrorView.display(this.getClass().getName(),
                        ANSI_RED + "Invalid selection - the Y coordinate must not be blank" + ANSI_RESET);
                continue;
             }
            
        try {
            column = Integer.parseInt(input);
        } catch (NumberFormatException nf){
           ErrorView.display(this.getClass().getName(),
                   ANSI_RED + "\nYou must enter a valid number" + nf.getMessage()+ ANSI_RESET);
           return false;
        }
            break;
         }
        if(column < 0 || column > 4) {
            ErrorView.display(this.getClass().getName(),
                    ANSI_RED + "\n The Y coordinate must be between 0 and 4" + ANSI_RESET);
            return false;
        }
        
        this.moveLocation();
        
        return true;

    }

    private void moveLocation() {
        Player player = game.getPlayer();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        StartProgramView startProgramView = new StartProgramView();
        int totalDistanceTraveled = game.getTotalDistanceTraveled();
        int currentLocationDist = game.getCurrentLocation().getScene().getDistanceTraveled();
        int destinationDist = locations[row][column].getScene().getDistanceTraveled();
        int distanceTraveled;
        int totalDistance;
         // this section calculates the total distance traveled in the game
            if(destinationDist > currentLocationDist) {
                distanceTraveled = destinationDist - currentLocationDist;
            }
            else {
                distanceTraveled = currentLocationDist - destinationDist;
            }
            totalDistance = totalDistanceTraveled + distanceTraveled;
        game.setTotalDistanceTraveled(totalDistance); // this ends total distance traveled section
     
        Location currentLocation = game.getCurrentLocation();
        try {
            buggyControl.calcFuel(currentLocation, row, column);
            foodControl.calcFood(currentLocation, row, column);
            toolControl.calcO2(currentLocation, row, column);
        } catch (GameControlException ex) {
            this.console.println(ex);
            startProgramView.startProgram();
        }


        game.setCurrentLocation(locations[row][column]);
        
        SceneView sceneView = new SceneView();
            sceneView.displaySceneView(row, column);
        
  
    }

    private void checkFuel() {
        double fuelCapacity = buggy.getFuelCapacity();
        double fuelLevel = buggy.getFuelLevel();
        double fuelPercent = fuelLevel / fuelCapacity;
        double amountToFill = buggy.getFuelCapacity() - buggy.getFuelLevel();
        this.console.println(ANSI_BLUE + "\nThe buggy's current fuel level is: " + defaultFormat.format(fuelPercent)
                    + ANSI_BLUE      + "\nThe buugy can hold " + amountToFill + " more gallons" + ANSI_RESET);
    }

    private void fillBuggy() throws BuggyControlException {
        boolean valid = false;
        String input = null;  // Integer.parseInt(numberAsString)
        int fillAmount = 0;
        
         
        while (!valid){
            this.console.println(ANSI_BLUE + "\nHow much fuel would you like to put in the buggy? MAX 4 when empty" + ANSI_RESET);
        try {
                input = this.keyboard.readLine();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),
                        "Enter valid selection" + ex.getMessage());
            }
            input= input.trim();
             
            if (input.length() < 1) {
                throw new BuggyControlException(ANSI_RED + "Invalid selection - the menu item must not be blank" + ANSI_RED);
             }
            
        try {
            fillAmount = Integer.parseInt(input);
        } catch (NumberFormatException nf){
            ErrorView.display(this.getClass().getName(),
                    ANSI_RED + "\nYou must enter a valid number" + nf.getMessage() + ANSI_RESET);
        }
            break;
        }
        
        if(fillAmount < 0 || fillAmount > 4) {
            throw new BuggyControlException(ANSI_RED + "\nYou obviously cannot follow instructions. Enter 1-4" + ANSI_RESET);
        }
        
        try {
            buggyControl.fillFuel(fillAmount);
        } catch (BuggyControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
    }

    private void checkO2() {
        facilityScene.checkO2Level();
    }

    private void checkFood() {
        foodControl.checkFood();
    }

    private void fillFood() throws FoodControlException {
        boolean valid = false;
        String input = null;  // Integer.parseInt(numberAsString)
        int fillAmount = 0;

         
        while (!valid){
            this.console.println(ANSI_BLUE + "\nHow much food would you like to eat?" + ANSI_RESET);
        try {
                input = this.keyboard.readLine();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),
                                    "Enter valid selection" + ex.getMessage());
            }
            input= input.trim();
             
            if (input.length() < 1) {
                throw new FoodControlException("Invalid selection - the menu item must not be blank");
             }
            
        try {
                  
            fillAmount = Integer.parseInt(input);
            } catch (NumberFormatException nf){
                ErrorView.display(this.getClass().getName(),
                                "\nYou must enter a valid number" + nf.getMessage());
            }
            break;
        }
    
    try {
        foodControl.fillFood(fillAmount);
    } catch (FoodControlException ex) {
        ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
    }
    
}

