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
public enum PreMissionSceneType implements Serializable{
    
    O2tanks("This will give you additional O2 at the start of the game."),
    water("This will give you additional water at the start of the game."),
    food("This will give you additional food/calories at the start of the game."),
    fuel("This will give you additional fuel at the start of the game.");
    
    private final String description;


    PreMissionSceneType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}