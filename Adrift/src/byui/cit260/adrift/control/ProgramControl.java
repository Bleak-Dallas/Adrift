/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.Adrift;
import byui.cit260.adrift.model.Player;

/**
 *
 * @author Dallas
 */
public class ProgramControl {

    public static Player createPlayer(String playerName) {
        
        if (playerName == null) {
            return null;
        }
        
        Player player = new Player();
        player.setPlayerName(playerName);

       
        Adrift.setPlayer(player);
        
        return player;
        
    }

    
}
