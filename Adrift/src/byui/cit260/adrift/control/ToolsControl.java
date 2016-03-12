/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import adrift.Adrift;
import byu.cit260.adrift.enums.Item;
import byu.cit260.adrift.enums.ToolType;
import byui.cit260.adrift.model.Game;
import byui.cit260.adrift.model.InventoryItem;
import byui.cit260.adrift.model.Tools;

/**
 *
 * @author Dallas
 */
public class ToolsControl {

    static Tools[] createToolList() {
        // create array(list) of inventory items
        Tools[] toolInventory = new Tools[ToolType.values().length];
        Tools shovel = new Tools();
        shovel.setDescription("Shovel  ");
        shovel.setQuantityInStock(0);
        shovel.setRequiredAmount(2);
        shovel.setRequiredResource("Iron    ");
        toolInventory[ToolType.shovel.ordinal()] = shovel;

        Tools drill = new Tools();
        drill.setDescription("Drill    ");
        drill.setQuantityInStock(0);
        drill.setRequiredAmount(3);
        drill.setRequiredResource("Iron    ");
        toolInventory[ToolType.drill.ordinal()] = drill;
        
        Tools hammer = new Tools();
        hammer.setDescription("Hammer  ");
        hammer.setQuantityInStock(0);
        hammer.setRequiredAmount(1);
        hammer.setRequiredResource("Iron    ");
        toolInventory[ToolType.hammer.ordinal()] = hammer;
        
        Tools O2tank = new Tools();
        O2tank.setDescription("O2Tank  ");
        O2tank.setQuantityInStock(0);
        O2tank.setRequiredAmount(3);
        O2tank.setRequiredResource("Aluminum");
        toolInventory[ToolType.O2tank.ordinal()] = O2tank;
        
        return toolInventory;
    }
    
     public static Tools[] getSortedToolList() {
        Tools[] originalToolList = Adrift.getCurrentGame().getToolInventory();
        
        Tools[] toolList = originalToolList.clone();
        
        Tools tempTools;
        int i;
        for ( i =0; i < toolList.length-1; i++) {
            for (int j = 0; j < toolList.length-1-i; j++){
                if (toolList[j].getRequiredAmount() < toolList[j + 1].getRequiredAmount()){
                    tempTools  = toolList[j];
                    toolList[j] = toolList[j+1];
                    toolList[j+1] = tempTools;
                }
            }
        }
        return toolList;
    }


//    public InventoryItem[] sortedTools(){
//        InventoryItem[] originalInventoryList = Adrift.getCurrentGame().getInventory(); // current game inventory
//               
//                // clone of current inventory
//                InventoryItem[] inventoryList = originalInventoryList.clone(); 
//               
//                //Tools to find
//                String drill1  = inventoryList[Item.drill.ordinal()].getDescription().trim();
//                String hammer1 = inventoryList[Item.hammer.ordinal()].getDescription().trim();
//                String o2Tank1 = inventoryList[Item.O2tank.ordinal()].getDescription().trim();
//                String shovel  = inventoryList[Item.shovel.ordinal()].getDescription().trim();
//
//                /*
//                 * There are several ways we can check whether a String array
//                 * contains a particular string.
//                 *
//                 * First of them is iterating the array elements and check as given below.
//                 */
//               
//                boolean contains = false;
//               
//                //iterate the String array
//                for(int i=0; i < inventoryList.length; i++){
//                       
//                        //check if string array contains the string
//                        if(inventoryList[i].getDescription().trim().equals(drill1)  || 
//                           inventoryList[i].getDescription().trim().equals(hammer1) ||
//                           inventoryList[i].getDescription().trim().equals(o2Tank1) ||
//                           inventoryList[i].getDescription().trim().equals(shovel)){
// 
//                                //string found
//                                contains = true;
//    
//                        }
//                }
//               
//                if(contains){
//                        System.out.println("String array contains String "    + drill1 
//                                                                        + " " + hammer1
//                                                                        + " " + o2Tank1
//                                                                        + " " + shovel);
//                }else{
//                        System.out.println("String array does not contain String " + drill1);
//                }
//                            
//       
//    return inventoryList;
//    }
                
                        
//    public double resourcesNeeded(){
//       
//       for(ToolType name : ToolType.values()) {
//            if(inventoryList[Item.iron.ordinal()].getQuantityInStock() < ToolType.drill.getAmountRequired()) {
//            }
//            System.out.println("You do not have enough resources to make tool");
//           }  
//       return 0;
//    }
                   
}



                        

//for(ToolType name : ToolType.values()) {
//            if(inventoryList[Item.iron.ordinal()].getQuantityInStock() < ToolType.drill.getAmountRequired()) {
//            }
//            System.out.println("You do not have enough resources to make tool");
//           }
