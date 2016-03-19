package solution;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;


/**
 * 描述: 
 *
 */

public class TwoSum {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {54,32,1,43,11,65,39,77,12,21,33};
//		int[] nums = {0,4,3,0};
		int[] indexs = new TwoSum().twoSum(nums, 0);
//		System.out.println(indexs[0] + " " + indexs[1]);

	}
	
	public int[] twoSum(int[] numbers, int target) {		
		
		List<Vector<Integer>> list = new ArrayList<Vector<Integer>>();
		for (int i = 0; i < numbers.length; i++) {
			Vector<Integer> v = new Vector<Integer>();  // 第一个值为number，第二个值为number的索引
			v.add(numbers[i]);
			v.add(i);
			
			list.add(v);
		}
		Collections.sort(list, VECTOR_COMPARATOR);  // 升序排序
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).get(0) + " " + list.get(i).get(1));
		}
		for (int i = 0; i < list.size(); i++) {
			int index =  locateNum(list, i + 1, numbers.length - 1, target - list.get(i).get(0));
			
			if (index != -1){
				if(list.get(i).get(1) < index)
					return new int[] { list.get(i).get(1) + 1, index + 1 };
				else
					return new int[] { index + 1 ,list.get(i).get(1) + 1};
					
			}
				
		}
		return new int[] { 0, 0 };
	}

	private int locateNum(List<Vector<Integer>> numbers, int begin, int end, int targetNum) {
		if (begin > end || (begin == end && numbers.get(begin).get(0) != targetNum))
			return -1;

		int middle = (begin + end) / 2;
		if (numbers.get(middle).get(0) == targetNum)
			return numbers.get(middle).get(1);
		else if (numbers.get(middle).get(0) < targetNum)
			return locateNum(numbers, middle + 1, end, targetNum);
		else
			return locateNum(numbers, begin, middle - 1, targetNum);
	}

	public static final Comparator<Vector<Integer>> VECTOR_COMPARATOR = new Comparator<Vector<Integer>>() {
		@Override
		public int compare(Vector<Integer> v1, Vector<Integer> v2) {

			return Integer.valueOf(v1.get(1)) - Integer.valueOf(v2.get(1)) ;
		}
	};
		 
//	public int[] twoSum(int[] numbers, int target) {
//		for (int i = 0; i < numbers.length && numbers[i] < target; i++) {
//			for (int j = i + 1; j < numbers.length && numbers[j] < target; j++) {
//				if (numbers[i] + numbers[j] == target)
//					return new int[] { i + 1, j + 1 };
//			}
//		}
//
//		return new int[] { 0, 0 };
//	}


}
