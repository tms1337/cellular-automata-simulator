package fmustafic.simulator.gui.wguielements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.InvalidParameterException;
import java.util.Random;
import javax.swing.JPanel;

public class InitialConfigurationSetterPanel extends JPanel {
    
    private static final Boolean INITIAL_CELL_STATE = false;
    
    private Boolean[] state;
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    
    public InitialConfigurationSetterPanel(int width, int height, int cellCount) {
        super();
        
        if(width < 0) {
            throw new InvalidParameterException("Width < 0.");
        } else if(height < 0) {
            throw new InvalidParameterException("Height < 0.");
        } else if(cellCount <= 0) {
            throw new InvalidParameterException("Cell count <= 0.");
        }
        
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        
        this.state = new Boolean[cellCount];
        
        this.setAllRandom();
        
        this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    int mouseX = e.getX();
                    int stateSize = state.length;
                    int cellWidth = PANEL_WIDTH / stateSize;
                    state[mouseX / cellWidth] = !state[mouseX / cellWidth];
                    
                    repaint();
                }
            });
    }
    
    public void setAllBlack() {
        int stateSize = this.state.length;
        for(int i = 0; i < stateSize; i++) {
            this.state[i] = true;
        }
        
        this.repaint();
    }
    
    public void setAllWhite() {
        int stateSize = this.state.length;
        for(int i = 0; i < stateSize; i++) {
            this.state[i] = false;
        }
        
        this.repaint();
    }
    
    public void setAllRandom() {
        Random rand = new Random();
        int stateSize = this.state.length;
        for(int i = 0; i < stateSize; i++) {
            this.state[i] = rand.nextBoolean();
        }
        
        this.repaint();
    }
    
    public void setMiddleBlack() {
        int stateSize = this.state.length;
        for(int i = 0; i < stateSize; i++) {
            this.state[i] = (i == stateSize / 2);
        }
    }
    
    public Boolean[] getState() {
        return this.state;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int stateSize = this.state.length;
        int cellWidth = this.PANEL_WIDTH / stateSize;
        int cellHeight = this.PANEL_HEIGHT;
        for(int i = 0; i < stateSize; i++) {
            g.setColor( (this.state[i]) ? Color.BLACK : Color.WHITE );
            g.fillRect(i * cellWidth, 0, cellWidth, cellHeight);
        }
    }


    
    
}
