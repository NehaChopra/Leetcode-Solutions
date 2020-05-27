package bucketSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/rearrange-words-in-a-sentence/

public class RearrangeWords {
	public static void main(String[] args) {
		String words = "Leetcode is cool";
		// String words = "Keep calm and code on";
		// String words = "To be or not to be";
		RearrangeWords obj = new RearrangeWords();
		System.out.println(obj.rearrangeWords(words));
	}

	public String rearrangeWords(String text) {
		String[] words = text.toLowerCase().split(" ");
		int size = 0;
		Map<String, Integer> wordsMap = new LinkedHashMap<String, Integer>();
		for (int index = 0; index < words.length; index++) {
			wordsMap.put(words[index] + "_" + index, words[index].length());
			if (size < words[index].length()) {
				size = words[index].length();
			}
		}
		List<Object> wordList = bucketSort(wordsMap, size);
		List<String> fList = new ArrayList<>(wordList.size());
		for (int index = 0; index < wordList.size(); index++) {
			LinkedList<String> wordL = (LinkedList<String>) wordList.get(index);
			if (wordL != null) {
				for (String s : wordL) {
					fList.add(s.split("_")[0]);
				}
			}
		}
		StringBuilder sb = new StringBuilder(
				fList.get(0).substring(0, 1).toUpperCase() + "" + fList.get(0).substring(1, fList.get(0).length()))
						.append(" ");
		for (int index = 1; index < fList.size(); index++) {
			sb.append(fList.get(index)).append(" ");
		}
		return sb.toString().trim();
	}

	public List<Object> bucketSort(Map<String, Integer> wordsMap, int size) {
		List<Object> wordList = new ArrayList<Object>(Arrays.asList(new Object[size + 1]));
		for (Map.Entry<String, Integer> s : wordsMap.entrySet()) {
			if (wordList.size() > 0 && wordList.get(s.getValue()) != null) {
				LinkedList<String> wordL = (LinkedList<String>) wordList.get(s.getValue());
				wordL.add(s.getKey());
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
