/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.model;

import java.io.Serializable;

/**
 *
 * @author Autumn
 */
public class Location implements Serializable {
    
        private int rowLocation;
        private int columnLocation;
        private int locationVisited;
        private int amountRemaining;

    public Location() {
    }
        
        

    public int getRowLocation() {
        return rowLocation;
    }

    public void setRowLocation(int rowLocation) {
        this.rowLocation = rowLocation;
    }

    public int getColumnLocation() {
        return columnLocation;
    }

    public void setColumnLocation(int columnLocation) {
        this.columnLocation = columnLocation;
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
        hash = 97 * hash + this.rowLocation;
        hash = 97 * hash + this.columnLocation;
        hash = 97 * hash + this.locationVisited;
        hash = 97 * hash + this.amountRemaining;
        return hash;
    }

    @Override
    public String toString() {
        return "Location{" + "rowLocation=" + rowLocation + ", columnLocation=" + columnLocation + ", locationVisited=" + locationVisited + ", amountRemaining=" + amountRemaining + '}';
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
        if (this.rowLocation != other.rowLocation) {
            return false;
        }
        if (this.columnLocation != other.columnLocation) {
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
