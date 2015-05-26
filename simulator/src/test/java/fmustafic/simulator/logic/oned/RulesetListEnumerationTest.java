/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.logic.oned;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author faruk
 */
@RunWith(Parameterized.class)
public class RulesetListEnumerationTest {
    private ArrayList<Boolean> ruleset;
    
    private String binaryEncoding;
    private int expectedResult;
    
    @Parameterized.Parameters
    public static Collection primeNumbers() {
       return Arrays.asList(new Object[][] {
           { "00011110", 30 },
           { "01111110", 126 },
           { "00110110", 54 },
           { "10010110", 150 }
       });
    }
    
    public RulesetListEnumerationTest(String binaryEncoding, int expectedResult) {
        this.binaryEncoding = binaryEncoding;
        this.expectedResult = expectedResult;
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.ruleset = new ArrayList<Boolean>();
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of getRulesetEnum method, of class Ruleset.
     */
    @Test
    public void testGetRulesetEnum() {        
        for(int i = 0; i < this.binaryEncoding.length(); i++) {
            if(this.binaryEncoding.charAt(i) == '0') {
                this.ruleset.add(false);
            } else {
                this.ruleset.add(true);
            }
        }
        
        int rulesetEnumeration = Ruleset.getRulesetEnum(ruleset);
        assertEquals(rulesetEnumeration, this.expectedResult);
    }
    
}
