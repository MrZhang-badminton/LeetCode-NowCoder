package oj.lc.q2000.lc1379;

import utils.TreeUtils;
import utils.node.TreeNode;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/2 12:38 上午
 */
public class SolutionV2 {

	/**
	 * 来自评论区的做法，确实挺巧妙地
	 * @param original
	 * @param cloned
	 * @param target
	 * @return
	 */
	public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		if (original == null) return null;
		if (original == target) return cloned;
		TreeNode left = getTargetCopy(original.left, cloned.left, target);
		if (left != null) return left;
		return getTargetCopy(original.right, cloned.right, target);
	}

	public static void main(String[] args) {
		TreeNode original = TreeUtils.createTree(new int[]{7, 4, 3, -1, -1, 6, 19});
		TreeNode cloned = TreeUtils.createTree(new int[]{7, 4, 3, -1, -1, 6, 19});
		TreeNode target = original;
		System.out.println(getTargetCopy(original, cloned, target));
	}
}
