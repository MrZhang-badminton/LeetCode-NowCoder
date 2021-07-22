package basicalogrithm.others;

/**
 * @date 2021年04月21日01:40:08
 * 找到第k大个数
 */
public class FindKtH {

	public static void main(String[] args) {
		System.out.println(findK(new int[]{1,2,2,3,4,5}, 3));
	}

	public static int findK(int[] arr, int k) {
		return partition(arr, 0, arr.length - 1, k - 1);
	}

	public static int partition(int[] arr, int left, int right, int index) {
		int pivot = arr[left];
		int l = left, r = right;
		while (l < r) {
			while (l < r && arr[r] >= pivot) {
				r--;
			}
			arr[l] = arr[r];
			l++;
			while (l < r && arr[l] <= pivot) {
				l++;
			}
			arr[r] = arr[l];
			r--;
		}
		arr[l] = pivot;
		int ans;
		if (l == index) {
			ans = pivot;
		} else if (l < index) {
			ans = partition(arr, l + 1, right, index);
		} else {
			ans = partition(arr, left, l - 1, index);
		}

		return ans;
	}
}
