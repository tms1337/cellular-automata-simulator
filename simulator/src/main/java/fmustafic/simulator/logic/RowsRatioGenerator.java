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
public class RowsRatioGenerator {
    
    public RowsRatioGenerator(Boolean[][] states) {
        this.states = states;
    }
    
    public double[][] getDataSet() {
        double[][] dataSet = new double[1][];
        dataSet[0] = new double[this.states.length];
        
        for(int i = 0; i < this.states.length; i++) {
            System.out.println("ctor " + (this.states[i] == null));
            int onCount = 0;
            for(int j = 0; j < this.states[i].length; j++) {
                if(this.states[i][j]) {
                    ++onCount;
                }
            }
            
            dataSet[0][i] = (double)(onCount) / this.states[i].length;
        }
        
        return dataSet;
    }
    
    private Boolean[][] states;
    
}
