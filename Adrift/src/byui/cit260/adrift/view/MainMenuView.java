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
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    
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
                System.out.println(ANSI_RED + "\n*** Invalid selection *** Try Again" + ANSI_RESET);
                break;
        }     
        return false;
    }

    private void startNewGame() { 
        //create new game
        GameControl.createNewGame (Adrift.getPlayer()); 
        
        //display the premission menu
        PreMissionView preMissionMenu = new PreMissionView ();
        preMissionMenu.display();
        
    }

    private void startExistingGame() {
        LoadGameView loadGame = new LoadGameView (); //display the game menu
        loadGame.display();
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView (); //display the game menu
        helpMenu.display();
    }

    private void saveGame() {
        SaveGameView saveGame = new SaveGameView (); //display the game menu
        saveGame.display();
    }

}


