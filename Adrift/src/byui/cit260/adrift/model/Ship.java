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
 * @author Joel
 */
public class Ship implements Serializable{
    private double fuelCapacity;
    private double fuelLevel;
    private double damageLevel;

    public Ship() {
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

    public double getDamageLevel() {
        return damageLevel;
    }

    public void setDamageLevel(double damageLevel) {
        this.damageLevel = damageLevel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.fuelCapacity) ^ (Double.doubleToLongBits(this.fuelCapacity) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.fuelLevel) ^ (Double.doubleToLongBits(this.fuelLevel) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.damageLevel) ^ (Double.doubleToLongBits(this.damageLevel) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Ship{" + "fuelCapacity=" + fuelCapacity + ", fuelLevel=" + fuelLevel + ", damageLevel=" + damageLevel + '}';
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
        final Ship other = (Ship) obj;
        if (Double.doubleToLongBits(this.fuelCapacity) != Double.doubleToLongBits(other.fuelCapacity)) {
            return false;
        }
        if (Double.doubleToLongBits(this.fuelLevel) != Double.doubleToLongBits(other.fuelLevel)) {
            return false;
        }
        if (Double.doubleToLongBits(this.damageLevel) != Double.doubleToLongBits(other.damageLevel)) {
            return false;
        }
        return true;
    }
}
