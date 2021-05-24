package basealogrithm.search;

/**
 * 找到k在列表中第此出现的位置（从1开始计数）
 */
public class BinarySearch {

	public static int find(int[] nums, int k) {
		int l = 0, r = nums.length - 1;
		int mid = -1;
		while (l <= r) {
			mid = (l + r) / 2;
			if (nums[mid] == k) {
				break;
			} else if (nums[mid] < k) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		if (nums[mid] == k) {
			int i = mid;
			while (nums[i] == k) {
				i--;
			}
			return i + 1 + 1;
		}

		return nums.length + 1;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 4, 4, 4, 5};
		System.out.println(find(nums, 4));
	}

}
