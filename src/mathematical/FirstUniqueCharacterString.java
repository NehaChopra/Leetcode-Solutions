package mathematical;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//https://leetcode.com/contest/warm-up-contest/problems/first-unique-character-in-a-string/

public class FirstUniqueCharacterString {
	public static void main(String[] args) {
		System.out.println(uniqueChar("leetcode"));
		System.out.println(uniqueChar("loveleetcode"));

	}

	public static int uniqueChar(String str) {
		Map<Character, Integer> chMap = new LinkedHashMap<Character, Integer>();
		Map<Character, Integer> indexMap = new HashMap<Character, Integer>();
		for (int index = 0; index < str.length(); index++) {
			char ch = str.charAt(index);
			if (chMap.containsKey(ch)) {
				chMap.put(ch, 1 + chMap.get(ch));
			} else {
				chMap.put(ch, 1);
				indexMap.put(ch, index);
			}
		}
		int position = -1;
		for (Map.Entry<Character, Integer> m : chMap.entrySet()) {
			if (m.getValue() == 1) {
				position = indexMap.get(m.getKey());
				break;
			}
		}
		return position;
	}
}