/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.model;

import java.io.Serializable;


/**
 *
 * @author Dallas
 */
public class Elevator implements Serializable{
    
    private double noOfItems;
    private double elevatorCapacity = 10;
    private double elevatorCapacityUsed;

    public Elevator() {
    }

    public double getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(double noOfItems) {
        this.noOfItems = noOfItems;
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
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.noOfItems) ^ (Double.doubleToLongBits(this.noOfItems) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.elevatorCapacity) ^ (Double.doubleToLongBits(this.elevatorCapacity) >>> 32));
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.elevatorCapacityUsed) ^ (Double.doubleToLongBits(this.elevatorCapacityUsed) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Elevator{" + "noOfItems=" + noOfItems + ", elevatorCapacity=" + elevatorCapacity + ", elevatorCapacityUsed=" + elevatorCapacityUsed + '}';
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
        final Elevator other = (Elevator) obj;
        if (Double.doubleToLongBits(this.noOfItems) != Double.doubleToLongBits(other.noOfItems)) {
            return false;
        }
        if (Double.doubleToLongBits(this.elevatorCapacity) != Double.doubleToLongBits(other.elevatorCapacity)) {
            return false;
        }
        if (Double.doubleToLongBits(this.elevatorCapacityUsed) != Double.doubleToLongBits(other.elevatorCapacityUsed)) {
            return false;
        }
        return true;
    }

}
