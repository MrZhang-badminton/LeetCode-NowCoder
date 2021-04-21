package oj.lc.q500.lc404;

import utils.ds.TreeNode;

public class Solution {
	public static boolean judgeIsLeaf(TreeNode root) {
		if(root == null){
			return false;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		return false;
	}

	public static int sumOfLeftLeaves(TreeNode root) {
		if(root == null){
			return 0;
		}
		int sum = 0;
		int left = 0, right = 0;
		if(judgeIsLeaf(root.left)){
			sum+=root.left.val;
		}else {
			sum += sumOfLeftLeaves(root.left);
		}
		sum += sumOfLeftLeaves(root.right);
		return sum;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{3, 9, 20, -1, -1, 15, 7});
		TreeNode.printTree(root);
		System.out.println(sumOfLeftLeaves(root));
	}
}
