package array;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicatesSortedArray {
	public static void main(String[] args) {
		// int[] nums = new int[] { 1, 1, 2 };
		int[] nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		System.out.println(removeDuplicate(nums));
	}

	public static int removeDuplicate(int[] array) {
		int finalLength = 0;
		int i = 1;
		for (int index = 0; index < array.length - 1; index++) {
			if (array[index] != array[index + 1]) {
				array[i] = array[index + 1];
				i++;
				finalLength = finalLength + 1;
			}

		}
		return finalLength + 1;
	}

}
