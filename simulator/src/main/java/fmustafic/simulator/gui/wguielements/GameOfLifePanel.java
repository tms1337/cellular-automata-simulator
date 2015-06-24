package fmustafic.simulator.gui.wguielements;

import fmustafic.simulator.logic.gameoflife.GameOfLife;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GameOfLifePanel extends JPanel {
    
    private GameOfLife game;
    
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    
    
    public GameOfLifePanel(int gameSize, int width, int height) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        
        this.setPreferredSize(
                new Dimension(
                        this.PANEL_WIDTH, 
                        this.PANEL_HEIGHT
                )
        );
        
        this.game = new GameOfLife(gameSize);
    }
    
    public void evolve() {
        this.game.evolveAll();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        final int CELL_WIDTH = this.PANEL_WIDTH / this.game.getGameSize();
        final int CELL_HEIGHT = this.PANEL_HEIGHT / this.game.getGameSize();
        int gameSize = this.game.getGameSize();
        Boolean[][] currentGameState = this.game.getGameState();
        
        for(int i = 0; i < gameSize; i++) {
            for(int j = 0; j < gameSize; j++) {
                g.setColor((currentGameState[i][j]) ? Color.BLACK : Color.WHITE);
                g.fillRect(i * CELL_WIDTH, j * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
            }
        }
    }
    
}

