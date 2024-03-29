package oj.lc.q500.lc124;

import utils.TreeUtils;
import utils.node.TreeNode;


/**
 * 类里面的静态变量，在拷贝到leetcode的时候要注意，把static去掉，否则跑测试用例的时候会保留上一次结果
 *
 * @date 2021年02月24日11:03:45
 */
public class Solution {

	private static int maxSum;

	public static int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		postOrder(root);
		return maxSum;
	}

	public static int postOrder(TreeNode root) {
		if (root == null) {
			return 0;
		}
		//大于0才纳入考虑，否则舍弃
		int left = Math.max(postOrder(root.left), 0);
		int right = Math.max(postOrder(root.right), 0);

		int max = root.val + left + right;

		maxSum = Math.max(max, maxSum);
		return root.val + Math.max(left, right);

	}

	public static void main(String[] args) {
		System.out.println(maxPathSum(TreeUtils.createTree(new int[]{-10, 9, 20, -1, -1, 15, 7})));
	}
}
