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
public class MiddleColRatioGenerator {
    
    public MiddleColRatioGenerator(Boolean[][] states) {
        this.states = states;
    }
    
    public double[][] getDataSet() {
        double[][] dataSet = new double[1][];
        dataSet[0] = new double[this.states.length];
        
        int onCount = 0;
        for(int i = 0; i < this.states.length; i++) {
            if(this.states[i][this.states[i].length / 2]) {
                ++onCount;
            }
            
            dataSet[0][i] = (double)(onCount) / (i + 1);
        }
        
        return dataSet;
    }
    
    private Boolean[][] states;
    
}
