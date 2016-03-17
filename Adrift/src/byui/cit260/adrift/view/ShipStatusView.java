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

/**
 *
 * @author Dallas
 */
public class ShipStatusView {
    Game game = Adrift.getCurrentGame();
    Ship[] shipItems = game.getShip();
    NumberFormat defaultFormat = NumberFormat.getPercentInstance();

    void dislpayShipStatus() {
        
    }
      
    
}
