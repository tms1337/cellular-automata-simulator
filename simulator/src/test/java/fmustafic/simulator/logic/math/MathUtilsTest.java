/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.logic.math;

import com.sun.org.apache.xpath.internal.axes.WalkerFactory;
import java.security.InvalidParameterException;
import java.util.ArrayList;
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
public class MathUtilsTest {
    
    public MathUtilsTest() {
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
     * Test of isPowerOf4 method, of class MathUtils.
     */
    @Test
    public void testIsPowerOf4() {
        ArrayList<Boolean> expectedResults = new ArrayList<>();
        ArrayList<Boolean> actualResults = new ArrayList<>();
        
        // [0]
        expectedResults.add(true);
        actualResults.add(MathUtils.isPowerOf4(1));
        
        // [1]
        expectedResults.add(true);
        actualResults.add(MathUtils.isPowerOf4(4));
        
        // [2]
        expectedResults.add(false);
        actualResults.add(MathUtils.isPowerOf4(2));
        
        // [3]
        expectedResults.add(false);
        actualResults.add(MathUtils.isPowerOf4(3));
        
        // [4]
        expectedResults.add(false);
        actualResults.add(MathUtils.isPowerOf4(0));
        
        // [5]
        expectedResults.add(false);
        actualResults.add(MathUtils.isPowerOf4(-1));
        
        // [6]
        expectedResults.add(true);
        actualResults.add(MathUtils.isPowerOf4(16));
        
        // assertion
        assertArrayEquals(expectedResults.toArray(), actualResults.toArray());
    }
    
    @Test
    public void testBitAt_regular() {
        int ns[] = new int[] { 123123, 1, 2, 2 };
        int bitAts[] = new int[] { 3, 0, 1, 0 };
        Boolean expectedResults[] = new Boolean[] { false, true, true, false };
        
        Boolean hasPassed = true;
        for(int i = 0; i < ns.length; i++) {
            if(MathUtils.bitAt(ns[i], bitAts[i]) != expectedResults[i]) {
                hasPassed = false;
                break;
            }
        }
        
        assertTrue(hasPassed);
    }

    /**
     * Test of parseBinary method, of class MathUtils.
     */
    @Test
    public void testParseBinary_BooleanArr() {
        System.out.println("parseBinary");
        Boolean[] binaryArray = null;
        int expResult = 0;
        int result = MathUtils.parseBinary(binaryArray);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseBinary method, of class MathUtils.
     */
    @Test
    public void testParseBinary_String() {
        System.out.println("parseBinary");
        String binaryString = "100";
        int expResult = 4;
        int result = MathUtils.parseBinary(binaryString);
        assertEquals(expResult, result);
    }
    
}
