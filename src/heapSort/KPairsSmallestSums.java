package heapSort;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

public class KPairsSmallestSums {
	public static void heapSort(int[] inputArray, List<List<Integer>> comb) {
		for (int index = inputArray.length / 2 - 1; index >= 0; index--) {
			heapify(index, inputArray.length, inputArray, comb);
		}

		for (int index = inputArray.length - 1; index >= 0; index--) {
			swap(0, index, inputArray, comb);
			heapify(0, index, inputArray, comb);
		}
	}

	public static void heapify(int index, int end, int[] inputArray, List<List<Integer>> comb) {
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
			swap(index, largest, inputArray, comb);
			heapify(largest, end, inputArray, comb);
		}
	}

	public static int leftChild(int index) {
		return ((2 * index) + 1);
	}

	public static int rightChild(int index) {
		return ((2 * index) + 2);
	}

	public static void swap(int iIndex, int jIndex, int[] inputArray, List<List<Integer>> comb) {
		int temp = inputArray[iIndex];
		inputArray[iIndex] = inputArray[jIndex];
		inputArray[jIndex] = temp;

		List<Integer> temp1 = comb.get(iIndex);
		comb.add(iIndex, inputArray[jIndex]);
		inputArray[jIndex] = temp;

	}

	public int[] topSmalledPair(int[] nums1, int[] nums2, int k) {
		int[] result = new int[k];
		List<List<Integer>> comb = new ArrayList<List<Integer>>();
		int fIndex = 0;
		int[] finalArray = new int[nums1.length * nums2.length];
		for (int index = 0; index < nums1.length; index++) {
			for (int jindex = 0; jindex < nums2.length; jindex++) {
				List<Integer> c = new ArrayList<Integer>();
				c.add(nums1[index]);
				c.add(nums2[jindex]);
				comb.add(c);
				finalArray[fIndex++] = nums1[index] + nums2[jindex];
			}
		}
		heapSort(finalArray, comb);
		for (int index = 0; index < k; index++) {
			result[index] = finalArray[index];
		}
		return result;
	}

	public static void main(String[] args) {

		int[] nums1 = new int[] { 1, 7, 11 };
		int[] nums2 = new int[] { 2, 4, 6 };
		int k = 1;
		KPairsSmallestSums ob = new KPairsSmallestSums();
		int[] arr1 = ob.topSmalledPair(nums1, nums2, k);
		for (int index = 0; index < arr1.length; index++) {
			System.out.println(arr1[index]);
		}

	}
}
