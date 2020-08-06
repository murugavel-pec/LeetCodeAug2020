package com.learning.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ArrayDuplicates {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] inputArray = {4,3,2,8,5,2,3,1};
		System.out.println(new DuplicateFinder().findDuplicates(inputArray));
	}

}

class DuplicateFinder {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
        	int temp = Math.abs(nums[i]);        	
        	if(nums[temp-1] < 0){
        		duplicates.add(-nums[temp-1]);
        	}
        		nums[temp-1] = -nums[temp-1];
        	
        }
        return duplicates;
    }
}


