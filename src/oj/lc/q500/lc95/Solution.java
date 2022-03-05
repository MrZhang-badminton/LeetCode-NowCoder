package oj.lc.q500.lc95;

import utils.TreeUtils;
import utils.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/**
	 * 分治法，分而治之
	 *
	 * @param n
	 * @return
	 */
	public static List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return new ArrayList<TreeNode>();
		}
		return generateTrees(1, n);
	}

	public static List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> treeList = new ArrayList<>();
		if (start > end) {
			treeList.add(null);
			return treeList;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> leftTrees = generateTrees(start, i - 1);
			List<TreeNode> rightTrees = generateTrees(i + 1, end);
			for (TreeNode left : leftTrees) {
				for (TreeNode right : rightTrees) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					treeList.add(root);
				}
			}
		}
		return treeList;
	}


	public static void main(String[] args) {
		List<TreeNode> list = generateTrees(3);
		for (TreeNode node : list) {
			TreeUtils.printTree(node);
			System.out.println();
		}
	}
}
