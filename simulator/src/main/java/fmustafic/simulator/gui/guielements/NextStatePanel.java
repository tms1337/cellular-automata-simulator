/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.gui.guielements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author faruk
 */
public class NextStatePanel extends JPanel implements MouseListener {
    
    Boolean currentState;
    
    public NextStatePanel(int width, int height, Boolean initialState) {
        this.currentState = initialState;
        
        this.setPreferredSize(new Dimension(width, height));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        this.addMouseListener(this);
    }
    
    public Boolean getCurrentState() {
        return this.currentState;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(currentState ? Color.BLACK : Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.currentState = !this.currentState;
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
