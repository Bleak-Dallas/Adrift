/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

/**
 *
 * @author Dallas
 */
public class MoveLocationView {
    
    
    
    public String displayMoveToLocation() {
     String display =("\n"
                    + "\n----------------------------------------"
                    + "\n |       Move To New Location          |"
                    + "\n ---------------------------------------"
                    + "\nTo estimate the resources that will be needed"
                    + "\nto travel from your current location to "
                    + "\nyour destination please input your current"
                    + "\nlocation and desired destination "
                    +"\n"
                    + "\nC - Current location"
                    + "\nD - Destination"
                    + "\nQ - Quit to main menu"
                    + "\n---------------------------------------");
     
     return display;
    }
    
    
}