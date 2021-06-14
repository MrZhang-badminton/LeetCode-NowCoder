package oj.lc.q500.lc4;

public class Solution {

	/**
	 * 写法较为复杂
	 * 时间复杂度为O(m+n)
	 * 空间复杂度为O(1)
	 *
	 * @param A
	 * @param B
	 * @return
	 */
	public static double findMedianSortedArrays(int[] A, int[] B) {
		int n1 = A.length, n2 = B.length;
		int k = (n1 + n2) / 2;
		if ((n1 + n2) % 2 == 0) {

			return ((double) find(A, B, k) + find(A, B, k + 1)) / 2;
		} else {
			return find(A, B, k + 1);
		}
	}

	/**
	 * 找到这两个数组中，所有数值的第K大
	 *
	 * @param A
	 * @param B
	 * @param k
	 * @return
	 */
	public static int find(int[] A, int[] B, int k) {
		int n1 = A.length, n2 = B.length;
		int i = 0, j = 0;
		int count = 0, temp = -1;
		while (count < k && i < n1 && j < n2) {
			if (A[i] < B[j]) {
				temp = A[i++];
			} else {
				temp = B[j++];
			}
			count++;
		}
		while (count < k && i < n1) {
			temp = A[i++];
			count++;
		}
		while (count < k && j < n2) {
			temp = B[j++];
			count++;
		}
		return temp;
	}

	/**
	 * 来自题解
	 * 写法相对简单明了
	 * 时间复杂度依然为O(m+n)
	 * 空间复杂度为O(1)
	 *
	 * @param A
	 * @param B
	 * @return
	 */
	public static double findMedianSortedArrays2(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int len = m + n;
		int left = -1, right = -1;
		int aStart = 0, bStart = 0;
		for (int i = 0; i <= len / 2; i++) {
			left = right;
			if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
				right = A[aStart++];
			} else {
				right = B[bStart++];
			}
		}
		if ((len & 1) == 0)
			return (left + right) / 2.0;
		else
			return right;

	}

	/**
	 * 二分法
	 * 时间复杂度O(n)
	 * 空间复杂度O(1)
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int left = (n + m + 1) / 2;
		int right = (n + m + 2) / 2;
		return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) +
				getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;

	}

	public static int getKth(int[] nums1, int start1, int end1,
							 int[] nums2, int start2, int end2, int k) {
		int len1 = end1 - start1 + 1;
		int len2 = end2 - start2 + 1;

		if (len1 > len2) {
			return getKth(nums2, start2, end2, nums1, start1, end1, k);
		}
		if (len1 == 0) {
			return nums2[start2 + k - 1];
		}
		if (k == 1) {
			return Math.min(nums1[start1], nums2[start2]);
		}

		int i = start1 + Math.min(len1, k / 2) - 1;
		int j = start2 + Math.min(len2, k / 2) - 1;

		if (nums1[i] > nums2[j]) {
			return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
		} else {
			return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
		}
	}

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays3(new int[]{1, 2}, new int[]{3, 4}));
	}
}
