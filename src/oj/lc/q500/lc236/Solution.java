package oj.lc.q500.lc236;

import utils.object.TreeNode;

public class Solution {

	/**
	 * 时间复杂度极高
	 *
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == p || root == q) {
			return root;
		}

		int count = 0;
		count += find(root.left, p, q);
		if (count == 2) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (count == 0) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}

	public static int find(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return 0;
		}
		int count = 0;
		if (root == p || root == q) {
			count++;
		}
		int left = find(root.left, p, q);
		int right = find(root.right, p, q);
		count = count + left + right;
		return count;
	}


	/**
	 * 时间复杂度为O(n)
	 *
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	private static TreeNode ansNode;

	public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		ansNode = null;
		dfs(root, p, q);
		return ansNode;
	}

	public static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return false;
		}
		boolean left = dfs(root.left, p, q);
		boolean right = dfs(root.right, p, q);

		if ((left && right) || ((root == p) || (root == q) && (left || right))) {
			ansNode = root;
		}
		return left || right || (root == p || root == q);
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4});
		System.out.println(lowestCommonAncestor2(root, root.left, root.right).val);
	}
}
