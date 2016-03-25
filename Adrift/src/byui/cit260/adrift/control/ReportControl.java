/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import byui.cit260.adrift.exceptions.GameControlException;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Tools;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Dallas
 */
public class ReportControl {
    
    public static void toolInventoryReport(Tools[] toolInventory, String filePath) throws GameControlException{
        try(FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(toolInventory);
        }
        catch(IOException e) {
            throw new GameControlException(e.getMessage());
        }
    
    }
    
}
