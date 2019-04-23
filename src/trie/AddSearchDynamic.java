package trie;

//https://leetcode.com/problems/add-and-search-word-data-structure-design/submissions/
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

class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
       return matchWord(word,0,root);
    }
    
    public boolean matchWord(String word, int pos, TrieNode root){
    	if(root != null && root.endOfWord && pos == word.length()) {
    		return true;
    	}
    	if(pos >= word.length()) {
    		return false;
    	}
    	char ch = word.charAt(pos);
		if(ch == '.') {
			boolean result = false;
			for(int index=0; index<26; index++) {
				if(root.children[index] != null) {
					result = result || matchWord(word,pos+1,root.children[index]);
				}
			}
			return result;
		}else {
			int eIndex = ch - 'a';
			if(root.children[eIndex] == null) {
				return false;
			}
			return matchWord(word,pos+1,root.children[eIndex]);
		}
    }
}
public class AddSearchDynamic {
    public static void main(String []args) {
    	WordDictionary obj = new WordDictionary();
    	obj.addWord("bad");
    	obj.addWord("mad");
    	obj.addWord("dad");
    	System.out.println(obj.search("pad"));
    	System.out.println(obj.search(".a"));
    	System.out.println(obj.search("b.."));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */