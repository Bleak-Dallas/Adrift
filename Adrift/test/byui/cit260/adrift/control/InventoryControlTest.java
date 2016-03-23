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

//    /**
//     * Test of calculateO2Needed method, of class InventoryControl.
//     */
//    @Test
//    public void testCalculateO2Needed() {
//        this.console.println("calculateO2Needed");
//        /********************
//         * Test case #1
//         ********************/
//        this.console.println("\tTest Case #1");
//        double currentO2 = 1.0;
//        int currentLocation = 25;
//        int destination = 22;
//        
//        double expResult = 0.25;
//        InventoryControl instance = new InventoryControl();
//        double result = instance.calculateO2Needed(currentO2, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        
//      
//        this.console.println("calculateO2Needed");
//        /********************
//         * Test case #2
//         ********************/
//        this.console.println("\tTest Case #2");
//        currentO2 = 1.0;
//        currentLocation = 1;
//        destination = 2;
//        expResult = 0.75;
//        result = instance.calculateO2Needed(currentO2, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("calculateO2Needed");
//        /********************
//         * Test case #3
//         ********************/
//        this.console.println("\tTest Case #3");
//        currentO2 = 1.0;
//        currentLocation = 1;
//        destination = 26;
//        expResult = -1;
//        result = instance.calculateO2Needed(currentO2, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("calculateO2Needed");
//        /********************
//         * Test case #4
//         ********************/
//        this.console.println("\tTest Case #4");
//        currentO2 = 1.0;
//        currentLocation = 20;
//        destination = 0;
//        expResult = -1;
//        result = instance.calculateO2Needed(currentO2, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("calculateO2Needed");
//        /********************
//         * Test case #5
//         ********************/
//        this.console.println("\tTest Case #5");
//        currentO2 = 0.5;
//        currentLocation = 20;
//        destination = 25;
//        expResult = -0.75;
//        result = instance.calculateO2Needed(currentO2, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("calculateO2Needed");
//        /********************
//         * Test case #6
//         ********************/
//        this.console.println("\tTest Case #6");
//        currentO2 = 1.0;
//        currentLocation = 24;
//        destination = 25;
//        expResult = 0.75;
//        result = instance.calculateO2Needed(currentO2, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("calculateO2Needed");
//        /********************
//         * Test case #7
//         ********************/
//        this.console.println("\tTest Case #7");
//        currentO2 = 1.0;
//        currentLocation = 2;
//        destination = 1;
//        expResult = 0.75;
//        result = instance.calculateO2Needed(currentO2, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//     /**
//     * Test of calculateCaloriesNeeded method, of class InventoryControl.
//     */
//    @Test
//    public void testCalculateCaloriesNeeded() {
//        this.console.println("calculateCaloriesNeeded");
//        /********************
//         * Test case #1
//         ********************/
//        this.console.println("\tTest Case #1");
//        double currentCalories = 50;
//        int currentLocation = 25;
//        int destination = 22;
//        
//        double expResult = 49.25;
//        InventoryControl instance = new InventoryControl();
//        double result = instance.calculateCaloriesNeeded(currentCalories, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        
//      
//        this.console.println("calculateCaloriesNeeded");
//        /********************
//         * Test case #2
//         ********************/
//        this.console.println("\tTest Case #2");
//        currentCalories = 50;
//        currentLocation = 1;
//        destination = 2;
//        expResult = 49.75;
//        result = instance.calculateO2Needed(currentCalories, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("calculateCaloriesNeeded");
//        /********************
//         * Test case #3
//         ********************/
//        this.console.println("\tTest Case #3");
//        currentCalories = 50;
//        currentLocation = 1;
//        destination = 26;
//        expResult = -1;
//        result = instance.calculateCaloriesNeeded(currentCalories, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("calculateCaloriesNeeded");
//        /********************
//         * Test case #4
//         ********************/
//        this.console.println("\tTest Case #4");
//        currentCalories = 50;
//        currentLocation = 20;
//        destination = 0;
//        expResult = -1;
//        result = instance.calculateCaloriesNeeded(currentCalories, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("calculateCaloriesNeeded");
//        /********************
//         * Test case #5
//         ********************/
//        this.console.println("\tTest Case #5");
//        currentCalories = 50;
//        currentLocation = 20;
//        destination = 0;
//        expResult = -1;
//        result = instance.calculateCaloriesNeeded(currentCalories, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("calculateCaloriesNeeded");
//        /********************
//         * Test case #6
//         ********************/
//        this.console.println("\tTest Case #6");
//        currentCalories = 50;
//        currentLocation = 24;
//        destination = 25;
//        expResult = 49.75;
//        result = instance.calculateCaloriesNeeded(currentCalories, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("calculateCaloriesNeeded");
//        /********************
//         * Test case #7
//         ********************/
//        this.console.println("\tTest Case #7");
//        currentCalories = 50;
//        currentLocation = 2;
//        destination = 1;
//        expResult = 49.75;
//        result = instance.calculateCaloriesNeeded(currentCalories, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//    }
//    /**
//     * Test of calculateO2Needed method, of class InventoryControl.
//     */
//    @Test
//    public void testCalculateFuelNeeded() {
//        this.console.println("calculateFuelNeeded");
//        /********************
//         * Test case #1
//         ********************/
//        this.console.println("\tTest Case #1");
//        double currentFuel = 1.0;
//        int currentLocation = 25;
//        int destination = 22;
//        
//        double expResult = 0.25;
//        InventoryControl instance = new InventoryControl();
//        double result = instance.calculateFuelNeeded(currentFuel, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        
//      
//        this.console.println("calculateFuelNeeded");
//        /********************
//         * Test case #2
//         ********************/
//        this.console.println("\tTest Case #2");
//        currentFuel = 1.0;
//        currentLocation = 1;
//        destination = 2;
//        expResult = 0.75;
//        result = instance.calculateFuelNeeded(currentFuel, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("calculateFuelNeeded");
//        /********************
//         * Test case #3
//         ********************/
//        this.console.println("\tTest Case #3");
//        currentFuel = 1.0;
//        currentLocation = 1;
//        destination = 26;
//        expResult = -1;
//        result = instance.calculateFuelNeeded(currentFuel, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("calculateFuelNeeded");
//        /********************
//         * Test case #4
//         ********************/
//        this.console.println("\tTest Case #4");
//        currentFuel = 1.0;
//        currentLocation = 20;
//        destination = 0;
//        expResult = -1;
//        result = instance.calculateFuelNeeded(currentFuel, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("calculateFuelNeeded");
//        /********************
//         * Test case #5
//         ********************/
//        this.console.println("\tTest Case #5");
//        currentFuel = 0.5;
//        currentLocation = 20;
//        destination = 25;
//        expResult = -0.75;
//        result = instance.calculateFuelNeeded(currentFuel, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("calculateFuelNeeded");
//        /********************
//         * Test case #6
//         ********************/
//        this.console.println("\tTest Case #6");
//        currentFuel = 1.0;
//        currentLocation = 24;
//        destination = 25;
//        expResult = 0.75;
//        result = instance.calculateO2Needed(currentFuel, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("calculateFuelNeeded");
//        /********************
//         * Test case #7
//         ********************/
//        this.console.println("\tTest Case #7");
//        currentFuel = 1.0;
//        currentLocation = 2;
//        destination = 1;
//        expResult = 0.75;
//        result = instance.calculateFuelNeeded(currentFuel, currentLocation, destination);
//        assertEquals(expResult, result, 0.0);
//    }
//    
//
//    /**
//     * Test of packElevator method, of class InventoryControl.
//     */
//    @Test
//    public void testPackElevator() {
//        this.console.println("packElevator");
//        /********************
//         * Test case #1
//         ********************/
//        this.console.println("\tTest Case #1");
//        int elevatorCapacity = 12000;
//        int elevatorCapacityUsed = 6000;
//        int noOfItems = 6;
//        
//        int expResult = 6000;
//        
//        InventoryControl instance = new InventoryControl();
//        double result = instance.packElevator(elevatorCapacity, elevatorCapacityUsed, noOfItems);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("packElevator");
//        /********************
//         * Test case #2
//         ********************/
//        this.console.println("\tTest Case #2");
//        elevatorCapacity = 12000;
//        elevatorCapacityUsed = 11000;
//        noOfItems = 11;
//        
//        expResult = 1000;
//        
//        result = instance.packElevator(elevatorCapacity, elevatorCapacityUsed, noOfItems);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("packElevator");
//        /********************
//         * Test case #3
//         ********************/
//        this.console.println("\tTest Case #3");
//        elevatorCapacity = 12000;
//        elevatorCapacityUsed = 0;
//        noOfItems = 0;
//        
//        expResult = -1;
//        
//        result = instance.packElevator(elevatorCapacity, elevatorCapacityUsed, noOfItems);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("packElevator");
//        /********************
//         * Test case #4
//         ********************/
//        this.console.println("\tTest Case #4");
//        elevatorCapacity = 12000;
//        elevatorCapacityUsed = 16000;
//        noOfItems = 16;
//        
//        expResult = -1;
//        
//        result = instance.packElevator(elevatorCapacity, elevatorCapacityUsed, noOfItems);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("packElevator");
//        /********************
//         * Test case #5
//         ********************/
//        this.console.println("\tTest Case #5");
//        elevatorCapacity = 12000;
//        elevatorCapacityUsed = 1000;
//        noOfItems = 1;
//        
//        expResult = 11000;
//        
//        result = instance.packElevator(elevatorCapacity, elevatorCapacityUsed, noOfItems);
//        assertEquals(expResult, result, 0.0);
//        
//        this.console.println("packElevator");
//        /********************
//         * Test case #6
//         ********************/
//        this.console.println("\tTest Case #6");
//        elevatorCapacity = 12000;
//        elevatorCapacityUsed = 12000;
//        noOfItems = 12;
//        
//        expResult = 0;
//        
//        result = instance.packElevator(elevatorCapacity, elevatorCapacityUsed, noOfItems);
//        assertEquals(expResult, result, 0.0);

    }

   
  
