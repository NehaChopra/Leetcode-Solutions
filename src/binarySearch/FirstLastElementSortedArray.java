package binarySearch;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class FirstLastElementSortedArray {
	public static void main(String[] args) {
		// int array[] = new int[] { 5, 7, 7, 8, 8, 10 };
		// int target = 8;
		// int target = 6;
		// int target = 7;
		// int array[] = new int[] { 1};
		// int target = 1;
		// int array[] = new int[] { 2, 2 };
		// int target = 3;
		// int array[] = new int[] { 1, 3 };
		// int target = 1;
		// int array[] = new int[] { 2, 2 };
		// int target = 2;
		// int array[] = new int[] { 1, 2, 3 };
		// int target = 1;
		// int target = 2;
		// int target = 3;
		// int array[] = new int[] { 2, 2 };
		// int target = 1;
		int array[] = new int[] { 3, 3, 3 };
		int target = 3;
		int lowIndex = -1;
		int highIndex = -1;
		binarySearchElementIndex(array, 0, array.length - 1, target, lowIndex, highIndex);
		System.out.println(lowIndex + " " + highIndex);
	}

	public static void binarySearchElementIndex(int array[], int start, int end, int target, int lowIndex,
			int highIndex) {
		if (start <= end) {
			int midIndex = start + (end - start) / 2;
			if (array[midIndex] == target) {
				if (lowIndex == -1 || lowIndex > midIndex) {
					lowIndex = midIndex;
				}
				if (highIndex == -1 || highIndex < midIndex) {
					highIndex = midIndex;
				}
			} else if (array[midIndex] <= target) {
				return binarySearchElementIndex(array, midIndex + 1, end, target, lowIndex, highIndex);
			} else if (array[midIndex] >= target) {
				return binarySearchElementIndex(array, start, midIndex, target, lowIndex, highIndex);
			}
		}
	}
}