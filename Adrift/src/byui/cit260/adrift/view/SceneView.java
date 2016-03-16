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
import byui.cit260.adrift.model.Scene;

/**
 *
 * @author Dallas
 */

public class SceneView {
    
    Game game = Adrift.getCurrentGame();
    Map map = game.getMap();
    Location[][] locations = map.getLocations();
    Scene[] scenes = game.getScenes();
    
//    private final String MENU = locations[row][column].getScene().getDescription();
//            "\n"
//                            + "\n----------------------------------------"
//                            + "\n |       Move To New Location          |"
//                            + "\n ---------------------------------------"
//                            + "\nTo move from one location to the next"
//                            + "\nyou will need to enter the X and Y "
//                            + "\ncoordinates. On the view map screen you"
//                            + "\nwill see Sectors like this: 0,2. The"
//                            + "\nfirst number is the X coordinate and"
//                            + "\nthe second number is the Y coordinate."
//                            +"\n"
//                            + "\nX - Enter X coordinate"
//                            + "\nY - Enter Y coordinate"
//                            + "\nQ - Quit to game menu"
//                            + "\n---------------------------------------";

    void displaySceneView(int row, int column) {
        String MENU = locations[row][column].getScene().getDescription();
        System.out.println(MENU);
    }

//    public boolean doAction(String value) {
//        value = value.toUpperCase(); // convert to all upper case
//        char choice = value.charAt(0); // get first character entered
//        
//        switch (choice) {
//             case 'X': //create and start new game
//                 //this.moveToX();
//                 break;
//             case 'Y': //Load existing game
//                 //this.moveToY();
//                 break;
//             case 'Q': //Exit the game
//                 return true;
//             default:
//                 System.out.println("\n*** Invalid selection *** Try Again");
//                 break;
//         }  
//         return false;
//    }
    
}