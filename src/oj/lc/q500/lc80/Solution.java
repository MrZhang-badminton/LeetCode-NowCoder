package oj.lc.q500.lc80;

class Solution {
//	public static int removeDuplicates(int[] nums) {
//		int n = nums.length;
//		HashMap<Integer,Integer> map = new HashMap<>();
//		int index = 0;
//		for (int i = 0; i < n; i++) {
//			boolean flag = map.containsKey(nums[i]);
//			if(!flag){
//				nums[index++] = nums[i];
//				map.put(nums[i],1);
//			}else if(map.get(nums[i]) < 2){
//				nums[index++] = nums[i];
//				map.replace(nums[i],2);
//			}
//		}
//		return index;
//	}

	public static int removeDuplicates(int[] nums) {
		int n = nums.length;
		if(n <= 2){
			return 2;
		}
		int index = 2;
		for (int i = 2; i < n; i++) {
			if(nums[i] != nums[index-1]){
				nums[index++] = nums[i];
			} else if(nums[i] != nums[index-2]){
				nums[index++] = nums[i];
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1,1,1,2,2,3};
		int len = removeDuplicates(nums);
		System.out.println(len);
		for (int i = 0; i < len; i++) {
			System.out.println(nums[i]);
		}
	}
}