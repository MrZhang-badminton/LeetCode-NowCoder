package basic.trees;

import utils.ds.TreeNode;

import java.util.*;

public class TreeTravelTest {

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{1, 2, 3, 4, 5});
		TreeNode.printTree(root);
		System.out.println(preOrder_r(root));
	}



	/**
	 * 递归前序遍历
	 * @param root
	 * @return
	 */
	public static List<Integer> preOrder_r(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		preOrder(root, list);
		return list;
	}

	public static void preOrder(TreeNode root, List<Integer> list) {
		if(root == null){
			return;
		}
		list.add(root.val);
		preOrder(root.left,list);
		preOrder(root.right,list);
	}

	/**
	 * 非递归前序遍历
	 * @param root
	 * @return
	 */
	public static List<Integer> preOrder_nr(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				list.add(p.val);
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop().right;
			}
		}
		return list;
	}
}
