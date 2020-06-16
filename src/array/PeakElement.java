package array;

// https://leetcode.com/problems/find-peak-element/

public class PeakElement {
	public static void main(String[] args) {
		// int[] nums = new int[] { 1, 2, 3, 1 };
		// int[] nums = new int[] { 1, 2, 1, 3, 5, 6, 4 };
		// int[] nums = new int[] { 2, 1 };
		int[] nums = new int[] { 1, 2 };
		System.out.println(peakBinarySearch(nums, 0, nums.length - 1));
	}

	public static int peakBinarySearch(int[] array, int start, int end) {
		if (start <= end) {
			if (array.length == 0 || array.length == 1) {
				return 0;
			}
			int midIndex = start + (end - start) / 2;
			if (midIndex == 0 && (array[midIndex] > array[midIndex + 1])) {
				return midIndex;
			}
			if ((midIndex == array.length - 1) && (array[midIndex] > array[midIndex - 1])) {
				return midIndex;
			}
			if (midIndex > 0 && midIndex < array.length - 1 && (array[midIndex - 1] < array[midIndex])
					&& (array[midIndex] > array[midIndex + 1])) {
				return midIndex;
			}
			if (array[midIndex] < array[midIndex + 1]) {
				return peakBinarySearch(array, midIndex + 1, end);
			} else {
				return peakBinarySearch(array, start, midIndex - 1);
			}
		}
		return -1;
	}

}
