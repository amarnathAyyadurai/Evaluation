/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.auxo;

/**
 *
 * @author amarnath
 */
public class Challenge1 {
    public static int howManyCharacters(String first,String second){
        int output = 0;
        
        for (int i = 0 ; i < first.length() ; i++){
            char x = first.charAt(i);
            int x_out = second.indexOf(x);
            
            if(x_out == -1)
                output++;
            
          // System.out.println(x+" "+x_out);
        }
        for (int i = 0 ; i < second.length() ; i++){
           char y = second.charAt(i);
           int y_out = first.indexOf(y);
           if(y_out == -1)
                output++;
            
           //System.out.println(y+" "+y_out);
        }
        
        System.out.println("First String: "+first);
        System.out.println("Second String: "+second);
        
        return output;
    }
}
