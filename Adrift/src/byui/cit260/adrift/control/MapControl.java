/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.Adrift;
import byu.cit260.adrift.enums.ActorType;
import byui.cit260.adrift.model.Actor;
import byui.cit260.adrift.model.Location;
import byui.cit260.adrift.model.Map;
import byui.cit260.adrift.model.Scene;
import byu.cit260.adrift.enums.SceneType;
import byui.cit260.adrift.model.Game;


public class MapControl {
    
    Game game = Adrift.getCurrentGame();
    
    public static Map createMap() {
        // create the map
        Map map = new Map(5, 5);
        
        // create a list of the different scenes in the game
        Scene[] scenes = createScenes();

         // assign the diffeent scenes to locations in the map
        assignScenesToLocations(map, scenes);
        
         // move actors to startin location
        
        moveActorsToStartingLocation(map);

    return map;
    
    }
    
    // create a list of the different scenes in the game
    static Scene[] createScenes() {
        
        Scene[] scenes = new Scene[SceneType.values().length];
        
        Scene start = new Scene();
        start.setDescription("\nYou have crash landed on asteroid CR76 in "
                + "\nthe Kimball Section of the asteroid belt. Luckily you did "
                + "\nnot crash far from the mining facility on this asteroid. Your "
                + "\ncrew has already made it to the mining facility while you were "
                + "\nassessing the damage on the ship. Your ship’s hull is damaged "
                + "\nand will need to be fixed. Due to the damage to the hull your "
                + "\nfuel cells have been damaged and additional fuel cells will "
                + "\nneed to be needed if you are ever to take off again. As "
                + "\nmission commander you need to: 1) Retrieve the top secret item "
                + "\nfrom the asteroid, 2) Fix the damaged hull, 3) Create new "
                + "\nfuel cells if possible, 4) Save your crew and return the item to earth.");
        start.setSymbol(" ST ");
        start.setBlocked(false);
        start.setDistanceTraveled(0);
        start.setResourceDescription("Ice");
        start.setResourceAmount(1);
        scenes[SceneType.start.ordinal()] = start;
        
        Scene sandy1 = new Scene();
        sandy1.setDescription("\nThis area has deep sands and high winds that are "
                + "\ncausing a dust storm making it difficult to see.");
        sandy1.setSymbol(" SA1 ");
        sandy1.setBlocked(false);
        sandy1.setDistanceTraveled(3);
        sandy1.setResourceDescription("Aluminum");
        sandy1.setResourceAmount(10);
        scenes[SceneType.sandy1.ordinal()] = sandy1;
    
                
        Scene sandy2 = new Scene();
        sandy2.setDescription("\nYou notice that the area is relatively flat with "
                + "\nthick deep sand. You also notice that there are some old "
                + "\nruins in the area, but not the same as you have seen before. "
                + "\nIt looks someone lived here long ago");
        sandy2.setSymbol(" SA2 ");
        sandy2.setBlocked(false);
        sandy2.setDistanceTraveled(15);
        sandy2.setResourceDescription("Fuel");
        sandy2.setResourceAmount(20);
        scenes[SceneType.sandy2.ordinal()] = sandy2;
        
        Scene rocky1 = new Scene();
        rocky1.setDescription("\nThis sector is very rocky on the asteroid. These "
                + "\nareas are usually great for mining all types of ore.");
        rocky1.setSymbol(" RO1 ");
        rocky1.setBlocked(false);
        rocky1.setDistanceTraveled(5);
        rocky1.setResourceDescription("Iron");
        rocky1.setResourceAmount(20);
        scenes[SceneType.rocky1.ordinal()] = rocky1;
        
        Scene rocky2 = new Scene();
        rocky2.setDescription("\nThis sector is inundated with large rocks making "
                + "\nit difficult to pass through. You look around for an easier "
                + "\nway to get through this section, but it looks like it may "
                + "\ntake a while.");
        rocky2.setSymbol(" RO2 ");
        rocky2.setBlocked(false);
        rocky2.setDistanceTraveled(18);
        rocky2.setResourceDescription("Iron");
        rocky2.setResourceAmount(50);
        scenes[SceneType.rocky2.ordinal()] = rocky2;
        
        Scene rocky3 = new Scene();
        rocky3.setDescription("\nThis sector is inundated with large rocks making "
                + "\nit difficult to pass through. You look around for an easier "
                + "\nway to get through this section, but it looks like it may "
                + "\ntake a while.");
        rocky3.setSymbol(" RO2 ");
        rocky3.setBlocked(false);
        rocky3.setDistanceTraveled(23);
        rocky3.setResourceDescription("Iron");
        rocky3.setResourceAmount(50);
        scenes[SceneType.rocky3.ordinal()] = rocky3;
        
        Scene icy1 = new Scene();
        icy1.setDescription("\nThis sector is bitterly cold and difficult to "
                + "\nmaneuver due to the massive amounts of ice. The good news is"
                + "\nthat you have found a mining buggy in this sector. The bad "
                + "\nnews is that it has no fuel. With the buggy you can begin "
                + "\nmining ore and other resources to fix your ship. If you do "
                + "\nnot have any fuel with you, you will need to travel back to "
                + "\nthe facility to get some in order to use the buggy. I wonder "
                + "\nwhat resource you can get from the area.");
        icy1.setSymbol(" IC1 ");
        icy1.setBlocked(false);
        icy1.setDistanceTraveled(4);
        icy1.setResourceDescription("Ice");
        icy1.setResourceAmount(20);
        scenes[SceneType.icy1.ordinal()] = icy1;
        
        Scene icy2 = new Scene();
        icy2.setDescription("\nYou have arrived at what looks like a frozen lake. "
                + "\nThe lake is very large and the ice is extremely blue.");
        icy2.setSymbol(" IC2 ");
        icy2.setBlocked(false);
        icy2.setDistanceTraveled(17);
        icy2.setResourceDescription("Aluminum");
        icy2.setResourceAmount(20);
        scenes[SceneType.icy2.ordinal()] = icy2;
        
        Scene canyon1 = new Scene();
        canyon1.setDescription("\nYou notice a very deep canyon in this sector. "
                + "\nAs you start to travel down the canyon you notice radiation "
                + "\nwarning signs that read, “8 hour exposure limit.”");
        canyon1.setSymbol(" CA1 ");
        canyon1.setBlocked(false);
        canyon1.setDistanceTraveled(9);
        canyon1.setResourceDescription("Uranium");
        canyon1.setResourceAmount(20);
        scenes[SceneType.canyon1.ordinal()] = canyon1;
        
        Scene canyon2 = new Scene();
        canyon2.setDescription("\nThe canyon continues to stretch on from the "
                + "\nprevious sector with no end in sight.");
        canyon2.setSymbol(" CA2 ");
        canyon2.setBlocked(false);
        canyon2.setDistanceTraveled(10);
        canyon2.setResourceDescription("Uranium");
        canyon2.setResourceAmount(10);
        scenes[SceneType.canyon2.ordinal()] = canyon2;
        
        Scene crater1 = new Scene();
        crater1.setDescription("\nThe sector is almost completely consumed by a "
                + "\nvery large crater. As you head down the crater you find a "
                + "\nshed with a mining core sample that reads, “Copper.” "
                + "\nYou decide to head down and see if you can get any of this ore here.");
        crater1.setSymbol(" CR1 ");
        crater1.setBlocked(false);
        crater1.setDistanceTraveled(7);
        crater1.setResourceDescription("Copper");
        crater1.setResourceAmount(10);
        scenes[SceneType.crater1.ordinal()] = crater1;
        
        Scene crater2 = new Scene();
        crater2.setDescription("\nCommander you have been descending into the "
                + "\nlargest crater on the asteroid. There is no way around due "
                + "\nto the high cliff sides. Unfortunately there is only one way "
                + "\nin and one way out of the crater. However, this area is great "
                + "\nfor mining.");
        crater2.setSymbol(" CR2 ");
        crater2.setBlocked(false);
        crater2.setDistanceTraveled(19);
        crater2.setResourceDescription("Copper");
        crater2.setResourceAmount(20);
        scenes[SceneType.crater2.ordinal()] = crater2;
        
        Scene outpost1 = new Scene();
        outpost1.setDescription("\nCongrats you have made it to outpost 1. make "
                + "\nsure you take the time to see if there are any items that you "
                + "\nmay need while you are here.");
        outpost1.setSymbol(" OP1 ");
        outpost1.setBlocked(false);
        outpost1.setDistanceTraveled(6);
        outpost1.setResourceDescription("Food");
        outpost1.setResourceAmount(15);
        scenes[SceneType.outpost1.ordinal()] = outpost1;
        
        Scene outpost2 = new Scene();
        outpost2.setDescription("\nYou have reached the second outpost. Keep an "
                + "\neye on your calories and look for any Emergency Rations.");
        outpost2.setSymbol(" OP2 ");
        outpost2.setBlocked(false);
        outpost2.setDistanceTraveled(11);
        outpost2.setResourceDescription("Food");
        outpost2.setResourceAmount(20);
        scenes[SceneType.outpost2.ordinal()] = outpost2;
        
        Scene outpost3 = new Scene();
        outpost3.setDescription("\nOutpost 3 is in sight. It has been a long "
                + "\nroad so far. Keep your eye on the ball and make sure that "
                + "\nyou are taking care to search these outposts thoroughly.");
        outpost3.setSymbol(" OP3 ");
        outpost3.setBlocked(false);
        outpost3.setDistanceTraveled(16);
        outpost3.setResourceDescription("Food");
        outpost3.setResourceAmount(20);
        scenes[SceneType.outpost3.ordinal()] = outpost3;
        
        Scene outpost4 = new Scene();
        outpost4.setDescription("\nYou have reached the final outpost. You search "
                + "\naround put you do not find the item that was supposed to be "
                + "\nat this outpost. You should search again to make sure");
        outpost4.setSymbol(" OP4 ");
        outpost4.setBlocked(false);
        outpost4.setDistanceTraveled(21);
        outpost4.setResourceDescription("Food");
        outpost4.setResourceAmount(10);
        scenes[SceneType.outpost4.ordinal()] = outpost4;
        
        Scene mountain1 = new Scene();
        mountain1.setDescription("\nYou have made it to the first mountain region "
                + "\nof your journey. Take some time to mine as you go through "
                + "\nthis rough area.");
        mountain1.setSymbol(" MN1 ");
        mountain1.setBlocked(false);
        mountain1.setDistanceTraveled(12);
        mountain1.setResourceDescription("Iron");
        mountain1.setResourceAmount(30);
        scenes[SceneType.mountain1.ordinal()] = mountain1;
        
        Scene mountain2 = new Scene();
        mountain2.setDescription("\nSecond mountain region in sight. Again make "
                + "\nsure to mine the area and keep your eyes open for any dangers. "
                + "\nThe last mining crew that was in this area dumped their buggy "
                + "\noff a cliff.");
        mountain2.setSymbol(" MN2 ");
        mountain2.setBlocked(false);
        mountain2.setDistanceTraveled(24);
        mountain2.setResourceDescription("Aluminum");
        mountain2.setResourceAmount(20);
        scenes[SceneType.mountain2.ordinal()] = mountain2;
        
        Scene cave1 = new Scene();
        cave1.setDescription("\nYou notice a cave in the distance and decide to "
                + "\nexplore it. Upon entering R2C3Data’s sensors start going off. "
                + "\nR2C3Data says, “High amounts of radiation detected. I may be "
                + "\nable to get some uranium here.");
        cave1.setSymbol(" CV1 ");
        cave1.setBlocked(false);
        cave1.setDistanceTraveled(13);
        cave1.setResourceDescription("Uranium");
        cave1.setResourceAmount(20);
        scenes[SceneType.cave1.ordinal()] = cave1;
        
        Scene cave2 = new Scene();
        cave2.setDescription("\nAfter days of searching you find another cave. "
                + "\nThis one has some type of ancient gate on it. You are unable "
                + "\nto open the gate and ask R2C3Data to try. The robot get the "
                + "\ngate open. There is strange writing on the walls and odd "
                + "\nlooking instruments. While looking around you spot it, the "
                + "\n“item,” you cannot believe that you have found it. Now all "
                + "\nthere is to do is get the ship fixed and fueled up and we "
                + "\ncan leave this rock");
        cave2.setSymbol(" CV2 ");
        cave2.setBlocked(false);
        cave2.setDistanceTraveled(25);
        cave2.setResourceDescription("Flux Capacitor");
        cave2.setResourceAmount(1);
        scenes[SceneType.cave2.ordinal()] = cave2;
        
        Scene drill1 = new Scene();
        drill1.setDescription("\nYou have arrived at an abandon drilling platform "
                + "\nand decide to see if it still works. The platform is "
                + "\noperational, but there are no drill heads around. R2C3Data "
                + "\nreminds you that drill heads can be manufactured at the "
                + "\nmining facility if you do not already have one.");
        drill1.setSymbol(" DL1 ");
        drill1.setBlocked(false);
        drill1.setDistanceTraveled(8);
        drill1.setResourceDescription("Fuel");
        drill1.setResourceAmount(20);
        scenes[SceneType.drill1.ordinal()] = drill1;
        
        Scene drill2 = new Scene();
        drill2.setDescription("\nYou have found another drilling platform that is "
                + "\nin working order");
        drill2.setSymbol(" DL2 ");
        drill2.setBlocked(false);
        drill2.setDistanceTraveled(14);
        drill2.setResourceDescription("Fuel");
        drill2.setResourceAmount(10);
        scenes[SceneType.drill2.ordinal()] = drill2;
        
        Scene drill3 = new Scene();
        drill3.setDescription("\nThe mountains seem to go on forever. As you are "
                + "\ntraveling you notice a  a very large crevice. As you look "
                + "\ncloser there is some weird looking machine. You examine the "
                + "\nmachine and find that it is a drilling platform that you "
                + "\nhave never seen before. R2C3Data has information on this "
                + "\ntype of drill and teaches you how to use it.");
        drill3.setSymbol(" DL3 ");
        drill3.setBlocked(false);
        drill3.setDistanceTraveled(20);
        drill3.setResourceDescription("Fuel");
        drill3.setResourceAmount(15);
        scenes[SceneType.drill3.ordinal()] = drill3;
        
        Scene drill4 = new Scene();
        drill4.setDescription("\nYou have arrived at a much older drilling site. "
                + "\nAll the machines are broken and unable to be fixed. However, "
                + "\nupon searching the area you find some barrels of "
                + "\ncrude oil, SCORE!!");
        drill4.setSymbol(" DL4 ");
        drill4.setBlocked(false);
        drill4.setDistanceTraveled(22);
        drill4.setResourceDescription("Fuel");
        drill4.setResourceAmount(10);
        scenes[SceneType.drill4.ordinal()] = drill4;
        
        Scene facility = new Scene();
        facility.setDescription("\nWelcome to the mining facility. Here at the "
                + "\nfacility you can call on your crew to smelt ore, construct "
                + "\ntools, and refine resources. The mining facility has an "
                + "\noxygen reclaimer that you can use to fill up your O2 tanks "
                + "\nas well as a small supply of petroleum. You may also store "
                + "\nand resources you collect here at the facility.");
        facility.setSymbol(" FC ");
        facility.setBlocked(false);
        facility.setDistanceTraveled(2);
        facility.setResourceDescription("Fuel");
        facility.setResourceAmount(4);
        scenes[SceneType.facility.ordinal()] = facility;
        
        Scene ship = new Scene();
        ship.setDescription("\nYou are back at the crash site. The ship needs it "
                + "\nhull repaired and new fuel cells before it can take off. Do "
                + "\nyou want to work on the ship?");
        ship.setSymbol(" SP ");
        ship.setBlocked(false);
        ship.setDistanceTraveled(1);
        ship.setResourceDescription("Fuel");
        ship.setResourceAmount(1);
        scenes[SceneType.ship.ordinal()] = ship;
        
        Scene finish = new Scene();
        finish.setDescription("\nCongratulations Commander!! You have fixed "
                + "\nyour ship, retrieved the item and saved your crew. Your total "
                + "\ntravel time was:");
        finish.setSymbol(" FN ");
        finish.setBlocked(false);
        finish.setDistanceTraveled(0);
        finish.setResourceDescription("Iron");
        finish.setResourceAmount(1);
        scenes[SceneType.finish.ordinal()] = finish;
        
        return scenes;
        
    }

