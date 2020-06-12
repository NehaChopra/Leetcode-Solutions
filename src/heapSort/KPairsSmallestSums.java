package heapSort;

// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

public class KPairsSmallestSums {
	public static void heapSort(int[] inputArray) {
		for (int index = inputArray.length / 2 - 1; index >= 0; index--) {
			heapify(index, inputArray.length, inputArray);
		}

		for (int index = inputArray.length - 1; index >= 0; index--) {
			swap(0, index, inputArray);
			heapify(0, index, inputArray);
		}
	}

	public static void heapify(int index, int end, int[] inputArray) {
		int largest = index;
		int left = leftChild(index);
		int right = rightChild(index);
		if (left < end && inputArray[left] > inputArray[largest]) {
			largest = left;
		}
		if (right < end && inputArray[right] > inputArray[largest]) {
			largest = right;
		}
		if (largest != index) {
			swap(index, largest, inputArray);
			heapify(largest, end, inputArray);
		}
	}

	public static int leftChild(int index) {
		return ((2 * index) + 1);
	}

	public static int rightChild(int index) {
		return ((2 * index) + 2);
	}

	public static void swap(int iIndex, int jIndex, int[] inputArray) {
		int temp = inputArray[iIndex];
		inputArray[iIndex] = inputArray[jIndex];
		inputArray[jIndex] = temp;
	}

	public int[] topSmalledPair(int[] nums1, int[] nums2, int k) {
		int[] finalArray = new int[nums1.length * nums2.length];
		for (int index = 0; index < nums1.length; index++) {
			for (int jindex = 0; jindex < nums2.length; jindex++) {
				finalArray[2 * index + jindex] = nums1[index] + nums2[jindex];
			}
		}
		heapSort(finalArray);
	}
}
