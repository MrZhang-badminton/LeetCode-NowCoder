package oj.lc.q500.lc98;

import utils.ds.TreeNode;

public class Solution {

	private static long pre;

	public static boolean isValidBST(TreeNode root) {
		pre = Long.MIN_VALUE;
		return inOrder(root);
	}

	public static boolean inOrder(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (inOrder(root.left) && pre < root.val) {
			pre = root.val;
		} else {
			return false;
		}
		return inOrder(root.right);
	}

	public static void main(String[] args) {
//		TreeNode root = TreeNode.createTree(new int[]{5, 1, 4, -1, -1, 3, 6});
		TreeNode root = TreeNode.createTree(new int[]{-2147483648});

		System.out.println(isValidBST(root));
	}
}
