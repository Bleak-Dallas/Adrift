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
public enum Tools implements Serializable {
    
    shovel("Is used to get frozen ice. Iron is required to make this tool"),
    drill("Is used to get petroleum. Iron is required to make this tool"),
    hammer("Is used to mine Iron, Aluminum, Uranium. Iron is required to make this tool"),
    O2tank("Is used to provide oxygen to the character. Aluminum is required to make this tool");
    
    
    private final String description;

    Tools(String description) {
        this.description = description;
    }
    

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Tools{" + "description=" + description + '}';
    }

    
}
