/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adrift;


import byui.cit260.adrift.model.Actor;
import byui.cit260.adrift.model.Buggy;
import byui.cit260.adrift.model.FacilitySceneType;

import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;


import byui.cit260.adrift.model.Player;
import byui.cit260.adrift.model.RegularSceneType;
import byui.cit260.adrift.model.ResourceSceneType;
import byui.cit260.adrift.model.Tools;
import byui.cit260.adrift.model.Ship;
import java.text.NumberFormat;


/**
 *
 * @author Joel
 */
public class Adrift {
    
    //Test methods for the team and individual code.
    public static void teamTest() {
        Player playerOne = new Player();
        Game newGame = new Game();
                
        playerOne.setName("Darth Vader");
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
        
        newGame.setNoOfActors(3);
        newGame.setTotalDistanceTraveled(3000);
        
        String gameInfo = newGame.toString();
        System.out.println(gameInfo); 
        }
    
    public static void joelTest() {
        Ship ship = new Ship();
        RegularSceneType regular = new RegularSceneType();
        
        ship.setDamageLevel(.70);
        ship.setFuelCapacity(100);
        ship.setFuelLevel(.12);
        
        NumberFormat defaultFormat = NumberFormat.getPercentInstance();
	defaultFormat.setMinimumFractionDigits(1);
	System.out.println("Damage Level: " + defaultFormat.format(ship.getDamageLevel()));
        System.out.println("Fuel Level: " + defaultFormat.format(ship.getFuelLevel()));
        
        regular.setBlocked(false);
        regular.setDistanceTraveled(10);
        
        String regularInfo  = regular.toString();
        System.out.println(regularInfo);
        
        
        
    }
    
    /**
     *
     */

        
  public static void johnTest() {
        //Revised comment to main
        FacilitySceneType resource = new FacilitySceneType   ();
        Location area = new Location ();
        Map tool  = new Map();
        Actor player = new Actor ();
        
        resource.setFacilityDescription("Deep Space9");
        resource.setDistanceTraveled(100);
        resource.setLocationBlocked(2);
        resource.setFacilitySymbol("ADRIFT");
        resource.setNoOfItems(5);
        
        String facilityInfo = resource.toString();
        System.out.println(facilityInfo);
        
        area.setRowLocation(4);
        area.setLocationVisited(5);
        area.setColumnLocation("B");
        area.setAmountRemaining(9);
        
        String locationInfo = area.toString();
        System.out.println(locationInfo);
        
        tool.setRowCount(8);
        tool.setColumnCount(9);
        
        String mapInfo = tool.toString();
        System.out.println(mapInfo);
        
        player.setActorAllName("Darth Vader");
        player.setCalorieLevel(200);
        player.setOxygenLevel (150);
        
        String actorInfo = player.toString();
        System.out.println(actorInfo);
    }
       
    public static void dallasTest() {
        InventoryItem inventory = new InventoryItem();
        Tools tool = new Tools();
        Buggy startBuggy = new Buggy();
        ResourceSceneType resource = new ResourceSceneType();
                    
        inventory.setInventoryType("Drill");
        inventory.setQuantityInStock(1);
        inventory.setAmountRemaining(1);
        
        String inventoryInfo = inventory.toString();
        System.out.println(inventoryInfo);
        
        tool.setDescriptionOfTool("Used to mine ore");
        tool.setRequiredResources("Iron");
        tool.setMiningValue(1.2);
        
        String toolInfo = tool.toString();
        System.out.println(toolInfo);
        
        startBuggy.setFuelCapacity(25);
        startBuggy.setFuelLevel(20);
        startBuggy.setStartLocation("A2");
        startBuggy.setLocation("B1");
        startBuggy.setMaxWeight(200);
        startBuggy.setLoadedWeight(126);
        
        String buggyInfo = startBuggy.toString();
        System.out.println(buggyInfo);
        
        resource.setResourceDescription("Used for making drills, shovels, and hammers.");
        resource.setDistanceTraveled(100);
        resource.setBlocked(true);
        resource.setSymbol('I');
        resource.setAmountAvailable(2);
        resource.setResourceType("Iron Ore");
        
        String resourceInfo = resource.toString();
        System.out.println(resourceInfo);
    }

    /**
     * @param args the command line arguments i
     */
    public static void main(String[] args) {
  
        /* Uncomment only the method that you are testing.
         * Keep all other methods commented out.
         */
         //teamTest();
         //joelTest();
        //johnTest();
         //dallasTest();
        
    }
    
    
    
}
