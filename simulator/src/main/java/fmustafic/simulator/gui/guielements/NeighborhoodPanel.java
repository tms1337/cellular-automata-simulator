/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.gui.guielements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author faruk
 */
public class NeighborhoodPanel extends JPanel {
    
    private Boolean left, middle, right;
    
    public NeighborhoodPanel(String neighborhood, int width, int height) {
        
    }
    
    public NeighborhoodPanel(
        Boolean left, Boolean middle, Boolean right, int width, int height
    ) {
        init(left, middle, right, width, height);
    }

    private void init(Boolean left, Boolean middle, Boolean right, int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        
        this.left = left;
        this.middle = middle;
        this.right = right;
        
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    @Override
    public void paintComponent(Graphics g) {  
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(1));
        
        g2.setColor(left ? Color.BLACK : Color.WHITE);
        g2.fillRect(0, 0, this.getWidth() / 3, this.getHeight());
        
        // slash
        g2.setColor(Color.BLACK);
        g2.drawRect(0, 0, this.getWidth() / 3, this.getHeight());
        
        g2.setColor(middle ? Color.BLACK : Color.WHITE);
        g2.fillRect(this.getWidth() / 3, 0, this.getWidth() / 3, this.getHeight());
        
        // slash
        g2.setColor(Color.BLACK);
        g2.drawRect(this.getWidth() / 3, 0, this.getWidth() / 3, this.getHeight());
        
        g2.setColor(right ? Color.BLACK : Color.WHITE);
        g2.fillRect(2 * this.getWidth() / 3, 0, this.getWidth() / 3, this.getHeight());
        
        // slash
        g2.setColor(Color.BLACK);
        g2.drawRect(2 * this.getWidth() / 3, 0, this.getWidth() / 3, this.getHeight());
    }
    
}
