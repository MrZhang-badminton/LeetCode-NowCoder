package oj.lc.q500.lc337;

import utils.TreeUtils;
import utils.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static int rob(TreeNode root) {
		int[] status = dfs(root);
		return Math.max(status[0], status[1]);
	}

	public static int[] dfs(TreeNode root) {
		if (root == null) {
			return new int[]{0, 0};
		}
		int[] l = dfs(root.left);
		int[] r = dfs(root.right);
		int selected = root.val + l[1] + r[1];
		int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
		return new int[]{selected, notSelected};
	}

	public static int rob2(TreeNode root) {
		List<Integer> list = dfs2(root);
		return Math.max(list.get(0), list.get(1));
	}

	public static List dfs2(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			list.add(0);
			list.add(0);
			return list;
		}

		List<Integer> leftList = dfs2(root.left);
		List<Integer> rightList = dfs2(root.right);

		int num1 = root.val + leftList.get(1) + rightList.get(1);
		int num2 = Math.max(leftList.get(0), leftList.get(1)) + Math.max(rightList.get(0), rightList.get(1));

		list.add(num1);
		list.add(num2);
		return list;

	}

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree(new int[]{3, 4, 5, 1, 3, -1, 1});
		TreeUtils.printTree(root);
		System.out.println(rob(root));
	}
}
