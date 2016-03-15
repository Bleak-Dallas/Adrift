/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;



/**
 *
 * @author Joel
 */
public class Player implements Serializable{

    //class instance variables
    private String playerName;
    private int calorieLevel;
    private int oxygenLevel;
    private Point currentLocation;

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

    public int getCalorieLevel() {
        return calorieLevel;
    }

    public void setCalorieLevel(int calorieLevel) {
        this.calorieLevel = calorieLevel;
    }

    public int getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(int oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.playerName);
        hash = 53 * hash + this.calorieLevel;
        hash = 53 * hash + this.oxygenLevel;
        hash = 53 * hash + Objects.hashCode(this.currentLocation);
        return hash;
    }

    @Override
    public String toString() {
        return "Player{" + "playerName=" + playerName + ", calorieLevel=" + calorieLevel + ", oxygenLevel=" + oxygenLevel + ", currentLocation=" + currentLocation + '}';
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
        if (this.calorieLevel != other.calorieLevel) {
            return false;
        }
        if (this.oxygenLevel != other.oxygenLevel) {
            return false;
        }
        if (!Objects.equals(this.playerName, other.playerName)) {
            return false;
        }
        if (!Objects.equals(this.currentLocation, other.currentLocation)) {
            return false;
        }
        return true;
    }
    
    

}
