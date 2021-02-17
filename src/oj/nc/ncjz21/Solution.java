package oj.nc.ncjz21;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	public static boolean IsPopOrder(int[] pushA, int[] popA) {
		int index1 = 0, index2 = 0;
		Deque<Integer> stack = new LinkedList<>();
		stack.push(pushA[index1++]);
		while (index2 != popA.length) {
			while (index1 < pushA.length && stack.peek() < popA[index2]) {
				stack.push(pushA[index1++]);
			}
			if (index1 == pushA.length && stack.peek() != popA[index2]) {
				return false;
			}
			while (index2 < popA.length && stack.peek() == popA[index2]){
				stack.pop();
				index2++;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,3,5,2,1}));
	}
}