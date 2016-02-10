/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.adrift.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joel
 */
public class InventoryControlTest {
    
    public InventoryControlTest() {
    }

    /**
     * Test of calculateO2Needed method, of class InventoryControl.
     */
    @Test
    public void testCalculateO2Needed() {
        System.out.println("calculateO2Needed");
        /********************
         * Test case #1
         ********************/
        System.out.println("\tTest Case #1");
        double currentO2 = 1.0;
        int currentLocation = 25;
        int destination = 22;
        
        double expResult = 0.25;
        InventoryControl instance = new InventoryControl();
        double result = instance.calculateO2Needed(currentO2, currentLocation, destination);
        assertEquals(expResult, result, 0.0);
        
        
      
        System.out.println("calculateO2Needed");
        /********************
         * Test case #2
         ********************/
        System.out.println("\tTest Case #2");
        currentO2 = 1.0;
        currentLocation = 1;
        destination = 2;
        expResult = 0.75;
        result = instance.calculateO2Needed(currentO2, currentLocation, destination);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("calculateO2Needed");
        /********************
         * Test case #3
         ********************/
        System.out.println("\tTest Case #3");
        currentO2 = 1.0;
        currentLocation = 1;
        destination = 26;
        expResult = -1;
        result = instance.calculateO2Needed(currentO2, currentLocation, destination);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("calculateO2Needed");
        /********************
         * Test case #4
         ********************/
        System.out.println("\tTest Case #4");
        currentO2 = 1.0;
        currentLocation = 20;
        destination = 0;
        expResult = -1;
        result = instance.calculateO2Needed(currentO2, currentLocation, destination);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("calculateO2Needed");
        /********************
         * Test case #5
         ********************/
        System.out.println("\tTest Case #5");
        currentO2 = 0.5;
        currentLocation = 20;
        destination = 25;
        expResult = -0.75;
        result = instance.calculateO2Needed(currentO2, currentLocation, destination);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("calculateO2Needed");
        /********************
         * Test case #6
         ********************/
        System.out.println("\tTest Case #6");
        currentO2 = 1.0;
        currentLocation = 24;
        destination = 25;
        expResult = 0.75;
        result = instance.calculateO2Needed(currentO2, currentLocation, destination);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("calculateO2Needed");
        /********************
         * Test case #7
         ********************/
        System.out.println("\tTest Case #7");
        currentO2 = 1.0;
        currentLocation = 2;
        destination = 1;
        expResult = 0.75;
        result = instance.calculateO2Needed(currentO2, currentLocation, destination);
        assertEquals(expResult, result, 0.0);
    }
    
    
    /**
     * Test of calculateO2Needed method, of class InventoryControl.
     */
    @Test
    public void testCalculateFuelNeeded() {
        System.out.println("calculateFuelNeeded");
        /********************
         * Test case #1
         ********************/
        System.out.println("\tTest Case #1");
        double currentFuel = 1.0;
        int currentLocation = 25;
        int destination = 22;
        
        double expResult = 0.25;
        InventoryControl instance = new InventoryControl();
        double result = instance.calculateFuelNeeded(currentFuel, currentLocation, destination);
        assertEquals(expResult, result, 0.0);
        
        
      
        System.out.println("calculateFuelNeeded");
        /********************
         * Test case #2
         ********************/
        System.out.println("\tTest Case #2");
        currentFuel = 1.0;
        currentLocation = 1;
        destination = 2;
        expResult = 0.75;
        result = instance.calculateFuelNeeded(currentFuel, currentLocation, destination);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("calculateFuelNeeded");
        /********************
         * Test case #3
         ********************/
        System.out.println("\tTest Case #3");
        currentFuel = 1.0;
        currentLocation = 1;
        destination = 26;
        expResult = -1;
        result = instance.calculateFuelNeeded(currentFuel, currentLocation, destination);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("calculateFuelNeeded");
        /********************
         * Test case #4
         ********************/
        System.out.println("\tTest Case #4");
        currentFuel = 1.0;
        currentLocation = 20;
        destination = 0;
        expResult = -1;
        result = instance.calculateFuelNeeded(currentFuel, currentLocation, destination);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("calculateFuelNeeded");
        /********************
         * Test case #5
         ********************/
        System.out.println("\tTest Case #5");
        currentFuel = 0.5;
        currentLocation = 20;
        destination = 25;
        expResult = -0.75;
        result = instance.calculateFuelNeeded(currentFuel, currentLocation, destination);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("calculateFuelNeeded");
        /********************
         * Test case #6
         ********************/
        System.out.println("\tTest Case #6");
        currentFuel = 1.0;
        currentLocation = 24;
        destination = 25;
        expResult = 0.75;
        result = instance.calculateO2Needed(currentFuel, currentLocation, destination);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("calculateFuelNeeded");
        /********************
         * Test case #7
         ********************/
        System.out.println("\tTest Case #7");
        currentFuel = 1.0;
        currentLocation = 2;
        destination = 1;
        expResult = 0.75;
        result = instance.calculateFuelNeeded(currentFuel, currentLocation, destination);
        assertEquals(expResult, result, 0.0);
    }
    

