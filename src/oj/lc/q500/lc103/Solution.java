package oj.lc.q500.lc103;

import utils.TreeUtils;
import utils.node.TreeNode;

import java.util.*;

public class Solution {
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ansList = new ArrayList<>();
		if (root == null) {
			return ansList;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		int count = 1;
		TreeNode ptrToRight = root;
		deque.add(root);
		List<Integer> list = new ArrayList<>();
		while (!deque.isEmpty()) {
			TreeNode ptr = deque.poll();
			list.add(ptr.val);
			if (ptr.left != null) {
				deque.add(ptr.left);
			}
			if (ptr.right != null) {
				deque.add(ptr.right);
			}

			if (ptr == ptrToRight) {
				if (count % 2 == 0) {
					Collections.reverse(list);
				}
				ansList.add(list);
				list = new ArrayList<>();

				if (!deque.isEmpty()) {
					ptrToRight = deque.getLast();
				}
				count++;
			}
		}
		return ansList;
	}

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree(new int[]{3, 9, 20, -1, -1, 15, 7});
		System.out.println(zigzagLevelOrder(root));
	}
}
