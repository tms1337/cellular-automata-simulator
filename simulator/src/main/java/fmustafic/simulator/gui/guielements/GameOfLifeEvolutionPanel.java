/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.gui.guielements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class GameOfLifeEvolutionPanel extends JPanel {
    private final Boolean[][] states;
    
    public GameOfLifeEvolutionPanel(Boolean[][] states, int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setSize(new Dimension(width, height));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        // no check...
        this.states = new Boolean[states.length][];
        for(int i = 0; i < states.length; i++) {
            this.states[i] = states[i].clone();
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        // assuming equal lengths in states
        int unitWidth = this.getWidth()/ this.states[0].length;
        int unitHeight = this.getHeight() / this.states.length;
        
        System.out.println("height: " + this.getHeight());
        System.out.println("height length: " + this.states.length);
        System.out.println("width: " + this.getWidth());
        System.out.println("width length: " + this.states[0].length);
        
        System.out.println("uw, uh: " + unitWidth + " " + unitHeight);
        
        for(int i = 0; i < this.states.length; i++) {
            for(int j = 0; j < this.states[i].length; j++) {
                g.setColor(states[i][j] ? Color.BLACK : Color.WHITE);
                g.fillRect(j * unitWidth, i * unitHeight, unitWidth, unitHeight);
                
            }
        }
    }
    
}
