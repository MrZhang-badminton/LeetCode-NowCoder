package oj.lc.q500.lc114;

import utils.TreeUtils;
import utils.node.TreeNode;

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
		TreeNode root = TreeUtils.createTree(new int[]{1, 2, 5, 3, 4, -1, 6});
		flatten(root);
		TreeUtils.printTree(root);
	}
}
