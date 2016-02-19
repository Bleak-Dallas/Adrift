/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import java.util.Scanner;

/**
 *
 * @author Autumn
 */
public class MainMenuView {
    
    private final String MENU = "\n"
            + "\n----------------------------------------"
            + "\n | Main Menu                           |"
            + "\n ---------------------------------------"
            + "\nN - Start new game"
            + "\nL - Load saved game"
            + "\nH - Get help on how to play the game"
            + "\nS - Save Game"
            + "\nE - Exit Game"
            + "\n---------------------------------------";

    void displayMenu() {
          
        char selection = ' ';
        do {
            
            System.out.println(MENU); //To change body of generated methods, choose Tools | Templates.
    
            String input = this.getInput();
            selection = input.charAt(0);
        
            this.doAction(selection);
        
        } while (selection != 'E');
    }

    private String getInput() {
        boolean valid = false;
        String input = null;
        Scanner keyboard = new Scanner(System.in);
        
        while (!valid){
            System.out.println("Enter menu selection");
            
            input = keyboard.nextLine();
            input= input.trim();
            
            if (input.length() < 1) {
                System.out.println("Invalid selection - the menu item must not be blank");
                continue;
            }
            break;
        }
        
        return input;
    }

    private void doAction(char choice) {
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
            case 'E': //Exit the game
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try Again");
                break;
        }     
    }

    private void startNewGame() {
        System.out.println("\n*** startNewGame function called ***");
    }

    private void startExistingGame() {
        System.out.println("\n*** startExistingGame function called ***");
    }

    private void displayHelpMenu() {
        System.out.println("*** display Help Menu function called ***");
    }

    private void saveGame() {
        System.out.println("\n*** saveGame function called ***");
    }

}
//      private void startNewGame() // create a new game{
//        GameControl.createNewGame (Adrift.getPlayer());
//          
//          // display the game menu
//        GameMenuView gameMenu = new GameMenuView ();
//        gameMenu.displayMenu();
////}
// 
//        
//}
//      private void saveGame() {
//        System.out.println("*** startExistingGame function called ***");
//}
// 
//        
//} 

