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
public class Elevator implements Serializable{
    private double capacity;
    private double capacityUsed;

    public Elevator() {
    }
    
    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacityUsed() {
        return capacityUsed;
    }

    public void setCapacityUsed(double capacityUsed) {
        this.capacityUsed = capacityUsed;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.capacity) ^ (Double.doubleToLongBits(this.capacity) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.capacityUsed) ^ (Double.doubleToLongBits(this.capacityUsed) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Elevator{" + "capacity=" + capacity + ", capacityUsed=" + capacityUsed + '}';
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
        if (Double.doubleToLongBits(this.capacity) != Double.doubleToLongBits(other.capacity)) {
            return false;
        }
        if (Double.doubleToLongBits(this.capacityUsed) != Double.doubleToLongBits(other.capacityUsed)) {
            return false;
        }
        return true;
    }
    
    
    
}
