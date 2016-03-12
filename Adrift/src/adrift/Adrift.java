/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adrift;


//import byui.cit260.adrift.model.Actor;
//import byui.cit260.adrift.model.Buggy;
//import byui.cit260.adrift.model.FacilitySceneType;
import byui.cit260.adrift.model.Game;
//import byui.cit260.adrift.model.InventoryItem;
//import byui.cit260.adrift.model.Location;
//import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Player;
//import byui.cit260.adrift.model.PreMissionSceneType;
//import byui.cit260.adrift.model.RegularSceneType;
//import byui.cit260.adrift.model.ResourceSceneType;
//import byui.cit260.adrift.model.Tools;
//import byui.cit260.adrift.model.Ship;
import byui.cit260.adrift.view.StartProgramView;
//import java.text.NumberFormat;


public class Adrift {
    
    private static Game currentGame = null;
    private static Player player = null;

    //Test methods for the team and individual code.
//    public static void teamTest() {
//        Player playerOne = new Player();
//        Game newGame = new Game();
//                
//        playerOne.setPlayerName("Darth Vader");
//        
//        String playerInfo = playerOne.toString();
//        System.out.println(playerInfo);
//        
//        newGame.setNoOfActors(3);
//        newGame.setTotalDistanceTraveled(3000);
//        
//        String gameInfo = newGame.toString();
//        System.out.println(gameInfo); 
//    }
//    
//    public static void joelTest() {
//        Ship ship = new Ship();
//        RegularSceneType regular = new RegularSceneType();
//        PreMissionSceneType preMission = new PreMissionSceneType();
//        
//        ship.setDamageLevel(.70);
//        ship.setFuelCapacity(100);
//        ship.setFuelLevel(.12);
//               
//        NumberFormat defaultFormat = NumberFormat.getPercentInstance();
//	defaultFormat.setMinimumFractionDigits(1);
//	System.out.println("Damage Level: " + defaultFormat.format(ship.getDamageLevel()));
//        System.out.println("Fuel Level: " + defaultFormat.format(ship.getFuelLevel()));
//        
//        regular.setBlocked(false);
//        regular.setDistanceTraveled(10);
//        
//        String regularInfo  = regular.toString();
//        System.out.println(regularInfo);
//        
//        /*Eliminated Elevator class and merged elevatorCapacity and 
//        elevatorCapacityUsed to PreMissionSceneType class*/
//        preMission.setElevatorCapacity(8000);
//        preMission.setElevatorCapacityUsed(7500);
//        preMission.setResourceType("Water");
//        preMission.setSymbol('W');
//        preMission.setNoOfItems(1500);
//        
//        String preMissionInfo = preMission.toString();
//        System.out.println(preMissionInfo);
//    }
//        
//  public static void johnTest() {
//        //Revised comment to main
//        FacilitySceneType resource = new FacilitySceneType   ();
//        Location area = new Location ();
//        Map tool  = new Map();
//        Actor player = new Actor ();
//        
//        resource.setFacilityDescription("Deep Space9");
//        resource.setDistanceTraveled(100);
//        resource.setLocationBlocked(2);
//        resource.setFacilitySymbol("ADRIFT");
//        resource.setNoOfItems(5);
//        
//        String facilityInfo = resource.toString();
//        System.out.println(facilityInfo);
//        
//        area.setLocation(4);
//        area.setLocationVisited(5);
//        area.setAmountRemaining(9);
//        
//        String locationInfo = area.toString();
//        System.out.println(locationInfo);
//        
//        tool.setRowCount(8);
//        tool.setColumnCount(9);
//        
//        String mapInfo = tool.toString();
//        System.out.println(mapInfo);
//        
//        player.setActorAllName("Darth Vader");
//        player.setCurrentLocation(23);
//        player.setCalorieLevel(200);
//        player.setOxygenLevel (150);
//        
//        String actorInfo = player.toString();
//        System.out.println(actorInfo);
//    }
//       
//    public static void dallasTest() {
//        InventoryItem inventory = new InventoryItem();
//        Tools tool = new Tools();
//        Buggy startBuggy = new Buggy();
//        ResourceSceneType resource = new ResourceSceneType();
//                    
//        inventory.setInventoryType("Drill");
//        inventory.setQuantityInStock(1);
//        inventory.setAmountRemaining(1);
//        
//        String inventoryInfo = inventory.toString();
//        System.out.println(inventoryInfo);
//        
//        tool.setDescriptionOfTool("Used to mine ore");
//        tool.setRequiredResources("Iron");
//        tool.setMiningValue(1.2);
//        
//        String toolInfo = tool.toString();
//        System.out.println(toolInfo);
//        
//        startBuggy.setFuelCapacity(25);
//        startBuggy.setFuelLevel(20);
//        startBuggy.setStartLocation("A2");
//        startBuggy.setLocation("B1");
//        startBuggy.setMaxWeight(200);
//        startBuggy.setLoadedWeight(126);
//        
//        String buggyInfo = startBuggy.toString();
//        System.out.println(buggyInfo);
//        
//        resource.setResourceDescription("Used for making drills, shovels, and hammers.");
//        resource.setDistanceTraveled(100);
//        resource.setBlocked(true);
//        resource.setSymbol('I');
//        resource.setAmountAvailable(2);
//        resource.setResourceType("Iron Ore");
//        
//        String resourceInfo = resource.toString();
//        System.out.println(resourceInfo);
//    }

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
    
    
  
    public static void main(String[] args) {
  
        /* Uncomment only the method that you are testing.
         * Keep all other methods commented out.
         */
         //teamTest();
         //joelTest();
         //johnTest();
         //dallasTest();
         
         StartProgramView startProgramView = new StartProgramView();
         startProgramView.startProgram();
        
    }
    
    
    
}
