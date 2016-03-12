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
 * @author Dallas
 */
public class ResourceSceneType implements Serializable{
    
    String [] resource;
    private String resourceDescription;
    private int distanceTraveled;
    private boolean blocked;
    private char symbol;
    private int amountAvailable;
    private String resourceType;

    public ResourceSceneType() {
    }
    
    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.resourceDescription);
        hash = 41 * hash + this.distanceTraveled;
        hash = 41 * hash + (this.blocked ? 1 : 0);
        hash = 41 * hash + this.symbol;
        hash = 41 * hash + this.amountAvailable;
        hash = 41 * hash + Objects.hashCode(this.resourceType);
        return hash;
    }

    @Override
    public String toString() {
        return "ResourceSceneType{" + "resourceDescription=" + resourceDescription + ", distanceTraveled=" + distanceTraveled + ", blocked=" + blocked + ", symbol=" + symbol + ", amountAvailable=" + amountAvailable + ", resourceType=" + resourceType + '}';
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
        final ResourceSceneType other = (ResourceSceneType) obj;
        if (this.distanceTraveled != other.distanceTraveled) {
            return false;
        }
        if (this.blocked != other.blocked) {
            return false;
        }
        if (this.symbol != other.symbol) {
            return false;
        }
        if (this.amountAvailable != other.amountAvailable) {
            return false;
        }
        if (!Objects.equals(this.resourceDescription, other.resourceDescription)) {
            return false;
        }
        if (!Objects.equals(this.resourceType, other.resourceType)) {
            return false;
        }
        return true;
    } 
    
}
