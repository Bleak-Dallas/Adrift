/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Player;
import java.util.Scanner;

/**
 *
 * @author Dallas
 */
public class MoveLocationView extends View{
    
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
                    +"\n"
                    + "\nX - Enter X coordinate"
                    + "\nY - Enter Y coordinate"
                    + "\nQ - Quit to game menu"
                    + "\n---------------------------------------");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered
        
        switch (choice) {
             case 'X': //create and start new game
                 this.moveToX();
                 break;
             case 'Y': //Load existing game
                 this.moveToY();
                 break;
             case 'Q': //Exit the game
                 return true;
             default:
                 System.out.println("\n*** Invalid selection *** Try Again");
                 break;
         }  
         return false;
    }

    private void moveToX() {
        boolean valid = false;
        String input = null;  // Integer.parseInt(numberAsString)
        Scanner keyboard = new Scanner(System.in);
         
        while (!valid){
            System.out.println("Enter selection");
             
            input = keyboard.nextLine();
            input= input.trim();
             
            if (input.length() < 1) {
                System.out.println("Invalid selection - the menu item must not be blank");
                continue;
             }
        try {
            
            row = Integer.parseInt(input);
        } catch (NumberFormatException nf){
            System.out.println("\nYou must enter a valid number");
        }
            break;
         }
        
        if(row < 0 || row > 4) {
                System.out.println("\n The X coordinate must be between 0 and 4");
            }
         
     }
    

    private void moveToY() {
        boolean valid = false;
        String input = null;  // Integer.parseInt(numberAsString)
        
        Scanner keyboard = new Scanner(System.in);
         
        while (!valid){
            System.out.println("Enter selection");
             
            input = keyboard.nextLine();
            input= input.trim();
             
            if (input.length() < 1) {
                System.out.println("Invalid selection - the menu item must not be blank");
                continue;
             }
            
        try {
                  
            column = Integer.parseInt(input);
        } catch (NumberFormatException nf){
            System.out.println("\nYou must enter a valid number");
        }
            break;
         }
        
        if(column < 0 || column > 4) {
            System.out.println("\n The Y coordinate must be between 0 and 4");
        }
        
        this.moveLocation();

    }

    private void moveLocation() {
        Game game = Adrift.getCurrentGame();
        Player player = game.getPlayer();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        
        game.setCurrentLocation(locations[row][column]);
        
        SceneView sceneView = new SceneView();
            sceneView.displaySceneView(row, column);
        
  
    }
}

