package fmustafic.simulator.logic.gameoflife;

import java.security.InvalidParameterException;
import java.util.Random;

public class GameOfLife {
    
    private final int gameSize;
    private Boolean[][] gameState;
    
    private int rulesetEnum;
    
    public GameOfLife(int gameSize) {
        this.gameSize = gameSize;
        this.gameState = new Boolean[this.gameSize][this.gameSize];
        
        // default is random
        this.setAllRandom();
    }
    
    public int getGameSize() {
        return this.gameSize;
    }
    
    public Boolean[][] getGameState() {
        return this.gameState;
    }
    
    public void setAllRandom() {
        Random randGen = new Random();
        for(Boolean[] row : this.gameState) {
            for(Boolean cell : row) {
                cell = randGen.nextBoolean();
            }
        }
    }
    
    public void setMiddleBlack() {
        this.setAllWhite();
        
        this.gameState[gameSize / 2][gameSize / 2] = true;
    }
    
    public void setAllWhite() {
        for(Boolean[] row : this.gameState) {
            for(Boolean cell : row) {
                cell = false;
            }
        }
    }
    
    public void setAllBlack() {
        for(Boolean[] row : this.gameState) {
            for(Boolean cell : row) {
                cell = true;
            }
        }
    }
    
    public int getRuleset(int rulesetEnum) {
        return this.rulesetEnum;
    }
    
    public void setRuleset(int rulesetEnum) {
        if(!GameOfLifeRules.isRulesetValid(rulesetEnum)) {
            throw new 
                InvalidParameterException("Bad rulesetEnum. Must be 0 - 2^8");
        }
        
        this.rulesetEnum = rulesetEnum;
    }
    
    public void evolveSpecific(int rowIndex, int colIndex) {
        
    }
    
    public void evolveAll() {
        
    }
    
}
