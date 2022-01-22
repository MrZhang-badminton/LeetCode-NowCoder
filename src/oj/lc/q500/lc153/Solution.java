package oj.lc.q500.lc153;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/1/22 7:57 下午
 */
public class Solution {

	/**
	 * 二分法
	 *
	 * @param nums
	 * @return
	 */
	public static int findMin(int[] nums) {
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int pivot = low + (high - low) /2 ;
			if(nums[pivot] < nums[high]){
				high = pivot;
			}else {
				low = pivot + 1;
			}
		}
		return nums[low];
	}


	public static void main(String[] args) {
		System.out.println(findMin(new int[]{3, 1, 2}));
	}

}
