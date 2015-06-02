package fmustafic.simulator.logic.wolframautomata;

import fmustafic.simulator.logic.math.MathUtils;
import java.security.InvalidParameterException;

/**
 *
 * @author faruk
 */
public class WolframRules {
    
    private int ruleEnumeration;
    
    public WolframRules(int ruleEnumeration) {
        this.setRuleEnumeration(ruleEnumeration);
    }
    

    /**
     * @return the ruleEnumeration
     */
    public final int getRuleEnumeration() {
        return ruleEnumeration;
    }

    /**
     * @param ruleEnumeration the ruleEnumeration to set
     */
    public final void setRuleEnumeration(int ruleEnumeration) {
        if(ruleEnumeration < 0 || ruleEnumeration > 256) {
            throw new InvalidParameterException("Ruleset not in bounds.");
        } 
        
        this.ruleEnumeration = ruleEnumeration;
    }
    
    public final Boolean getNextState(
            Boolean left, 
            Boolean element, 
            Boolean right
    ) {
        return MathUtils.bitAt(
            this.getRuleEnumeration(), 
            MathUtils.parseBinary(new Boolean[] { left, element, right })
        );
    }
    
    public final Boolean getNextState(String neighborhood) {
        if(neighborhood.length() != 3) {
            throw new InvalidParameterException("Neighborhood != 3 cells.");
        }
        
        return MathUtils.bitAt(
            this.getRuleEnumeration(), 
            MathUtils.parseBinary(neighborhood)
        );
    }
    
    
}

