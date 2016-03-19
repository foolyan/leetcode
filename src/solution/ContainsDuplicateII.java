package solution;


import java.util.HashSet;
import java.util.Set;

/**
 * 描述: Contains Duplicate II
 * 
 */

public class ContainsDuplicateII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {

		Set<Integer> numSet = new HashSet<Integer>();

		for (int i = 0, j = 0; j < nums.length; j++) {
			if (j - i > k) {
				numSet.remove(nums[i]);
				i++;
			}

			if (!numSet.add(nums[j]))
				return true;
		}

		return false;
	}
}
