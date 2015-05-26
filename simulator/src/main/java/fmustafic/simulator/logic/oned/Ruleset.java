/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.logic.oned;

import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 *
 * @author faruk
 */
public class Ruleset {
    public static int getRulesetEnum(ArrayList<Boolean> ruleset) {
        int rulesetSize = ruleset.size();
        
        // size constraint check
        if((rulesetSize & (rulesetSize - 1)) != 0) {
            throw new InvalidParameterException("Ruleset size must be power of 2.");
        }
        
        int enumeration = 0;
        for(int i = 0; i < ruleset.size(); i++) {
            if(ruleset.get(rulesetSize - 1 - i)) {
                enumeration += Math.pow(2.0, i);
            }
        }
        
        return enumeration;
    } 
    
    public static ArrayList<Boolean> getRuleset(int enumeration, int radius) {
        if(enumeration > Math.pow(2.0, radius)) {
            throw new InvalidParameterException("Enumeration > 2 ^ radius.");
        }
        
        ArrayList<Boolean> ruleset = new ArrayList<>();
        for(int i = 0; i < 2 * radius; i++) {
            ruleset.add(enumeration % 2 == 1);
            enumeration = enumeration << 1;
        }
        
        return ruleset;
    }
    
    public Boolean getNextState(
            ArrayList<Boolean> ruleset, 
            ArrayList<Boolean> neighborhood
    ) {
        
        return null;
    }
    
    public Boolean getNextState(int ruleset, ArrayList<Boolean> neighborhood) {
        
        return null;
    }
}

