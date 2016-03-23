/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author Autumn
 */
public abstract class View implements ViewInterface {
    
    protected String displayMessage;
    
    protected final BufferedReader keyboard = Adrift.getInFile();
    protected final PrintWriter console = Adrift.getOutFile();

    public View (String message) {
        this.displayMessage = message;
    }
    
    @Override
    public void display () {
        boolean done;
        do {
            
            String value = this.getInput();
                        
            done = this.doAction(value);
        
        } while (!done);
    }
    
    @Override
    public String getInput(){
        
        boolean valid = false;
        String value = null;
        
        while (!valid){
            this.console.println("\n" + this.displayMessage);
            
            try {
                value = this.keyboard.readLine();
            } catch (IOException ex) {
                this.console.println("Enter valid selection");
            }
            value = value.trim();
            
            if (value.length() < 1) {
                ErrorView.display(this.getClass().getName(),
                        "Invalid selection - the menu item must not be blank");
                continue;
            }
            break;
        }
        
        return value;
    }

}
    

