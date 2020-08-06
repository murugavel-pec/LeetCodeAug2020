package com.learning.leetcode;

public class Trie {
	
	private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    public TrieNode searchKey(String word){
    	TrieNode node = root;
    	for(int i=0;i<word.length();i++){
    		char ch = word.charAt(i);
    		if(node.containsKey(ch)){
    			node = node.get(ch);
    		}else{
    			return null;
    		}
    	}
    	return node;
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode node = searchKey(word);
        return node != null && node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode node = searchKey(prefix);
        return node != null;
    }
    
    public boolean modifiedSearch(String word){
    	TrieNode node = root;
    	return recursiveSearch(node, word, 0);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.insert("hello");
		trie.insert("dell");
		System.out.println(trie.search("hell"));
		System.out.println(trie.searchKey("hello"));
		System.out.println(trie.startsWith("hell"));
		System.out.println(trie.startsWith("dell"));
		System.out.println(trie.modifiedSearch(".e.."));
		
	}

}
