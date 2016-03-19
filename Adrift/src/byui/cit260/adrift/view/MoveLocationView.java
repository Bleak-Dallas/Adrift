/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byui.cit260.adrift.control.BuggyControl;
import byui.cit260.adrift.exceptions.FoodControlException;
import byui.cit260.adrift.exceptions.MapControlException;
import byui.cit260.adrift.model.Buggy;
import byui.cit260.adrift.model.FoodControl;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Player;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dallas
 */
public class MoveLocationView extends View{
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    Game game = Adrift.getCurrentGame();
    Buggy buggy  = game.getBuggy();
    BuggyControl buggyControl = new BuggyControl();
    FoodControl foodControl = new FoodControl();
    private int row;
    private int column;
    
    public MoveLocationView() {
                super("\n"
                    + "\n----------------------------------------"
                    + "\n |       Move To New Location          |"
                    + "\n ---------------------------------------"
     + ANSI_BLUE    + "\nTo move from one location to the next"
     + ANSI_BLUE               + "\nyou will need to enter the X and Y "
     + ANSI_BLUE               + "\ncoordinates. On the view map screen you"
     + ANSI_BLUE               + "\nwill see Sectors like this: 0,2. The"
     + ANSI_BLUE               + "\nfirst number is the X coordinate and"
     + ANSI_BLUE               + "\nthe second number is the Y coordinate."
     + ANSI_BLUE               +"\n" + ANSI_RESET
                 + "\nX - Enter X coordinate" 
                    + "\nY - Enter Y coordinate"
                    + "\n --------------------------------------"
                    + "\nC - Check buggy's fuel level"
                    + "\nF - Fill buggy with fuel"
                    + "\nO - Check O2 level"
                    + "\nR - Replacce O2"
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
             case 'X': {
            try {
                this.moveToX();
            } catch (MapControlException ex) {
                System.out.println(ex);
            }
        }
                 break;
             case 'Y': {
            try {
                this.moveToY();
            } catch (MapControlException ex) {
                System.out.println(ex);
            }
        }
                 break;
             case 'C': //create and start new game
                 this.checkFuel();
                 break;
             case 'F': //Load existing game
                 this.fillBuggy();
                 break;
             case 'O': //create and start new game
                 this.checkO2();
                 break;
             case 'R': //Load existing game
                 this.fillO2();
                 break;
             case 'L': //create and start new game
                 this.checkFood();
                 break;
             case 'E': {
            try {
                //Load existing game
                this.fillFood();
            } catch (FoodControlException ex) {
                System.out.println(ex);
            }
        }
                 break;
             case 'Q': //Exit the game
                 return true;
             default:
                 System.out.println(ANSI_RED + "\n*** Invalid selection *** Try Again" + ANSI_RESET);
                 break;
         }  
         return false;
    }

    private void moveToX() throws MapControlException {
        boolean valid = false;
        String input = null;  // Integer.parseInt(numberAsString)
        Scanner keyboard = new Scanner(System.in);
         
        while (!valid){
            System.out.println("Enter selection");
             
            input = keyboard.nextLine();
            input= input.trim();
             
            if (input.length() < 1) {
               throw new MapControlException(ANSI_RED + "Invalid selection - the menu item must not be blank" + ANSI_RESET);

             }
        try {
            
            row = Integer.parseInt(input);
        } catch (NumberFormatException nf){
            System.out.println(ANSI_RED + "\nYou must enter a valid number" + ANSI_RESET);
        }
            break;
         }
        
        if(row < 0 || row > 4) {
                throw new MapControlException("\n The X coordinate must be between 0 and 4");
            }
         
     }
    

