package oj.lc.q500.lc6;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/**
	 * 将字符串转化为之字图的时候，将没有有字母的地方都用#填充
	 * 最后遍历的时候，横向遍历只记录非'#'的字母
	 *
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		List<String> list = new ArrayList<>();
		int i = 0;
		while (i < s.length()) {
			int k = i % (numRows - 1);
			if (k == 0) {
				if (i + numRows >= s.length()) {
					String str = s.substring(i, s.length());
					for (int j = str.length(); j < numRows; j++) {
						str = str + "#";
					}
					list.add(str);
				} else {
					list.add(s.substring(i, i + numRows));
				}
				i += numRows;
			} else {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < numRows - 1 - k; j++) {
					sb.append("#");
				}
				sb.append(s.substring(i, i + 1));
				for (int j = 0; j < k; j++) {
					sb.append("#");
				}
				list.add(sb.toString());
				i++;
			}
		}
		//最终将所有有效字符放入StringBuilder的实例对象中
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < numRows; j++) {
			for (int k = 0; k < list.size(); k++) {
				if ('#' != list.get(k).charAt(j)) {
					sb.append(list.get(k).charAt(j));
				}
			}
		}
		return sb.toString();

	}

	/**
	 * 将每一行初始化为一个StringBuilder
	 * 然后遍历每行的元素，插入相应的队列
	 * <p>
	 * 另外，这个地方应该观察到，行数的变化是向下，向上，循环往复
	 * 所以每次到达边界都要"调头"
	 * <p>
	 * 熟练运用本题中的"调头"方式！
	 *
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert2(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}

		List<StringBuilder> list = new ArrayList<>();
		for (int j = 0; j < numRows; j++) {
			list.add(new StringBuilder());
		}

		int curRow = 0;
		boolean goDown = false;

		for (char ch : s.toCharArray()) {
			list.get(curRow).append(ch);
			if (curRow == 0 || curRow == numRows - 1) {
				goDown = !goDown;
			}
			curRow += goDown ? 1 : -1;
		}
		StringBuilder sb = new StringBuilder();
		for (StringBuilder tempSb : list) {
			sb.append(tempSb);
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		System.out.println(convert2("A", 1));
	}
}
