/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byui.cit260.adrift.control.ToolsControl;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Tools;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Dallas
 */
class PrintReportView extends View{
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    Game game = Adrift.getCurrentGame();
    Tools[] toolInventory = ToolsControl.getSortedToolList();
    private static PrintWriter reportFile = null;
    
    public PrintReportView(){
        super("\n"
            + "\n----------------------------------------"
            + "\n | Print Reports Menu                  |"
            + "\n ---------------------------------------"
            + "\nI - Inventory Report"
            + "\nT - Tool Inventory Report"
            + "\nR - Resources at Location Report"
            + "\nQ - Quit to main menu"
            + "\n---------------------------------------");
    }
  
    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered 
    
        switch (choice) {
            case 'I': //create and start new game
                this.inventoryReport();
                break;
            case 'T': //create and start new game
                this.toolInventoryReport();
                break;
            case 'R': //create and start new game
                this.resourcesReport();
                break;
            case 'Q': //Quit the game
                return true;
            default:
               ErrorView.display(this.getClass().getName(),
                       ANSI_RED + "\n*** Invalid selection *** Try Again" + ANSI_RESET);
                break;
        }     
        return false;
    }

    private void inventoryReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void toolInventoryReport() {
        this.console.println(ANSI_BLUE + "\nEnter the filepath and file name where the report will be saved" + ANSI_RESET);
        
        String filePath = this.getInput();
        try(PrintWriter reportFile = new PrintWriter(filePath)) {

        // print title and column headings
        reportFile.println("\n\n                   Tool Inventory Report                    ");
        reportFile.printf("%n%-15s%14s%18s%20s", "Description", "In Stock", "Resource", "Amount Required");
        reportFile.printf("%n%-15s%14s%18s%20s", "-----------", "--------", "--------", "---------------");
        
        //print toool items
        for(Tools tool : toolInventory) {
            reportFile.printf("%n%-15s%10d%23s%13d" , tool.getDescription()
                                                    , tool.getQuantityInStock()
                                                    , tool.getRequiredResource()
                                                    , tool.getRequiredAmount());
        }
        if(reportFile != null) {
            this.console.println(ANSI_GREEN + "\n\nYour report has been succesfully run and saved" + ANSI_RESET);
        }

        }
        catch(IOException ex) {
            ErrorView.display("GameMenuView", ex.getMessage());
        }
        
        finally {
                try {
                    if(reportFile != null)
                        reportFile.close();

                 } catch (Exception ex) {
                    ErrorView.display("GameMenuView Error closing file", ex.getMessage());
                }  
        
        }
    }

    private void resourcesReport() {
        this.console.println("\n**** resourceReport function called in PrintReportView  ****");
    }

    
}
