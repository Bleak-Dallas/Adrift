/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.view;

import adrift.Adrift;
import byu.cit260.adrift.enums.ShipType;
import byui.cit260.adrift.control.ShipControl;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.Ship;
import java.text.NumberFormat;


public class ShipStatusView {
    Game game = Adrift.getCurrentGame();
    Ship[] shipItems = game.getShip();
    NumberFormat defaultFormat = NumberFormat.getPercentInstance();

    void dislpayShipStatus() {
        ShipControl shipControl = new ShipControl();
        shipControl.shipStatus();
        
        System.out.println("\n*************************************************"
                    + "\n|             Ship Status                     |"
                    + "\n*************************************************"
                    + "\nRepair Level: " + defaultFormat.format(shipItems[ShipType.shipstatus.ordinal()].getRepairLevel()) 
                    + "\nFuel Level: " + defaultFormat.format(shipItems[ShipType.shipstatus.ordinal()].getFuelLevel()));

        System.out.println("\n*************************************************"
                            + "\n|             Ship Resource Status                     |"
                            + "\n*************************************************\n");
        System.out.println("Description" + "\t" +
                            "In Stock"   + "\t" +
                            "Amount Required");
        
        // for each inventory item
        for(int i=1; i < shipItems.length; i++) {
            // Display the description, the required amount and the amount in stock
            System.out.println(shipItems[i].getDescription() + "\t\t" + "    " +
                               shipItems[i].getShipItemAmount() + "\t\t" + "      " + 
                               shipItems[i].getRequiredShipAmount());
            
    }
      
    }
}
