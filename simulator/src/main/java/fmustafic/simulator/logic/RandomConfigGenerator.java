/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.logic;

import java.util.Random;

/**
 *
 * @author faruk
 */
public class RandomConfigGenerator { 
    
    public RandomConfigGenerator(int n) {
        this.n = n;
    }
    
    public Boolean[] getConfig() {
        Boolean[] config = new Boolean[n];
        Random randomGen = new Random();
        
        for(int i = 0; i < n; i++) {
            config[i] = randomGen.nextBoolean();
        }
        
        return config.clone();
    }
    
    public Boolean[] getConfigWithDensity(double density) {
        Random randomGen = new Random();
        
        int requiredOnCount = (int)(density * n);
        
        Boolean[] config = new Boolean[n];
        for(int i = 0; i < config.length; i++) {
            config[i] = false;
        }
        
        int soFarCount = 0;
        while(soFarCount != requiredOnCount) {
            int cellChoice = randomGen.nextInt(config.length);
            if(!config[cellChoice]) {
                config[cellChoice] = true;
                ++soFarCount;
            }
        }
        
        return config.clone();
    }
    
    private int n;
    
}
