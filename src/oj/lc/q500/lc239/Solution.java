package oj.lc.q500.lc239;

import utils.ArrayUtils;

import java.util.*;

public class Solution {


	/**
	 * 滑动窗口最优美写法，来自题解
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] ans = new int[n - k + 1];
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
				deque.removeLast();
			}
			deque.addLast(i);
		}
		ans[0] = nums[deque.peekFirst()];
		for (int i = k; i < n; i++) {
			while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
				deque.removeLast();
			}
			deque.addLast(i);
			if (deque.getFirst() < i + 1 - k) {
				deque.removeFirst();
			}


			ans[i - k + 1] = nums[deque.getFirst()];
		}
		return ans;
	}


	/**
	 * 滑动窗口自己写法
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int[] maxSlidingWindow2(int[] nums, int k) {
		int n = nums.length;
		Deque<Integer> deque = new LinkedList<>();
		List<Integer> list = new ArrayList<>();

		for (int j = 0; j < k - 1; j++) {
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j]) {
				deque.removeLast();
			}
			deque.addLast(j);
		}

		for (int j = k - 1; j < n; j++) {
			while (!deque.isEmpty() && deque.peekFirst() < j - k + 1) {
				deque.removeFirst();
			}
			int num = nums[j];
			if (!deque.isEmpty()) {
				list.add(Math.max(nums[deque.peekFirst()], num));
			} else {
				list.add(num);
			}

			while (!deque.isEmpty() && nums[deque.peekLast()] < num) {
				deque.removeLast();
			}
			deque.addLast(j);

		}

		int[] res = new int[list.size()];
		for (int j = 0; j < list.size(); j++) {
			res[j] = list.get(j);
		}
		return res;
	}


	/**
	 * 优先队列写法
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int[] maxSlidingWindow3(int[] nums, int k) {
		int n = nums.length;
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
		for (int i = 0; i < k; i++) {
			queue.offer(new int[]{nums[i], i});
		}
		int[] ans = new int[n - k + 1];
		ans[0] = queue.peek()[0];
		for (int i = k; i < n; i++) {
			queue.offer(new int[]{nums[i], i});
			while (queue.peek()[1] < i - k) {
				queue.poll();
			}
			ans[i - k + 1] = queue.peek()[0];
		}
		return ans;
	}


	public static void main(String[] args) {
		int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
		int[] ans = maxSlidingWindow2(nums, 3);
		ArrayUtils.printArray(ans);
	}
}
