/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author faruk
 */
public class AutomataSimulatorTest {
    
    public AutomataSimulatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSteps method, of class AutomataSimulator.
     */
    @Test
    public void testGetSteps() {
        System.out.println("getSteps");
        Boolean[] initialState = new Boolean[5];
        initialState[0] = false;
        initialState[1] = false;
        initialState[2] = true;
        initialState[3] = false;
        initialState[4] = false;
        
        AutomataSimulator instance = new AutomataSimulator(initialState, 5, 110);
        Boolean[][] expResult = null;
        Boolean[][] result = instance.getSteps();
        
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
        
        assertArrayEquals(expResult, result);
    }
    
}
