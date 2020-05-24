package trie;

//https://leetcode.com/problems/camelcase-matching/
class TrieNode {
	TrieNode children[] = new TrieNode[26];
	boolean endOfWord;
	char ch;

	TrieNode() {
		for (int index = 0; index < children.length; index++) {
			this.children[index] = null;
		}
		this.endOfWord = false;
	}
}

class WordDictionary {
	TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode cwral = root;
		for (int index = 0; index < word.length(); index++) {
			int elementIndex = word.charAt(index) - 'a';
			if (elementIndex < 0) {
				elementIndex = word.charAt(index) - 'A';
			}
			if (cwral.children[elementIndex] == null) {
				cwral.children[elementIndex] = new TrieNode();
				cwral.children[elementIndex].ch = word.charAt(index);
			}
			cwral = cwral.children[elementIndex];
		}
		cwral.endOfWord = true;
	}

	public boolean searchCamelCastMatch(String word) {
		TrieNode cwral = root;
		for (int index = 0; index < word.length(); index++) {
			int elementIndex = word.charAt(index) - 'a';
			if (elementIndex < 0) {
				elementIndex = word.charAt(index) - 'A';
				if (cwral.children[elementIndex] == null) {
					return false;
				} else {
					cwral = cwral.children[elementIndex];
				}
			} else {
				if (cwral.children[elementIndex] != null && cwral.children[elementIndex].ch == word.charAt(index)) {
					cwral = cwral.children[elementIndex];
				}
			}
		}
		return (cwral != null && cwral.endOfWord);
	}

}

public class CamelcaseMatching {
	public static void main(String[] args) {
		// String pattern = "FB";
		// WordDictionary obj = new WordDictionary();
		// obj.addWord(pattern);
		//
		// System.out.println(obj.searchCamelCastMatch("FooBar"));
		// System.out.println(obj.searchCamelCastMatch("FooBarTest"));
		// System.out.println(obj.searchCamelCastMatch("FootBall"));
		// System.out.println(obj.searchCamelCastMatch("FrameBuffer"));
		// System.out.println(obj.searchCamelCastMatch("ForceFeedBack"));

		// String pattern = "FoBa";
		// WordDictionary obj = new WordDictionary();
		// obj.addWord(pattern);
		//
		// System.out.println(obj.searchCamelCastMatch("FooBar"));
		// System.out.println(obj.searchCamelCastMatch("FooBarTest"));
		// System.out.println(obj.searchCamelCastMatch("FootBall"));
		// System.out.println(obj.searchCamelCastMatch("FrameBuffer"));
		// System.out.println(obj.searchCamelCastMatch("ForceFeedBack"));

		// String pattern = "FoBaT";
		// WordDictionary obj = new WordDictionary();
		// obj.addWord(pattern);
		//
		// System.out.println(obj.searchCamelCastMatch("FooBar"));
		// System.out.println(obj.searchCamelCastMatch("FooBarTest"));
		// System.out.println(obj.searchCamelCastMatch("FootBall"));
		// System.out.println(obj.searchCamelCastMatch("FrameBuffer"));
		// System.out.println(obj.searchCamelCastMatch("ForceFeedBack"));

		String pattern = "CP";
		WordDictionary obj = new WordDictionary();
		obj.addWord(pattern);

		System.out.println(obj.searchCamelCastMatch("CompetitiveProgramming"));
		System.out.println(obj.searchCamelCastMatch("CounterPick"));
		System.out.println(obj.searchCamelCastMatch("ControlPanel"));

	}
}
