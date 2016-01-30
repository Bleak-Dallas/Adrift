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
public class RegularSceneType implements Serializable{
    
    private int distanceTraveled;
    private char symbol;
    private boolean blocked;
    private String description;

    public RegularSceneType() {
    }
    
    
    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.distanceTraveled;
        hash = 71 * hash + this.symbol;
        hash = 71 * hash + (this.blocked ? 1 : 0);
        hash = 71 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public String toString() {
        return "RegularSceneType{" + "distanceTraveled=" + distanceTraveled + ", symbol=" + symbol + ", blocked=" + blocked + ", description=" + description + '}';
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
        final RegularSceneType other = (RegularSceneType) obj;
        if (this.distanceTraveled != other.distanceTraveled) {
            return false;
        }
        if (this.symbol != other.symbol) {
            return false;
        }
        if (this.blocked != other.blocked) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    
    
} 
    
   