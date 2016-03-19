/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byui.cit260.adrift.control.InventoryControl;
import byui.cit260.adrift.exceptions.InventoryControlException;
import byui.cit260.adrift.model.Buggy;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Scene;
import java.util.Scanner;

/**
 *
 * @author Dallas
 */
public class CalculateFuelView extends View{

    Game game = Adrift.getCurrentGame();
    Map map = game.getMap();
    Scene[] scenes = game.getScenes();
    Location[][] locations = map.getLocations();
    Buggy buggy = game.getBuggy();
    InventoryControl inventoryControl = new InventoryControl();
    double currentFuel = buggy.getFuelLevel();
    int currentLocation;
    int destination;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public CalculateFuelView() {
        super("\n"
            + "\n----------------------------------------"
            + "\n | Calculate Fuel                          |"
            + "\n ---------------------------------------"
            + "\nTo calculate the fuel that will be needed"
            + "\nto travel from your current location to "
            + "\nyour destination please input your current"
            + "\nlocation and desired destination "
            +"\n"
            + "\nC - Current location"
            + "\nD - Destination"
            + "\nQ - Quit to main menu"
            + "\n---------------------------------------");
    }
         @Override
    public boolean doAction(String value) {
       value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered 
    
        switch (choice) {
            case 'C': //create and start new game
                this.currentLocation();
                break;
            case 'D': //Load existing game
                this.destination();
                break;
            case 'Q': //Quit the game
                return true;
            default:
                System.out.println(ANSI_RED + "\n*** Invalid selection *** Try Again" + ANSI_RESET);
                break;
        }     
        return false;
    }

   private void currentLocation() {
        boolean valid = false;
        int row = 0;
        int column = 0;
        String input = null;  // Integer.parseInt(numberAsString)
        Scanner keyboard = new Scanner(System.in);
         
        while (!valid){
            System.out.println("Enter X coordinate");
             
            input = keyboard.nextLine();
            input= input.trim();
             
            if (input.length() < 1) {
                System.out.println(ANSI_RED + "Invalid selection - the menu item must not be blank" + ANSI_RESET);
                continue;
             }
        try {
            
            row = Integer.parseInt(input);
        } catch (NumberFormatException nf){
            System.out.println(ANSI_RED + "\nYou must enter a valid number" + ANSI_RESET);
        }
            break;
         }
        
        if(row < 0 || row > 4) {
                System.out.println("\n The X coordinate must be between 0 and 4");
            }
        
         while (!valid){
            System.out.println("Enter Y coordinate");
             
            input = keyboard.nextLine();
            input= input.trim();
             
            if (input.length() < 1) {
                System.out.println(ANSI_RED + "Invalid selection - the menu item must not be blank" + ANSI_RESET);
                continue;
             }
            
        try {
                  
            column = Integer.parseInt(input);
        } catch (NumberFormatException nf){
            System.out.println(ANSI_RED + "\nYou must enter a valid number" + ANSI_RESET);
        }
            break;
         }
        
        if(column < 0 || column > 4) {
            System.out.println("\n The Y coordinate must be between 0 and 4");
        }
        
        currentLocation = locations[row][column].getScene().getDistanceTraveled();
    }

    private void destination() {
          boolean valid = false;
        int row = 0;
        int column = 0;
        String input = null;  // Integer.parseInt(numberAsString)
        Scanner keyboard = new Scanner(System.in);
         
        while (!valid){
            System.out.println("Enter X coordinate");
             
            input = keyboard.nextLine();
            input= input.trim();
             
            if (input.length() < 1) {
                System.out.println(ANSI_RED + "Invalid selection - the menu item must not be blank" + ANSI_RESET);
                continue;
             }
        try {
            
            row = Integer.parseInt(input);
        } catch (NumberFormatException nf){
            System.out.println(ANSI_RED + "\nYou must enter a valid number" + ANSI_RESET);
        }
            break;
         }
        
        if(row < 0 || row > 4) {
                System.out.println("\n The X coordinate must be between 0 and 4");
            }
        
         while (!valid){
            System.out.println("Enter Y coordinate");
             
            input = keyboard.nextLine();
            input= input.trim();
             
            if (input.length() < 1) {
                System.out.println(ANSI_RED + "Invalid selection - the menu item must not be blank" + ANSI_RESET);
                continue;
             }
            
        try {
                  
            column = Integer.parseInt(input);
        } catch (NumberFormatException nf){
            System.out.println( ANSI_RED + "\nYou must enter a valid number" + ANSI_RESET);
        }
            break;
         }
        
        if(column < 0 || column > 4) {
            System.out.println("\n The Y coordinate must be between 0 and 4");
        }
        
        destination = locations[row][column].getScene().getDistanceTraveled();
        
        try {
            inventoryControl.calculateFuelNeeded(currentFuel, currentLocation, destination);
        } catch (InventoryControlException ex) {

        }

    }
 
    
}
