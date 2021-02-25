package oj.lc.q1000.lc566;

public class Solution {
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		int nr = nums.length;
		int nc = nums[0].length;
		int count1 = nr * nc;
		if(r*c != count1){
			return nums;
		}
		int[][] result = new int[r][c];
		int count2 = 0;
		for (int i = 0; i < count1; i++) {
			int r1 = i / nc, c1 = i % nc;
			int r2 = count2 / c, c2 = count2 % c;
			result[r2][c2] = nums[r1][c1];
			count2++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] result = matrixReshape(new int[][]{
						{1, 2},
						{3, 4}},
				2, 4);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
