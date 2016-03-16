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
private int shipItemAmount;
private int requiredShipAmount;
private double repairLevel;
private double fuelLevel;

    public Ship() {
        
        this.repairLevel = 0;
        this.fuelLevel = 0;
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

    public int getShipItemAmount() {
        return shipItemAmount;
    }

    public void setShipItemAmount(int shipItemAmount) {
        this.shipItemAmount = shipItemAmount;
    }

    public int getRequiredShipAmount() {
        return requiredShipAmount;
    }

    public void setRequiredShipAmount(int requiredShipAmount) {
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
        int hash = 3;
        hash = 53 * hash + Arrays.deepHashCode(this.shipItems);
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + this.shipItemAmount;
        hash = 53 * hash + this.requiredShipAmount;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.repairLevel) ^ (Double.doubleToLongBits(this.repairLevel) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.fuelLevel) ^ (Double.doubleToLongBits(this.fuelLevel) >>> 32));
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
        if (this.shipItemAmount != other.shipItemAmount) {
            return false;
        }
        if (this.requiredShipAmount != other.requiredShipAmount) {
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
