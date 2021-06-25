package oj.lc.q500.lc134;

public class Solution {

	/**
	 * 暴力算法
	 * 时间复杂度O(n^2)
	 *
	 * @param gas
	 * @param cost
	 * @return
	 */
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;
		for (int i = 0; i < n; i++) {
			int sum = gas[i] - cost[i];
			if (judge(gas, cost, i, next(n, i), sum)) {
				return i;
			}
		}
		return -1;
	}

	public static int next(int n, int index) {
		if (++index == n) {
			return 0;
		} else {
			return index;
		}
	}

	public static boolean judge(int[] gas, int[] cost, int index, int curIndex, int sum) {
		int n = cost.length;
		if (sum < 0) {
			return false;
		}
		if (curIndex == index) {
			return true;
		}

		sum = sum + gas[curIndex] - cost[curIndex];
		return judge(gas, cost, index, next(n, curIndex), sum);
	}

	/**
	 * 只遍历一次
	 * 时间复杂度为O(n)
	 *
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit2(int[] gas, int[] cost) {
		int n = gas.length;
		int i = 0;
		while (i < n) {
			int sumOfGas = 0, sumOfCost = 0;
			int cnt = 0;
			while (cnt < n) {
				int j = (i + cnt) % n;
				sumOfGas += gas[j];
				sumOfCost += cost[j];
				if (sumOfCost > sumOfGas) {
					break;
				}
				cnt++;
			}
			if (cnt == n) {
				return i;
			} else {
				i = i + cnt + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(canCompleteCircuit(new int[]{2, 3, 4,}, new int[]{3, 4, 3}));
	}
}
