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
 * @author Autumn
 */
public class Actor implements Serializable{
    
        private String actorName;
        private int calorieLevel;
        private int oxygenLevel;

    public Actor() {
    }
        
        

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public int getCalorieLevel() {
        return calorieLevel;
    }

    public void setCalorieLevel(int calorieLevel) {
        this.calorieLevel = calorieLevel;
    }

    public int getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(int oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.actorName);
        hash = 43 * hash + this.calorieLevel;
        hash = 43 * hash + this.oxygenLevel;
        return hash;
    }

    @Override
    public String toString() {
        return "Actor{" + "actorName=" + actorName + ", calorieLevel=" + calorieLevel + ", oxygenLevel=" + oxygenLevel + '}';
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
        final Actor other = (Actor) obj;
        if (this.calorieLevel != other.calorieLevel) {
            return false;
        }
        if (this.oxygenLevel != other.oxygenLevel) {
            return false;
        }
        if (!Objects.equals(this.actorName, other.actorName)) {
            return false;
        }
        return true;

    }
}
        


   