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
public class StartProgramView {
    

    public StartProgramView() {
        
    }

    public void startProgram() {
        
//      Display the banner screen
        this.displayBanner();
//      Get the players name
//      Create a new player
//      DISPLAY a customized welcome message
//      DISPLAY the main menu 

        }

    public void displayBanner() {
        System.out.println("\n\n*********************************************");
        
         System.out.println("*                                      *"
                        + "\n* You are playing Adrift               *"
                        + "\n* In this game you will guide a crew   *"
                        + "\n* of American astronauts to recover a  *"
                        + "\n* secret military payload from deep    *"
                        + "\n* within the asteroid belt.            *");
        
        System.out.println("*                                      *"
                        + "\n* You'll have to plan every move       *"
                        + "\n* carefully so you don't run out of    *"
                        + "\n* vital resources which will keep you  *"
                        + "\n* alive throughout your mission.       *");
        
        System.out.println("***********************************************");
    }
}