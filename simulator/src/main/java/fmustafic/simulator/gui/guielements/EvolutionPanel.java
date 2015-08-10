/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.gui.guielements;

import fmustafic.simulator.gui.wguielements.InitialConfigurationSetterPanel;
import fmustafic.simulator.logic.AutomataSimulator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author faruk
 */
public class EvolutionPanel extends JPanel {
    
    public EvolutionPanel(Boolean[] initialConfig, int stepsRequired, int size, int rule) {
        this.setPreferredSize(new Dimension(size, size));
        this.setSize(new Dimension(size, size));
        
        this.states = new Boolean[stepsRequired][];
        
        this.states[0] = initialConfig;
        this.stepsRequired = stepsRequired;
        this.rule = rule;
        
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        int unitLength = this.getWidth() / this.states[0].length;
        
        AutomataSimulator simulator = 
                new AutomataSimulator(this.states[0], this.stepsRequired, this.rule);
        Boolean[][] evolutionSteps = simulator.getSteps();
        
        for(int i = 0; i < evolutionSteps.length; i++) {
            for(int j = 0; j < evolutionSteps[i].length; j++) {
                g.setColor(evolutionSteps[i][j] ? Color.BLACK : Color.WHITE);
                g.fillRect(j * unitLength, i * unitLength, unitLength, unitLength);
            }
        }
    }
    
    private Boolean[][] states;
    private int stepsRequired;
    private int rule;
    
}
