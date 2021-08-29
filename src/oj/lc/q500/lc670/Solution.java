package oj.lc.q500.lc670;

/**
 * @Classname: Solution
 * @Author: zhanghua
 * @Date: 2021/8/29 3:12 下午
 */
public class Solution {

	/**
	 * 方法一：暴力算法
	 * 时间复杂度O(n)
	 *
	 * @param num
	 * @return
	 */
	public static int maximumSwap(int num) {
		String s = String.valueOf(num);
		int n = s.length();
		String result = s;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				char l = s.charAt(i);
				char r = s.charAt(j);
				StringBuilder sb = new StringBuilder(s);
				sb.deleteCharAt(i);
				sb.insert(i, r);
				sb.deleteCharAt(j);
				sb.insert(j, l);
				if (Integer.valueOf(sb.toString()) > Integer.valueOf(result)) {
					result = sb.toString();
				}
			}
		}
		return Integer.valueOf(result);
	}

	/**
	 * 方法二：同方法一，写法更优雅（来自题解）
	 *
	 * @param num
	 * @return
	 */
	public int maximumSwap2(int num) {
		String s = String.valueOf(num);
		int len = s.length();
		char[] charArray = s.toCharArray();
		int max = num;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				swap(charArray, i, j);
				max = Math.max(max, Integer.parseInt(new String(charArray)));
				swap(charArray, i, j);
			}
		}
		return max;
	}

	private void swap(char[] charArray, int index1, int index2) {
		char temp = charArray[index1];
		charArray[index1] = charArray[index2];
		charArray[index2] = temp;
	}

	/**
	 * 方法三：贪心算法
	 * 时间复杂度O(n)
	 *
	 * @param num
	 * @return
	 */
	public int maximumSwap3(int num) {
		String s = String.valueOf(num);
		int len = s.length();
		char[] charArray = s.toCharArray();

		// 记录每个数字出现的最后一次出现的下标
		int[] last = new int[10];
		for (int i = 0; i < len; i++) {
			last[charArray[i] - '0'] = i;
		}

		// 从左向右扫描，找到当前位置右边的最大的数字并交换
		for (int i = 0; i < len - 1; i++) {
			// 找最大，所以倒着找
			for (int d = 9; d > charArray[i] - '0'; d--) {
				if (last[d] > i) {
					swap(charArray, i, last[d]);
					// 只允许交换一次，因此直接返回
					return Integer.parseInt(new String(charArray));
				}
			}
		}
		return num;
	}

	public static void main(String[] args) {
		System.out.println(maximumSwap(2736));
	}
}
