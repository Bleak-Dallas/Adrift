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
    
    //Test methods for the team and individual code.
    public static void teamTest() {
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
    
    public static void joelTest() {
        
    }
    
    public static void johnTest() {
        
    }
    
    public static void dallasTest() {
        
    }

    /**
     * @param args the command line arguments i
     */
    public static void main(String[] args) {
  
        /* Uncomment only the method that you are testing.
         * Keep all other methods commented out.
         */
         teamTest();
         //joelTest();
         //johnTest();
         //dallasTest();
        
    }
    
    
    
}
