package oj.lc.q1000.lc515;

import utils.TreeUtils;
import utils.node.TreeNode;

import java.util.*;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/8 12:03 上午
 */
public class Solution {

	/**
	 * 层次遍历
	 * @param root
	 * @return
	 */
	public static List<Integer> largestValues(TreeNode root) {
		List<Integer> ansList = new ArrayList<>();
		if (root == null) {
			return ansList;
		}
		Deque<TreeNode> queue = new LinkedList<>();
		TreeNode lastPtr = root;
		int max = Integer.MIN_VALUE;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
			max = Math.max(max, p.val);
			if (p.left != null) {
				queue.add(p.left);
			}
			if (p.right != null) {
				queue.add(p.right);
			}
			if (p == lastPtr) {
				ansList.add(max);
				max = Integer.MIN_VALUE;
				lastPtr = queue.isEmpty() ? null : queue.getLast();
			}
		}
		return ansList;
	}

	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree(new int[]{1, 3, 2, 5, 3, -1, 9});
		System.out.println(largestValues(root));
	}
}
