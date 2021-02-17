package oj.lc.q500.lc42;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

	public static int trap(int[] height) {
		int n = height.length;
		if (n <= 2) {
			return 0;
		}
		int l = 0;
		int sum = 0;
		while (l < n - 2) {
			int r = l + 1;
			int min = height[r];
			int max = height[r];
			int maxIndex = r;
			while (r < n && height[r] < height[l]) {
				if (height[r] <= min) {
					min = height[r];
				}
				if (height[r] >= max) {
					max = height[r];
					maxIndex = r;
				}
				r++;
			}
			if (r < n && l + 1 < r) {
				int h = height[l];
				for (int i = l + 1; i < r; i++) {
					sum += h - height[i];
				}
			}
			if (r == n) {
				if (max > min) {
					int h = max;
					for (int i = l + 1; i < maxIndex; i++) {
						sum += h - height[i];
					}
					l = maxIndex;
					continue;
				}
			}
			l = r;
		}
		return sum;
	}

	public static int trap1(int[] height) {
		int n = height.length;
		int ans = 0;
		for (int i = 1; i < n - 1; i++) {
			int leftMax = 0;
			int rightMax = 0;
			for (int j = i - 1; j >= 0; j--) {
				leftMax = Math.max(leftMax, height[j]);
			}
			for (int j = i + 1; j < n; j++) {
				rightMax = Math.max(rightMax, height[j]);
			}
			int temp = Math.min(leftMax, rightMax) - height[i];
			ans += Math.max(0, temp);
		}
		return ans;
	}

	public static int trap2(int[] height) {
		int n = height.length;
		if (n == 0) {
			return 0;
		}
		int ans = 0;

		int[] leftMax = new int[n];
		int[] rightMax = new int[n];

		leftMax[0] = height[0];
		rightMax[n - 1] = height[n - 1];
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], height[i]);
		}
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], height[i]);
		}
		for (int i = 1; i < n - 1; i++) {
			ans += Math.min(leftMax[i], rightMax[i]) - height[i];
		}
		return ans;
	}

	public static int trap3(int[] height) {
		int n = height.length;
		int ans = 0, current = 0;
		Deque<Integer> stack = new LinkedList<>();
		while (current < n) {
			while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
				int top = stack.pop();
				if (stack.isEmpty()) {
					break;
				}
				int distance = current - stack.peek() - 1;
				int h = Math.min(height[current], height[stack.peek()]) - height[top];
				ans += distance * h;
			}
			stack.push(current++);
		}
		return ans;
	}

	public static int trap4(int[] height) {
		int n = height.length;
		int left = 0, right = n - 1;
		int leftMax = 0, rightMax = 0;
		int ans = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				if (leftMax < height[left]) {
					leftMax = height[left];
				} else {
					ans += leftMax - height[left];
				}
				++left;
			} else {
				if (height[right] >= rightMax) {
					rightMax = height[right];
				} else {
					ans += (rightMax - height[right]);
				}
				right--;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(trap3(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
	}
}
