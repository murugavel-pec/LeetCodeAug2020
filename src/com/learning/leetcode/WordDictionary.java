package com.learning.leetcode;

class WordDictionary {
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
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length();i++){
        	char ch = word.charAt(i);
        	if(!node.containsKey(ch)){
        		node.put(ch, new TrieNode());
        	}
        	node = node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean recursiveSearch(TrieNode node, String word, int index){    	
    	if(index >= word.length()){
    		return node.isEnd();
    	}
    	char ch = word.charAt(index);    	    
    	if(ch == '.'){
    		for(int i=0;i<26;i++){
    			if(node.links[i]!= null && recursiveSearch(node.links[i], word, index+1)){
    				return true;
    			}
    		}
    	}else{
    		return recursiveSearch(node.get(ch), word, index+1);
    	}
    	return false;    	
    }  
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node = root;
    	return recursiveSearch(node, word, 0);
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	WordDictionary dict = new WordDictionary();
    	dict.addWord("hello");
    	dict.addWord("");
    	System.out.println(dict.search("hell."));

	}
}



