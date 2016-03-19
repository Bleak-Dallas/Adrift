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
class LoadGameView extends View{
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    
    public LoadGameView(){
        super("\n"
            + "\n----------------------------------------"
            + "\n | Load Game Menu                           |"
            + "\n ---------------------------------------"
            + "\nL - Load game"
            + "\nQ - Quit to main menu"
            + "\n---------------------------------------");
    }
  
    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered 
    
        switch (choice) {
            case 'L': //create and start new game
                this.loadGame();
                break;
            case 'Q': //Quit the game
                return true;
            default:
                System.out.println(ANSI_RED + "\n*** Invalid selection *** Try Again" + ANSI_RESET);
                break;
        }     
        return false;
    }

    private void loadGame() {
        System.out.println("\n*** loadGame function called ***");
    }

}
