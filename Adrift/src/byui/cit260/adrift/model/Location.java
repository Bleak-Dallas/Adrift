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
public class Location implements Serializable {
    
        private int location;
        private int locationVisited;
        private int amountRemaining;

    public Location() {
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getLocationVisited() {
        return locationVisited;
    }

    public void setLocationVisited(int locationVisited) {
        this.locationVisited = locationVisited;
    }

    public int getAmountRemaining() {
        return amountRemaining;
    }

    public void setAmountRemaining(int amountRemaining) {
        this.amountRemaining = amountRemaining;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.location;
        hash = 59 * hash + this.locationVisited;
        hash = 59 * hash + this.amountRemaining;
        return hash;
    }

    @Override
    public String toString() {
        return "Location{" + "location=" + location + ", locationVisited=" + locationVisited + ", amountRemaining=" + amountRemaining + '}';
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
        final Location other = (Location) obj;
        if (this.location != other.location) {
            return false;
        }
        if (this.locationVisited != other.locationVisited) {
            return false;
        }
        if (this.amountRemaining != other.amountRemaining) {
            return false;
        }
        return true;
    }
    
    
}