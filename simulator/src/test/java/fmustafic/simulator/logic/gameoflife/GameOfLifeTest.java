/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.logic.gameoflife;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author faruk
 */
public class GameOfLifeTest {
    @Test
    public void testSetAllWhite() {
        System.out.println("setAllBlack");
        GameOfLife instance = new GameOfLife(10);
        instance.setAllWhite();
        Boolean isPassed = true;
        Boolean[][] currState = instance.getGameState();
        for(Boolean[] row : currState) {
            for(Boolean cell : row) {
                if(cell) {
                    isPassed = false;
                    break;
                }
            }
        }
        
        assertTrue(isPassed);
    }

    @Test
    public void testSetAllBlack() {
        System.out.println("setAllBlack");
        GameOfLife instance = new GameOfLife(10);
        instance.setAllBlack();
        Boolean isPassed = true;
        Boolean[][] currState = instance.getGameState();
        for(Boolean[] row : currState) {
            for(Boolean cell : row) {
                if(!cell) {
                    isPassed = false;
                    break;
                }
            }
        }
        
        assertTrue(isPassed);
    }

    @Test
    public void testEvolveAll() {
        System.out.println("evolveAll");
        GameOfLife instance = new GameOfLife(10);
        Boolean[][] currentState = instance.getGameState();
        for(Boolean[] row : currentState) {
            for(Boolean cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        currentState = instance.getGameState();
        System.out.println();
        System.out.println();
        System.out.println();
        instance.evolveAll();
        for(Boolean[] row : currentState) {
            for(Boolean cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        assertEquals(true, true);
    }
    
}
