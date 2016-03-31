/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byu.cit260.adrift.enums.ToolType;
import byui.cit260.adrift.model.Buggy;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Player;
import byui.cit260.adrift.model.Tools;


/**
 *
 * @author Dallas
 */
public class PreMissionView extends View{
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public PreMissionView() {
    super("\n"
            + "\n ---------------------------------------"
            + "\n | Pre-Mission Selection Menu          |"
            + "\n ---------------------------------------"
            + "\n"
            + "\n ======================================="
            + "\n  You may choose a maximum of 4 of any"
            + "\n  item with a total of 12 items"
            + "\n ======================================="
            + "\nR - Food Rations"
            + "\nT - O2 Tanks"
            + "\nF - Fuel"
            + "\nQ - Done with selections"
            + "\n---------------------------------------");
    }

 
    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered
        
        switch (choice) {
            case 'R': //create and start new game
                this.chooseFood();
                break;
                
            case 'T': // display Help Menu
                this.chooseO2Tanks();
                break;

            case 'F': //Save game
                this.chooseFuel();
                break;
                
            case 'Q': 
                //display game menu
                this.createPlayerItems();
                SceneView sceneView = new SceneView();
                sceneView.displayStartingScene();
                GameMenuView gameMenu = new GameMenuView (); //display the game menu
                gameMenu.display();
                return true;
            default:
                ErrorView.display(this.getClass().getName(),
                        ANSI_RED + "\n*** Invalid selection *** Try Again" + ANSI_RESET);
                break;
        }
        return false;

    }

    private void chooseFood() {
        ChooseFoodView foodView = new ChooseFoodView();
        foodView.display();
    }

    private void chooseO2Tanks() {
        ChooseO2TanksView O2TanksView = new ChooseO2TanksView();
        O2TanksView.display();
    }


    private void chooseFuel() {
        ChooseFuelView chooseFuel = new ChooseFuelView();
        chooseFuel.display();
    }

    private void createPlayerItems() {
        Game game = Adrift.getCurrentGame();
        Player player = game.getPlayer();
        Buggy buggy = game.getBuggy();
        Tools[] toolList = game.getToolInventory();
        
        player.setCurrentCalorieLevel(2);
        player.setCurrentOxygenLevel(toolList[ToolType.O2tank.ordinal()].getQuantityInStock());
        buggy.setFuelLevel(1);
    }
}
    

