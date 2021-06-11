package oj.lc.jz.lcjz33;

public class Solution {

	public static boolean verifyPostorder(int[] postorder) {
		int n = postorder.length;
		return judge(postorder, 0, n - 1);
	}

	public static boolean judge(int[] postorder, int left, int right) {
		if (right - left <= 1) {
			return true;
		}
		int k = postorder[right];
		boolean flag = false;
		int index = left-1;
		for (int i = left; i < right; i++) {
			if (!flag) {
				if (postorder[i] < k) {
					index = i;
				} else {
					flag = !flag;
				}
			} else {
				if (postorder[i] < k) {
					return false;
				}
			}
		}
		return judge(postorder, left, index) && judge(postorder, index + 1, right - 1);
	}

	public static void main(String[] args) {
		System.out.println(verifyPostorder(new int[]{1, 2, 5, 10, 6, 9, 4, 3}));
	}
}
