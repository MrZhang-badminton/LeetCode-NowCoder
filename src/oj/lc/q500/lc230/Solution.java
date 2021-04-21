package oj.lc.q500.lc230;

import utils.ds.TreeNode;

public class Solution {

	private static int count = 0;

	public static int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return -1;
		}
		int left = kthSmallest(root.left,k);
		if(left != -1){
			return left;
		}
		count++;
		if(count == k){
			return root.val;
		}
		return kthSmallest(root.right,k);

	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{5,3,6,2,4,-1,-1,1});
//		System.out.println();
		System.out.println(kthSmallest(root, 3));
	}
}
