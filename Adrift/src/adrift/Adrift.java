/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adrift;


import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Player;
import byui.cit260.adrift.view.ErrorView;
import byui.cit260.adrift.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;



public class Adrift {
    
    private static Game currentGame = null;
    private static Player player = null;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static PrintWriter logFile = null;


    public static void main(String[] args) {

        
         
    try {
        // open character stream files for end user input and output
        Adrift.inFile = new BufferedReader(new InputStreamReader(System.in));
        Adrift.outFile = new PrintWriter(System.out, true);
        
        // open log file
        String filePath = "log.txt";
        Adrift.logFile = new PrintWriter(filePath);        
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.startProgram();
        return;
    } catch (Throwable te){
      System.out.println("Exception: " + te.toString() +
                         "\nCause: " +   te.getCause() +
                         "\nMessage: " + te.getMessage());
      te.printStackTrace();
      StartProgramView startProgramView = new StartProgramView();
      startProgramView.startProgram();
    }

    finally {
            try {
                if(Adrift.inFile != null)
                    Adrift.inFile.close();
                
                if(Adrift.outFile != null)
                    Adrift.outFile.close();
                
                if(Adrift.logFile != null);
                    Adrift.logFile.close();
             } catch (IOException ex) {
                 System.out.println("Error closing files" + ex.getMessage());
             }
        
    }
}
    
    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        Adrift.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Adrift.player = player;
    }    

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        Adrift.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        Adrift.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        Adrift.logFile = logFile;
    }
    

}
