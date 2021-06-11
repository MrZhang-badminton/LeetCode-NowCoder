package utils.methods;

public class ArrayUtils {
	/**
	 * 打印数组
	 *
	 * @param nums
	 */
	public static void printArray(int[] nums) {
		System.out.print("[");
		for (int i = 0; i < nums.length; i++) {
			if (i < nums.length - 1) {
				System.out.print(nums[i] + ", ");
			} else {
				System.out.print(nums[i]);
			}
		}
		System.out.print("]");
		System.out.println();
	}

	public static void printArray(int[][] nums) {
		System.out.print("[");
		System.out.println();
		if (nums == null || nums.length == 0 || nums[0].length == 0) {
			System.out.print("]");
			return;
		}
		int nr = nums.length, nc = nums[0].length;
		for (int i = 0; i < nr; i++) {
			System.out.print(" [");
			for (int j = 0; j < nc; j++) {
				if (j == nc - 1) {
					System.out.print(nums[i][j]);
					continue;
				}
				System.out.print(nums[i][j] + ", ");
			}
			System.out.print("]");
			if(i != nr-1){
				System.out.print(",");
			}
			System.out.println();
		}
		System.out.print("]");
		System.out.println();
	}

	public static void main(String[] args) {
		printArray(new int[][]{{1, 2, 4}, {3, 4, 10}, {4, 2, 5}});

	}
}
