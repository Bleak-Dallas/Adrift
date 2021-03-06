/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Dallas
 */
public class Scene implements Serializable{
    
    private int distanceTraveled;
    private String symbol;
    private boolean blocked;
    private String description;
    private Scene[] scenes;
    private String resourceDescription;
    private double resourceAmount;

    public Scene() {
    }
    
    
    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Scene[] getScenes() {
        return scenes;
    }

    public void setScenes(Scene[] scenes) {
        this.scenes = scenes;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    public double getResourceAmount() {
        return resourceAmount;
    }

    public void setResourceAmount(double resourceAmount) {
        this.resourceAmount = resourceAmount;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.distanceTraveled;
        hash = 59 * hash + Objects.hashCode(this.symbol);
        hash = 59 * hash + (this.blocked ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + Arrays.deepHashCode(this.scenes);
        hash = 59 * hash + Objects.hashCode(this.resourceDescription);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.resourceAmount) ^ (Double.doubleToLongBits(this.resourceAmount) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Scene{" + "distanceTraveled=" + distanceTraveled + ", symbol=" + symbol + ", blocked=" + blocked + ", description=" + description + ", scenes=" + Arrays.toString(scenes) + ", resourceDescription=" + resourceDescription + ", resourceAmount=" + resourceAmount + '}';
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
        final Scene other = (Scene) obj;
        if (this.distanceTraveled != other.distanceTraveled) {
            return false;
        }
        if (this.blocked != other.blocked) {
            return false;
        }
        if (Double.doubleToLongBits(this.resourceAmount) != Double.doubleToLongBits(other.resourceAmount)) {
            return false;
        }
        if (!Objects.equals(this.symbol, other.symbol)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.resourceDescription, other.resourceDescription)) {
            return false;
        }
        if (!Arrays.deepEquals(this.scenes, other.scenes)) {
            return false;
        }
        return true;
    }

} 
