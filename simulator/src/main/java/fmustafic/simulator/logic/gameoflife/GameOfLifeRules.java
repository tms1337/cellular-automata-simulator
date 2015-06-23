package fmustafic.simulator.logic.gameoflife;

// utils class

import fmustafic.simulator.logic.math.MathUtils;
import java.security.InvalidParameterException;


public class GameOfLifeRules {
    
    public static Boolean getNextState(int rulesetEnum, Boolean[] neighborhood) {
        if(neighborhood.length != 8) {
            throw new 
                InvalidParameterException("Neigh size bad. Must be 8.");
        } else if(GameOfLifeRules.isRulesetValid(rulesetEnum)) {
            throw new 
                InvalidParameterException("Bad rulesetEnum. Must be 0 - 2^8");
        }
        
        return 
            MathUtils.bitAt(rulesetEnum, MathUtils.parseBinary(neighborhood));
    }
    
    public static Boolean isRulesetValid(int rulesetEnum) {
        return rulesetEnum >= 0 && rulesetEnum < Math.pow(2.0, 8.0);
    }
    
}
