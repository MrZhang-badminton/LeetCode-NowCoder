package oj.lc.q2000.lc1379;

import utils.TreeUtils;
import utils.node.TreeNode;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/2 12:24 上午
 */
public class Solution {

	private static TreeNode resultNode;
	private static boolean flag = true;

	/**
	 * 这个方法比较粗暴，写的也比较丑
	 *
	 * @param original
	 * @param cloned
	 * @param target
	 * @return
	 */
	public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		inOrder(original, cloned, target);
		return resultNode;
	}

	public static void inOrder(TreeNode original, TreeNode cloned, TreeNode target) {
		if (original == null) {
			return;
		}
		if (!flag) {
			return;
		}
		inOrder(original.left, cloned.left, target);
		if (!flag) {
			return;
		}
		if (target == original) {
			flag = false;
			resultNode = cloned;
		}
		if (!flag) {
			return;
		}
		inOrder(original.right, cloned.right, target);

	}


	public static void main(String[] args) {
		TreeNode original = TreeUtils.createTree(new int[]{7, 4, 3, -1, -1, 6, 19});
		TreeNode cloned = TreeUtils.createTree(new int[]{7, 4, 3, -1, -1, 6, 19});
		TreeNode target = original;
		System.out.println(getTargetCopy(original, cloned, target));
	}
}
