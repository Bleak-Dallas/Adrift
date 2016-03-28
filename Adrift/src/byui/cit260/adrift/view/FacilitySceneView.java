/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byu.cit260.adrift.enums.SceneType;
import byu.cit260.adrift.enums.ToolType;
import byui.cit260.adrift.model.Buggy;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Player;
import byui.cit260.adrift.model.Scene;
import byui.cit260.adrift.model.Tools;
import java.text.NumberFormat;
/**
 *
 * @author Dallas
 */
public class FacilitySceneView extends View{
    Game game = Adrift.getCurrentGame();
    Map map = game.getMap();
    Player player = game.getPlayer();
    Location[][] locations = map.getLocations();
    Scene[] scenes = game.getScenes();
    Tools[] tool = game.getToolInventory();
    Buggy buggy = game.getBuggy();
    NumberFormat defaultFormat = NumberFormat.getPercentInstance();
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    double currentO2;
    
    public FacilitySceneView() {
        super("\n"
            + "\nWhat would you like to do at the facility"
            +"\n"
            + "\nU - Unload the buggy"
            + "\nC - Check O2 level"
            + "\nF - Fill O2 tanks"
            + "\nQ - Quit to move to location menu"
            + "\n---------------------------------------");
    }

        @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered
        
        switch (choice) {
            case 'U': 
                this.unloadBuggy();
                break;
            case 'C': 
                this.checkO2Level();
                break;
            case 'F': 
                this.fillO2();
                break;
            case 'Q': 
                return true;
            default:
                ErrorView.display(this.getClass().getName(),
                        ANSI_RED + "\n*** Invalid selection *** Try Again" + ANSI_RESET);
                break;
        }
        return false;

    }

    void displayFacilitySCene() {

        String facilityScene = scenes[SceneType.facility.ordinal()].getDescription();
        this.console.println(facilityScene);
        this.display();
        }

    private void unloadBuggy() {
        buggy.setLoadedWeight(0);
    }

    public void checkO2Level() {
        currentO2 = player.getCurrentOxygenLevel();
        this.console.println(ANSI_GREEN + "\nYour current O2 level is " + defaultFormat.format(currentO2) + ANSI_RESET);
    }

    private void fillO2() {
        int amountOfO2Tanks = tool[ToolType.O2tank.ordinal()].getQuantityInStock();
        player.setCurrentOxygenLevel(amountOfO2Tanks);
    }
    
}
