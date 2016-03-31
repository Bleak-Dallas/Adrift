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
    private double maxWeight;
    private double loadedWeight;

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

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getLoadedWeight() {
        return loadedWeight;
    }

    public void setLoadedWeight(double loadedWeight) {
        this.loadedWeight = loadedWeight;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.fuelCapacity) ^ (Double.doubleToLongBits(this.fuelCapacity) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.fuelLevel) ^ (Double.doubleToLongBits(this.fuelLevel) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.maxWeight) ^ (Double.doubleToLongBits(this.maxWeight) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.loadedWeight) ^ (Double.doubleToLongBits(this.loadedWeight) >>> 32));
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
        if (Double.doubleToLongBits(this.maxWeight) != Double.doubleToLongBits(other.maxWeight)) {
            return false;
        }
        if (Double.doubleToLongBits(this.loadedWeight) != Double.doubleToLongBits(other.loadedWeight)) {
            return false;
        }
        return true;
    }

}
