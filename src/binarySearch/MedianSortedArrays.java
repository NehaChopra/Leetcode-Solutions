package binarySearch;

//https://leetcode.com/problems/median-of-two-sorted-arrays/

public class MedianSortedArrays {
	public static void main(String[] args) {
		// int array1[] = {-5,3,6,12,15};
		// int array2[] = {-12,-10,-6,-3,4,10};

		// int array1[] = {2,3,5,8};
		// int array2[] = {10,12,14,16,18,20};

//		int array1[] = { 1, 12, 15, 26, 38 };
//		int array2[] = { 2, 13, 17, 30, 45 };

		int array1[] = { 1, 2 };
		int array2[] = { 3, 4 };
		
		int mergedArray[] = mergeSortedArrays(array1, array2, array1.length, array2.length);
		int len = mergedArray.length;
		if (mergedArray.length % 2 == 0) {
			System.out.println((mergedArray[len / 2] + mergedArray[len / 2 - 1]) / 2.0);
		} else {
			System.out.println((mergedArray[len / 2]));
		}
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int mergedArray[] = mergeSortedArrays(nums1, nums2, nums1.length, nums2.length);
		int len = mergedArray.length;
		if (mergedArray.length % 2 == 0) {
			return ((mergedArray[len / 2] + mergedArray[len / 2 - 1]) / 2.0);
		} else {
			return ((mergedArray[len / 2]));
		}
	}

	public static int[] mergeSortedArrays(int array1[], int array2[], int al1, int al2) {
		int len = al1 + al2;
		int mergedArray[] = new int[len];
		al1 = al1 - 1;
		al2 = al2 - 1;
		while (len > 0) {
			if (al1 < 0) {
				mergedArray[--len] = array2[al2--];
			} else if (al2 < 0) {
				mergedArray[--len] = array1[al1--];
			} else if (array1[al1] > array2[al2]) {
				mergedArray[--len] = array1[al1--];
			} else {
				mergedArray[--len] = array2[al2--];
			}
		}
		return mergedArray;
	}
}