package oj.lc.q500.lc107;

import utils.TreeUtils;
import utils.node.TreeNode;

import java.util.*;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/11/18 02:34
 */
public class Solution {


	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (Objects.isNull(root)) {
			return new ArrayList<>();
		}

		List<List<Integer>> resultList = new ArrayList<>();
		TreeNode lastPtr = root;
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		List<Integer> list = new ArrayList<>();
		while (!deque.isEmpty()) {
			TreeNode p = deque.poll();
			list.add(p.val);
			if (Objects.nonNull(p.left)) {
				deque.offer(p.left);
			}
			if (Objects.nonNull(p.right)) {
				deque.offer(p.right);
			}
			if (lastPtr == p) {

				resultList.add(list);
				list = new ArrayList<>();
				if (!deque.isEmpty()) {
					lastPtr = deque.getLast();
				}
			}
		}

		Collections.reverse(resultList);
		return resultList;

	}


	public static void main(String[] args) {
		TreeNode root = TreeUtils.createTree(new int[]{3, 9, 20, -1, -1, 15, 7});
		System.out.println(levelOrderBottom(root));
	}
}
