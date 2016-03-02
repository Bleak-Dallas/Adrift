/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byui.cit260.adrift.control.GameControl;

/**
 *
 * @author Autumn
 */
public class MainMenuView extends View {
    
    public MainMenuView(){
        super("\n"
            + "\n----------------------------------------"
            + "\n | Main Menu                           |"
            + "\n ---------------------------------------"
            + "\nN - Start new game"
            + "\nL - Load saved game"
            + "\nH - Get help on how to play the game"
            + "\nS - Save Game"
            + "\nQ - Quit Game"
            + "\n---------------------------------------");
    }
  
    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered 
    
        switch (choice) {
            case 'N': //create and start new game
                this.startNewGame();
                break;
            case 'L': //Load existing game
                this.startExistingGame();
                break;
            case 'H': // display Help Menu
                this.displayHelpMenu();
                break;
            case 'S': //Save game
                this.saveGame();
                break;
            case 'Q': //Quit the game
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try Again");
                break;
        }     
        return false;
    }

    private void startNewGame() { 
         GameControl.createNewGame (Adrift.getPlayer()); //create new gamew
         PreMissionView preMissionMenu = new PreMissionView ();//display the premission menu
         preMissionMenu.display();
         
         GameMenuView gameMenu = new GameMenuView (); //display the game menu
         gameMenu.display();
    }

    private void startExistingGame() {
        System.out.println("\n*** startExistingGame function called ***");
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView (); //display the game menu
        helpMenu.display();
    }

    private void saveGame() {
        System.out.println("\n*** saveGame function called ***");
    }

}


