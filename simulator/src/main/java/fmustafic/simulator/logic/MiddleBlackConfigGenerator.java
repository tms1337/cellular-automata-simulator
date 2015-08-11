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
public class MiddleBlackConfigGenerator { 
    
    public MiddleBlackConfigGenerator(int n) {
        this.n = n;
    }
    
    public Boolean[] getConfig() {
        Boolean[] config = new Boolean[n];
        Random randomGen = new Random();
        
        for(int i = 0; i < n; i++) {
            config[i] = (i == n / 2);
        }
        
        return config.clone();
    }
    
    private int n;
    
}
