package solution;


/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * 
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 * 
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 */

public class NumArray {
	
	private int[] numArray;

	private int rangeBegin;
	private int rangeEnd;
	private int rangeSum;

	public NumArray(int[] nums) {
		numArray = nums;
	}

	void update(int i, int val) {
		if (i >= rangeBegin && i <= rangeEnd) {
			int orginNum = numArray[i];
			rangeSum = rangeSum - orginNum + val;
		}

		numArray[i] = val;

	}

	public int sumRange(int i, int j) {
		int sum = 0;
		if ((rangeBegin == 0 && rangeEnd == 0) || i >= rangeEnd
				|| j <= rangeBegin) {
			sum = rangesum(i, j);
		} else if (i >= rangeBegin && j >= rangeEnd) {
			if ((j - i) <= (i + j - rangeBegin - rangeEnd)) {
				sum = rangesum(i, j);
			} else {
				sum = rangeSum - rangesum(rangeBegin, i - 1)
						+ rangesum(rangeEnd + 1, j);
			}
		} else if (i <= rangeBegin && j <= rangeEnd) {
			if ((j - i) <= (rangeBegin + rangeEnd - i - j)) {
				sum = rangesum(i, j);
			} else {
				sum = rangeSum - rangesum(j + 1, rangeEnd)
						+ rangesum(i, rangeBegin - 1);
			}
		} else if (i <= rangeBegin && j >= rangeEnd) {
			sum = rangeSum + rangesum(i, rangeBegin - 1)
					+ rangesum(rangeEnd + 1, j);
		} else {
			if ((j - i) <= (rangeEnd - j + i - rangeBegin)) {
				sum = rangesum(i, j);
			} else {
				sum = rangeSum - rangesum(rangeBegin, i - 1)
						- rangesum(j + 1, rangeEnd);
			}
		}

		rangeBegin = i;
		rangeEnd = j;
		rangeSum = sum;
		return sum;
	}

	private int rangesum(int begin, int end) {
		if (begin > end)
			return 0;

		int sum = 0;
		for (int i = begin; i <= end; i++) {
			sum += numArray[i];
		}

		return sum;
	}
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 NumArray numArray = new NumArray(new int[]{1,2,3,4,5,6});
		System.out.println(numArray.sumRange(0, 5)); 
		 numArray.update(1, 10);
		 System.out.println(numArray.sumRange(1, 5)); 

	}

}

