package oj.nc.nc91;

import java.util.Arrays;

public class Solution2 {
	public static int[] LIS(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];
		int[] path = new int[n];
		path[0] = -1;

		Arrays.fill(dp, 1);
		for (int i = 1; i < n; i++) {
			int index = -1;
			int minVal = arr[i];
			int dpVal = dp[i];
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i] && arr[j] < minVal && dp[j] + 1 >= dpVal) {
					index = j;
					minVal = arr[j];
					dpVal = dp[j] + 1;
				}
			}
			path[i] = index;
			dp[i] = dpVal;
		}

		int max = -1;
		int index = -1;
		int minVal = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (dp[i] > max) {
				max = dp[i];
				index = i;
				minVal = arr[i];
			}else if(dp[i] == max && arr[i] < minVal){
				minVal = arr[i];
				index = i;
			}
		}
		int[] ret = new int[max];
		ret[--max] = arr[index];

		while (max > 0) {
			ret[--max] = arr[path[index]];
			index = path[index];
		}

		return ret;
	}


	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 8, 6, 4};
		int[] res = LIS(arr);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
}
