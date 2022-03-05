package oj.lc.q500.lc129;

import utils.TreeUtils;
import utils.node.TreeNode;

public class Solution {

	private static int sum;

	public static void inOrder(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		k = k * 10 + root.val;
		if (root.left == null && root.right == null) {
			sum += k;
			return;
		}
		inOrder(root.left, k);
		inOrder(root.right, k);
	}

	public static int sumNumbers(TreeNode root) {
		if(root == null){
			return 0;
		}
		sum = 0;
		inOrder(root, 0);
		return sum;
	}

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree(new int[]{1, 2, 3});
		System.out.println(sumNumbers(root));
	}
}
