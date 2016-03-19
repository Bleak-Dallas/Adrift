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
    private double currentCalorieLevel;
    private double maxCalorieLevel = 4;
    private double currentOxygenLevel;
    private double maxOxygenLevel;
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

    public double getCurrentCalorieLevel() {
        return currentCalorieLevel;
    }

    public void setCurrentCalorieLevel(double currentCalorieLevel) {
        this.currentCalorieLevel = currentCalorieLevel;
    }

    public double getMaxCalorieLevel() {
        return maxCalorieLevel;
    }

    public void setMaxCalorieLevel(int maxCalorieLevel) {
        this.maxCalorieLevel = maxCalorieLevel;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }

    public double getCurrentOxygenLevel() {
        return currentOxygenLevel;
    }

    public void setCurrentOxygenLevel(double currentOxygenLevel) {
        this.currentOxygenLevel = currentOxygenLevel;
    }

    public double getMaxOxygenLevel() {
        return maxOxygenLevel;
    }

    public void setMaxOxygenLevel(int maxOxygenLevel) {
        this.maxOxygenLevel = maxOxygenLevel;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.playerName);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.currentCalorieLevel) ^ (Double.doubleToLongBits(this.currentCalorieLevel) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.maxCalorieLevel) ^ (Double.doubleToLongBits(this.maxCalorieLevel) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.currentOxygenLevel) ^ (Double.doubleToLongBits(this.currentOxygenLevel) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.maxOxygenLevel) ^ (Double.doubleToLongBits(this.maxOxygenLevel) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.currentLocation);
        return hash;
    }

    @Override
    public String toString() {
        return "Player{" + "playerName=" + playerName + ", currentCalorieLevel=" + currentCalorieLevel + ", maxCalorieLevel=" + maxCalorieLevel + ", currentOxygenLevel=" + currentOxygenLevel + ", maxOxygenLevel=" + maxOxygenLevel + ", currentLocation=" + currentLocation + '}';
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
        if (this.currentCalorieLevel != other.currentCalorieLevel) {
            return false;
        }
        if (this.maxCalorieLevel != other.maxCalorieLevel) {
            return false;
        }
        if (this.currentOxygenLevel != other.currentOxygenLevel) {
            return false;
        }
        if (this.maxOxygenLevel != other.maxOxygenLevel) {
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
