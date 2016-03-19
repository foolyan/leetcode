package solution;


import java.util.ArrayList;
import java.util.List;

/**
 * 描述: 从右侧看二叉树
 * 
 */

public class BinaryTreeRightSideView {

	private List<Integer> results = new ArrayList<Integer>();
	private int depth = 1;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t2.right = t5;
		t3.right = t4;
		System.out.println(new BinaryTreeRightSideView().rightSideView(t1));
	}

	public List<Integer> rightSideView(TreeNode root) {
		if(root == null)
			return new ArrayList<Integer>();
		else{
			setValue(root);
			return results;
		}
    }
	
	/**
	 * 递归遍历二叉树，将每层最右侧的数加到results里
	 * 
	 * @param node
	 */
	private void setValue(TreeNode node){
		if(results.size() < depth) // 该层尚未找到最右的数
			results.add(node.val);
		
		depth++;
		
		if(node.right != null)   // 先右后左 
			setValue(node.right);
		
		if(node.left != null)
			setValue(node.left);
		
		depth--;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
