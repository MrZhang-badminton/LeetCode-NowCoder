package oj.lc.jz.lcjz68;

import utils.TreeUtils;
import utils.node.TreeNode;

public class Solution {

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4});
		TreeNode p = root.left, q = root.left.right.right;
		System.out.println(lowestCommonAncestor2(root, p, q).val);
	}

	/**
	 * 时间复杂度较高
	 * 遍历每个节点的时候都把以这个节点为根的子树扫描了一遍
	 *
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		int count = 0;
		if (root == p || root == q) {
			return root;
		}
		int num = dfs(root.left, p, q);
		if (num == 2) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (num == 1) {
			return root;
		} else {
			return lowestCommonAncestor(root.right, p, q);
		}

	}

	public static int dfs(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return 0;
		}
		int count = 0;
		if (root == p || root == q) {
			count++;
		}
		count += dfs(root.left, p, q);
		count += dfs(root.right, p, q);
		return count;
	}

	/**
	 * 题解做法
	 * 时间复杂度为O(n)
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	private static TreeNode ansNode;
	public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		dfs2(root,p,q);
		return ansNode;
	}


	public static boolean dfs2(TreeNode root,TreeNode p,TreeNode q){
		if(root == null){
			return false;
		}
		boolean lson = dfs2(root.left,p,q);
		boolean rson = dfs2(root.right,p,q);
		if((lson&& rson)||(root == p || root == q) && (lson || rson)){
			ansNode = root;
		}
		return lson || rson||(root == p || root == q);
	}


}