    private void moveToY() throws MapControlException {
        boolean valid = false;
        String input = null;  // Integer.parseInt(numberAsString)
        
        Scanner keyboard = new Scanner(System.in);
         
        while (!valid){
            System.out.println("Enter selection");
             
            input = keyboard.nextLine();
            input= input.trim();
             
            if (input.length() < 1) {
                throw new MapControlException(ANSI_RED + "Invalid selection - the menu item must not be blank" + ANSI_RESET);
             }
            
        try {
                  
            column = Integer.parseInt(input);
        } catch (NumberFormatException nf){
            System.out.println(ANSI_RED + "\nYou must enter a valid number" + ANSI_RESET);
        }
            break;
         }
        
        if(column < 0 || column > 4) {
           throw new MapControlException("\n The Y coordinate must be between 0 and 4");
        }
        
        this.moveLocation();

    }

    private void moveLocation() {
        Player player = game.getPlayer();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
     
        Location currentLocation = game.getCurrentLocation();
        buggyControl.calcFuel(currentLocation, row, column);
        foodControl.calcFood(currentLocation, row, column);


        game.setCurrentLocation(locations[row][column]);
        
        SceneView sceneView = new SceneView();
            sceneView.displaySceneView(row, column);
        
  
    }

    private void checkFuel() {
        double amountToFill = buggy.getFuelCapacity() - buggy.getFuelLevel();
        System.out.println(ANSI_BLUE + "\nThe buggy's current fuel level is: " + buggy.getFuelLevel()
                    + ANSI_BLUE      + "\nThe buugy can hold " + amountToFill + " more gallons" + ANSI_RESET);
    }

    private void fillBuggy() {
        boolean valid = false;
        String input = null;  // Integer.parseInt(numberAsString)
        int fillAmount = 0;
        
        Scanner keyboard = new Scanner(System.in);
         
        while (!valid){
            System.out.println(ANSI_BLUE + "\nHow much fuel would you like to put in the buggy? MAX 4 when empty" + ANSI_RESET);
             
            input = keyboard.nextLine();
            input= input.trim();
             
            if (input.length() < 1) {
                System.out.println(ANSI_RED + "Invalid selection - the menu item must not be blank" + ANSI_RED);
                continue;
             }
            
        try {
                  
            fillAmount = Integer.parseInt(input);
        } catch (NumberFormatException nf){
            System.out.println(ANSI_RED + "\nYou must enter a valid number" + ANSI_RESET);
        }
            break;
        }
        
        if(fillAmount < 0 || fillAmount > 4) {
            System.out.println(ANSI_RED + "\nYou obviously cannot follow instructions. Enter 1-4" + ANSI_RESET);
        }
        
        buggyControl.fillFuel(fillAmount);
    }

    private void checkO2() {
        System.out.println("\n*** called checkO2 function has been called in MoveLocation Class ***");
        //double amountToFill = buggy.getFuelCapacity() - buggy.getFuelLevel();
        //System.out.println(ANSI_BLUE + "\nThe buggy's current fuel level is: " + buggy.getFuelLevel()
        //                 + "\nThe buugy can hold " + amountToFill + " more gallons" + ANSI_RESET);
    }

    private void fillO2() {
        System.out.println("\n*** called fillO2 function has been called in MoveLocation Class ***");
    }

    private void checkFood() {
        foodControl.checkFood();
    }

    private void fillFood() throws FoodControlException {
         boolean valid = false;
        String input = null;  // Integer.parseInt(numberAsString)
        int fillAmount = 0;
        
        Scanner keyboard = new Scanner(System.in);
         
        while (!valid){
            System.out.println(ANSI_BLUE + "\nHow much food would you like to eat?" + ANSI_RESET);
             
            input = keyboard.nextLine();
            input= input.trim();
             
            if (input.length() < 1) {
                throw new FoodControlException("Invalid selection - the menu item must not be blank");
             }
            
        try {
                  
            fillAmount = Integer.parseInt(input);
            } catch (NumberFormatException nf){
                System.out.println("\nYou must enter a valid number");
            }
            break;

        
        }
    try {
        foodControl.fillFood(fillAmount);
    } catch (FoodControlException ex) {
        System.out.println(ex);
        }
    }
    
}

