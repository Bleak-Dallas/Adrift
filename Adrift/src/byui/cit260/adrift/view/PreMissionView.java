/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import java.util.Scanner;

/**
 *
 * @author Dallas
 */
public class PreMissionView {
    
    private final String PREMISSIONMENU = "\n"
            + "\n ---------------------------------------"
            + "\n | Pre-Mission Selection Menu          |"
            + "\n ---------------------------------------"
            + "\n"
            + "\n ======================================="
            + "\n  You may choose a maximum of 3 of any"
            + "\n  item with a total of 12 items"
            + "\n ======================================="
            + "\nE - Emergency Rations"
            + "\nW - Water"
            + "\nT - O2 Tanks"
            + "\nM - Special Mining Equipment"
            + "\nF - Fuel"
            + "\nR - Replacement Parts/Repair Materials for Ship"
            + "\nD - Done"
            + "\n---------------------------------------";

    void displayPreMissionMenu() {
        
        char selection = ' ';
        do {
            
            System.out.println(PREMISSIONMENU); //To change body of generated methods, choose Tools | Templates.
    
            String input = this.getInput();
            selection = input.charAt(0);
        
            this.doAction(selection);
        
        } while (selection != 'D');
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
            case 'E': //create and start new game
                this.chooseAmount();
                break;
            case 'W': //Load existing game
                this.chooseAmount();
                break;
            case 'T': // display Help Menu
                this.chooseAmount();
                break;
            case 'M': //Save game
                this.chooseAmount();
                break;
            case 'F': //Save game
                this.chooseAmount();
                break;
            case 'R': //Save game
                this.chooseAmount();
                break;
            case 'D': //display main menu
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try Again");
                break;
        }
    }

    private void chooseAmount() {
        System.out.println("\n*** chooseAmount function called ***");
    }
    
}
    
