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
 * @author Joel
 */
public class Ship implements Serializable{

String [] shipItems;
private String description;
private double shipItemAmount;
private double requiredShipAmount;
private double repairLevel;
private double fuelLevel;

    public Ship() {
 
    }

    public String[] getShipItems() {
        return shipItems;
    }

    public void setShipItems(String[] shipItems) {
        this.shipItems = shipItems;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getShipItemAmount() {
        return shipItemAmount;
    }

    public void setShipItemAmount(double shipItemAmount) {
        this.shipItemAmount = shipItemAmount;
    }

    public double getRequiredShipAmount() {
        return requiredShipAmount;
    }

    public void setRequiredShipAmount(double requiredShipAmount) {
        this.requiredShipAmount = requiredShipAmount;
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
        int hash = 7;
        hash = 31 * hash + Arrays.deepHashCode(this.shipItems);
        hash = 31 * hash + Objects.hashCode(this.description);
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.shipItemAmount) ^ (Double.doubleToLongBits(this.shipItemAmount) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.requiredShipAmount) ^ (Double.doubleToLongBits(this.requiredShipAmount) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.repairLevel) ^ (Double.doubleToLongBits(this.repairLevel) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.fuelLevel) ^ (Double.doubleToLongBits(this.fuelLevel) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Ship{" + "shipItems=" + shipItems + ", description=" + description + ", shipItemAmount=" + shipItemAmount + ", requiredShipAmount=" + requiredShipAmount + ", repairLevel=" + repairLevel + ", fuelLevel=" + fuelLevel + '}';
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
        if (Double.doubleToLongBits(this.shipItemAmount) != Double.doubleToLongBits(other.shipItemAmount)) {
            return false;
        }
        if (Double.doubleToLongBits(this.requiredShipAmount) != Double.doubleToLongBits(other.requiredShipAmount)) {
            return false;
        }
        if (Double.doubleToLongBits(this.repairLevel) != Double.doubleToLongBits(other.repairLevel)) {
            return false;
        }
        if (Double.doubleToLongBits(this.fuelLevel) != Double.doubleToLongBits(other.fuelLevel)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Arrays.deepEquals(this.shipItems, other.shipItems)) {
            return false;
        }
        return true;
    }

}
