/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author pvmad
 */
public class google {
    public static int solution(String S, int K) {
        
        String result;
        
        int length = S.length( );
       // int count = StringUtils.countMatches("a.b.c.d", ".");
        int count1 = S.replace("-", "").length();
        
        int kal = count1 % K;
        int use = count1/K;
        if(kal == 0){
        String one = S.replace("-","");
        one.substring(0, use) ;
        
        }
        return count1;
        // write your code in Java SE 8
        
        
    }
    public static void main(String[] args){
    int val = solution("m-adhu", 2);
    
    System.out.println(val);
    }
}
