/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.gui.guielements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class StatsPanel extends JPanel {
    
    public StatsPanel(double[][] dataSet, int width, int height, Color defaultColor) {
        this.dataSet = dataSet;
        
        this.defaultColors = new Color[2];
        this.defaultColors[0] = defaultColor;
        this.defaultColors[1] = Color.RED;
        
        this.setSize(new Dimension(
                (int)(Math.ceil(width / dataSet[0].length) * dataSet[0].length), 
                height)
        );
        this.setPreferredSize(new Dimension(
                (int)(Math.ceil(width / dataSet[0].length) * dataSet[0].length), 
                height)
        );
        
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        this.setBackground(Color.BLACK);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        // first one determines the others 
        int unitLength = this.getWidth() / this.dataSet[0].length;
        
        double maxValue = 0;
        for (double[] dataSet1 : this.dataSet) {
            for (int j = 0; j < dataSet1.length; j++) {
                if (dataSet1[j] > maxValue) {
                    maxValue = dataSet1[j];
                }
            }
        }
        
        paintLabels(g, maxValue);
        
        int i = 0;
        for (double[] dataSet1 : this.dataSet) {
            int prevX = -1;
            int prevY = -1;
            for (int j = 0; j < dataSet1.length; j++) {
                int currX = j * unitLength;
                int currY = this.getHeight() - (int) (0.9 * (dataSet1[j] / maxValue) * this.getHeight());
                
                g.setColor(this.defaultColors[i]);
                
                g.drawRect(
                    currX, 
                    currY, 
                    1, 
                    1
                );
                
                if(prevX != -1 && prevY != -1) {
                    g.drawLine(prevX, prevY, currX, currY);
                }
                
                prevX = currX;
                prevY = currY;
            }
            ++i;
        }
    }
    
    private void paintLabels(Graphics g, double maxValue) {
        int style = Font.PLAIN;
        g.setFont(new Font("Dialog", style, 12));
        g.setColor(this.defaultColors[0]);
        
        g.drawString(Double.toString( (int)(maxValue * 100) / 100.0 ), 0, 10);
    }
    
    private double[][] dataSet;
    private static final int X_OFFSET = 50;
    private static final int Y_OFFSET = 50;
    private Color[] defaultColors;
    
}
