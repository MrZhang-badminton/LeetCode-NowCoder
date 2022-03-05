package oj.lc.q1000.lc814;

import utils.ds.TreeNode;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/2 1:06 上午
 */
public class Solution {

	/**
	 * 目测递归解法
	 *
	 * @param root
	 * @return
	 */
	public static TreeNode pruneTree(TreeNode root) {
		return remove(root) ? null : root;
	}


	/**
	 * 递归剪枝
	 *
	 * @param root
	 * @return true代表可以剪枝  false代表不可以剪枝
	 */
	public static boolean remove(TreeNode root) {
		if (root == null) {
			return true;
		}
		boolean flag1 = remove(root.left);
		boolean flag2 = remove(root.right);
		if (flag1) {
			root.left = null;
		}
		if (flag2) {
			root.right = null;
		}
		if (root.val == 0 && flag1 && flag2) {
			return true;
		}

		return false;
	}

	/**
	 * 评论区大佬给出的解法,非常优美
	 *
	 * @param root
	 * @return
	 */
	public TreeNode pruneTree2(TreeNode root) {
		if (root == null) {
			return null;
		}
		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);
		if (root.left == null && root.right == null && root.val == 0) {
			return null;
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{0, -1, 0, -1, -1, 0, 0});
		TreeNode.printTree(root);
		TreeNode.printTree(pruneTree(pruneTree(root)));
	}

}
