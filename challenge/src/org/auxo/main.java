/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.auxo;

import java.awt.List;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author amarnath
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Challenge2 classifier = new Challenge2();
        
        runChallengeOne();   
        
        try {
            classifier.StartProcess();
        } catch (IOException ex) {
            
            ex.printStackTrace();
            //Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private static void runChallengeOne(){
        
        System.out.println("Delete Characters in 1 & 2:"+Challenge1.howManyCharacters("adbzcxy", "abcg")+"\n");
        
        System.out.println("Delete Characters in 1 & 2:"+Challenge1.howManyCharacters("abc", "cde")+"\n");
        
        System.out.println("Delete Characters in 1 & 2:"+Challenge1.howManyCharacters("abc", "cab")+"\n");
        
        System.out.println("Delete Characters in 1 & 2:"+Challenge1.howManyCharacters("abc", "cnb")+"\n");
        
    }
    
}
