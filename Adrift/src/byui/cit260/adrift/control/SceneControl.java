/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.Adrift;

import byui.cit260.adrift.exceptions.SceneControlException;
import byui.cit260.adrift.exceptions.BuggyControlException;
import byui.cit260.adrift.model.Buggy;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Scene;
import static byui.cit260.adrift.view.SceneView.ANSI_BLUE;
import static byui.cit260.adrift.view.SceneView.ANSI_RESET;
import static byui.cit260.adrift.control.InventoryControl.ANSI_RED;
import byui.cit260.adrift.view.ErrorView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author Dallas
 */
public class SceneControl {
    Game game = Adrift.getCurrentGame();
    Map map = game.getMap();
    Location[][] locations = map.getLocations();
    Scene[] scenes = game.getScenes();
    InventoryItem[] inventoryList = game.getInventory();
    Buggy buggy = game.getBuggy();
    BuggyControl buggyControl = new BuggyControl();
    protected final BufferedReader keyboard = Adrift.getInFile();
    protected final PrintWriter console = Adrift.getOutFile();
    int row;
    int column;
    int amountToMine;
    int resourceAmount;
    int sceneAmount;
    String resourceDescription;
    String currentInventoryDesc;
    
        public void mineResources(String resourceDescription, String currentInventoryDesc)
                throws SceneControlException, BuggyControlException {
        
        boolean valid = false;
        int currentInventoryAmount;
        String input = null;  // Integer.parseInt(numberAsString)
         
        while (!valid){
            this.console.println(ANSI_BLUE + "\nHow much " + resourceDescription 
                                + " would you like to mine?" + ANSI_RESET);
             
            try {
                input = this.keyboard.readLine();
            } catch (IOException ex) {
                 ErrorView.display(this.getClass().getName(),
                         "Enter valid selection" + ex.getMessage());
            }
            input= input.trim();
             
            if (input.length() < 1) {
            
               throw new SceneControlException("Invalid selection - the menu item must not be blank");
                
             }   
            amountToMine = Integer.parseInt(input);
            
                if(amountToMine > resourceAmount) {
                    throw new BuggyControlException(ANSI_RED + "Invalid selection you only have " + resourceAmount
                                    + ANSI_RED    + " " + resourceDescription + " to mine." + ANSI_RESET);
                }
                buggyControl.calWeight(amountToMine);
        
        for(InventoryItem inventory : inventoryList) {
            currentInventoryAmount = inventory.getQuantityInStock();
            currentInventoryDesc = inventory.getDescription().trim();
            if(inventory.getDescription().trim().equals(resourceDescription.trim()))
                inventory.setQuantityInStock(amountToMine + currentInventoryAmount);
        }

           sceneAmount = resourceAmount - amountToMine;
                locations[row][column].getScene().setResourceAmount(sceneAmount);
                break;
        }
        
    }
    
}
