/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmustafic.simulator.logic.math;

import java.security.InvalidParameterException;

/**
 *
 * @author faruk
 */
public class MathUtils {
    public static Boolean isPowerOf4(int n) {
        if(n <= 0) {
            return false;
        }
        
        while(n >= 4) {
            n /= 4;
        }
        
        return n == 1;
    }    
    
    public static Boolean bitAt(int n, int bitPosition) {
        for(int i = 0; i < bitPosition; i++) {
            n = n >> 1;
        }
        
        return (n % 2 == 1);
    }
    
    public static int parseBinary(Boolean[] binaryArray) {
        int integerResult = 0;
        int arraySize = binaryArray.length;
        for(int i = arraySize - 1; i >= 0; i--) {
            integerResult += 
                    (binaryArray[i]) ? Math.pow(2.0, arraySize - 1 - i) : 0;
        }
        
        return integerResult;
    }
    
    public static int parseBinary(String binaryString) {
        int integerResult = 0;
        int stringLength = binaryString.length();
        for(int i = stringLength - 1; i >= 0; i--) {
            char currentChar = binaryString.charAt(i);
            if(currentChar != '0' && currentChar != '1') {
                throw new InvalidParameterException("Must be 0s and 1s only.");
            }
            integerResult += 
                    (currentChar == '1') ? 
                        Math.pow(2.0, stringLength - 1 - i) : 
                        0;
        }
        
        return integerResult;
    }
}
