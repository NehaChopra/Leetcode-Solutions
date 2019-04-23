package trie;

//https://leetcode.com/problems/implement-trie-prefix-tree/
/*
 * 1. Autocomplete
2. Spell checker
3. IP routing (Longest prefix matching)
4. T9 predictive text
5. Solving word games
 */
class TrieNode{
	TrieNode children[] = new TrieNode[26];
	boolean endOfWord;
	TrieNode(){
		for(int index=0; index<children.length; index++){
			this.children[index] = null;
		}
		this.endOfWord = false;
	}
}

class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
		TrieNode cwral = root;
		for(int index=0; index<word.length();index++){
			int elementIndex = word.charAt(index) - 'a';
			if(cwral.children[elementIndex] == null){
				cwral.children[elementIndex] = new TrieNode();
			}
			cwral = cwral.children[elementIndex];
		}
		cwral.endOfWord = true;        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
		TrieNode cwral = root;
		for(int index=0; index<word.length();index++){
			int elementIndex = word.charAt(index) - 'a';
			if(cwral.children[elementIndex] == null){
				return false;
			}
			cwral = cwral.children[elementIndex];
		}
		return (cwral!=null && cwral.endOfWord);        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cwral = root;
        for(int index=0; index<prefix.length();index++){
            int elementIndex = prefix.charAt(index) - 'a';
            if(cwral.children[elementIndex] == null){
				return false;
			}
            cwral = cwral.children[elementIndex];
        }
        return true;
    }
    
}


public class ImplementTrie {
    public static void main(String []args) {
    	Trie obj = new Trie();
    	obj.insert("apple");
    	System.out.println(obj.startsWith("app"));
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */