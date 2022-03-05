package oj.lc.q2000.lc1302;

import utils.TreeUtils;
import utils.node.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

	public static int deepestLeavesSum(TreeNode root) {
		TreeNode oldPtr = root;
		int tempSum = 0;
		Deque<TreeNode> deque = new LinkedList<>();
		deque.addLast(root);
		while (!deque.isEmpty()) {
			TreeNode p = deque.poll();
			tempSum += p.val;
			if (p.left != null) {
				deque.addLast(p.left);
			}
			if (p.right != null) {
				deque.addLast(p.right);
			}
			if (!deque.isEmpty() && p == oldPtr) {
				tempSum = 0;
				oldPtr = deque.getLast();
			}
		}
		return tempSum;
	}

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree(new int[]{1, 2, 3, 4, 5, -1, 6, 7, -1, -1,
				-1, -1, -1, -1, 8});
		System.out.println(deepestLeavesSum(root));
	}
}
