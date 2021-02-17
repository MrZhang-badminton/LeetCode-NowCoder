package oj.lc.jz.lcjz45;

public class Solution {

	//	public static String minNumber(int[] nums) {
//		String[] strings = new String[nums.length];
//		for (int i = 0; i < nums.length; i++) {
//			strings[i] = String.valueOf(nums[i]);
//		}
//		Arrays.sort(strings,(x, y)->(x + y).compareTo(y + x));
//		StringBuilder sb = new StringBuilder();
//		for(String s : strings){
//			sb.append(s);
//		}
//		return sb.toString();
//	}
//
	public static void fastSort(String[] strings, int left, int right) {
		if (left >= right) {
			return;
		}
		int l = left, r = right;
		String tempString = strings[left];
		while (l < r) {
			while (l < r && (strings[r] + strings[left]).compareTo((strings[left] + strings[r])) >= 0) {
				r--;
			}
			while (l < r && (strings[l] + strings[left]).compareTo((strings[left] + strings[l])) <= 0) {
				l++;
			}
			tempString = strings[l];
			strings[l] = strings[r];
			strings[r] = tempString;
		}
		strings[l] = strings[left];
		strings[left] = tempString;
		fastSort(strings, left, l - 1);
		fastSort(strings, l + 1, right);

	}

	public static String minNumber(int[] nums) {
		String[] strings = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strings[i] = String.valueOf(nums[i]);
		}
		fastSort(strings, 0, strings.length - 1);
		StringBuilder sb = new StringBuilder();
		for (String s : strings) {
			sb.append(s);
		}
		return sb.toString();
	}

//	public static String largestNumber(int[] nums) {
//		String[] strings = new String[nums.length];
//		for (int i = 0; i < nums.length; i++) {
//			strings[i] = String.valueOf(nums[i]);
//		}
//		Arrays.sort(strings,(x, y)->(y + x).compareTo(x + y));
//		StringBuilder sb = new StringBuilder();
//		for(String s : strings){
//			sb.append(s);
//		}
//		int i;
//		for (i = 0; i < sb.length(); i++) {
//			if(sb.charAt(i) != '0'){
//				break;
//			}
//		}
//		if(i == sb.length()){
//			return "0";
//		}
//		return sb.toString();
//	}

	public static void main(String[] args) {

		int[] nums = new int[]{1,2,3,1};
		System.out.println(minNumber(nums));

	}
}
