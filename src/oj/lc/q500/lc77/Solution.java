package oj.lc.q500.lc77;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/12/28 00:02
 */
public class Solution {

	private static List<List<Integer>> ret;


	public static List<List<Integer>> combine(int n, int k) {
		ret = new ArrayList<>();
		backTrace(n, k, new ArrayList<>(), 1);
		return ret;
	}


	/**
	 * 回溯
	 *
	 * @param n
	 * @param k
	 * @param list
	 * @param i
	 */
	private static void backTrace(int n, int k, List<Integer> list, int i) {
		if (list.size() == k) {
			ret.add(new ArrayList<>(list));
			return;
		}

		for (int j = i; j <= n; j++) {
			list.add(j);
			backTrace(n, k, list, j + 1);
			list.remove(list.size() - 1);
		}
	}


	public static void main(String[] args) {
		System.out.println(combine(4, 2));
	}

}
