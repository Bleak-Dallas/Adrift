/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

/**
 *
 * 
 */
public class InventoryControl {
  
    public double calculateO2Needed(double currentO2,int currentLocation,int destination){
        
        double numberOfSpacesTraveled = 0;
         
        if (destination < 1 || destination > 25){
            return -1;
        }

        if (currentLocation  < destination) {
            numberOfSpacesTraveled = destination - currentLocation; 
            
        }

        if (currentLocation > destination){
            numberOfSpacesTraveled = currentLocation - destination;
            
            
        }

     
        double remainingO2 =  currentO2 - (numberOfSpacesTraveled * .25);
        return remainingO2;
    
    }   

}
