package com.learning.leetcode;

import java.util.HashMap;

class MyHashSet {
	
	private HashMap map;
	private static final Object PRESENT = new Object();

    /** Initialize your data structure here. */
    public MyHashSet() {
        map = new HashMap<>();
    }
    
    public void add(int key) {
        map.put(key, PRESENT);
    }
    
    public void remove(int key) {
        map.remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return map.containsKey(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

public class HashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashSet obj = new MyHashSet();
		obj.add(1);
		obj.add(1);
		obj.remove(1);
		System.out.println(obj.contains(1));
		obj.remove(1);
		System.out.println(obj.contains(1));

	}

}
