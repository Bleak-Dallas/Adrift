/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

/**
 *
 * @author Joel
 */
class CalculateO2View extends View {
    
    public CalculateO2View() {
        super("\n"
            + "\n----------------------------------------"
            + "\n | Calculate O2                          |"
            + "\n ---------------------------------------"
            + "\nTo calculate the O2 that will be needed"
            + "\nto travel from your current location to "
            + "\nyour destination please input your current"
            + "\nlocation and desired destination "
            +"\n"
            + "\nC - Current location"
            + "\nD - Destination"
            + "\nQ - Quit to main menu"
            + "\n---------------------------------------");
    }
         @Override
    public boolean doAction(String value) {
       value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered 
    
        switch (choice) {
            case 'C': //create and start new game
                this.currentLocation();
                break;
            case 'D': //Load existing game
                this.destination();
                break;
            case 'Q': //Quit the game
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try Again");
                break;
        }     
        return false;
    }

    private void currentLocation() {
        System.out.println("\n*** currentLocation function called ***");
    }

    private void destination() {
        System.out.println("\n*** destination function called ***");
    }
    
}

