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
	 * 是否有环
	 *
	 * @param head
	 * @return
	 */
	public static boolean isHasCycle(ListNode head) {
		ListNode slow, fast;
		slow = head;
		fast = head;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 找到环的入口
	 *
	 * @param head
	 * @return
	 */
	public static ListNode findEntrance(ListNode head) {
		ListNode slow, fast;
		slow = head;
		fast = head;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
			if (fast == slow) {
				break;
			}
		}
		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	/**
	 * 反转链表
	 *
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head) {
		ListNode pHead = new ListNode(-1);
		while (head != null) {
			ListNode p = head.next;
			head.next = pHead.next;
			pHead.next = head;
			head = p;
		}
		return pHead.next;
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
	 * 重排序
	 * 1->2->3->4->5
	 * <p>
	 * 1->5->2->4->3
	 *
	 * @param head
	 * @return
	 */
	public static ListNode sortList(ListNode head) {
		ListNode pHead = new ListNode(-1);
		pHead.next = head;
		ListNode slow = pHead, fast = pHead;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
		}
		ListNode head2 = slow.next;
		slow.next = null;

		head2 = reverseList(head2);
		pHead.next = null;
		ListNode tail = pHead;
		while (head != null && head2 != null) {
			ListNode next = head.next;
			head.next = null;
			tail.next = head;
			tail = tail.next;
			head = next;

			next = head2.next;
			head2.next = null;
			tail.next = head2;
			tail = tail.next;
			head2 = next;
		}
		if (head != null) {
			tail.next = head;
		}
		if (head2 != null) {
			tail.next = head2;
		}

		return pHead.next;
	}

	/**
	 * K个一组翻转链表
	 *
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode reverseK(ListNode head, int k) {
		ListNode pHead = new ListNode(-1);
		pHead.next = head;
		ListNode p = pHead;
		int count = 0;
		while (count < k && p.next != null) {
			count++;
			p = p.next;
		}
		if (count < k) {
			return head;
		}
		ListNode othersNode = p.next;
		p.next = null;
		ListNode tail = pHead.next;
		pHead.next = reverseList(pHead.next);
		tail.next = reverseK(othersNode, k);
		return pHead.next;
	}


	private static TreeNode ansNode;

	/**
	 * 寻找最新公共最先
	 *
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode findCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		ansNode = null;
		dfs(root, p, q);
		return ansNode;
	}

	public static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return false;
		}
		boolean left = dfs(root.left, p, q);
		boolean right = dfs(root.right, p, q);

		if ((left && right) || ((root == p || root == q) && (left || right))) {
			ansNode = root;
		}

		return left || right || root == q || root == p;
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
	 * 根据前中序列，建立二叉树
	 *
	 * @param pre
	 * @param in
	 * @return
	 */
	public static TreeNode buildTree(int[] pre, int[] in) {
		return build(pre, 0, pre.length - 1, in, 0, pre.length - 1);

	}

	public static TreeNode build(int[] pre, int l1, int r1, int[] in, int l2, int r2) {
		if (l1 > r1) {
			return null;
		}
		int val = pre[l1];
		TreeNode root = new TreeNode(val);
		int i = l2;
		for (; i <= r2; i++) {
			if (in[i] == val) {
				break;
			}
		}
		int len = i - l2;

		root.left = build(pre, l1 + 1, l1 + len, in, l2, i - 1);
		root.right = build(pre, l1 + len + 1, r1, in, i + 1, r2);
		return root;

	}

	/**
	 * 树的镜像
	 *
	 * @param root
	 * @return
	 */
	public static TreeNode mirrorTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode tNode = root.left;
		root.left = mirrorTree(root.right);
		root.right = mirrorTree(tNode);
		return root;
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

	/**
	 * random7()实现random10()
	 *
	 * @return
	 */
	public static int random10() {
		int row, col, index;
		do {
			row = random7();
			col = random7();
			index = (random7() - 1) * 7 + col;
		} while (index > 40);
		return index % 10 + 1;
	}

	public static int random7() {
		return 1;
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

	public static void preOrder(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				System.out.println(p.val);
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop().right;
			}
		}
	}


	public static void postOrder(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode p = root, preVisited = null;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				TreeNode tNode = stack.peek();
				if (tNode.right == null || tNode.right == preVisited) {
					System.out.println(tNode.val);
					preVisited = tNode;
					stack.pop();
				} else {
					p = tNode.right;
				}
			}
		}
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

	public static void main(String[] args) {
//		int[] nums = new int[]{4,3,76,4,1,89,5};
//		ArrayUtils.printArray(quickSort(nums));

//		ListNode head = ListNode.createList(new int[]{1, 2, 3, 4, 5});
//		head.next.next.next = head.next;
//		System.out.println(findEntrance(head).val);

//		ListNode.printListNode(reverseK(head, 2));

//		System.out.println(findPeekElement(new int[]{1, 2, 3, 2, 1, 4, 3}));

//
//		TreeNode root = TreeNode.createTree(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4, -1, -1, -1, -1});
//		TreeNode p = root.left, q = root.left.right.right;
//		System.out.println(findCommonAncestor(root, p, q).val);

//		System.out.println(twoSum(new int[]{3, 2, 4}, 6));
//		System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}, 0));

//		TreeNode root = buildTree(new int[]{1, 2, 4, 5, 3}, new int[]{4, 2, 5, 1, 3});
//		TreeNode.printTree(root);

//		TreeNode root = TreeNode.createTree(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4, -1, -1, -1, -1});
//		TreeNode.printTree(root);
//		TreeNode.printTree(mirrorTree(root));


//		System.out.println(lengthOfLongestSubstring("abcabcbb"));

//		System.out.println(nthUglyNumber(10));


//		TreeNode root = TreeNode.createTree(new int[]{1, 2, 3, 4, 5});
//		postOrder(root);

		System.out.println(longestHuiwen("12321444444"));
	}

}
