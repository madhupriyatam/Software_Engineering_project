/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pvmad
 */
public class sample {
      
    int maxDifference(int[] a) {
    int minimum, diff = -1;
    if(a.length == 0) {
        return -1;
    }
    minimum = a[0];
    for (int i = 1; i < a.length; i++) {
        diff = Math.max(diff, a[i] - minimum);
        minimum = Math.min(minimum, a[i]);
    }
    return diff;

}    
    public static void main(String[] args)  
    { 
        sample s = new sample(); 
        int arr[] = {2, 3, 10, 2, 4, 8, 1}; 
        System.out.println(s.maxDifference(arr)); 
    } 
} 
   
    
 