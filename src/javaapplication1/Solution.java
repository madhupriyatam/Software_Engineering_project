/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author pvmad
 */
public class Solution {
    
    public static void main(String[] args){
        List<String> words = Arrays.asList("foo", "abc", "sup");
        String query = "fg.";
        
        System.out.println(isMember(words, query));
    }
    
     public static boolean isMember(List<String> words, String query) {
         boolean result = false;
         if(query.indexOf(".") >= 0){
         //query has joker
         
         //iterate through the string
           for(String v: words)
             {
                
              int count = 0;
              for(int j = 0;j<v.length();j++)
              {
                  char sec = v.charAt(j);
      //         for(int i = 0;i<query.length();i++)
    //     {
             
             char s = query.charAt(j);
              System.out.println(s + " " + sec);
              if(s == '.'){
                 count++;
                // break;
                   }
                 else if(s == sec){
                     
                     count++;
                 }
                 else if(s != sec){
                 count--;
                //  System.out.println("s");
              // break;
                 }
        // }
              
              }
              
              if(count  == v.length()){
                  result = true;
                  break;
              }
             }
           
           
      
         //iterate through each word
         
         }
         else{
         //query no joker
         
         if(words.contains(query)){
         result = true;
         }
         else{
         result = false;
         }
         }
         
         
         return result;
    }

}
