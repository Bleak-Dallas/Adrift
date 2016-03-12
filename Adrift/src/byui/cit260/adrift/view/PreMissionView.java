/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;


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
            + "\n  You may choose a maximum of 3 of any"
            + "\n  item with a total of 12 items"
            + "\n ======================================="
            + "\nE - Emergency Rations"
            + "\nW - Water"
            + "\nT - O2 Tanks"
            + "\nM - Special Mining Equipment"
            + "\nF - Fuel"
            + "\nR - Replacement Parts/Repair Materials for Ship"
            + "\nQ - Done with selections"
            + "\n---------------------------------------");
    }

 
    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered
        
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

    private void chooseAmount() {
        System.out.println("\n*** chooseAmount function called ***");
    }
    
}
    
