package oj.lc.q1000.lc543;

import utils.TreeUtils;
import utils.node.TreeNode;

public class Solution {

	private static int width;

	public static int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		width = 0;
		getHeight(root);
		return width;
	}

	public static int getHeight(TreeNode root) {
		if(root == null){
			return 0;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);

		width = Math.max(width,left+right);
		return Math.max(left,right) + 1;
	}



	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree(new int[]{1, 2, 3, 4, 5});
		System.out.println(diameterOfBinaryTree(root));
	}
}
