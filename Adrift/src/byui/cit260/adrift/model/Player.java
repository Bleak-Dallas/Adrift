/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.model;

import java.io.Serializable;
import java.util.Objects;



/**
 *
 * @author Joel
 */
public class Player implements Serializable{

    //class instance variables
    private String playerName;

    public Player() {
    }

    public Player(String playerName) {
        this.playerName = playerName;
    }
    

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.playerName);
        return hash;
    }

    @Override
    public String toString() {
        return "Player{" + "playerName=" + playerName + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (!Objects.equals(this.playerName, other.playerName)) {
            return false;
        }
        return true;
    }
    
    

}
