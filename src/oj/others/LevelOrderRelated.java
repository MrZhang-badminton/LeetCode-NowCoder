package oj.others;

import utils.ds.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 层次遍历的变种，树的每层存入一个数组，最后返回一个二维数组
 *
 * @auther Peter Hua
 * @date 2021年04月22日11:24:05
 */
public class LevelOrderRelated {

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{1, 2, 3, 4, 5, 6, 7});
		System.out.println(levelOrder(root));
	}


	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ansList = new ArrayList<>();
		if (root == null) {
			return ansList;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		TreeNode ptr = root;
		queue.add(root);
		List<Integer> list = new ArrayList<>();

		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
			list.add(p.val);
			if (p.left != null) {
				queue.add(p.left);
			}
			if (p.right != null) {
				queue.add(p.right);
			}
			if (p == ptr) {
				if (!queue.isEmpty()) {
					ptr = queue.getLast();
				}
				ansList.add(list);
				list = new ArrayList<>();
			}
		}
		return ansList;
	}
}
