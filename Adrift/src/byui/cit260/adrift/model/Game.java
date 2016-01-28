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
public class Game implements Serializable{
 
    private int noOfActors;
    private int totalDistanceTraveled;

    public Game() {
    }

        
    public int getNoOfActors() {
        return noOfActors;
    }

    public void setNoOfActors(int noOfActors) {
        this.noOfActors = noOfActors;
    }

    public int getTotalDistanceTraveled() {
        return totalDistanceTraveled;
    }

    public void setTotalDistanceTraveled(int totalDistanceTraveled) {
        this.totalDistanceTraveled = totalDistanceTraveled;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.noOfActors;
        hash = 61 * hash + this.totalDistanceTraveled;
        return hash;
    }

    @Override
    public String toString() {
        return "Game{" + "noOfActors=" + noOfActors + ", totalDistanceTraveled=" + totalDistanceTraveled + '}';
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
        final Game other = (Game) obj;
        if (this.noOfActors != other.noOfActors) {
            return false;
        }
        if (this.totalDistanceTraveled != other.totalDistanceTraveled) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
