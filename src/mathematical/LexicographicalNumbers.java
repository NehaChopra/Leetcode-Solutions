package mathematical;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/contest/warm-up-contest/problems/lexicographical-numbers/

public class LexicographicalNumbers {
	public static void main(String[] args) {
		List<Integer> fResult = lexicoOrder(20);
		System.out.println(fResult);

	}

	public static List<Integer> lexicoOrder(int num) {
		List<Integer> fResult = new ArrayList<>();
		int cur = 1;
		for (int index = 1; index <= num; index++) {
			fResult.add(cur);
			if (cur * 10 <= num) {
				cur = cur * 10;
			} else if ((cur % 10 != 9) && (cur + 1 <= num)) {
				cur++;
			} else {
				while ((cur / 10) % 10 == 9) {
					cur /= 10;
				}
				cur = cur / 10 + 1;
			}
		}
		return fResult;
	}
}