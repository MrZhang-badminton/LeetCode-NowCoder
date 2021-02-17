package oj.lc.q2000.lc1626;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public static int bestTeamScore(int[] scores, int[] ages) {
		int n = scores.length;
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = ages[i];
			arr[i][1] = scores[i];
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		/**
		 * dp是以i结尾的，最大子序列
		 */
		int[] dp = new int[n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			dp[i] = arr[i][1];
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j][1] <= arr[i][1]){
					dp[i] = Math.max(dp[j] + arr[i][1],dp[i]);
				}
			}
			ans = dp[i] > ans ? dp[i] : ans;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(bestTeamScore(new int[]{4, 1, 2, 6}, new int[]{1, 1, 2, 2}));
	}
}

