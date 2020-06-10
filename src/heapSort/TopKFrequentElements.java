package heapSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/top-k-frequent-elements/

public class TopKFrequentElements {
	public static void heapSort(Integer[] inputArray, Integer[] inputArray1) {
		for (int index = inputArray.length / 2 - 1; index >= 0; index--) {
			heapify(index, inputArray.length, inputArray, inputArray1);
		}

		for (int index = inputArray.length - 1; index >= 0; index--) {
			swap(0, index, inputArray, inputArray1);
			heapify(0, index, inputArray, inputArray1);
		}
	}

	public static void heapify(Integer index, Integer end, Integer[] inputArray, Integer[] inputArray1) {
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
			swap(index, largest, inputArray, inputArray1);
			heapify(largest, end, inputArray, inputArray1);
		}
	}

	public static int leftChild(Integer index) {
		return ((2 * index) + 1);
	}

	public static int rightChild(Integer index) {
		return ((2 * index) + 2);
	}

	public static void swap(Integer iIndex, Integer jIndex, Integer[] inputArray, Integer[] inputArray1) {
		int temp = inputArray[iIndex];
		inputArray[iIndex] = inputArray[jIndex];
		inputArray[jIndex] = temp;

		int temp1 = inputArray1[iIndex];
		inputArray1[iIndex] = inputArray1[jIndex];
		inputArray1[jIndex] = temp1;
	}

	public int[] topKFrequent(int[] nums, int k) {
		List<Integer> elements = new ArrayList<Integer>();
		Map<Integer, List<Integer>> mapList = new HashMap<Integer, List<Integer>>();
		Map<Integer, Integer> fele = new HashMap<Integer, Integer>();
		for (int index = 0; index < nums.length; index++) {
			if (fele.containsKey(nums[index])) {
				fele.put(nums[index], fele.get(nums[index]) + 1);
			} else {
				fele.put(nums[index], 1);
			}
		}

		Integer[] valuesSets = (Integer[]) fele.values().stream().toArray(Integer[]::new);
		Integer[] keysSets = (Integer[]) fele.keySet().stream().toArray(Integer[]::new);
		heapSort(valuesSets, keysSets);

		int greThan = valuesSets[valuesSets.length - k];
		for (int index = valuesSets.length - 1; index >= 0; index--) {
			if (valuesSets[index] < greThan) {
				break;
			}
			elements.add(keysSets[index]);
		}
		return (int[]) elements.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		// int[] arr = new int[] { 3, 2, 1, 5, 6, 4 };
		// int k = 2;

		// int[] arr = new int[] { 1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 5, 5, 5 };
		// int k = 2;

		int[] arr = new int[] { 1 };
		int k = 1;
		TopKFrequentElements ob = new TopKFrequentElements();
		int[] arr1 = ob.topKFrequent(arr, k);
		for (int index = 0; index < arr1.length; index++) {
			System.out.println(arr1[index]);
		}

	}
}
