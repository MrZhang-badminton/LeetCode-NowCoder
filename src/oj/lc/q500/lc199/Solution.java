package oj.lc.q500.lc199;

import utils.ds.TreeNode;

import java.util.*;

public class Solution {
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.add(root);
		TreeNode ptrToRight = root;
		while (!deque.isEmpty()) {
			TreeNode ptr = deque.poll();
			if (ptr.left != null) {
				deque.add(ptr.left);
			}
			if (ptr.right != null) {
				deque.add(ptr.right);
			}
			if (ptr == ptrToRight) {
				list.add(ptr.val);
				if(!deque.isEmpty()){
					ptrToRight = deque.getLast();
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{1, 2, 3, -1, 5, -1, 4});
		List<Integer> list = rightSideView(root);
		System.out.println(list);
	}


}
