package com.learning.leetcode;

public class TrieNode {
	
	public TrieNode[] links;
	
	private final int R = 26;
	
	private boolean isEnd;
	
	TrieNode(){
		links = new TrieNode[R];
	}
	
	public void put(char ch, TrieNode node){
		links[ch-'a'] = node;
	}
	
	public boolean containsKey(char ch){
		return links[ch-'a'] != null;
	}
	
	public TrieNode get(char ch){
		return links[ch-'a'];
	}
	
	public boolean isEnd(){
		return isEnd;
	}
	
	public void setEnd(){
		isEnd = true;
	}

}
