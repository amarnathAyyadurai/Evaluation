/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.auxo;

import libsvm.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author amarnath
 */
public class Challenge2 {

    BufferedReader fp = null;
    Vector<Double> vy = new Vector<Double>();
    Vector<svm_node[]> vx = new Vector<svm_node[]>();
    int max_index = 0;

    private static double atof(String s) {
        double d = Double.valueOf(s).doubleValue();
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            System.err.print("NaN or Infinity in input\n");
            System.exit(1);
        }
        return (d);
    }

    private static int atoi(String s) {
        return Integer.parseInt(s);
    }

    private void ReadDataIN(String path) throws FileNotFoundException, IOException {
        fp = new BufferedReader(new FileReader(path));
        int counter = 0;
        while (true) {
            String line = fp.readLine();
            if (line == null || counter > 5) {
                break;
            }

            String[] tokens = line.split(",");
            svm_node[] x = new svm_node[tokens.length-1];
            for (int j = 0; j < tokens.length-1; j++) {
                
                x[j] = new svm_node();
                String val = tokens[j];
                x[j].index = j;
                x[j].value = atof(val);
            }
            vx.addElement(x);
            vy.addElement(atof(tokens[tokens.length]));

            System.out.println("String :" + counter + ">> " + tokens.length);
            //System.out.println(vx.toString());
            counter++;
        }
    }

    public void StartProcess() throws IOException {
        ReadDataIN("/home/amarnath/Documents/auxo/classification/Twitter/Relative_labeling/sigma=500/Twitter-Relative-Sigma-500.data");
    }
}
