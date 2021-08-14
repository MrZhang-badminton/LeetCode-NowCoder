package oj.lc.q500.lc297;

import utils.ds.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 序列化之后的值:
 * 0!-7,1!-3,10!-9,11!-3,100!6,1001!-1000,110!-6,111!-6,1110!-2---4
 * <p>
 * ---后面的是根节点的值
 * 前边以逗号分隔,!左边的是节点位置,!右边的是节点的值
 * (注意这边本来之前是用"-"分隔的,但是由于负数转化为String的时候就有"-",所以不能用"-"分隔
 * 这边采用的是!进行分隔)
 *
 * @Classname: Codec
 * @Author: zhanghua
 * @Date: 2021/8/14 6:31 下午
 */
public class Codec {
	// 序列化
	public static String serialize(TreeNode root) {
		if (root == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		StringBuilder tSb = new StringBuilder();
		handle(root, sb, tSb);
		if (sb.length() != 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("---" + root.val);
		return sb.toString();

	}

	// 反序列化
	public static TreeNode deserialize(String data) {
		if (data == null) {
			return null;
		}
		String[] str1 = data.split("---");
		TreeNode root = new TreeNode(Integer.valueOf(str1[1]));
		//得到除了根节点之外的节点位置-value,比如00!3
		if (str1[0].length() == 0) {
			return root;
		}
		String[] nodes = str1[0].split(",");
		List<Entry> list = new ArrayList<>();
		Arrays.stream(nodes).collect(Collectors.toList()).forEach((s) -> {
			String[] tStr = s.split("!");
			list.add(new Entry(tStr[0].length(), s));
		});
		Collections.sort(list, Comparator.comparingInt(o -> (Integer) o.getKey()));
		list.forEach((entry) -> {
			insert(root, (String) entry.getValue());
		});
		return root;
	}

	public static void handle(TreeNode root, StringBuilder sb, StringBuilder tSb) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			sb.append(tSb + "0" + "!" + root.left.val + ",");
		}
		if (root.right != null) {
			sb.append(tSb + "1" + "!" + root.right.val + ",");
		}
		handle(root.left, sb, tSb.append(0));
		tSb.deleteCharAt(tSb.length() - 1);
		handle(root.right, sb, tSb.append(1));
		tSb.deleteCharAt(tSb.length() - 1);
	}

	public static void insert(TreeNode root, String str) {
		String[] strings = str.split("!");
		String pos = strings[0];
		int value = Integer.valueOf(strings[1]);
		int idx = 0;
		TreeNode p = root;
		while (idx != pos.length() - 1) {
			char ch = pos.charAt(idx);
			if (ch == '0') {
				p = p.left;
			} else {
				p = p.right;
			}
			idx++;
		}
		char ch = pos.charAt(pos.length() - 1);
		if (ch == '0') {
			p.left = new TreeNode(value);
		} else {
			p.right = new TreeNode(value);
		}
	}

	static class Entry {
		int key;
		String value;

		public Entry(int key, String value) {
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}
	}


	public static void main(String[] args) {
		TreeNode root = TreeNode.createTree(new int[]{4, -7, -3, -1, -1, -9, -3, 9, -7, -4, -1, 6, -1, -6, -6, -1, -1, 0, 6, 5, -1, 9, -1, -1, -1000, -4, -1, -1, -1, -2});
		TreeNode.printTree(root);
		String s = serialize(root);
		System.out.println(s);
		TreeNode tRoot = deserialize(s);
		TreeNode.printTree(tRoot);
	}


}
