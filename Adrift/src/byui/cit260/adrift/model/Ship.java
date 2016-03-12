/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.model;

import java.io.Serializable;


/**
 *
 * @author Joel
 */
public class Ship implements Serializable{
    
String [] shipStatus;   
private double repairLevel;
private double fuelLevel;

    public Ship() {
        
        this.repairLevel = 0;
        this.fuelLevel = 0;
    }

    public double getRepairLevel() {
        return repairLevel;
    }

    public void setRepairLevel(double repairLevel) {
        this.repairLevel = repairLevel;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.repairLevel) ^ (Double.doubleToLongBits(this.repairLevel) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.fuelLevel) ^ (Double.doubleToLongBits(this.fuelLevel) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Ship{" + "repairLevel=" + repairLevel + ", fuelLevel=" + fuelLevel + '}';
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
        if (Double.doubleToLongBits(this.repairLevel) != Double.doubleToLongBits(other.repairLevel)) {
            return false;
        }
        if (Double.doubleToLongBits(this.fuelLevel) != Double.doubleToLongBits(other.fuelLevel)) {
            return false;
        }
        return true;
    }

    

}
