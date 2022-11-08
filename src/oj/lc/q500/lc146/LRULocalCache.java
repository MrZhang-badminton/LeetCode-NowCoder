package oj.lc.q500.lc146;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/11/9 00:02
 */
public class LRULocalCache {

	Map<Integer, LNode> map;
	LNode headNode;
	LNode tailNode;

	private int capacity;
	private int vol;

	public LRULocalCache(int capacity) {
		this.capacity = capacity;
		this.vol = 0;
		map = new HashMap<>();
		headNode = new LNode(-1, -1, null, null);
		tailNode = new LNode(-1, -1, headNode, null);
		headNode.next = tailNode;
	}

	public int get(int key) {
		LNode node = map.get(key);
		if (Objects.isNull(node)) {
			return -1;
		}
		moveToHead(node);
		return node.value;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			LNode node = map.get(key);
			node.value = value;
			moveToHead(node);
			return;
		}

		LNode node = new LNode(key, value, null, null);
		addHead(node);
		map.put(key, node);
		vol++;
		if (vol > capacity) {
			removeTail();
			vol--;
		}
	}

	private void moveToHead(LNode node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
		LNode p = headNode.next;
		headNode.next = node;
		node.next = p;
		node.pre = headNode;
		p.pre = node;
	}

	private void removeTail() {
		int key = tailNode.pre.key;
		map.remove(key);
		LNode p = tailNode.pre.pre;
		p.next = tailNode;
		tailNode.pre = p;
	}

	private void addHead(LNode node) {
		LNode p = headNode.next;
		node.pre = headNode;
		node.next = p;
		headNode.next = node;
		p.pre = node;
	}


	static class LNode {
		int key;
		int value;
		LNode pre;
		LNode next;

		LNode() {
		}

		LNode(int key, int value, LNode pre, LNode next) {
			this.key = key;
			this.value = value;
			this.pre = pre;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		LRULocalCache lRUCache = new LRULocalCache(2);
		lRUCache.put(1, 1); // 缓存是 {1=1}
		lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
		System.out.println(lRUCache.get(1));    // 返回 1
		lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
		System.out.println(lRUCache.get(2));
		;    // 返回 -1 (未找到)
		lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
		System.out.println(lRUCache.get(1));
		;    // 返回 -1 (未找到)
		System.out.println(lRUCache.get(3));
		;    // 返回 3
		System.out.println(lRUCache.get(4));
		;    // 返回 4
	}
}
