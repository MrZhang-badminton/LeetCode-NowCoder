package basic.backtrace;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 2021年05月17日
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合，组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字，输入: k = 3, x = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class SumofNumbers {

	private static List<List<Integer>> retList;

	public static List<List<Integer>> findList(int target, int k) {
		retList = new LinkedList<>();
		LinkedList<Integer> list = new LinkedList<>();
		dfs(target, k, list);

		return retList;
	}

	public static void dfs(int target, int k, LinkedList<Integer> list) {
		if (target == 0 && k == 0) {
			ArrayList<Integer> tList = new ArrayList<>(list);
			retList.add(0, tList);
		} else if ((target == 0 && k != 0) || (target != 0 && k == 0)) {
			return;
		}
		for (int i = 1; i <= target - k + 1 && !list.contains(i); i++) {
			list.addFirst(i);
			dfs(target - i, k - 1, list);
			list.removeFirst();
		}
	}


	private static List<List<Integer>> ansList;

	public static List<List<Integer>> findList2(int target, int k) {
		ansList = new LinkedList<>();
		List<Integer> list = new LinkedList<>();

		dfss(target, k, list);
		return ansList;
	}

	public static void dfss(int target, int k, List<Integer> list) {
		if (target == 0 && k == 0) {
			ansList.add(new ArrayList<>(list));
		} else if ((target == 0 && k != 0) || (target != 0 && k == 0)) {
			return;
		}
		for (int i = 1; i <= target - k + 1; i++) {
			if (list.size() == 0 || (!list.contains(i) && (i > list.get(list.size() - 1)))) {
				list.add(list.size(), i);
				dfss(target - i, k - 1, list);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(findList2(10, 3));
	}
}
