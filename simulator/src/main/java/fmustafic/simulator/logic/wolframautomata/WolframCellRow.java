/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.logic.wolframautomata;

import java.security.InvalidParameterException;

/**
 *
 * @author faruk
 */
public class WolframCellRow {
    
    private WolframRules rules;
    
    private Boolean[] rowState;
    
    public WolframCellRow(int size, int ruleEnumeration) {
        this.rowState = new Boolean[size];
        this.rules = new WolframRules(ruleEnumeration);
    }
    
    public Boolean[] getRowState() {
        return this.rowState;
    }
    
    public void setRowState(Boolean[] state) {
        if(state.length != this.rowState.length) {
            throw new 
                InvalidParameterException(  
                    "State length != " + this.rowState.length
                );
        }
        
        this.rowState = state;
    }
    
    public void setRowState(String state) {
        if(state.length() != this.rowState.length) {
            throw new 
                InvalidParameterException(  
                    "State length != " + this.rowState.length
                );
        }
        
        for(int i = 0; i < state.length(); i++) {
            char currentChar = state.charAt(i);
            if(currentChar != '0' && currentChar != '1') {
                throw new 
                    InvalidParameterException("State must be only 0s and 1s");
            }
            
            this.rowState[i] = (currentChar == '1');
        }
    }
    
    public void evolveAll() {
        for(int i = 0; i < this.rowState.length; i++) {
            this.evolveSpecific(i);
        }
    }
    
    public void evolveSpecific(int n) {
        if(n < 0 || n >= this.rowState.length) {
            throw new InvalidParameterException(
                    "n < 0 || n >= this.rowState.length."
            );
        }
        
        int leftIndex = 
                    (n - 1 < 0) ? (rowState.length - 1) : (n - 1);
        int rightIndex = 
                (n + 1 >= rowState.length) ? 0 : (n + 1);

        this.rowState[n] = this.rules.getNextState(
                this.rowState[leftIndex], 
                this.rowState[n], 
                this.rowState[rightIndex]
        );
    }
    
}