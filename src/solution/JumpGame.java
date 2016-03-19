package solution;


import java.util.ArrayList;
import java.util.List;

/**
 * 描述: Jump Game
 * 
 */

public class JumpGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(1);
		list.add(4);
//		System.out.println(new JumpGame().canJump(list));
		List<Integer> list2 = new ArrayList<Integer>();
		for(int i=25000;i>=1;i--){
			list2.add(i);
		}
		list2.add(1);
		list2.add(0);
		list2.add(0);
		
		System.out.println(new JumpGame().canJump(list2));
	}

	public boolean canJump(List<Integer> nums) {
		int size = nums.size();
		boolean[] can = new boolean[size];
		for (int i = 0; i < size; i++)
			can[i] = false;

		for (int i = size - 1; i >= 0; i--) {
			if (nums.get(i) >= size - 1 - i) {
				can[i] = true;

			} else {
				for (int j = size - 1; j > i; j--) {
					if (can[j] == true && nums.get(i) >= j - i) {
						can[i] = true;
						break;
					}
				}

			}
		}

		return can[0];
	}

	private boolean canJumpToNext(List<Integer> list, int beginIndex,
			int endIndex) {
		if (beginIndex == endIndex)
			return true;
		else {
			int num = list.get(beginIndex - 1);
			for (int i = 1; i <= num; i++) {
				if (canJumpToNext(list, beginIndex + i, endIndex))
					return true;
			}

			return false;
		}

	}

}
