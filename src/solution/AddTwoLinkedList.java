package solution;


import java.math.BigInteger;

/**
 * 描述: 两个linkList相加
 * 
 */

public class AddTwoLinkedList {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
		// Output: 7 -> 0 -> 8
		ListNode a = new ListNode(3);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(2);
		c.next = b;
		b.next = a;

		ListNode d = new ListNode(4);
		ListNode e = new ListNode(6);
		ListNode f = new ListNode(5);
		f.next = e;
		e.next = d;

		ListNode aa = new ListNode(9);
		ListNode ab = new ListNode(9);
		aa.next = ab;
		ListNode l1 = new AddTwoLinkedList().addTwoNumbers(new ListNode(1), aa);
		System.out.println(l1.val);
		while (l1.next != null) {
			l1 = l1.next;
			System.out.println(l1.val);
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// BigInteger a = changeListToNumber(l1);
		// BigInteger b = changeListToNumber(l2);
		// BigInteger c = a.add(b);
		// if(c.toString().length() > 0)
		// return changeNumberToList(c.toString());
		// else
		// return null;
		
		if (l1 == null && l2 == null)
            return null;
		
		return addTwoNumOneByOne(l1, l2, 0);

	}

	private ListNode addTwoNumOneByOne(ListNode l1, ListNode l2, int plus) {
		int val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + plus;
		ListNode node = new ListNode(val % 10);
		plus = val / 10;
		
		ListNode l1next = (l1 == null) ? null : l1.next; 
		ListNode l2next = (l2 == null) ? null : l2.next; 
		
		if (l1next != null || l2next != null || plus > 0)
			node.next = addTwoNumOneByOne(l1next, l2next, plus);

		return node;
	}

//	private BigInteger changeListToNumber(ListNode list) {
//		String sb = list.val + "";
//		while (list.next != null) {
//			list = list.next;
//			sb = list.val + sb;
//		}
//		BigInteger num = new BigInteger(sb);
//		return num;
//	}
//
//	private ListNode changeNumberToList(String num) {
//		
//		int val = Integer.parseInt(num.substring(num.length() - 1));
//
//		ListNode list = new ListNode(val);
//
//		if (num.length() > 1) {
//			list.next = changeNumberToList(num.substring(0, num.length() - 1));
//		}
//
//		return list;
//	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}