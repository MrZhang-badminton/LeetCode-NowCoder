package oj.lc.q500.lc264;

public class Solution {
	//	public static int nthUglyNumber(int n) {
//		if(n <= 6){
//			return n;
//		}
//		int count = 6, i = 7;
//		while(true){
//			if(determine(i)){
//				++count;
//			}
//			if(count == n){
//				break;
//			}
//			i++;
//		}
//		return i;
//	}
//
//	public static boolean determine(int n){
//		while(n % 3 == 0){
//			n /= 3;
//		}
//		while(n % 5 == 0){
//			n /= 5;
//		}
//		while(n % 2 == 0){
//			n /= 2;
//		}
//
//		return n == 1;
//	}
	public static int nthUglyNumber(int n) {
		int two = 0, three = 0, five = 0;
		int[] dp = new int[n];
		dp[0] = 1;

		for (int i = 1; i < n; ++i) {
			int t1 = dp[two] * 2, t2 = dp[three] * 3, t3 = dp[five] * 5;
			dp[i] = Math.min(Math.min(t1, t2), t3);

			if (dp[i] == t1) {
				++two;
			}
			if (dp[i] == t2) {
				++three;
			}
			if (dp[i] == t3) {
				++five;
			}
		}
		return dp[n - 1];
	}

	public int singleNumber(int[] nums) {
		int ones = 0, twos = 0;
		for(int num : nums){
			ones = ones ^ num & ~twos;
			twos = twos ^ num & ~ones;
		}
		return ones;
	}
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(1352));
		String s = new String("123");
		StringBuilder sb = new StringBuilder(s);
	}
}
