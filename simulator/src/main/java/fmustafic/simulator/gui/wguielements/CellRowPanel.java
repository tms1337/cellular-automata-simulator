package fmustafic.simulator.gui.wguielements;

import fmustafic.simulator.logic.wolframautomata.WolframCellRow;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;


public class CellRowPanel extends JPanel {
    
    private WolframCellRow cellStates;
    ArrayList<Boolean[]> allRows;
    private final int PANEL_WIDTH;
    private final int CELL_HEIGHT;
    
    public CellRowPanel(
            int width, 
            int cellHeight,
            int ruleEnumeration, 
            Boolean[] initialState
    ) {
        int cellCount = initialState.length;
        this.cellStates = new WolframCellRow(cellCount, ruleEnumeration);
        this.cellStates.setRowState(initialState);
        
        this.allRows = new ArrayList<>();
        this.allRows.add(initialState.clone());
        
        this.PANEL_WIDTH = width;
        this.CELL_HEIGHT = cellHeight;
    }
    
    public void evolve() {
        this.cellStates.evolveAll();
        this.allRows.add(this.cellStates.getRowState().clone());
        this.setPreferredSize(
                new Dimension(
                        this.PANEL_WIDTH, 
                        this.allRows.size() * this.CELL_HEIGHT
                )
        );
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int cellWidth = this.PANEL_WIDTH / this.allRows.get(0).length;
        int rowCount = this.allRows.size();
        for(int i = 0; i < rowCount; i++) {
            int currentY = i * this.CELL_HEIGHT;
            Boolean[] currentRow = this.allRows.get(i);
            int currentRowCount = currentRow.length;
            for(int j = 0; j < currentRowCount; j++) {
                g.setColor((currentRow[j]) ? Color.BLACK : Color.WHITE);
                g.fillRect(j * cellWidth, currentY, cellWidth, this.CELL_HEIGHT);
            }
        }
        
    }
    
}
