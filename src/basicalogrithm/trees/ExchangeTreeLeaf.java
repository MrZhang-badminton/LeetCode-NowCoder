package basicalogrithm.trees;

import utils.ds.TreeNode;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 交换左右子树
 *
 * @date 2021年04月29日01:08:27
 */
public class ExchangeTreeLeaf {

	/**
	 * 递归做法
	 *
	 * @param root
	 * @return
	 */
	public static TreeNode exchange_r(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode tNode = root.left;
		root.left = exchange_r(root.right);
		root.right = exchange_r(tNode);
		return root;
	}

	/**
	 * 非递归做法
	 *
	 * @param root
	 * @return
	 */
	public static TreeNode exchange_nr(TreeNode root) {
		TreeNode p = root;
		Deque<TreeNode> stack = new LinkedList<>();

		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				TreeNode tNode = p.left;
				p.left = p.right;
				p.right = tNode;
				if (p.right != null) {
					stack.push(p.right);
				}
				p = p.left;
			} else {
				p = stack.pop();
			}
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
		TreeNode.printTree(root);
		root = exchange_nr(root);
		TreeNode.printTree(root);
	}
}
