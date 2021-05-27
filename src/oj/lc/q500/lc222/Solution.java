package oj.lc.q500.lc222;

import utils.ds.TreeNode;

public class Solution {

	public static int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return countNodes(root.left) + countNodes(root.right) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{1, 2, 3, 4, 5, 6});
		System.out.println(countNodes(root));
	}
}
