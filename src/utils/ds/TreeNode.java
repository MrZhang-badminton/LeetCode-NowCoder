package utils.ds;

import java.util.*;

public class TreeNode {
	public int val = 0;
	public TreeNode left = null;
	public TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}

	/**
	 * 根据数组构建二叉树，空节点为-1
	 *
	 * @param nums
	 * @return
	 */
	public static TreeNode createTree(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			System.out.println("数组长度为0！！");
			return null;
		}
		TreeNode[] nodes = new TreeNode[n];
		for (int i = 0; i < n; i++) {
			if (nums[i] != -1) {
				nodes[i] = new TreeNode(nums[i]);
			} else {
				nodes[i] = null;
			}
		}

		int index = 0;
		while (index < nums.length) {
			int temp = index * 2 + 1;
			if (temp < n && nodes[index] != null) {
				nodes[index].left = nodes[temp];
			}
			temp++;
			if (temp < n && nodes[index] != null) {
				nodes[index].right = nodes[temp];
			}
			index++;
		}
		return nodes[0];
	}

	/**
	 * 按照层次打印树
	 *
	 * @param root
	 */
	public static void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		TreeNode ptrToRight = root;
		queue.add(root);
		System.out.println(root.val);

		while (!queue.isEmpty()) {
			TreeNode ptr = queue.poll();
			System.out.print(ptr.left == null ? "# " : (ptr.left.val + " "));
			System.out.print(ptr.right == null ? "# " : (ptr.right.val + " "));
			if (ptr.left != null) {
				queue.add(ptr.left);
			}
			if (ptr.right != null) {
				queue.add(ptr.right);
			}
			if (ptrToRight == ptr) {
				System.out.println();
				ptrToRight = queue.size() != 0 ? queue.getLast() : null;
			}
		}
		System.out.println();
//		System.out.println("最后一行不算！");
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
		System.out.println(root);

		TreeNode.printTree(root);
	}

}
