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
    
        private int rowLocation;
        private String columnLocation;
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

    public String getColumnLocation() {
        return columnLocation;
    }

    public void setColumnLocation(String columnLocation) {
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
        int hash = 3;
        hash = 41 * hash + this.rowLocation;
        hash = 41 * hash + Objects.hashCode(this.columnLocation);
        hash = 41 * hash + this.locationVisited;
        hash = 41 * hash + this.amountRemaining;
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
        if (this.columnLocation == null ? other.columnLocation != null : !this.columnLocation.equals(other.columnLocation)) {
            return false;
        }
        if (this.locationVisited != other.locationVisited) {
            return false;
        }
        if (this.amountRemaining != other.amountRemaining) {
            return false;
        }
        if (!Objects.equals(this.columnLocation, other.columnLocation)) {
            return false;
        }
        return true;
    }
        
        
}