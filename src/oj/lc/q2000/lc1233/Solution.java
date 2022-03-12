package oj.lc.q2000.lc1233;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/12 11:52 上午
 */
public class Solution {

	/**
	 * 简单题
	 * 采用了lamda写法
	 *
	 * @param folder
	 * @return
	 */
	public static List<String> removeSubfolders(String[] folder) {
		Arrays.sort(folder, Comparator.comparingInt(String::length));
		for (int i = 0; i < folder.length; i++) {
			if (folder[i] == null) {
				continue;
			}
			String str = folder[i] + "/";
			for (int j = i + 1; j < folder.length; j++) {
				String s = folder[j];
				if (s != null && s.startsWith(str)) {
					folder[j] = null;
				}
			}
		}

		return Arrays.stream(folder).filter(Objects::nonNull).collect(Collectors.toList());
	}


	public static void main(String[] args) {
		System.out.println(removeSubfolders(new String[]{"/a", "/a/b/c", "/a/b/d"}));
	}
}
