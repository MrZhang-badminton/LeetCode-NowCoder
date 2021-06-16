import sun.tools.jconsole.inspector.XNodeInfo;
import utils.ds.ListNode;
import utils.ds.TreeNode;
import utils.methods.ArrayUtils;

import java.util.*;


public class ExcesicesReview {


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

	public static void quick(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}
		int l = left, r = right;
		int pivot = nums[left];
		while (l < r) {
			while (l < r && nums[r] >= pivot) {
				r--;
			}
			nums[l] = nums[r];
			while (l < r && nums[l] < pivot) {
				l++;
			}
			nums[r] = nums[l];
		}
		nums[l] = pivot;
		quick(nums, left, l - 1);
		quick(nums, l + 1, right);
	}


	/**
	 * 二分查找
	 *
	 * @param nums
	 * @return
	 */
	public static int findPeekElement(int[] nums) {
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = (l + r) / 2;
			if (nums[mid] > nums[mid + 1]) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}


	/**
	 * 两数之和
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static List<Integer> twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				list.add(map.get(target - nums[i]));
				list.add(i);
			} else {
				map.put(nums[i], i);
			}
		}
		return list;
	}

	/**
	 * 三数之和
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums, int target) {
		int n = nums.length;
		List<List<Integer>> ansList = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < n - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int remain = target - nums[i];
			int k = n - 1;
			for (int j = i + 1; j < n - 1; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				while (j < k && nums[j] + nums[k] > remain) {
					k--;
				}
				if (j == k) {
					break;
				}

				if (nums[j] + nums[k] == remain) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					ansList.add(list);
				}
			}
		}
		return ansList;
	}

	/**
	 * 无重复最长子串
	 *
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int right = 0, ans = 0;
		for (int i = 0; i < n; i++) {
			if (i != 0) {
				set.remove(s.charAt(i - 1));
			}
			while (right < n && !set.contains(s.charAt(right))) {
				set.add(s.charAt(right));
				right++;
			}
			ans = Math.max(ans, right - i);
		}
		return ans;
	}

	public static int nthUglyNumber(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		int idx2 = 1, idx3 = 1, idx5 = 1;
		for (int i = 2; i <= n; i++) {
			int two = dp[idx2] * 2;
			int three = dp[idx3] * 3;
			int five = dp[idx5] * 5;
			dp[i] = Math.min(Math.min(two, three), five);
			if (dp[i] == two) {
				idx2++;
			}
			if (dp[i] == three) {
				idx3++;
			}
			if (dp[i] == five) {
				idx5++;
			}
		}
		return dp[n];
	}

	public static String longestHuiwen(String s) {
		if (s == null || s == "") {
			return null;
		}

		int n = s.length();
		String ans = "";
		for (int i = 0; i < n - 1; i++) {
			//奇数情况
			int l = i, r = i;
			while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
				l--;
				r++;
			}
			if (r - l - 1 > ans.length()) {
				ans = s.substring(l + 1, r);
			}

			//偶数情况
			l = i;
			r = i + 1;
			while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
				l--;
				r++;
			}
			if (r - l - 1 > ans.length()) {
				ans = s.substring(l + 1, r);
			}
		}
		return ans;
	}

	public static int findK(int[] nums, int k) {
		return find(nums, 0, nums.length - 1, k - 1);
	}

	public static int find(int[] nums, int left, int right, int k) {
		if (left > right) {
			return -1;
		}
		int l = left, r = right;
		int pivot = nums[left];
		while (l < r) {
			while (l < r && nums[r] >= pivot) r--;
			nums[l] = nums[r];
			while (l < r && nums[l] < pivot) l++;
			nums[r] = nums[l];
		}
		nums[l] = pivot;
		if (l == k) {
			return pivot;
		} else if (l < k) {
			return find(nums, l + 1, right, k);
		} else {
			return find(nums, left, l - 1, k);
		}
	}

	public static List<List<Integer>> printZTree(TreeNode root) {
		List<List<Integer>> ansList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		TreeNode pre = root;
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		while (!deque.isEmpty()) {
			TreeNode p = deque.removeFirst();
			list.add(p.val);
			if (p.left != null) {
				deque.addLast(p.left);
			}
			if (p.right != null) {
				deque.addLast(p.right);
			}
			if (p == pre) {
				ansList.add(list);
				if (!deque.isEmpty()) {
					list = new ArrayList<>();
					pre = deque.getLast();
				}
			}
		}
		return ansList;
	}

	public static void printMatrixSpecial(int[][] matrix) {
		int left = 0, top = 0, right = matrix[0].length - 1, down = matrix.length - 1;
		List<Integer> ansList = new ArrayList<>();
		int count = 0;
		while (left <= right || top <= down) {
			List<Integer> list = new ArrayList<>();
			for (int i = left; i < right; i++) {
				list.add(matrix[top][i]);
			}
			for (int i = top; i < down; i++) {
				list.add(matrix[i][right]);
			}
			for (int i = right; i > left; i--) {
				list.add(matrix[down][i]);
			}
			for (int i = down; i > top; i--) {
				list.add(matrix[i][left]);
			}
			if ((count & 1) == 1) {
				int temp = list.remove(0);
				list.add(temp);
				Collections.reverse(list);
			}
			left++;
			top++;
			right--;
			down--;
			ansList.addAll(list);
			count++;
		}
		System.out.println(ansList);
	}

	//	public static void main(String[] args) {
//		int[][] matrix = new int[][]{
//				{1, 2, 3, 4},
//				{5, 6, 7, 8},
//				{9, 10, 11, 12},
//				{13, 14, 15, 16}
//		};
//		printMatrixSpecial(matrix);
//	}

	public static TreeNode findCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		TreeNode ansNode = null;
		find(root, node1, node2, ansNode);
		return ansNode;
	}

	public static boolean find(TreeNode root, TreeNode node1, TreeNode node2, TreeNode ansNode) {
		if (root == null) {
			return false;
		}
		boolean left = find(root.left, node1, node2, ansNode);
		boolean right = find(root.right, node1, node2, ansNode);
		if ((left && right) || (root.val == node1.val || root.val == node2.val) && (left || right)) {
			ansNode = root;
		}
		return left || right || (root.val == node1.val || root.val == node2.val);
	}

	public static int random5() {
		return 1;
	}

	public static int random7() {
		int num;
		do {
			num = (random5() - 1) * 5 + random5();
		} while (num > 21);
		return num % 7 + 1;
	}


	public static TreeNode buildTree(int[] in, int[] post) {
		return build(in, 0, in.length - 1, post, 0, post.length - 1);
	}

	public static TreeNode build(int[] in, int l1, int r1, int[] post, int l2, int r2) {
		if (l1 > r1) {
			return null;
		}
		int value = post[r2];
		TreeNode root = new TreeNode(value);
		int len = 0;
		while (in[l1 + len] != value) {
			len++;
		}

		root.left = build(in, l1, l1 + len - 1, post, l2, l2 + len - 1);
		root.right = build(in, l1 + len + 1, r1, post, l2 + len, r2 - 1);
		return root;
	}

//	public static void main(String[] args) {
//		TreeNode root = buildTree(new int[]{4, 2, 5, 1, 6, 3, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
//		TreeNode.printTree(root);
//	}

	public static int shortestSubarray(int[] A, int K) {
		int n = A.length;
		long[] p = new long[n + 1];
		for (int i = 0; i < n; i++) {
			p[i + 1] = p[i] + (long) A[i];
		}
		int ans = n + 1;
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < n + 1; i++) {
			while (!deque.isEmpty() && p[deque.getLast()] >= p[i]) {
				deque.removeLast();
			}
			while (!deque.isEmpty() && p[deque.getFirst()] + K <= p[i]) {
				ans = Math.min(ans, i - deque.removeFirst());
			}
			deque.addLast(i);
		}
		return ans < n + 1 ? ans : -1;
	}

//	public static void main(String[] args) {
//		System.out.println(shortestSubarray(new int[]{2, -1, 2}, 3));
//	}

}
