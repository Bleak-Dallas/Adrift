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
public class FacilitySceneType implements Serializable{
    
        private String facilityDescription;
        private int distanceTraveled;
        private int locationBlocked;
        private String facilitySymbol;
        private int noOfItems;

    public FacilitySceneType() {
    }
        
        

    public String getFacilityDescription() {
        return facilityDescription;
    }

    public void setFacilityDescription(String facilityDescription) {
        this.facilityDescription = facilityDescription;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public int getLocationBlocked() {
        return locationBlocked;
    }

    public void setLocationBlocked(int locationBlocked) {
        this.locationBlocked = locationBlocked;
    }

    public String getFacilitySymbol() {
        return facilitySymbol;
    }

    public void setFacilitySymbol(String facilitySymbol) {
        this.facilitySymbol = facilitySymbol;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.facilityDescription);
        hash = 89 * hash + this.distanceTraveled;
        hash = 89 * hash + this.locationBlocked;
        hash = 89 * hash + Objects.hashCode(this.facilitySymbol);
        hash = 89 * hash + this.noOfItems;
        return hash;
    }

    @Override
    public String toString() {
        return "FacilitySceneType{" + "facilityDescription=" + facilityDescription + ", distanceTraveled=" + distanceTraveled + ", locationBlocked=" + locationBlocked + ", facilitySymbol=" + facilitySymbol + ", noOfItems=" + noOfItems + '}';
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
        final FacilitySceneType other = (FacilitySceneType) obj;
        if (this.distanceTraveled != other.distanceTraveled) {
            return false;
        }
        if (this.locationBlocked != other.locationBlocked) {
            return false;
        }
        if (this.noOfItems != other.noOfItems) {
            return false;
        }
        if (!Objects.equals(this.facilityDescription, other.facilityDescription)) {
            return false;
        }
        if (!Objects.equals(this.facilitySymbol, other.facilitySymbol)) {
            return false;
        }
        return true;
    }
        
        
   
}
