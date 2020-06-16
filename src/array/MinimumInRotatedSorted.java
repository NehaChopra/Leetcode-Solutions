package array;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class MinimumInRotatedSorted {
	public static void main(String[] args) {
		int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		// int[] nums = new int[] { 3, 4, 5, 1, 2 };
		// int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		// int[] nums = new int[] { 1 };
		// int[] nums = new int[] { 1, 2 };
		// int[] nums = new int[] { 1, 2, 3 };
		// int[] nums = new int[] { 1, 2, 3, 4 };
		// int[] nums = new int[] { 4, 3, 2, 1 };
		// int[] nums = new int[] { 3, 2, 1 };
		// int[] nums = new int[] { 2, 1 };
		// int[] nums = new int[] { 2, 3, 4, 5, 1 };
		// int[] nums = new int[] { 5, 1, 2, 3, 4 };
		System.out.println(findMin(nums));
	}

	public static int findMin(int[] num) {
		if (num.length == 0) {
			return 0;
		}
		if (num.length == 1) {
			return num[0];
		}
		int start = 0, end = num.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (mid > 0 && num[mid] < num[mid - 1]) {
				return num[mid];
			}
			if (num[start] <= num[mid] && num[mid] > num[end]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return num[start];
	}
}
