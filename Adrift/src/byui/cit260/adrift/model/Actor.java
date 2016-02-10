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
 * @author Autumn
 */
public class Actor implements Serializable{
    
        private String actorAllName;
        private double currentLocation;
        private int calorieLevel;
        private int oxygenLevel;

    public Actor() {
    }

    public String getActorAllName() {
        return actorAllName;
    }

    public void setActorAllName(String actorAllName) {
        this.actorAllName = actorAllName;
    }

    public double getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(double currentLocation) {
        this.currentLocation = currentLocation;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.actorAllName);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.currentLocation) ^ (Double.doubleToLongBits(this.currentLocation) >>> 32));
        hash = 89 * hash + this.calorieLevel;
        hash = 89 * hash + this.oxygenLevel;
        return hash;
    }

    @Override
    public String toString() {
        return "Actor{" + "actorAllName=" + actorAllName + ", currentLocation=" + currentLocation + ", calorieLevel=" + calorieLevel + ", oxygenLevel=" + oxygenLevel + '}';
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
        final Actor other = (Actor) obj;
        if (Double.doubleToLongBits(this.currentLocation) != Double.doubleToLongBits(other.currentLocation)) {
            return false;
        }
        if (this.calorieLevel != other.calorieLevel) {
            return false;
        }
        if (this.oxygenLevel != other.oxygenLevel) {
            return false;
        }
        if (!Objects.equals(this.actorAllName, other.actorAllName)) {
            return false;
        }
        return true;
    }

    
}