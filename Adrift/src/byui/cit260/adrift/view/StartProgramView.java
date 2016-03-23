/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import static byui.cit260.adrift.control.InventoryControl.ANSI_RED;
import static byui.cit260.adrift.control.InventoryControl.ANSI_RESET;
import byui.cit260.adrift.control.ProgramControl;
import byui.cit260.adrift.model.Player;
import java.io.BufferedReader;
import java.io.PrintWriter;



/**
 *
 * @author Dallas
 */
public class StartProgramView {
    private BufferedReader keyboard = Adrift.getInFile();
    private PrintWriter console = Adrift.getOutFile();
    

    public StartProgramView() {
        
   
        
    }

    public void startProgram(){
//      Display the banner screen
        this.displayBanner();
//      Get the players name
        String playerName;
        playerName = this.getPlayerName();
//      Create a new player
        Player player = ProgramControl.createPlayer(playerName);
//      DISPLAY a customized welcome message
        this.displayWelcomeMessage(player);
//      DISPLAY the main menu 
        MainMenuView mainMenu = new MainMenuView ();
        mainMenu.display ();
        }

    public void displayBanner() {
        this.console.println("\n\n*********************************************");
        
        this.console.println("\n               _      _  __ _   \n" +
                             "     /\\      | |    (_)/ _| |  \n" +
                             "    /  \\   __| |_ __ _| |_| |_ \n" +
                             "   / /\\ \\ / _` | '__| |  _| __|\n" +
                             "  / ____ \\ (_| | |  | | | | |_ \n" +
                             " /_/    \\_\\__,_|_|  |_|_|  \\__|\n" +
                             "                               \n");
        this.console.println("*                                      *"
                        + "\n* You are playing Adrift               *"
                        + "\n* In this game you will guide a crew   *"
                        + "\n* of American astronauts to recover a  *"
                        + "\n* secret military payload from deep    *"
                        + "\n* within the asteroid belt.            *");
        
        this.console.println("*                                      *"
                        + "\n* You'll have to plan every move       *"
                        + "\n* carefully so you don't run out of    *"
                        + "\n* vital resources which will keep you  *"
                        + "\n* alive throughout your mission.       *");
        
        this.console.println("***********************************************");
    }

    private String getPlayerName(){
        boolean valid = false;
        String playerName = null;
        try {
        while (!valid){
            this.console.println("Enters player's name below");
            

            playerName = this.keyboard.readLine();

    
            playerName= playerName.trim();

            if (playerName.length() < 2) {
                ErrorView.display(this.getClass().getName(),
                        ANSI_RED + "Invalid name - the name must not be blank" + ANSI_RESET);
                continue;
            }
            break;
        }
        } catch (Exception e) {
           ErrorView.display(this.getClass().getName(),
                   "Error reading input: " + e.getMessage());
        }
        return playerName;
    }

    private void displayWelcomeMessage(Player player) {
        this.console.println("\n\n=============================================");
        this.console.println("\tWelcome to Adrift " + player.getPlayerName());
        this.console.println("\tWe hope you have a BLAST!!");
        this.console.println("================================================");
    }
}

