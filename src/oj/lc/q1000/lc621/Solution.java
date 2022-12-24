package oj.lc.q1000.lc621;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/12/25 00:33
 */
public class Solution {


	/**
	 * 贪心法
	 * 来自题解：https://leetcode.cn/problems/task-scheduler/solutions/2020840/by-stormsunshine-hxv6/?languageTags=java
	 *
	 * @param tasks
	 * @param n
	 * @return
	 */
	public static int leastInterval(char[] tasks, int n) {
		int maxCnt = 0;
		int[] arr = new int[26];
		for (char ch : tasks) {
			arr[ch - 'A']++;
			maxCnt = Math.max(maxCnt, arr[ch - 'A']);
		}

		int maxTasks = 0;
		for (Integer i : arr) {
			if (i == maxCnt) {
				maxTasks++;
			}
		}

		int total = (n + 1) * (maxCnt - 1) + maxTasks;
		return Math.max(total, tasks.length);
	}

	public static void main(String[] args) {

		System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
	}
}
