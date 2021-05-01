package utils.methods;

public class ArrayUtils {
	/**
	 * 打印数组
	 *
	 * @param nums
	 */
	public static void printArray(int[] nums) {
//		System.out.print("[");
		for (int i = 0; i < nums.length; i++) {
			if (i < nums.length - 1) {
				System.out.print(nums[i] + ", ");
			} else {
				System.out.print(nums[i]);
			}
		}
//		System.out.print("]");
		System.out.println();
	}

	public static void printArray(int[][] nums) {
		int nr = nums.length,nc = nums[0].length;
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				if(j == nc-1){
					System.out.print(nums[i][j]);
					continue;
				}
				System.out.print(nums[i][j] + ", ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		printArray(new int[][]{{1, 2}, {3, 4}});
//		printArray(new int[]{1,2,3,4});
	}
}
