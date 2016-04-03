/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byu.cit260.adrift.enums.Item;
import byu.cit260.adrift.enums.SceneType;
import byui.cit260.adrift.control.BuggyControl;
import byui.cit260.adrift.exceptions.BuggyControlException;
import byui.cit260.adrift.control.SceneControl;
import byui.cit260.adrift.exceptions.SceneControlException;
import byui.cit260.adrift.model.Buggy;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Player;
import byui.cit260.adrift.model.Scene;


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
    Player player = game.getPlayer();
    Location[][] locations = map.getLocations();
    Scene[] scenes = game.getScenes();
    InventoryItem[] inventoryList = game.getInventory();
    Buggy buggy = game.getBuggy();
    BuggyControl buggyControl = new BuggyControl();
    SceneControl sceneControl = new SceneControl();
    int row;
    int column;
    double amountToMine;
    double resourceAmount;
    double sceneAmount;
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
               sceneControl.mineResources(row, column);
           } catch (SceneControlException | BuggyControlException ex) {
               ErrorView.display(this.getClass().getName(),ex.getMessage());
           }
       }
                break;
            case 'Q': //Quit the game
                return true;
            default:
                ErrorView.display(this.getClass().getName(),
                        ANSI_RED + "\n*** Invalid selection *** Try Again" + ANSI_RESET);
                break;
        }     
        return false;
    }

    void displaySceneView(int row, int column) {
        this.row = row;
        this.column = column;
        if(row == 0 && column == 0) {
            this.displayShipScene();
        }
        else if(row == 0 && column == 1) {
            this.displayFacilityScene();
        }
        else {
        String menu = locations[row][column].getScene().getDescription();
            if(row == 4 && column == 4) {
                inventoryList[Item.fluxcapacitor.ordinal()].setQuantityInStock(1);
            }
        this.console.println("\n" + ANSI_BLUE + menu + ANSI_RESET);
        this.display();
        }
    }

    private void checkResources() {
        resourceDescription = locations[row][column].getScene().getResourceDescription().trim();
        resourceAmount = locations[row][column].getScene().getResourceAmount();
        this.console.println(ANSI_BLUE + "\nThe resource found in this sector is " + resourceDescription +
                             ANSI_BLUE + "\nThe amount remaining is " + resourceAmount + ANSI_RESET);
        
    }
    
    public void displayStartingScene() {
        String startScene = scenes[SceneType.start.ordinal()].getDescription();
        this.console.println(startScene);
    }
    
    public void displayShipScene() {
        ShipSceneView shipScene = new ShipSceneView();
        shipScene.displayShipScene();
    }
    
    public void displayFacilityScene() {
        FacilitySceneView faciltyScene = new FacilitySceneView();
        faciltyScene.displayFacilitySCene();
        
    }

}

