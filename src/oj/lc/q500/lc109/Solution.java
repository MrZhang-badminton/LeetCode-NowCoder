package oj.lc.q500.lc109;

import utils.object.ListNode;
import utils.object.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2021年03月15日14:10:55
 */
public class Solution {

	/**
	 * 递归中序遍历
	 *
	 * @param list
	 * @param l
	 * @param r
	 * @return
	 */
	public static TreeNode build(List<Integer> list, int l, int r) {
		if (l > r) {
			return null;
		}
		int mid = (l + r) / 2;
		TreeNode root = new TreeNode(list.get(mid));
		root.left = build(list, l, mid - 1);
		root.right = build(list, mid + 1, r);
		return root;
	}

	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		List<Integer> list = new ArrayList<>();

		ListNode p = head;
		while (p != null) {
			list.add(p.val);
			p = p.next;
		}

		return build(list, 0, list.size() - 1);
	}


	public static void main(String[] args) {
		ListNode head = ListNode.getList(new int[]{-10, -3, 0, 5, 9});
		TreeNode root = sortedListToBST(head);
		TreeNode.printTree(root);
	}
}
