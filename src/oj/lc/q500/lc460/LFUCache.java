package oj.lc.q500.lc460;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/11/10 01:19
 */
public class LFUCache {

	int capacity, time;
	Map<Integer, Node> map;
	TreeSet<Node> treeSet;


	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.time = 0;
		map = new HashMap<>();
		treeSet = new TreeSet<>();
	}

	public int get(int key) {
		// 不存在, 返回-1
		if (!map.containsKey(key)) {
			return -1;
		}

		Node node = map.get(key);
		treeSet.remove(node);

		node.cnt++;
		node.time = ++time;

		treeSet.add(node);
		map.put(key, node);

		return node.value;
	}

	public void put(int key, int value) {
		if (capacity == 0) {
			return;
		}

		if (map.containsKey(key)) {
			// 包含的情况
			Node node = map.get(key);
			treeSet.remove(node);
			node.cnt++;
			node.time = ++time;
			node.value = value;
			treeSet.add(node);
			map.put(key, node);
			return;
		}
		// 不包含的情况
		if (map.size() == capacity) {
			map.remove(treeSet.first().key);
			treeSet.remove(treeSet.first());
		}
		Node node = new Node(0, ++time, key, value);
		treeSet.add(node);
		map.put(key, node);

	}

	static class Node implements Comparable<Node> {
		int cnt, time, key, value;

		Node(int cnt, int time, int key, int value) {
			this.cnt = cnt;
			this.time = time;
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Node node) {
			return cnt == node.cnt ? time - node.time : cnt - node.cnt;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Node node = (Node) o;
			return cnt == node.cnt && time == node.time;
		}

		@Override
		public int hashCode() {
			return cnt * 10086 + time;
		}
	}

	public static void main(String[] args) {

		LFUCache lfu = new LFUCache(2);
		lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
		lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
		System.out.println(lfu.get(1));;      // 返回 1
		// cache=[1,2], cnt(2)=1, cnt(1)=2
		lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
		// cache=[3,1], cnt(3)=1, cnt(1)=2
		System.out.println(lfu.get(2));;      // 返回 -1（未找到）
		System.out.println(lfu.get(3));;      // 返回 3
		// cache=[3,1], cnt(3)=2, cnt(1)=2
		lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
		// cache=[4,3], cnt(4)=1, cnt(3)=2
		System.out.println(lfu.get(1));;      // 返回 -1（未找到）
		System.out.println(lfu.get(3));;      // 返回 3
		// cache=[3,4], cnt(4)=1, cnt(3)=3
		System.out.println(lfu.get(4));;      // 返回 4
		// cache=[3,4], cnt(4)=2, cnt(3)=3

	}


}
