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
        this.console.println("\nEnter the filepath where the report will be saved");
        
        String filePath = this.getInput();
        try(PrintWriter reportFile = new PrintWriter(filePath)) {
//            if(filePath = true) {
//                this.console.println("\nFile " + filePath + " already exists");
//            }
        // print title and column headings
        reportFile.println("\n\n                   Tool Inventory Report                    ");
        reportFile.printf("%n%-20s%10s%10s%15s", "Description", "In Stock", "Resource", "Amount Required");
        
        //print toool items
        for(Tools tool : toolInventory) {
            reportFile.printf("%n%-20s%7d%10s%7d"   , tool.getDescription()
                                             , tool.getQuantityInStock()
                                             , tool.getRequiredResource()
                                             , tool.getRequiredAmount());
        }
        if(reportFile != null) {
            this.console.println(ANSI_GREEN + "\n\nYour report has been succesfully run and saved" + ANSI_RESET);
        }

        }
        catch(Throwable te) {
            ErrorView.display("GameMenuView", te.getMessage());
        }
        
        if(reportFile != null) {
            reportFile.close();
        }

//        finally {
//            try {
//                if(reportFile != null)
//                    reportFile.close();
//
//             } catch (IOException ex) {
//                 ErrorView.display("GameMenuView", ex.getMessage());
//             }
//        
//    }
    }

    private void resourcesReport() {
        this.console.println("\n**** resourceReport function called in PrintReportView  ****");
    }

    
}
