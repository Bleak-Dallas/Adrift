/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byu.cit260.adrift.enums.Item;
import byui.cit260.adrift.control.BuggyControl;
import byui.cit260.adrift.control.SceneControl;
import byui.cit260.adrift.exceptions.SceneControlException;
import byui.cit260.adrift.model.Buggy;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Scene;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dallas
 */

public class SceneView extends View{
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    Game game = Adrift.getCurrentGame();
    Map map = game.getMap();
    Location[][] locations = map.getLocations();
    Scene[] scenes = game.getScenes();
    InventoryItem[] inventoryList = game.getInventory();
    Buggy buggy = game.getBuggy();
    BuggyControl buggyControl = new BuggyControl();
    SceneControl sceneControl = new SceneControl();
    int row;
    int column;
    int amountToMine;
    int resourceAmount;
    int sceneAmount;
    String resourceDescription;
    String currentInventoryDesc;
    
    public SceneView() {
        super("\n"
            + "\nWhat would you like to do in this sector"
            +"\n"
            + "\nC - Check resources"
            + "\nM - Mine resources"
            + "\nQ - Quit to move to location menu"
            + "\n---------------------------------------");
    }
         @Override
    public boolean doAction(String value) {
       value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered 
    
        switch (choice) {
            case 'C': //create and start new game
                this.checkResources();
                break;
            case 'M': {
           try {               
               sceneControl.mineResources(resourceDescription, currentInventoryDesc);
           } catch (SceneControlException ex) {
               System.out.println(ex);
           }
       }
                break;
            case 'Q': //Quit the game
                return true;
            default:
                System.out.println(ANSI_RED + "\n*** Invalid selection *** Try Again" + ANSI_RESET);
                break;
        }     
        return false;
    }

    void displaySceneView(int row, int column) {
        this.row = row;
        this.column = column;

        String menu = locations[row][column].getScene().getDescription();
        System.out.println("\n" + ANSI_BLUE + menu + ANSI_RESET);
        this.display();
    }

    private void checkResources() {
        resourceDescription = locations[row][column].getScene().getResourceDescription().trim();
        resourceAmount = locations[row][column].getScene().getResourceAmount();
        System.out.println(ANSI_BLUE + "\nThe resource found in this sector is " + resourceDescription
                         + "\nThe amount remaining is " + resourceAmount + ANSI_RESET);
        
    }

}

