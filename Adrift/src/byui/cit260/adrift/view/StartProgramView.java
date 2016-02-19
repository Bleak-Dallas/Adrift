/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import byui.cit260.adrift.control.ProgramControl;
import byui.cit260.adrift.model.Player;
import java.util.Scanner;

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
        String playerName = this.getPlayerName();
//      Create a new player
        Player player = ProgramControl.createPlayer(playerName);
//      DISPLAY a customized welcome message
        this.displayWelcomeMessage(player);
//      DISPLAY the main menu 
//        MainMenuView mainMenu = new MainMenuView ();
//        mainMenu.displayMenu ();
        }

    public void displayBanner() {
        System.out.println("\n\n*********************************************");
        
        System.out.println("\n               _      _  __ _   \n" +
                             "     /\\      | |    (_)/ _| |  \n" +
                             "    /  \\   __| |_ __ _| |_| |_ \n" +
                             "   / /\\ \\ / _` | '__| |  _| __|\n" +
                             "  / ____ \\ (_| | |  | | | | |_ \n" +
                             " /_/    \\_\\__,_|_|  |_|_|  \\__|\n" +
                             "                               \n");
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

    private String getPlayerName() {
        boolean valid = false;
        String playerName = null;
        Scanner keyboard = new Scanner(System.in);
        
        while (!valid){
            System.out.println("Enters player's name below");
            
            playerName = keyboard.nextLine();
            playerName= playerName.trim();
            
            if (playerName.length() < 2) {
                System.out.println("Invalid name - the name must not be blank");
                continue;
            }
            break;
        }
        
        return playerName;
    }

    private void displayWelcomeMessage(Player player) {
        System.out.println("\n\n=============================================");
        System.out.println("\tWelcome to Adrift " + player.getPlayerName());
        System.out.println("\tWe hope you have a BLAST!!");
        System.out.println("================================================");
    }
}

