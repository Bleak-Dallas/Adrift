/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byu.cit260.adrift.enums.Item;
import byui.cit260.adrift.control.MapControl;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;


/**
 *
 * @author Dallas
 */
public class PreMissionView extends View{
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
            + "\nD - Drill"
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
            case 'D': //Save game
                this.chooseDrill();
                break;
            case 'F': //Save game
                this.chooseFuel();
                break;
            case 'Q': 
                //display game menu
                GameMenuView gameMenu = new GameMenuView (); //display the game menu
                gameMenu.display();
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try Again");
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

    private void chooseDrill() {
        ChooseDrillView chooseDrill = new ChooseDrillView();
        chooseDrill.display();
    }

    private void chooseFuel() {
        ChooseFuelView chooseFuel = new ChooseFuelView();
        chooseFuel.display();
    }

//    private void chooseAmount() {
//        Map map = MapControl.createMap();
//        Location[][] locations = map.getLocations();
//        System.out.println("\n***" + locations[0][2].getScene().getResourceDescription());
}
    

