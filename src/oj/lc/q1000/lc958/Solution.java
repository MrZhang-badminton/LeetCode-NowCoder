package oj.lc.q1000.lc958;

import utils.TreeUtils;
import utils.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static boolean isCompleteTree(TreeNode root) {
		if (root == null) {
			return true;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
			if (p != null) {
				queue.offer(p.left);
				queue.offer(p.right);
			} else {
				while (!queue.isEmpty()) {
					TreeNode q = queue.poll();
					if (q != null) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree(new int[]{1, 2, 3, 4, 5, -1, 7});
		System.out.println(isCompleteTree(root));
	}
}
