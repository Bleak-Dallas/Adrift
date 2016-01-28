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
public class Tools implements Serializable{
    
    private String descriptionOfTool;
    private String requiredResources;
    private double miningValue;

    public Tools() {
    }
    

    public String getDescriptionOfTool() {
        return descriptionOfTool;
    }

    public void setDescriptionOfTool(String descriptionOfTool) {
        this.descriptionOfTool = descriptionOfTool;
    }

    public String getRequiredResources() {
        return requiredResources;
    }

    public void setRequiredResources(String requiredResources) {
        this.requiredResources = requiredResources;
    }

    public double getMiningValue() {
        return miningValue;
    }

    public void setMiningValue(double miningValue) {
        this.miningValue = miningValue;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.descriptionOfTool);
        hash = 23 * hash + Objects.hashCode(this.requiredResources);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.miningValue) ^ (Double.doubleToLongBits(this.miningValue) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Tools{" + "descriptionOfTool=" + descriptionOfTool + ", requiredResources=" + requiredResources + ", miningValue=" + miningValue + '}';
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
        if (Double.doubleToLongBits(this.miningValue) != Double.doubleToLongBits(other.miningValue)) {
            return false;
        }
        if (!Objects.equals(this.descriptionOfTool, other.descriptionOfTool)) {
            return false;
        }
        if (!Objects.equals(this.requiredResources, other.requiredResources)) {
            return false;
        }
        return true;
    }
    
    
    
}
