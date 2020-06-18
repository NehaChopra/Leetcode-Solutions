package array;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

public class MaximumProductTwoElements {
	public static void main(String[] args) {
		// int[] nums = new int[] { 3, 4, 5, 2 };
		// int[] nums = new int[] { 1, 5, 4, 5 };
		int[] nums = new int[] { 3, 7 };
		System.out.println(findMaxProduct(nums));
	}

	public static void heap(int[] inputArray) {
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

	public static int findMaxProduct(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		if (array.length == 1) {
			return (array[0] - 1);
		}
		heap(array);
		return (array[array.length - 1] - 1) * (array[array.length - 2] - 1);
	}
}
