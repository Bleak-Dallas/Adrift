/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byu.cit260.adrift.enums;

import java.io.Serializable;
import java.awt.Point;

/**
 *
 * @author Autumn
 */
public enum ActorType implements Serializable{
    
    Luke("Ship pilot"),
    Chewy("ship technician"),
    Bones("Ship geologist"),
    R2C3Data("Ship robot");
    
    private final String description;
    private final Point coordinates;


   
    ActorType(String description) {
        this.description = description;
        coordinates = new Point(0,1);
        
    }

    public String getDescription() {
        return description;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "ActorType{" + "description=" + description + ", coordinates=" + coordinates + '}';
    }

}