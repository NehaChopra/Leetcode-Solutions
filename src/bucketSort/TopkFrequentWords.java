package bucketSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/top-k-frequent-words/

public class TopkFrequentWords {
	public static void main(String[] args) {
		String[] words = new String[] { "i", "love", "leetcode", "i", "love", "coding" };
		int k = 2;
		// String[] words = new String[] { "the", "day", "is", "sunny", "the", "the",
		// "the", "sunny", "is", "is" };
		// String[] words = new String[] { "the", "day", "is", "sunny", "the", "the",
		// "the", "sunny", "is", "is" };
		// int k = 4;
		TopkFrequentWords obj = new TopkFrequentWords();
		System.out.println(obj.topKFrequent(words, k));
	}

	public List<String> topKFrequent(String[] words, int k) {
		int size = 0;
		Map<String, Integer> wordsMap = new HashMap<String, Integer>();
		for (int index = 0; index < words.length; index++) {
			if (wordsMap.containsKey(words[index])) {
				int inc = wordsMap.get(words[index]) + 1;
				wordsMap.put(words[index], inc);
				if (size < inc) {
					size = inc;
				}
			} else {
				wordsMap.put(words[index], 1);
			}
		}
		List<Object> wordList = bucketSort(wordsMap, size);
		List<String> fList = new ArrayList<String>(k);
		for (int index = wordList.size() - 1; index > 0; index--) {
			LinkedList<String> wordL = (LinkedList<String>) wordList.get(index);
			if(wordL !=null) {
				for (String s : wordL) {
					fList.add(s);
				}
			}
		}
		return fList.subList(0, k);
	}

	public List<Object> bucketSort(Map<String, Integer> wordsMap, int size) {
		int fsize = (size < wordsMap.size()) ? wordsMap.size() : size;
		List<Object> wordList = new ArrayList<Object>(Arrays.asList(new Object[fsize + 1]));
		for (Map.Entry<String, Integer> s : wordsMap.entrySet()) {
			if (wordList.size() > 0 && wordList.get(s.getValue()) != null) {
				LinkedList<String> wordL = (LinkedList<String>) wordList.get(s.getValue());
				wordL.add(s.getKey());
				Collections.sort(wordL);
				wordList.set(s.getValue(), wordL);
			} else {
				LinkedList<String> wordL = new LinkedList<String>();
				wordL.add(s.getKey());
				wordList.set(s.getValue(), wordL);
			}
		}
		return wordList;

	}

}
