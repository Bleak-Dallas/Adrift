/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import java.util.Scanner;

/**
 *
 * @author Autumn
 */
public abstract class View implements ViewInterface {
    
    protected String displayMessage;
    
    public View (String message) {
        this.displayMessage = message;
    }
    
    @Override
    public void display () {
        boolean done = false;
        do {
            
            String value = this.getInput();
            if (value.toUpperCase().equals("Q"))
                return;
                        
            done = this.doAction(value);
        
        } while (!done);
    }
    
    @Override
    public String getInput(){
        
        boolean valid = false;
        String value = null;
        Scanner keyboard = new Scanner(System.in);
        
        while (!valid){
            System.out.println("\n" + this.displayMessage);
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() < 1) {
                System.out.println("Invalid selection - the menu item must not be blank");
                continue;
            }
            break;
        }
        
        return value;
    }

}
    

