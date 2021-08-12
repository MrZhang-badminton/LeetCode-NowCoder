package oj.lc.q500.lc114;

import utils.ds.TreeNode;

/**
 * @Classname: Solution
 * @Author: zhanghua
 * @Date: 2021/8/13 2:39 上午
 */
public class Solution {
	private static TreeNode head;

	public static void flatten(TreeNode root) {
		head = new TreeNode(-1);
		preOrder(root);
	}

	public static void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		head.right = root;
		head = root;
		TreeNode leftNode = root.left;
		TreeNode rightNode = root.right;
		root.left = null;
		root.right = null;
		preOrder(leftNode);
		preOrder(rightNode);
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{1, 2, 5, 3, 4, -1, 6});
		flatten(root);
		TreeNode.printTree(root);
	}
}
