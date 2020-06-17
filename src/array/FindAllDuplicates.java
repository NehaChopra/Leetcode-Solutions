package array;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-duplicates-in-an-array/

public class FindAllDuplicates {
	public static void main(String[] args) {
		int[] nums = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> arr = findDuplicates(nums);
		arr.forEach(System.out::println);
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

	public static List<Integer> findDuplicates(int[] array) {
		List<Integer> fr = new ArrayList<>();
		heap(array);
		for (int index = 0; index < array.length - 1; index++) {
			if (array[index] == array[index + 1]) {
				fr.add(array[index]);
			}

		}
		return fr;
	}
}
