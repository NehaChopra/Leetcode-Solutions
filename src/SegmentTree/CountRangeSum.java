package SegmentTree;

//https://leetcode.com/problems/count-of-range-sum/

public class CountRangeSum {
	public static int[] array;
	public static int arrayL;

	public static int getMid(int start, int end) {
		return (start + (end - start) / 2);
	}

	public static int constructSegmentArray(int inputArray[], int segStart, int segEnd, int segIndex) {
		if (segStart == segEnd) {
			array[segIndex] = inputArray[segStart];
			return inputArray[segStart];
		}
		int mid = getMid(segStart, segEnd);
		array[segIndex] = constructSegmentArray(inputArray, segStart, mid, (2 * segIndex) + 1)
				+ constructSegmentArray(inputArray, mid + 1, segEnd, (2 * segIndex) + 2);
		return array[segIndex];
	}

	public static int evaluateSum(int segStart, int segEnd, int quStart, int quEnd, int segIndex) {
		if (quStart <= segStart && quEnd >= segEnd) {
			return array[segIndex];
		}
		if (segEnd < quStart || segStart > quEnd) {
			return 0;
		}
		int mid = getMid(segStart, segEnd);
		return evaluateSum(segStart, mid, quStart, quEnd, (2 * segIndex) + 1)
				+ evaluateSum(mid + 1, segEnd, quStart, quEnd, (2 * segIndex) + 2);
	}

	public int countRangeSum(int[] inputArray, int lower, int upper) {
		if (inputArray.length > 1) {
			this.arrayL = 2 * (int) (Math.pow(2, ((int) Math.ceil(Math.log(inputArray.length) / Math.log(2)))) - 1);
			array = new int[arrayL];
			constructSegmentArray(inputArray, 0, inputArray.length - 1, 0);
			return evaluateSum(0, inputArray.length - 1, lower, upper, 0);
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] inputArray = new int[] { -2, 5, -1 };
		int lower = -2;
		int upper = 2;
		CountRangeSum cr = new CountRangeSum();
		System.out.println(cr.countRangeSum(inputArray, lower, upper));
	}

}