package utils;

public class SearchUtils {

	/**
	 * 找到和目标值相等的数的下标
	 * 但是得确定数组中有target
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int binarySearchTarget(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return l;
	}

	/**
	 * 特殊情况未考虑，具体情况具体分析
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int binarySearch(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = (l + r) / 2;
			if (nums[mid] <= target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return l;
	}

//	public static void main(String[] args) {
//		int[] nums = new int[]{6,6,6,6,6};
//		System.out.println(binarySearchTarger(nums, 6));
//	}
}
