/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.logic;

/**
 *
 * @author faruk
 */
public class AutomataSimulator {

    public AutomataSimulator(Boolean[] state, int stepsRequired, int rule) {
        this.initialState = state;
        this.stepsRequired = stepsRequired;
        this.rule = rule;
    }

    public Boolean[][] getSteps() {
        Boolean[][] stepsResult = new Boolean[this.stepsRequired][initialState.length];
        stepsResult[0] = this.initialState;
        
        WolframCellRow ruleLogic = 
                new WolframCellRow(this.initialState.length, this.rule);
        
        for(int i = 1; i < stepsResult.length; i++) {
            ruleLogic.setRowState(stepsResult[i - 1]);
            ruleLogic.evolveAll();
            stepsResult[i] = ruleLogic.getRowState();
        }
        
        return stepsResult.clone();
    }
    
    private Boolean[] initialState;
    private int stepsRequired;
    private int rule;
    
}