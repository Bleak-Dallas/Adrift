/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

/**
 *
 * @author Autumn
 */
public class MainMenuView {
    
    private final String MENU = "\n"
            + "\n----------------------------------------"
            + "\n | Main Menu                           |"
            + "\n ---------------------------------------"
            + "\nG - Start Game"
            + "\nH - Get help on how ot play the game"
            + "\nS - Save Game"
            + "\nE - Exit Game";
          
}
//      public  void displayMenu() {
//        
//        char selection = ' ';
//        do {
//            
//        System.out.println(Menu); //To change body of generated methods, choose Tools | Templates.
//    
//        String input = this.getInput();
//        selection = input.charAt(0);
//        
//        this.doAction(selection);
//        
//        } while (selection != 'E');
//        
//    public void doAction(char choice) {
//
//        switch (choice) {
//            case 'N': //create and start new game
//                this.startNewGame();
//                break;
//            case 'G': // What is the goal of the game? 
//                this.startExistingGame();
//                break;
//            case 'H': // display Help Menu
//                this.displayHelpMenu();
//                break;
//            case 'E': // Estimating the amount of resources needed
//                this.displayHelpMenu();
//                break;
//            case 'F': // Calculating Fuel
//                this.displayHelpMenu();
//                break;
//            case 'O': // Calculating O2
//                this.displayHelpMenu();
//                break;
//            case 'T': // Constructing Tools
//                this.displayHelpMenu();
//                break;
//            case 'H': // Harvesting Resources
//                this.displayHelpMenu();
//                break;
//            case 'D': // Delivering resources to facility
//                this.displayHelpMenu();
//                break;
//            case 'S': // Repairing the Ship
//                this.displayHelpMenu();
//                break;
//            case 'Q': // Quit
//                this.displayHelpMenu();
//                return;
//             default:
//                    System.out.println("\n*** Invalid selection *** Try Again");
//                    break;
//    }     
//}
//    
//
//    private String getInput() {
//        System.out.println("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private void doAction(char selection) {
//        System.out.println("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//      private void startNewGame() // create a new game{
//        GameControl.createNewGame (Adrift.getPlayer());
//          
//          // display the game menu
//        GameMenuView gameMenu = new GameMenuView ();
//        gameMenu.displayMenu();
////}
//      private void startExistingGame() {
//        System.out.println("\n*** startExistingGame function called ***");
//}
//      private void saveGame() {
//        System.out.println("*** startExistingGame function called ***");
//}
//      private void displayHelpMenu() {
//        System.out.println("*** display Help Menu function called ***");
//} 
//}
