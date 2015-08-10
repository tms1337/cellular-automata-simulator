/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.gui;

import fmustafic.simulator.gui.guielements.EvolutionPanel;
import fmustafic.simulator.gui.guielements.NeighborhoodPanel;
import fmustafic.simulator.gui.guielements.NextStatePanel;
import fmustafic.simulator.logic.InitialConfigGenerator;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author faruk
 */
public class WolframAutomataFrame extends javax.swing.JFrame {

    /**
     * Creates new form WolframAutomataFrame
     */
    public WolframAutomataFrame() {
        initComponents();
        
        customInit();
        customComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSlider1 = new javax.swing.JSlider();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.white);
        setForeground(null);
        setPreferredSize(new java.awt.Dimension(625, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSlider1.setOrientation(javax.swing.JSlider.VERTICAL);
        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 278));

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setSelected(true);
        jRadioButton4.setText("middle black");
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("random");
        getContentPane().add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, -1));

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setText("middle white");
        getContentPane().add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        jButton1.setText("Stats");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 67, -1));

        jCheckBox1.setText("step-by-step");
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 610, -1, -1));

        jLabel1.setText("Rule picker");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, -1, -1));

        jTextField1.setText("110");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 650, 120, -1));

        jButton2.setText("Start");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 610, 70, -1));

        jButton3.setText("Load");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 650, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Boolean isShrinked = true;
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // toggle
        if(isShrinked) {
            this.setSize(
                    new Dimension(2 * this.getWidth(), this.getHeight())
            );
        } else {
            this.setSize(
                    new Dimension((int)(0.5 * this.getWidth()), this.getHeight())
            );
        }
        
        isShrinked = !isShrinked;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.updateNextStatePanels();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int n = 100;
        InitialConfigGenerator generator = new InitialConfigGenerator(n);
        Boolean[] initialConfig = generator.getConfig();
        
        EvolutionPanel evolutionPanel = new EvolutionPanel(initialConfig, 100, 500, 110);
        
        this.getContentPane().add(
                evolutionPanel, 
                new AbsoluteConstraints(new Point(75, 80))
        );
        
        this.pack();
        this.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WolframAutomataFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WolframAutomataFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WolframAutomataFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WolframAutomataFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WolframAutomataFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void customInit() {
        this.setPreferredSize(new Dimension(625, 800));
        this.setSize(new Dimension(625, 1000));
        
        this.getContentPane().setBackground(java.awt.Color.white);
    }
    
    private void customComponents() {
        int unitLength = this.getWidth() / 25;
        int yCoord = this.jLabel1.getY() + 50;
        int rule = Integer.parseInt(this.jTextField1.getText());
        
        for(int i = 0; i < 8; i++) {
            this.getContentPane().add(
                new NeighborhoodPanel((i >> 2) % 2 == 1, (i >> 1) % 2 == 1, i % 2 == 1, 2 * unitLength, unitLength / 2), 
                new AbsoluteConstraints(new Point(unitLength + i * (3 * unitLength), yCoord))
            );
        }
        
        this.updateNextStatePanels();
    }
    
    private NextStatePanel[] nextStatePanels = new NextStatePanel[8];
    
    private void updateNextStatePanels() {
        int unitLength = this.getWidth() / 25;
        int yCoord = this.jLabel1.getY() + 50;
        int rule = Integer.parseInt(this.jTextField1.getText());
        
        for(int i = 0; i < 8; i++) {
            if(this.nextStatePanels[i] != null) { // bacaus of initital adding
                this.getContentPane().remove(this.nextStatePanels[i]);
            }
        }
        
        for(int i = 0; i < 8; i++) {
            this.nextStatePanels[i] = new NextStatePanel((2 * unitLength) / 3, unitLength / 2, (rule >> (7 - i)) % 2 == 1);
            this.getContentPane().add(
                nextStatePanels[i],
                new AbsoluteConstraints(new Point(unitLength + (2 * unitLength) / 3 + i * (3 * unitLength), yCoord + unitLength / 2))
            );
        }
        
        this.pack();
    }
}