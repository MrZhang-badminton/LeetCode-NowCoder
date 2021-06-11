package oj.lc.q500.lc437;

import utils.ds.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

//	/**
//	 * 暴力搜索
//	 * @param root
//	 * @param sum
//	 * @return
//	 */
//	public static int pathSum(TreeNode root, int sum) {
//		if (root == null) {
//			return 0;
//		}
//		return calPathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//	}
//
//	private static int calPathSum(TreeNode root, int sum) {
//		if (root == null) {
//			return 0;
//		}
//		int tmp = 0;
//		sum -= root.val;
//		if (sum == 0) {
//			tmp++;
//		}
//		return tmp + calPathSum(root.left, sum) + calPathSum(root.right, sum);
//	}

	private static Map<Integer, Integer> map;

	public static int pathSum(TreeNode root, int targetSum) {
		map = new HashMap<>();
		map.put(0, 1);

		return dfs(root, targetSum, 0);
	}

	public static int dfs(TreeNode root, int targetSum, int curSum) {
		if (root == null) {
			return 0;
		}
		int res = 0;
		curSum += root.val;
		res += map.getOrDefault(curSum - targetSum, 0);
		map.put(curSum, map.getOrDefault(curSum, 0) + 1);

		res += dfs(root.left, targetSum, curSum);
		res += dfs(root.right, targetSum, curSum);

		map.put(curSum, map.get(curSum) - 1);
		return res;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{10, 5, -3, 3, 2, -1, 11, 3, -2, -1, 1});
		System.out.println(pathSum(root, 8));
	}
}
