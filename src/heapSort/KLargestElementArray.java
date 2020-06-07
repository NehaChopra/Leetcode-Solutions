package heapSort;

// https://leetcode.com/problems/kth-largest-element-in-an-array/

public class KLargestElementArray {
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

	public int findKthLargest(int[] nums, int k) {
		heapSort(nums);
		return nums[nums.length - k];
	}

	public static void main(String[] args) {
		// int[] arr = new int[] { 3, 2, 1, 5, 6, 4 };
		// int k = 2;

		int[] arr = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 4;
		KLargestElementArray ob = new KLargestElementArray();
		System.out.println(ob.findKthLargest(arr, k));

	}
}
