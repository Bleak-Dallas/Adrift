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
    
    private double fuelCapacity;
    private double fuelLevel;
    private int maxWeight;
    private int loadedWeight;

    public Buggy() {
        this.fuelCapacity = 4;
        this.fuelLevel = 1;
        this.maxWeight = 60;
        this.loadedWeight = 0;
    }
    

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
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
        int hash = 5;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.fuelCapacity) ^ (Double.doubleToLongBits(this.fuelCapacity) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.fuelLevel) ^ (Double.doubleToLongBits(this.fuelLevel) >>> 32));
        hash = 41 * hash + this.maxWeight;
        hash = 41 * hash + this.loadedWeight;
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
        if (Double.doubleToLongBits(this.fuelCapacity) != Double.doubleToLongBits(other.fuelCapacity)) {
            return false;
        }
        if (Double.doubleToLongBits(this.fuelLevel) != Double.doubleToLongBits(other.fuelLevel)) {
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