    /**
     * Test of packElevator method, of class InventoryControl.
     */
    @Test
    public void testPackElevator() {
        System.out.println("packElevator");
        /********************
         * Test case #1
         ********************/
        System.out.println("\tTest Case #1");
        int elevatorCapacity = 12000;
        int elevatorCapacityUsed = 6000;
        int noOfItems = 6;
        
        int expResult = 6000;
        
        InventoryControl instance = new InventoryControl();
        double result = instance.packElevator(elevatorCapacity, elevatorCapacityUsed, noOfItems);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("packElevator");
        /********************
         * Test case #2
         ********************/
        System.out.println("\tTest Case #2");
        elevatorCapacity = 12000;
        elevatorCapacityUsed = 11000;
        noOfItems = 11;
        
        expResult = 1000;
        
        result = instance.packElevator(elevatorCapacity, elevatorCapacityUsed, noOfItems);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("packElevator");
        /********************
         * Test case #3
         ********************/
        System.out.println("\tTest Case #3");
        elevatorCapacity = 12000;
        elevatorCapacityUsed = 0;
        noOfItems = 0;
        
        expResult = -1;
        
        result = instance.packElevator(elevatorCapacity, elevatorCapacityUsed, noOfItems);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("packElevator");
        /********************
         * Test case #4
         ********************/
        System.out.println("\tTest Case #4");
        elevatorCapacity = 12000;
        elevatorCapacityUsed = 16000;
        noOfItems = 16;
        
        expResult = -1;
        
        result = instance.packElevator(elevatorCapacity, elevatorCapacityUsed, noOfItems);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("packElevator");
        /********************
         * Test case #5
         ********************/
        System.out.println("\tTest Case #5");
        elevatorCapacity = 12000;
        elevatorCapacityUsed = 1000;
        noOfItems = 1;
        
        expResult = 11000;
        
        result = instance.packElevator(elevatorCapacity, elevatorCapacityUsed, noOfItems);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("packElevator");
        /********************
         * Test case #6
         ********************/
        System.out.println("\tTest Case #6");
        elevatorCapacity = 12000;
        elevatorCapacityUsed = 12000;
        noOfItems = 12;
        
        expResult = 0;
        
        result = instance.packElevator(elevatorCapacity, elevatorCapacityUsed, noOfItems);
        assertEquals(expResult, result, 0.0);

    }

    @Test
    public void testResourceInventory() {
        System.out.println("resourceInventory");
        InventoryControl instance = new InventoryControl();
        instance.resourceInventory();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAmountToManufacture() {
        System.out.println("getAmountToManufacture");
        String inventoryType = "";
        int quantityInStock = 0;
        InventoryControl instance = new InventoryControl();
        int expResult = 0;
        int result = instance.getAmountToManufacture(inventoryType, quantityInStock);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalculateIronNeededShip() {
        System.out.println("calculateIronNeededShip");
        double damageLevel = 0.0;
        int quantityInStock = 0;
        InventoryControl instance = new InventoryControl();
        double expResult = 0.0;
        double result = instance.calculateIronNeededShip(damageLevel, quantityInStock);
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalculateFuelNeededShip() {
        System.out.println("calculateFuelNeededShip");
        double fuelCapacity = 0.0;
        double fuelLevel = 0.0;
        int quantityInStock = 0;
        InventoryControl instance = new InventoryControl();
        double expResult = 0.0;
        double result = instance.calculateFuelNeededShip(fuelCapacity, fuelLevel, quantityInStock);
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCalculateAluminumNeededO2Tank() {
        System.out.println("calculateAluminumNeededO2Tank");
        String inventoryType = "";
        int quantityInStock = 0;
        InventoryControl instance = new InventoryControl();
        double expResult = 0.0;
        double result = instance.calculateAluminumNeededO2Tank(inventoryType, quantityInStock);
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetInventoryList() {
        System.out.println("getInventoryList");
        String inventoryType = "";
        int quantityInStock = 0;
        InventoryControl instance = new InventoryControl();
        String expResult = "";
        String result = instance.getInventoryList(inventoryType, quantityInStock);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddToInventory() {
        System.out.println("addToInventory");
        String inventoryType = "";
        int quantityInStock = 0;
        InventoryControl instance = new InventoryControl();
        int expResult = 0;
        int result = instance.addToInventory(inventoryType, quantityInStock);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemoveFromInventory() {
        System.out.println("removeFromInventory");
        String inventoryType = "";
        int quantityInStock = 0;
        InventoryControl instance = new InventoryControl();
        int expResult = 0;
        int result = instance.removeFromInventory(inventoryType, quantityInStock);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

  
}
