/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.logic.oned;

import fmustafic.simulator.logic.wolframautomata.WolframRules;
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
public class WolframRulesTest {
    
    public WolframRulesTest() {
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
     * Test of getNextState method, of class WolframRules.
     */
    @Test
    public void testGetNextState_3args_rule30() {
        System.out.println("getNextState");
        Boolean neighborhoods[] = new Boolean[] {
            true, true, true,
            true, true, false
        };
        
        Boolean expResults[] = new Boolean[] {
            false,
            false
        };
        
        WolframRules instance = new WolframRules(30);
        
        Boolean hasPassed = true;
        for(int i = 0; i < neighborhoods.length / 3; i++) {
            if(!instance.getNextState(
                    neighborhoods[3 * i],
                    neighborhoods[3 * i + 1],
                    neighborhoods[3 * i + 2]
                ).equals(expResults[i]) ) {
                hasPassed = false;
                break;
            }
        }
        
        assertTrue(hasPassed);
    }

    /**
     * Test of getNextState method, of class WolframRules.
     */
    @Test
    public void testGetNextState_String_rule30() {
        System.out.println("getNextState");
        String neighborhoods[] = new String[] { "111", "110", "100" };
        Boolean expResults[] = new Boolean[] { false, false, true };
        
        WolframRules instance = new WolframRules(30);

        Boolean hasPassed = true;
        
        for(int i = 0; i < neighborhoods.length; i++) {
            if(!instance.getNextState(neighborhoods[i]).equals(expResults[i])) {
                hasPassed = false;
                break;
            }
        }        
        
        assertTrue(hasPassed);
    }
    
    /**
     * Test of getNextState method, of class WolframRules.
     */
    @Test
    public void testGetNextState_3args_rule110() {
        System.out.println("getNextState");
        Boolean neighborhoods[] = new Boolean[] {
            true, true, true,
            true, true, false,
            false, true, false,
            true, false, false
        };
        
        Boolean expResults[] = new Boolean[] {
            false,
            true,
            true,
            false
        };
        
        WolframRules instance = new WolframRules(110);
        
        Boolean hasPassed = true;
        for(int i = 0; i < neighborhoods.length / 3; i++) {
            if(!instance.getNextState(
                    neighborhoods[3 * i],
                    neighborhoods[3 * i + 1],
                    neighborhoods[3 * i + 2]
                ).equals(expResults[i]) ) {
                hasPassed = false;
                break;
            }
        }
        
        assertTrue(hasPassed);
    }

    /**
     * Test of getNextState method, of class WolframRules.
     */
    @Test
    public void testGetNextState_String_rule110() {
        System.out.println("getNextState");
        String neighborhoods[] = new String[] { "111", "110", "100" };
        Boolean expResults[] = new Boolean[] { false, true, false };
        
        WolframRules instance = new WolframRules(110);

        Boolean hasPassed = true;
        
        for(int i = 0; i < neighborhoods.length; i++) {
            System.out.println(instance.getNextState(neighborhoods[i]));
            System.out.println(expResults[i]);
            if(!instance.getNextState(neighborhoods[i]).equals(expResults[i])) {
                hasPassed = false;
                break;
            }
        }        
        
        assertTrue(hasPassed);
    }
    
}
