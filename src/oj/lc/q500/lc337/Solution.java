package oj.lc.q500.lc337;

import utils.object.TreeNode;

public class Solution {

	public static int rob(TreeNode root) {
		int[] status = dfs(root);
		return Math.max(status[0], status[1]);
	}

	public static int[] dfs(TreeNode root) {
		if(root == null){
			return new int[]{0,0};
		}
		int[] l= dfs(root.left);
		int[] r = dfs(root.right);
		int selected = root.val + l[1] + r[1];
		int notSelected = Math.max(l[0],l[1]) + Math.max(r[0],r[1]);
		return new int[]{selected,notSelected};
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{3, 4, 5, 1, 3, -1, 1});
		TreeNode.printTree(root);
		System.out.println(rob(root));
	}
}
