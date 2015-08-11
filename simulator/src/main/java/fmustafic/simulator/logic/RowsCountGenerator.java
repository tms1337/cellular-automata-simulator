/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.logic;

public class RowsCountGenerator {
    
    public RowsCountGenerator(Boolean[][] states) {
        this.states = states;
    }
    
    public double[][] getDataSet() {
        double[][] dataSet = new double[2][];
        dataSet[0] = new double[this.states.length];
        dataSet[1] = new double[this.states.length];
        
        for(int i = 0; i < this.states.length; i++) {
            int onCount = 0;
            int offCount = 0;
            
            for(int j = 0; j < this.states[i].length; j++) {
                if(this.states[i][j]) {
                    ++onCount;
                } else {
                    ++offCount;
                }
            }
            
            dataSet[0][i] = onCount;
            dataSet[1][i] = offCount;
        }
        
        return dataSet;
    }
    
    private Boolean[][] states;
    
}
