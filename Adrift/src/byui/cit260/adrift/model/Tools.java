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
 * @author Dallas
 */
public class Tools implements Serializable{
    
    String[] toolInventory;
    private String description;
    private double quantityInStock;
    private double requiredAmount;
    private String requiredResource;

    public Tools() {
    }

    public String[] getToolInventory() {
        return toolInventory;
    }

    public void setToolInventory(String[] toolInventory) {
        this.toolInventory = toolInventory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(double quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(double requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    public String getRequiredResource() {
        return requiredResource;
    }

    public void setRequiredResource(String requiredResource) {
        this.requiredResource = requiredResource;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Arrays.deepHashCode(this.toolInventory);
        hash = 83 * hash + Objects.hashCode(this.description);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.quantityInStock) ^ (Double.doubleToLongBits(this.quantityInStock) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.requiredAmount) ^ (Double.doubleToLongBits(this.requiredAmount) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.requiredResource);
        return hash;
    }

    @Override
    public String toString() {
        return "Tools{" + "toolInventory=" + toolInventory + ", description=" + description + ", quantityInStock=" + quantityInStock + ", requiredAmount=" + requiredAmount + ", requiredResource=" + requiredResource + '}';
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
        final Tools other = (Tools) obj;
        if (Double.doubleToLongBits(this.quantityInStock) != Double.doubleToLongBits(other.quantityInStock)) {
            return false;
        }
        if (Double.doubleToLongBits(this.requiredAmount) != Double.doubleToLongBits(other.requiredAmount)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.requiredResource, other.requiredResource)) {
            return false;
        }
        if (!Arrays.deepEquals(this.toolInventory, other.toolInventory)) {
            return false;
        }
        return true;
    }

}
