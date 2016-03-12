/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.model;

import byu.cit260.adrift.enums.ActorType;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Autumn
 */
public class Location implements Serializable {
    
        private int row;
        private int column;
        private boolean visited;
        private int amountRemaining;
        private Scene scene;
        private ActorType actors;

    public Location() {
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getAmountRemaining() {
        return amountRemaining;
    }

    public void setAmountRemaining(int amountRemaining) {
        this.amountRemaining = amountRemaining;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public ActorType getActors() {
        return actors;
    }

    public void setActors(ActorType actors) {
        this.actors = actors;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.row;
        hash = 23 * hash + this.column;
        hash = 23 * hash + (this.visited ? 1 : 0);
        hash = 23 * hash + this.amountRemaining;
        hash = 23 * hash + Objects.hashCode(this.scene);
        hash = 23 * hash + Objects.hashCode(this.actors);
        return hash;
    }

    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + ", visited=" + visited + ", amountRemaining=" + amountRemaining + ", scene=" + scene + ", actors=" + actors + '}';
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
        final Location other = (Location) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        if (this.visited != other.visited) {
            return false;
        }
        if (this.amountRemaining != other.amountRemaining) {
            return false;
        }
        if (!Objects.equals(this.scene, other.scene)) {
            return false;
        }
        if (this.actors != other.actors) {
            return false;
        }
        return true;
    }
    
}