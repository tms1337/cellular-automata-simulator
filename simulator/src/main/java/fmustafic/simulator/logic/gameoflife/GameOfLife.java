package fmustafic.simulator.logic.gameoflife;

import java.security.InvalidParameterException;
import java.util.Random;

public class GameOfLife {
    
    private final int gameSize;
    private Boolean[][] gameState;
    
    private int rulesetEnum;
    
    public GameOfLife(int gameSize) {
        this.gameSize = gameSize;
        this.gameState = new Boolean[this.gameSize][];
        for(int i = 0; i < this.gameSize; i++) {
            this.gameState[i] = new Boolean[this.gameSize];
        }
        
        // default is random
        this.setAllRandom();
    }
    
    public int getGameSize() {
        return this.gameSize;
    }
    
    public Boolean[][] getGameState() {
        return this.gameState.clone();
    }
    
    public void setAllRandom() {
        Random randGen = new Random();
        for(int i = 0; i < this.gameSize; i++) {
            for(int j = 0; j < this.gameSize; j++) {
                this.gameState[i][j] = randGen.nextBoolean();
            }
        }
    }
    
    public void setMiddleBlack() {
        this.setAllWhite();
        
        this.gameState[gameSize / 2][gameSize / 2] = true;
    }
    
    public void setAllWhite() {
        for(int i = 0; i < this.gameSize; i++) {
            for(int j = 0; j < this.gameSize; j++) {
                this.gameState[i][j] = false;
            }
        }
    }
    
    public void setAllBlack() {
        for(int i = 0; i < this.gameSize; i++) {
            for(int j = 0; j < this.gameSize; j++) {
                this.gameState[i][j] = true;
            }
        }
    }
    
    public void evolveAll() {
        Boolean[][] oldGameState = new Boolean[gameSize][];
        for(int i = 0; i < this.gameSize; i++) {
            oldGameState[i] = this.gameState[i].clone();
        }
        for(int rowIndex = 0; rowIndex < this.gameSize; rowIndex++) {
            for(int colIndex = 0; colIndex < this.gameSize; colIndex++) {
                int rowAbove = (rowIndex - 1 < 0) ? this.gameSize - 1 : rowIndex - 1;
                int rowBellow = (rowIndex + 1 >= this.gameSize) ? 0 : rowIndex + 1;

                int colLeft = (colIndex - 1 < 0) ? this.gameSize - 1 : colIndex - 1;
                int colRight = (colIndex + 1 >= this.gameSize) ? 0 : colIndex + 1;

                Boolean currCellState =  oldGameState[rowAbove][colLeft];
                
                Boolean[] neighborhood = new Boolean[] {
                    oldGameState[rowAbove][colLeft], 
                    oldGameState[rowAbove][colIndex], 
                    oldGameState[rowAbove][colRight], 
                    oldGameState[rowIndex][colLeft],
                    //oldGameState[rowIndex][colIndex],
                    oldGameState[rowIndex][colRight], 
                    oldGameState[rowBellow][colLeft], 
                    oldGameState[rowBellow][colIndex], 
                    oldGameState[rowBellow][colRight]            
                };
                
                int neighLiveCount = 0;
                for(Boolean cell : neighborhood) {
                    if(cell) {
                        ++neighLiveCount;
                    }
                }
                
                // can be logically reduced
                if(currCellState && neighLiveCount < 2) {
                    this.gameState[rowIndex][colIndex] = false;
                } else if(currCellState && neighLiveCount < 4) {
                    this.gameState[rowIndex][colIndex] = true;
                } else if(currCellState && neighLiveCount >= 4) {
                    this.gameState[rowIndex][colIndex] = false;
                } else if(!currCellState && neighLiveCount == 3) {
                    this.gameState[rowIndex][colIndex] = true;
                } else {
                    this.gameState[rowIndex][colIndex] = false;
                }
            }
        }
    }
    
}
