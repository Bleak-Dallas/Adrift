/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.Adrift;
import byu.cit260.adrift.enums.ToolType;

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
import byui.cit260.adrift.model.Tools;
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
    Tools[] tool = game.getToolInventory();
    Buggy buggy = game.getBuggy();
    BuggyControl buggyControl = new BuggyControl();
    private final BufferedReader keyboard = Adrift.getInFile();
    private final PrintWriter console = Adrift.getOutFile();
    int buggyMaxWeight = buggy.getMaxWeight();
    int buggyCurrentWeight = buggy.getLoadedWeight();
    int row;
    int column;
    int amountToMine;
    int sceneAmount;
    String resourceDescription;
    String currentInventoryDesc;
    
        public boolean mineResources(String resourceDescription, int row, int column)
                throws SceneControlException, BuggyControlException {
            
        int resourceAmount = locations[row][column].getScene().getResourceAmount();
        int hammer = tool[ToolType.hammer.ordinal()].getQuantityInStock();
        int shovel = tool[ToolType.shovel.ordinal()].getQuantityInStock();
        int drill = tool[ToolType.drill.ordinal()].getQuantityInStock();
        boolean valid = false;
        int currentInventoryAmount;
        String input = null;  // Integer.parseInt(numberAsString)
        
        if(resourceDescription.trim().equals("Iron") && hammer >= 1 
                || resourceDescription.trim().equals("Aluminum") && hammer >= 1  
                || resourceDescription.trim().equals("Uranium") && hammer >= 1 && shovel >=1 
                || resourceDescription.trim().equals("Copper") && hammer >= 1 
                || resourceDescription.trim().equals("Fuel") && drill >= 1 
                || resourceDescription.trim().equals("Food")) {

        while (!valid){
            this.console.println(ANSI_BLUE + "\nHow much " + resourceDescription 
                                + " would you like to mine?" + ANSI_RESET);
             
            try {
                input = this.keyboard.readLine();
            } catch (IOException ex) {
                 ErrorView.display(this.getClass().getName(),
                         "Enter valid selection" + ex.getMessage());
            }
            input = input.trim();
             
            if (input.length() < 1) {
                throw new SceneControlException("Invalid selection - the menu item must not be blank");
            
            }
            break;
        }
            amountToMine = Integer.parseInt(input);
            
                if(amountToMine > resourceAmount) {
                    throw new BuggyControlException(ANSI_RED + "Invalid selection you only have " + resourceAmount
                                    + ANSI_RED    + " " + resourceDescription + " to mine." + ANSI_RESET);
                }
                
                sceneAmount = resourceAmount - amountToMine;
            if(sceneAmount < 0) {
                this.console.println(ANSI_RED + "\nThere is no more resources to mine at this location" + ANSI_RESET);
                return false;
            } else {
                buggyControl.calWeight(amountToMine);
                locations[row][column].getScene().setResourceAmount(sceneAmount);
            }

            for(InventoryItem inventory : inventoryList) {
                currentInventoryAmount = inventory.getQuantityInStock();
                currentInventoryDesc = inventory.getDescription().trim();
                if(inventory.getDescription().trim().equals(resourceDescription.trim()))
                    inventory.setQuantityInStock(amountToMine + currentInventoryAmount);
                }
        } else {
            throw new SceneControlException(ANSI_RED + "\nYou do not have the tool required to mine this resource" + ANSI_RESET);
        }
        return true;
    }
    
}
