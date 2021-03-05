package oj.lc.q1000.lc836;

public class Solution {


	public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		if (rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
			return false;
		}
		return !(rec1[2] <= rec2[0] ||
				rec1[3] <= rec2[1] ||
				rec1[0] >= rec2[2] ||
				rec1[1] >= rec2[3]);
	}

	public static boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
		return (Math.min(rec1[2],rec2[2]) > Math.max(rec1[0],rec2[0])&&
				Math.min(rec1[3],rec2[3]) > Math.max(rec1[1],rec2[1]));
	}

	public static void main(String[] args) {
		System.out.println(isRectangleOverlap2(new int[]{2, 17, 6, 20}, new int[]{3, 8, 6, 20}));
	}
}
