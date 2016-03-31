/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.Adrift;
import byu.cit260.adrift.enums.ToolType;
import byui.cit260.adrift.exceptions.GameControlException;
import byui.cit260.adrift.exceptions.ToolControlException;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Player;
import byui.cit260.adrift.model.Tools;

/**
 *
 * @author Dallas
 */
public class ToolsControl {
    Game game = Adrift.getCurrentGame();
    Map map = game.getMap();
    Player player = game.getPlayer();
    Location[][] locations = map.getLocations();
    Tools[] tool = game.getToolInventory();
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    static Tools[] createToolList() {
        // create array(list) of inventory items
        Tools[] toolInventory = new Tools[ToolType.values().length];
        Tools shovel = new Tools();
        shovel.setDescription("Shovel  ");
        shovel.setQuantityInStock(0);
        shovel.setRequiredAmount(2);
        shovel.setRequiredResource("Iron    ");
        toolInventory[ToolType.shovel.ordinal()] = shovel;

        Tools drill = new Tools();
        drill.setDescription("Drill    ");
        drill.setQuantityInStock(0);
        drill.setRequiredAmount(3);
        drill.setRequiredResource("Iron    ");
        toolInventory[ToolType.drill.ordinal()] = drill;
        
        Tools hammer = new Tools();
        hammer.setDescription("Hammer  ");
        hammer.setQuantityInStock(0);
        hammer.setRequiredAmount(1);
        hammer.setRequiredResource("Iron    ");
        toolInventory[ToolType.hammer.ordinal()] = hammer;
        
        Tools O2tank = new Tools();
        O2tank.setDescription("O2Tank  ");
        O2tank.setQuantityInStock(20);
        O2tank.setRequiredAmount(3);
        O2tank.setRequiredResource("Aluminum");
        toolInventory[ToolType.O2tank.ordinal()] = O2tank;
        
        return toolInventory;
    }
    
     public static Tools[] getSortedToolList() {
        Tools[] originalToolList = Adrift.getCurrentGame().getToolInventory();
        
        Tools[] toolList = originalToolList.clone();
        
        Tools tempTools;
        int i;
        for ( i =0; i < toolList.length-1; i++) {
            for (int j = 0; j < toolList.length-1-i; j++){
                if (toolList[j].getRequiredAmount() < toolList[j + 1].getRequiredAmount()){
                    tempTools  = toolList[j];
                    toolList[j] = toolList[j+1];
                    toolList[j+1] = tempTools;
                }
            }
        }
        return toolList;
    }
     
    public double calcO2(Location currentLocation, int row, int column) throws GameControlException{
        int currentLoc = currentLocation.getScene().getDistanceTraveled();
        int destination = locations[row][column].getScene().getDistanceTraveled();
        double cuurentO2 = player.getCurrentOxygenLevel();
        double remainingO2;
        double numberOfSpacesTraveled = 0;

        if (currentLoc  < destination) {
            numberOfSpacesTraveled = destination - currentLoc; 
        }

        if (currentLoc > destination){
            numberOfSpacesTraveled = currentLoc - destination;
        }

        remainingO2 =  cuurentO2 - (numberOfSpacesTraveled * .25);
        if(remainingO2 <= 0) {
            throw new GameControlException(ANSI_RED + "\nYOU DIED!!!  YOU RAN OUT OF O2" + ANSI_RESET);
        }
        player.setCurrentOxygenLevel(remainingO2);

        return remainingO2;
        }
     
}
