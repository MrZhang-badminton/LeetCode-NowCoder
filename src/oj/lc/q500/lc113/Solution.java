package oj.lc.q500.lc113;

import utils.object.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void inOrder(TreeNode root, int sum, int targetSum,
							   List<Integer> list, List<List<Integer>> ansList) {
		if (root == null) {
			return;
		}

		list.add(root.val);
		sum += root.val;
		if (root.left == null && root.right == null && sum == targetSum) {
			ansList.add(new ArrayList<>(list));
		}
		inOrder(root.left, sum, targetSum, list, ansList);
		inOrder(root.right, sum, targetSum, list, ansList);
		sum -= root.val;
		list.remove(list.size() - 1);

	}

	public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> ansList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		inOrder(root, sum, targetSum, list, ansList);
		return ansList;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{5,4,8,11,-1,13,4,7,2,-1,-1,-1,-1,5,1});
		System.out.println(pathSum(root,22));
	}
}
