/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adrift;

import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Player;

/**
 *
 * @author Joel
 */
public class Adrift {

    /**
     * @param args the command line arguments i
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        Game newGame = new Game();
                
        playerOne.setName("Darth Vader");
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
        
        newGame.setNoOfActors(3);
        newGame.setTotalDistanceTraveled(3000);
        
        String actorInfo = newGame.toString();
        String distanceInfo = newGame.toString();
        System.out.println(newGame);      
         
        
        
    }
    
    
    
}
