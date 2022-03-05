package oj.lc.q1000.lc503;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	public static int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		Arrays.fill(res, -1);
		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < n * 2 - 1; i++) {
			while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
				res[stack.pop()] = nums[i % n];
			}
			stack.push(i % n);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] ret = nextGreaterElements(new int[]{1, 2, 1});
		ArrayUtils.printArray(ret);
	}
}
