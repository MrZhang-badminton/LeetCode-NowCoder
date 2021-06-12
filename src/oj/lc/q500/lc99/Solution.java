package oj.lc.q500.lc99;

import utils.ds.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public static void recoverTree(TreeNode root) {
		List<TreeNode> nodeList = new ArrayList<>();
		inOrder(root, nodeList);
		recover(nodeList);
	}

	public static void inOrder(TreeNode root, List<TreeNode> nodeList) {
		if (root == null) {
			return;
		}
		inOrder(root.left, nodeList);
		nodeList.add(root);
		inOrder(root.right, nodeList);
	}

	public static void recover(List<TreeNode> list) {
		int n = list.size();
		int x = -1, y = -1, index1 = -1, index2 = -2;
		for (int i = 0; i < n - 1; i++) {
			if (list.get(i + 1).val < list.get(i).val) {
				y = list.get(i + 1).val;
				index2 = i + 1;
				if (x == -1) {
					x = list.get(i).val;
					index1 = i;
				} else {
					break;
				}
			}
		}
		int temp = list.get(index1).val;
		list.get(index1).val = list.get(index2).val;
		list.get(index2).val = temp;
	}

	public static void recoverTree2(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode x = null, y = null, pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (pre != null && root.val < pre.val) {
				y = root;
				if (x == null) {
					x = pre;
				} else {
					break;
				}
			}
			pre = root;
			root = root.right;
		}
		//交换两个错位节点的值
		int temp = x.val;
		x.val = y.val;
		y.val = temp;

	}


	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{3, 1, 4, -1, -1, 2, -1});
		TreeNode.printTree(root);
		recoverTree2(root);
		TreeNode.printTree(root);
	}
}
