package utils;

import utils.node.TreeNode;
import utils.ref.TreeOperation;

import java.util.Objects;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/6 12:41 上午
 */
public class TreeUtils {
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

//	/**
//	 * 按照层次打印树
//	 *
//	 * @param root
//	 */
//	public static void printTree(TreeNode root) {
//		if (root == null) {
//			return;
//		}
//		Deque<TreeNode> queue = new ArrayDeque<>();
//		TreeNode ptrToRight = root;
//		queue.add(root);
//		int treeHeight = getTreeHeight(root);
//
//		/**
//		 * 当前树的高度，因为根节点还没有出队
//		 * 默认为0
//		 */
//		int h = 0;
//
//		System.out.println(root.val);
//		while (!queue.isEmpty()) {
//			TreeNode ptr = queue.poll();
//			if (h + 1 != treeHeight) {
//				System.out.print(ptr.left == null ? "# " : (ptr.left.val + " "));
//				System.out.print(ptr.right == null ? "# " : (ptr.right.val + " "));
//			}
//			if (ptr.left != null) {
//				queue.add(ptr.left);
//			}
//			if (ptr.right != null) {
//				queue.add(ptr.right);
//			}
//			if (h + 1 != treeHeight && ptrToRight == ptr) {
//				System.out.println();
//				h++;
//				ptrToRight = queue.size() != 0 ? queue.getLast() : null;
//			}
//		}
//		System.out.println();
//	}
//
//	private static int getTreeHeight(TreeNode root) {
//		return root == null ? 0 : (1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right)));
//	}


	public static void printTree(TreeNode root) {
		if(Objects.isNull(root)){
			System.out.println("root is null");
			return;
		}
		TreeOperation.show(root);
	}

}
