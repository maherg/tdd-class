/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gamal Shaban OLC
 */
class NumberNames {

    public static String read(Integer digit){
        String number;
        switch(digit.toString().length()){
            case 1:{
                
            }
        }
        
        
        return "One";
    }
    
    private final static Map<Integer,String> oneDigitMap= new HashMap<>();
    
    private static String readOneDigit(Integer digit)throws Exception{
        if(digit.toString().length()>1){
            throw new Exception("Digits Length must be only one digit.");
        }
        oneDigitMap.put(1, "one");
        oneDigitMap.put(2, "two");
        
        
        return null;
    }
}
