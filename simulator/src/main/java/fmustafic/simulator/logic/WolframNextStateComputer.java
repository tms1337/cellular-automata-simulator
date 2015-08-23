/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.logic;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author faruk
 */
public class WolframNextStateComputer extends RecursiveTask<Boolean[]> {
    private final Boolean[] currentState;
    private final int rule;
    private final int from;
    private final int to;
    private static final int SIZE_TRESHOLD = 250;

    public WolframNextStateComputer(
        Boolean[] currentState, 
        int from,
        int to,
        int rule
    ) {
        this.currentState = currentState;
        this.from = from;
        this.to = to;
        this.rule = rule;
    }
    
    @Override
    protected Boolean[] compute() {
        System.out.println("from: " + this.from);
        System.out.println("to: " + this.to);
        if(this.to - this.from <= SIZE_TRESHOLD) {
            Boolean[] nextState = new Boolean[this.currentState.length];
            
            WolframRules rules = new WolframRules(this.rule);
            
            for(int i = from; i < to; i++) {
                int leftIndex
                    = (i - 1 < 0) ? (this.currentState.length - 1) : (i - 1);
                int rightIndex
                        = (i + 1 >= this.currentState.length) ? 0 : (i + 1);

                nextState[i] = rules.getNextState(
                    this.currentState[leftIndex],
                    this.currentState[i],
                    this.currentState[rightIndex]
                );
            }
            
            return nextState;
        } else {
            int stateSize = this.currentState.length;
            WolframNextStateComputer left = 
                new WolframNextStateComputer(
                    this.currentState,
                    this.from,
                    this.from + (this.to - this.from) / 2,
                    this.rule
            );
            
            WolframNextStateComputer right = 
                new WolframNextStateComputer(
                    this.currentState,
                    this.from + (this.to - this.from) / 2,
                    this.to,
                    this.rule
            );
            
            left.fork();
            Boolean[] rightResult = right.compute();
            Boolean[] leftResult = left.join();
            
            Boolean[] nextState = new Boolean[leftResult.length + rightResult.length];
            
            System.arraycopy(leftResult, 0, nextState, 0, leftResult.length);
            
            for(int i = leftResult.length; i < nextState.length; i++) {
                nextState[i] = rightResult[i - leftResult.length];
            }
            
            return nextState;
        }
    }
    
}
