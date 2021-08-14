package oj.lc.q500.lc297;

import utils.ds.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 哈哈哈哈,虽然代码有点长,但是是正确的
 * 将树的中序遍历和后序遍历的结果存放到字符传中,并且做好分割标记
 * 解码的时候将中序遍历数组和后序遍历数组都分别取出来
 * 然后复用之前写的根据中序、后序遍历构建二叉树的方法即可
 *
 * !!!这种办法是不可行的
 * 这种方法只能解决树中没有重复元素的情况
 * 如下请情况就不可以
 * [3, 2, 4, 3]
 *
 * @Classname: Solution
 * @Author: zhanghua
 * @Date: 2021/8/14 12:50 下午
 */
public class Codec1 {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return null;
		}
		List<Integer> inOrderList = new ArrayList<>();
		List<Integer> postOrderList = new ArrayList<>();

		inOrderVisit(root, inOrderList);
		postOrderVisit(root, postOrderList);

		StringBuilder sb = new StringBuilder();
		inOrderList.forEach((num) -> {
			sb.append(num + ",");
		});
		sb.deleteCharAt(sb.length() - 1);
		sb.append("-");
		postOrderList.forEach((num) -> {
			sb.append(num + ",");
		});
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null) {
			return null;
		}
		String[] firstStrings = data.split("-");
		String[] inorder = firstStrings[0].split(",");
		String[] postorder = firstStrings[1].split(",");
		int[] inorderNums = Arrays.stream(inorder).mapToInt(Integer::valueOf).toArray();
		int[] postorderNums = Arrays.stream(postorder).mapToInt(Integer::valueOf).toArray();
		TreeNode root = buildTree(inorderNums, postorderNums);
		return root;
	}

	public void inOrderVisit(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inOrderVisit(root.left, list);
		list.add(root.val);
		inOrderVisit(root.right, list);
	}

	public void postOrderVisit(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		postOrderVisit(root.left, list);
		postOrderVisit(root.right, list);
		list.add(root.val);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	public TreeNode build(int[] in, int l1, int r1, int[] post, int l2, int r2) {
		if (l1 > r1) {
			return null;
		}
		int value = post[r2];
		TreeNode root = new TreeNode(value);
		int index = l1;
		while (in[index] != value) index++;
		int len = index - l1;
		root.left = build(in, l1, index - 1, post, l2, l2 + len - 1);
		root.right = build(in, index + 1, r1, post, l2 + len, r2 - 1);
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{3,2,4,3});
		TreeNode.printTree(root);
		Codec1 codec1 = new Codec1();
		System.out.println(codec1.serialize(root));
		TreeNode node = codec1.deserialize(codec1.serialize(root));
		TreeNode.printTree(node);
	}


}
