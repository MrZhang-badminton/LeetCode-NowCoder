package oj.lc.q500.lc101;

import utils.ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	/**
	 * 递归
	 *
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric(TreeNode root) {
		return judge(root.left, root.right);
	}

	public static boolean judge(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}

		if (p != null && q != null && p.val == q.val) {
			return judge(p.left, q.right) && judge(p.right, q.left);
		}
		return false;
	}

	/**
	 * 迭代
	 *
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric2(TreeNode root) {
		return check(root, root);
	}

	public static boolean check(TreeNode p, TreeNode q) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(p);
		queue.offer(q);
		while (!queue.isEmpty()) {
			p = queue.poll();
			q = queue.poll();
			if (p == null && q == null) {
				continue;
			}
			if ((p == null || q == null) || (q.val != p.val)) {
				return false;
			}
			queue.offer(q.left);
			queue.offer(p.right);
			queue.offer(q.right);
			queue.offer(p.right);
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{1, 2, 2});
		System.out.println(isSymmetric2(root));
	}
}
