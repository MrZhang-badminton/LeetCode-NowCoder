package basic.search;


public class BinarySearch {

	/**
	 * 找到值为target的数的index，如果target有多个重复的值
	 * 那么返回的index可能使这几个target中的某个index
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int findTarget(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}


	/**
	 * 找到target，并且输出第一个target的index
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int findFirstTime2(int[] nums, int target) {
		int l = 0, r = nums.length - 1, pos = -2;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] < target) {
				pos = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return pos + 1;
	}


	/**
	 * 比target小的数值的最后边位置
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int findTargetPreIndex(int[] nums, int target) {
		int l = 0, r = nums.length - 1, pos = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] < target) {
				pos = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return pos;
	}

	/**
	 * 找到比target的数的最左边的index
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int findTargetPostIndex(int[] nums, int target) {
		int l = 0, r = nums.length - 1, pos = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] <= target) {
				l = mid + 1;
			} else {
				pos = mid;
				r = mid - 1;
			}
		}
		return pos;
	}


	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 4, 4, 4, 5};
		System.out.println(findFirstTime2(nums, 4));
//		System.out.println(findTargetPreIndex(new int[]{1, 3, 3, 3, 4, 4, 6, 9}, 4));
//		System.out.println(findTargetPostIndex(new int[]{1, 3, 3, 3, 4, 4, 6, 9}, 4));
//		System.out.println(findTarget(new int[]{1, 3, 3, 3, 4, 4, 6, 9}, 3));
	}

}
