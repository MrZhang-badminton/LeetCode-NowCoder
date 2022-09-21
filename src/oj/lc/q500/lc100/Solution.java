package oj.lc.q500.lc100;

import utils.TreeUtils;
import utils.node.TreeNode;

import java.util.Objects;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/9/21 09:25
 */
public class Solution {

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if ((Objects.isNull(p) && Objects.isNull(q))) {
			return true;
		}
		if (Objects.isNull(p) || Objects.isNull(q)) {
			return false;
		}
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static void main(String[] args) {
		TreeNode tree1 = TreeUtils.createTree(new int[]{1, 2, 1});
		TreeNode tree2 = TreeUtils.createTree(new int[]{1, 1, 2});
		System.out.println(isSameTree(tree1, tree2));
	}

}
