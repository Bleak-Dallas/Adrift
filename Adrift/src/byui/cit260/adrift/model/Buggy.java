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
public class Buggy implements Serializable{
    
    private int fuelCapacity;
    private int fuelLevel;
    private int maxWeight;
    private int loadedWeight;

    public Buggy() {
        this.fuelCapacity = 1;
        this.fuelLevel = 0;
        this.maxWeight = 6000;
        this.loadedWeight = 0;
    }
    

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getLoadedWeight() {
        return loadedWeight;
    }

    public void setLoadedWeight(int loadedWeight) {
        this.loadedWeight = loadedWeight;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.fuelCapacity;
        hash = 19 * hash + this.fuelLevel;
        hash = 19 * hash + this.maxWeight;
        hash = 19 * hash + this.loadedWeight;
        return hash;
    }

    @Override
    public String toString() {
        return "Buggy{" + "fuelCapacity=" + fuelCapacity + ", fuelLevel=" + fuelLevel + ", maxWeight=" + maxWeight + ", loadedWeight=" + loadedWeight + '}';
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
        final Buggy other = (Buggy) obj;
        if (this.fuelCapacity != other.fuelCapacity) {
            return false;
        }
        if (this.fuelLevel != other.fuelLevel) {
            return false;
        }
        if (this.maxWeight != other.maxWeight) {
            return false;
        }
        if (this.loadedWeight != other.loadedWeight) {
            return false;
        }
        return true;
    }
    
    
    
}
