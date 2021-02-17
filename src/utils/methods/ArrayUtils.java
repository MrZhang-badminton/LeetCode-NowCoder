package utils.methods;

public class ArrayUtils {
	public static void printArray(int[] nums){
		System.out.print("[");
		for (int i = 0; i < nums.length; i++) {
			if(i < nums.length - 1){
				System.out.print(nums[i] + ", ");
			}else {
				System.out.print(nums[i]);
			}
		}
		System.out.print("]");
	}

	public static void main(String[] args) {
		printArray(new int[]{1,2,3,4});
	}
}
