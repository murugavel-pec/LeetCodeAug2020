package com.learning.leetcode;

import java.util.Scanner;

public class DetectCapital {

	public static void main(String[] args) {
		String testStr = "hEFllo";
		testStr= new Scanner(System.in).next();
		System.out.println(new Solution().detectCapitalUse(testStr));

	}

}

class Solution {
	public boolean detectCapitalUse(String word) {
		boolean result = false;
		boolean startsWithLower = false;
		int i = 0;
		if (Character.isLowerCase(word.charAt(i))) {
			startsWithLower = true;
			i++;
		} else {
			i++;
		}
		if (word.length() > 1) {
			if (startsWithLower) {
				while (i < word.length()) {
					if (!Character.isLowerCase(word.charAt(i))) {
						result = false;
						break;
					}
					result = true;
					i++;
				}
			} else {
				boolean secondChar = Character.isUpperCase(word.charAt(i));
				//i++;
				if (secondChar) {
					while (i < word.length()) {
						if (!Character.isUpperCase(word.charAt(i))) {
							result = false;
							break;
						}
						result = true;
						i++;
					} 
				} else {
					while (i < word.length()) {
						if (!Character.isLowerCase(word.charAt(i))) {
							result = false;
							break;
						}
						result = true;
						i++;
					} 
				}

			}
		}
		else{
			result = true;
		}
		return result;
	}
}
