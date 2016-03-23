/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.model;

import byui.cit260.adrift.view.ErrorView;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
/**
 *
 * @author Autumn
 */
public class Map implements Serializable {

    private String name = "Adrift";
    private String description = "Sector Map";
    private int noOfRows;
    private int noOfColumns;
    public Location[][] locations;
    
    public Map() {  
    }

    public Map(int noOfRows, int noOfColumns) {
        
        if (noOfRows < 1 || noOfColumns < 1) {
        ErrorView.display(this.getClass().getName(),
                "The number of rows and columns must be greater than zero");
        }
        
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        
        // create two dimensional array for Location objects
        this.locations = new Location[noOfRows][noOfColumns];
        
        for(int row = 0; row < noOfRows; row++) {
            for(int column = 0; column < noOfColumns; column++){
                // create and initialize new Location object instance
                Location location = new Location();
                location.setColumn(column);
                location.setRow(row);
                location.setVisited(false);
                
                //assign the location object to the current position in the array
                locations[row][column] = location;
            }
        }
    }
    

    public int getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfRows(int noOfRows) {
        this.noOfRows = noOfRows;
    }

    public int getNoOfColumns() {
        return noOfColumns;
    }

    public void setNoOfColumns(int noOfColumns) {
        this.noOfColumns = noOfColumns;
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + this.noOfRows;
        hash = 53 * hash + this.noOfColumns;
        hash = 53 * hash + Arrays.deepHashCode(this.locations);
        return hash;
    }

    @Override
    public String toString() {
        return "Map{" + "name=" + name + ", description=" + description + ", noOfRows=" + noOfRows + ", noOfColumns=" + noOfColumns + ", locations=" + locations + '}';
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
        final Map other = (Map) obj;
        if (this.noOfRows != other.noOfRows) {
            return false;
        }
        if (this.noOfColumns != other.noOfColumns) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Arrays.deepEquals(this.locations, other.locations)) {
            return false;
        }
        return true;
    }



    
}