    public static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();
        
        // start point
        locations[0][0].setScene(scenes[SceneType.ship.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.facility.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.sandy1.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.icy1.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.rocky1.ordinal()]);
        
        locations[1][0].setScene(scenes[SceneType.outpost1.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.crater1.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.drill1.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.canyon1.ordinal()]);
        locations[1][4].setScene(scenes[SceneType.canyon2.ordinal()]);
        
        locations[2][0].setScene(scenes[SceneType.outpost2.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.mountain1.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.cave1.ordinal()]);
        locations[2][3].setScene(scenes[SceneType.drill2.ordinal()]);
        locations[2][4].setScene(scenes[SceneType.sandy2.ordinal()]);
        
        locations[3][0].setScene(scenes[SceneType.outpost3.ordinal()]);
        locations[3][1].setScene(scenes[SceneType.icy2.ordinal()]);
        locations[3][2].setScene(scenes[SceneType.rocky2.ordinal()]);
        locations[3][3].setScene(scenes[SceneType.crater2.ordinal()]);
        locations[3][4].setScene(scenes[SceneType.drill3.ordinal()]);
        
        locations[4][0].setScene(scenes[SceneType.outpost4.ordinal()]);
        locations[4][1].setScene(scenes[SceneType.drill4.ordinal()]);
        locations[4][2].setScene(scenes[SceneType.rocky1.ordinal()]);
        locations[4][3].setScene(scenes[SceneType.mountain2.ordinal()]);
        locations[4][4].setScene(scenes[SceneType.cave2.ordinal()]);

    }

