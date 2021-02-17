package oj.nc.nc199;

import java.util.*;
public class Test {

	public static void partion(int[] arr, int left, int right, int k) {
		int pivot = arr[left];
		int l = left;
		int r = right;
		while (l < r) {
			while (l < r && arr[r] >= pivot) { r--;}
			arr[l] = arr[r];
			while(l < r && arr[l] <= pivot) { l++;}
			arr[r] = arr[l];
		}
		arr[l] = pivot;
		if(l < k) {
			partion(arr, l + 1, right, k - l);
		} else if(l > k) {
			partion(arr, left, l - 1, k);
		}
	}

	public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<>();

		if (input.length < k || k == 0) {
			return list;
		}

		partion(input, 0, input.length - 1, k - 1);
		for (int i = 0; i < k; i++) {
			list.add(input[i]);
		}

		Collections.sort(list);
		return list;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
		System.out.println(GetLeastNumbers_Solution(arr, 4));
		
	}
}
