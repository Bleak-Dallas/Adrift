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
 * @author Dallas
 */
class SaveGameView extends View {
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public SaveGameView(){
        super("\n"
            + "\n----------------------------------------"
            + "\n | Save Game Menu                      |"
            + "\n ---------------------------------------"
            + "\nS - Save game"
            + "\nQ - Quit to main menu"
            + "\n---------------------------------------");
    }
  
    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered 
    
        switch (choice) {
            case 'S': //create and start new game
                return this.saveGame();
            case 'Q': //Quit the game
                return true;
            default:
               ErrorView.display(this.getClass().getName(),
                       ANSI_RED + "\n*** Invalid selection *** Try Again" + ANSI_RESET);
                break;
        }     
        return false;
    }

    private boolean saveGame() {
        
        this.console.println("\nEnter the filepath where the game will be saved");
        
        String filePath = this.getInput();
        
        try {
            GameControl.saveGame(Adrift.getCurrentGame(), filePath);
            this.console.println("your game was succesfully saved as: " + filePath);
            return true;
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        return false;
    }
}