//    static Actor[] createActorList() {
////         create list of actors
//        Actor[] actors = new Actor[ActorType.values().length];
//        
//        Actor Luke = new Actor();
//        Luke.setDescription("Ship pilot");
//        actors[ActorType.Luke.ordinal()] = Luke;
//        
//        Actor Chewy = new Actor();
//        Chewy.setDescription("ship technician");
//        actors[ActorType.Chewy.ordinal()] = Chewy;
//        
//        Actor Bones = new Actor();
//        Bones.setDescription("Ship geologist");
//        actors[ActorType.Bones.ordinal()] = Bones;
//        
//        Actor R2C3Data = new Actor();
//        R2C3Data.setDescription("Ship robot");
//        actors[ActorType.R2C3Data.ordinal()] = R2C3Data;
//        
//        return actors;
//    }
    
        public static void moveActorsToStartingLocation(Map map) {
        Location[][] locations = map.getLocations();
        
        // start point
        locations[0][1].setActors(ActorType.Luke);
        locations[0][1].setActors(ActorType.Chewy);
        locations[0][1].setActors(ActorType.Bones);
        locations[0][1].setActors(ActorType.R2C3Data);
        
        
        }
      
     
//        Map map = Adrift.getCurrentGame().getMap();
//        int newRow = coordinates.x-0;
//        int newColumn = coordinates.y-1;
//       
//            if (newRow < 0 || newColumn < 0 || newColumn >= map.getNoOfColumns() || newRow >= map.getNoOfRows()) {
//                System.out.println("/nCan not move actor to location "
//                                    + coordinates.x + "'" + coordinates.y
//                                    + " beacuse that location is outside "
//                                    + "the bounds of the map");
//
//            }

}
