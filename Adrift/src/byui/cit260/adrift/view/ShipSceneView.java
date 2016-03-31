/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byu.cit260.adrift.enums.SceneType;
import byui.cit260.adrift.control.ShipControl;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Scene;

/**
 *
 * @author Dallas
 */
public class ShipSceneView extends View{
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    Game game = Adrift.getCurrentGame();
    Scene[] scenes = game.getScenes();
    RepairShipView repairShip = new RepairShipView();
    ShipStatusView shipStauts = new ShipStatusView();
    ShipControl shipControl = new ShipControl();

    
    public ShipSceneView() {
        super("\nWhat would you like to do at the ship"
            +"\n"
            + "\nC - Check ship status"
            + "\nR - Repair ship"
            + "\nL - Launch ship"
            + "\nQ - Quit to move to location menu"
            + "\n---------------------------------------");
    }
         @Override
    public boolean doAction(String value) {
       value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered 
    
        switch (choice) {
            case 'C': 
                shipStauts.dislpayShipStatus(); // display ship status
                break;
            case 'R': 
                repairShip.display(); // display repair ship view
                break;
            case 'L': 
                shipControl.launchShip(); // launch ship
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

    void displayShipScene() {
        String shipScene = scenes[SceneType.ship.ordinal()].getDescription();
        this.console.println(shipScene);
        this.display();
    }
    
}
