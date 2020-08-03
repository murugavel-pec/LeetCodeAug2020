package com.learning.leetcode;

import java.util.Scanner;

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the string to verify valid palindrome");
		String str = new Scanner(System.in).nextLine();		
		System.out.println(new Solution1().isPalindrome(str));
	}
}

class Solution1 {
    public boolean isPalindrome(String s) {
    	s = s.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase().trim();    	
        boolean result = false;
        int i=0;
        int j = s.length()-1;        
        if(s.length() ==0){
        	return true;
        }else{
        	while(i<=j){
        		if(isValid(s.charAt(i))){
        			if(isValid(s.charAt(j))){
        				if(s.charAt(i) == s.charAt(j)){
        					result = true;
        					if(i!=j){
        						i++;
        						j--;
        						continue;
        					}else{
        						return true;
        					}
        					
        				}else{
        					return false;
        				}        				
        			}
        			j--;
        			continue;
        		}
        		i++;
        	}
        }        
        return result;
    }
    
    public boolean isValid(char c){
    	int ascii = (int)c;
    	if((ascii >= 97 && ascii <= 122) || (ascii >= 48 && ascii <= 57)){
    		return true;
    	}
    	return false;
    }
}


