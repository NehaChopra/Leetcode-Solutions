package array;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class FirstLastPositionElement {
	public static void main(String[] args) {
		int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
		int[] arr = new int[] { -1, -1 };
		Integer low = Integer.MAX_VALUE;
		Integer lar = Integer.MIN_VALUE;
		arr = searchRange(nums, 8, 0, nums.length, low, lar, arr);
		System.out.println(arr[0] + " " + arr[1]);
	}

	public static int[] searchRange(int[] nums, int target, int start, int end, Integer low, Integer lar, int[] arr) {
		if (start <= end) {
			int midIndex = start + (end - start) / 2;
			if (nums[midIndex] == target) {
				if (low > midIndex) {
					low = midIndex;
					arr[0] = low;
				}
				if (lar < midIndex) {
					lar = midIndex;
					arr[1] = lar;
				}
			}
			if (nums[midIndex] > target) {
				searchRange(nums, target, start, midIndex - 1, low, lar, arr);
			} else {
				searchRange(nums, target, midIndex + 1, end, low, lar, arr);
			}
		}
		return arr;
	}

}
