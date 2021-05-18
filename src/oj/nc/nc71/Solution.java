package oj.nc.nc71;

public class Solution {

	public static int minNumberInRotateArray(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		int l = 0, r = arr.length - 1;
		while (l < r) {
			if (arr[l] < arr[r]) {
				return arr[l];
			}
			int mid = l + (r - l) / 2;
			if (arr[mid] > arr[r]) {
				l = mid + 1;
			} else if (arr[mid] < arr[r]) {
				r = mid;
			} else {
				r--;
			}
		}
		return arr[l];
	}

	public static void main(String[] args) {
		System.out.println(minNumberInRotateArray(new int[]{3, 4, 5, 1, 2}));
	}
}
