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
    
    private int noOfItems;
    private int elevatorCapacity = 12;
    private int elevatorCapacityUsed;

    public Elevator() {
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }

    public int getElevatorCapacity() {
        return elevatorCapacity;
    }

    public void setElevatorCapacity(int elevatorCapacity) {
        this.elevatorCapacity = elevatorCapacity;
    }

    public int getElevatorCapacityUsed() {
        return elevatorCapacityUsed;
    }

    public void setElevatorCapacityUsed(int elevatorCapacityUsed) {
        this.elevatorCapacityUsed = elevatorCapacityUsed;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.noOfItems;
        hash = 47 * hash + this.elevatorCapacity;
        hash = 47 * hash + this.elevatorCapacityUsed;
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
        if (this.noOfItems != other.noOfItems) {
            return false;
        }
        if (this.elevatorCapacity != other.elevatorCapacity) {
            return false;
        }
        if (this.elevatorCapacityUsed != other.elevatorCapacityUsed) {
            return false;
        }
        return true;
    }

    
    
}
