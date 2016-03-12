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
public class Scene implements Serializable{
    
    private int distanceTraveled;
    private String symbol;
    private boolean blocked;
    private String description;
    private Scene[] scenes;

    public Scene() {
    }
    
    
    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
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

    public Scene[] getScenes() {
        return scenes;
    }

    public void setScenes(Scene[] scenes) {
        this.scenes = scenes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.distanceTraveled;
        hash = 19 * hash + Objects.hashCode(this.symbol);
        hash = 19 * hash + (this.blocked ? 1 : 0);
        hash = 19 * hash + Objects.hashCode(this.description);
        hash = 19 * hash + Arrays.deepHashCode(this.scenes);
        return hash;
    }

    @Override
    public String toString() {
        return "Scene{" + "distanceTraveled=" + distanceTraveled + ", symbol=" + symbol + ", blocked=" + blocked + ", description=" + description + ", scenes=" + scenes + '}';
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
        final Scene other = (Scene) obj;
        if (this.distanceTraveled != other.distanceTraveled) {
            return false;
        }
        if (this.blocked != other.blocked) {
            return false;
        }
        if (!Objects.equals(this.symbol, other.symbol)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Arrays.deepEquals(this.scenes, other.scenes)) {
            return false;
        }
        return true;
    }



} 
