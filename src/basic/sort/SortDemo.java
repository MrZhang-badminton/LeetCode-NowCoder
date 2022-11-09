package basic.sort;

/**
 * @author Peter Hua
 * @date 2021年04月21日15:32:58
 * <p>
 * 一些排序算法
 */
public class SortDemo {

	public static void main(String[] args) {
		//调用排序函数
		int[] ans = quickSort(new int[]{5, 1, 2, 8, 3, 10, 12});


		for (int i = 0; i < ans.length; i++) {
			if (i != ans.length - 1) {
				System.out.print(ans[i] + ",");
			} else {
				System.out.println(ans[i]);
			}
		}
	}

	/**
	 * 冒泡排序
	 *
	 * @param arr
	 * @return
	 */
	public static int[] bubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = n - 1; i > 0; i--) {
			boolean flag = false;
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					swap(arr, j, j + 1);
				}
			}
			if (!flag) {
				break;
			}
		}
		return arr;
	}


	/**
	 * 选择排序
	 *
	 * @param arr
	 * @return
	 */
	public static int[] selectSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {

			int min = arr[i];
			int index = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < min) {
					min = arr[j];
					index = j;
				}
			}
			swap(arr, i, index);
		}
		return arr;
	}


	/**
	 * 快速排序
	 *
	 * @param nums
	 * @return
	 */
	public static int[] quickSort(int[] nums) {
		quick(nums, 0, nums.length - 1);
		return nums;
	}

	private static void quick(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}

		int pivot = arr[left];
		int l = left, r = right;
		while (l < r) {
			while (l < r && arr[r] > pivot) {
				r--;
			}
			if (l < r) {
				arr[l++] = arr[r];
			}
			while (l < r && arr[l] < pivot) {
				l++;
			}
			if (l < r) {
				arr[r--] = arr[l];
			}
		}
		arr[l] = pivot;
		quick(arr, left, l - 1);
		quick(arr, l + 1, right);

	}

	/**
	 * 堆排序
	 *
	 * @param arr
	 * @return
	 */
	public static int[] heapSort(int[] arr) {
		int n = arr.length;
		//最大堆
		buildHeap(arr);
		for (int i = n - 1; i > 0; i--) {
			swap(arr, 0, i);
			down(arr, 0, i - 1);
		}
		return arr;
	}

	/**
	 * 建堆操作
	 *
	 * @param arr
	 */
	public static void buildHeap(int[] arr) {
		int n = arr.length;
		for (int i = (n - 1) / 2; i >= 0; i--) {
			down(arr, i, n - 1);
		}
	}

	/**
	 * 下沉操作
	 *
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void down(int[] arr, int start, int end) {
		if (start == end) {
			return;
		}
		int i = start;
		while (i <= end) {
			int left = i * 2 + 1;
			int right = left + 1;
			// index指向值最大的子节点
			int index = left;

			// 如果有右子节点且大于左节点, 则index指向右节点
			if (right <= end && arr[left] < arr[right]) {
				index = right;
			}
			// 如果有子节点, 并且子节点中最大的大于当前节点, 则交换
			if (index <= end && arr[i] < arr[index]) {
				swap(arr, i, index);
			}
			i = index;
		}
	}

	/**
	 * 归并排序
	 *
	 * @param arr
	 * @return
	 */
	public static int[] mergeSort(int[] arr) {
		int n = arr.length;
		//用作中间数组，避免重复申请数组
		int[] temp = new int[n];

		mSort(arr, 0, n - 1, temp);

		return arr;
	}

	public static void mSort(int[] arr, int left, int right, int[] temp) {
		if (left >= right) {
			return;
		}
		int mid = (left + right) / 2;
		mSort(arr, left, mid, temp);
		mSort(arr, mid + 1, right, temp);
		merge(arr, left, mid, right, temp);
	}

	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int l1 = left, l2 = mid + 1;
		int index = left;
		while (l1 <= mid && l2 <= right) {
			if (arr[l1] < arr[l2]) {
				temp[index++] = arr[l1++];
			} else {
				temp[index++] = arr[l2++];
			}
		}
		while (l1 <= mid) {
			temp[index++] = arr[l1++];
		}
		while (l2 <= right) {
			temp[index++] = arr[l2++];
		}

		for (int i = left; i <= right; i++) {
			arr[i] = temp[i];
		}
	}


	public static void swap(int[] arr, int l, int r) {
		if (l == r) {
			return;
		}
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}

}
