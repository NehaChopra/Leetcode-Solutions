package array;

//https://leetcode.com/problems/find-the-duplicate-number/
/*
 * Floyd's cycle finding algorithm (tortoise and hare) to find the cycle (duplicate value in array)
 */

public class DuplicateNumber {
	public static void main(String[] args) {
		// int[] nums = new int[] { 1, 3, 4, 2, 2 };
		// int[] nums = new int[] { 3, 1, 3, 4, 2 };
		int[] nums = new int[] { 2, 2, 2, 2, 2 };
		System.out.println(findDuplicate(nums));
	}

	public static int findDuplicate(int[] nums) {
		int samNoL = 0;
		int n = nums.length - 1;
		for (int index = 0; index < nums.length - 1; index++) {
			if (nums[index] == nums[index + 1]) {
				samNoL = samNoL + 1;
			}
		}
		if (samNoL == n) {
			return nums[0];
		}
		int cSum = 0;
		int aSum = (n * (n + 1)) / 2;
		for (int no : nums) {
			cSum = cSum + no;
		}
		return (cSum - aSum);
	}
}
