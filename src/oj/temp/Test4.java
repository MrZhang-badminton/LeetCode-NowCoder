package oj.temp;

import utils.object.TreeNode;

import java.util.*;

public class Test4 {
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ansList = new ArrayList<>();
		if(root == null){
			return ansList;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		TreeNode ptr = root;
		queue.add(root);
		List<Integer> list = new ArrayList<>();

		while(!queue.isEmpty()){
			TreeNode tempNode = queue.poll();
			list.add(tempNode.val);
			if(tempNode.left != null){
				queue.add(tempNode.left);
			}
			if(tempNode.right != null){
				queue.add(tempNode.right);
			}
			if(tempNode == ptr){
				if(!queue.isEmpty()){
					ptr = queue.getLast();
				}
				ansList.add(list);
				list = new ArrayList<>();
			}
		}
		return ansList;
	}
	public static void main(String[] args) {
		TreeNode t7 = new TreeNode(7);
		TreeNode t15 = new TreeNode(15);
		TreeNode t20 = new TreeNode(20);
		TreeNode t9 = new TreeNode(9);
		TreeNode t3 = new TreeNode(3);
		t3.left = t9;
		t3.right = t20;
		t20.left = t15;
		t20.right = t7;
		System.out.println(levelOrder(null));
	}
}
