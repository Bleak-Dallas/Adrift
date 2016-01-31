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
public class PreMissionSceneType implements Serializable{
    private String description;
    private char symbol;
    private double noOfItems;
    private String resourceType;
    private double elevatorCapacity;
    private double elevatorCapacityUsed;

    public PreMissionSceneType() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public double getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(double noOfItems) {
        this.noOfItems = noOfItems;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public double getElevatorCapacity() {
        return elevatorCapacity;
    }

    public void setElevatorCapacity(double elevatorCapacity) {
        this.elevatorCapacity = elevatorCapacity;
    }

    public double getElevatorCapacityUsed() {
        return elevatorCapacityUsed;
    }

    public void setElevatorCapacityUsed(double elevatorCapacityUsed) {
        this.elevatorCapacityUsed = elevatorCapacityUsed;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + this.symbol;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.noOfItems) ^ (Double.doubleToLongBits(this.noOfItems) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.resourceType);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.elevatorCapacity) ^ (Double.doubleToLongBits(this.elevatorCapacity) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.elevatorCapacityUsed) ^ (Double.doubleToLongBits(this.elevatorCapacityUsed) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "PreMissionSceneType{" + "description=" + description + ", symbol=" + symbol + ", noOfItems=" + noOfItems + ", resourceType=" + resourceType + ", elevatorCapacity=" + elevatorCapacity + ", elevatorCapacityUsed=" + elevatorCapacityUsed + '}';
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
        final PreMissionSceneType other = (PreMissionSceneType) obj;
        if (this.symbol != other.symbol) {
            return false;
        }
        if (Double.doubleToLongBits(this.noOfItems) != Double.doubleToLongBits(other.noOfItems)) {
            return false;
        }
        if (Double.doubleToLongBits(this.elevatorCapacity) != Double.doubleToLongBits(other.elevatorCapacity)) {
            return false;
        }
        if (Double.doubleToLongBits(this.elevatorCapacityUsed) != Double.doubleToLongBits(other.elevatorCapacityUsed)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.resourceType, other.resourceType)) {
            return false;
        }
        return true;
    }

    

    
    
    
    
    
}