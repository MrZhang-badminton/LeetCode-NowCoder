package oj.nc.ncjz64;

import java.util.*;

public class Solution {

	/**
	 * 暴力算法
	 * 时间复杂度O(n*k)
	 *
	 * @param num
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> maxInWindows(int[] num, int size) {
		int n = num.length;
		ArrayList<Integer> list = new ArrayList<>();
		if (size > n || size == 0) {
			return list;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<>(
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o2 - o1;
					}
				}
		);
		for (int i = size - 1; i < n; i++) {
			queue.clear();
			for (int j = i; j >= i - size + 1; j--) {
				queue.add(num[j]);
			}
			list.add(queue.poll());
		}
		return list;
	}

	/**
	 * 单调栈
	 * 时间复杂度O(n)
	 *
	 * @param num
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> maxInWindows2(int[] num, int size) {
		Deque<Integer> deque = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		int n = num.length;
		if (n == 0 || size < 1 || n < size) {
			return list;
		}
		for (int i = 0; i < n; i++) {
			while (!deque.isEmpty() && num[deque.getLast()] < num[i]) {
				deque.removeLast();
			}
			deque.addLast(i);
			if (deque.getFirst() + size <= i) {
				deque.removeFirst();
			}
			if (i + 1 >= size) {
				list.add(num[deque.getFirst()]);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(maxInWindows2(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
	}

}
