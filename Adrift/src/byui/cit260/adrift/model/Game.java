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
 * @author Joel
 */
public class Game implements Serializable{
 
    private int noOfActors;
    private int totalDistanceTraveled;
    private Player player;
    private String[] actors;
    private InventoryItem[] inventory;
    private Tools[] toolInventory;
    private Scene[] scenes;
    private Elevator elevator;
    private Ship ship;
    private Buggy buggy;
    private Map map;
    private Location currentLocation;

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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public InventoryItem[] getInventory() {
        return inventory;
    }

    public void setInventory(InventoryItem[] inventory) {
        this.inventory = inventory;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Buggy getBuggy() {
        return buggy;
    }

    public void setBuggy(Buggy buggy) {
        this.buggy = buggy;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public Scene[] getScenes() {
        return scenes;
    }

    public void setScenes(Scene[] scenes) {
        this.scenes = scenes;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        currentLocation.setVisited(true);
        this.currentLocation = currentLocation;
    }

    public Tools[] getToolInventory() {
        return toolInventory;
    }

    public void setToolInventory(Tools[] toolInventory) {
        this.toolInventory = toolInventory;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.noOfActors;
        hash = 37 * hash + this.totalDistanceTraveled;
        hash = 37 * hash + Objects.hashCode(this.player);
        hash = 37 * hash + Arrays.deepHashCode(this.actors);
        hash = 37 * hash + Arrays.deepHashCode(this.inventory);
        hash = 37 * hash + Arrays.deepHashCode(this.toolInventory);
        hash = 37 * hash + Arrays.deepHashCode(this.scenes);
        hash = 37 * hash + Objects.hashCode(this.elevator);
        hash = 37 * hash + Objects.hashCode(this.ship);
        hash = 37 * hash + Objects.hashCode(this.buggy);
        hash = 37 * hash + Objects.hashCode(this.map);
        hash = 37 * hash + Objects.hashCode(this.currentLocation);
        return hash;
    }

    @Override
    public String toString() {
        return "Game{" + "noOfActors=" + noOfActors + ", totalDistanceTraveled=" + totalDistanceTraveled + ", player=" + player + ", actors=" + Arrays.toString(actors) + ", inventory=" + Arrays.toString(inventory) + ", toolInventory=" + Arrays.toString(toolInventory) + ", scenes=" + Arrays.toString(scenes) + ", elevator=" + elevator + ", ship=" + ship + ", buggy=" + buggy + ", map=" + map + ", currentLocation=" + currentLocation + '}';
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
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Arrays.deepEquals(this.actors, other.actors)) {
            return false;
        }
        if (!Arrays.deepEquals(this.inventory, other.inventory)) {
            return false;
        }
        if (!Arrays.deepEquals(this.toolInventory, other.toolInventory)) {
            return false;
        }
        if (!Arrays.deepEquals(this.scenes, other.scenes)) {
            return false;
        }
        if (!Objects.equals(this.elevator, other.elevator)) {
            return false;
        }
        if (!Objects.equals(this.ship, other.ship)) {
            return false;
        }
        if (!Objects.equals(this.buggy, other.buggy)) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Objects.equals(this.currentLocation, other.currentLocation)) {
            return false;
        }
        return true;
    }
    
}
