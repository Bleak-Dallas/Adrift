/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import java.util.Scanner;

/**
 *
 * @author Joel
 */
class ConstructToolsView {

    private final String TOOLSMENU = "\n"
            + "\n----------------------------------------"
            + "\n | Tools Menu                           |"
            + "\n ---------------------------------------"
            + "\nD - Mining Drill"
            + "\nS - Shovel"
            + "\nH - Hammer"
            + "\nT - O2 Tank"
            + "\nQ - Exit to Game Menu"
            + "\n---------------------------------------";
    
    void displayconstructToolsMenu() {
        char selection = ' ';
        do {
            
            System.out.println(TOOLSMENU); //To change body of generated methods, choose Tools | Templates.
    
            String input = this.getInput();
            selection = input.charAt(0);
        
            this.doAction(selection);
        
        } while (selection != 'Q');
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
            case 'D': //make mining drill
                this.makeDrill();
                break;
                
            case 'S': //make shovel
                this.makeShovel();
                break;
                
            case 'H': //make hammer
                this.makeHammer();
                break;
                
            case 'T': //make O2 tank
                this.makeO2Tank();
                break;
                
            case 'Q': //Exit the game menu
                GameMenuView gameMenu = new GameMenuView (); //display the game menu
                gameMenu.display();
                
            default:
                System.out.println("\n*** Invalid selection *** Try Again");
                break;
        } 
    }

    private void makeDrill() {
        System.out.println("\n*** makeDrill function called ***");
    }

    private void makeShovel() {
        System.out.println("\n*** makeShovel function called ***");
    }

    private void makeHammer() {
        System.out.println("\n*** makeHammer function called ***");
    }

    private void makeO2Tank() {
        System.out.println("\n*** makeO2Tank function called ***");
    }
        
}
