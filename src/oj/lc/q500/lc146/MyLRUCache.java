package oj.lc.q500.lc146;

import java.util.HashMap;
import java.util.Map;

public class MyLRUCache {

	private final int capacity;
	private int volume;

	Map<Integer, LNode> hashMap = new HashMap<>();
	MyLinkedList list = new MyLinkedList();

	public MyLRUCache(int capacity) {
		this.capacity = capacity;
		volume = 0;
	}

	public int get(int key) {
		if (volume == 0 || !hashMap.containsKey(key)) {
			return -1;
		}
		LNode node = hashMap.get(key);
		list.moveToHead(node);
		return node.data.value;
	}

	public void put(int key, int value) {
		if (hashMap.containsKey(key)) {
			LNode node = hashMap.get(key);
			node.data.value = value;
			list.moveToHead(node);
		} else {
			LNode node = new LNode(new Entry(key, value));
			hashMap.put(key, node);
			list.add(node);
			volume++;
		}
		if (volume > capacity) {
			hashMap.remove(list.getTail().data.key);
			volume--;
			list.removeTail();
		}
	}


	static class MyLinkedList {

		private LNode preHead;
		private LNode tail;

		MyLinkedList() {
			preHead = new LNode(new Entry(-1, -1));
			tail = preHead;

		}

		public void add(LNode e) {
			if (tail == preHead) {
				e.next = null;
				e.pre = preHead;
				preHead.next = e;
				tail = e;
			} else {
				LNode first = preHead.next;
				e.next = first;
				first.pre = e;
				preHead.next = e;
				e.pre = preHead;
			}
		}

		public void moveToHead(LNode e) {
			if (e.pre == preHead) {
				return;
			} else if (e == tail) {
				tail = tail.pre;
				tail.next = null;

			} else {
				LNode pre = e.pre;
				LNode next = e.next;

				pre.next = next;
				next.pre = pre;
			}
			add(e);
		}


		public LNode getTail() {
			if (tail == preHead) {
				return null;
			}
			return tail;
		}

		public void removeTail() {
			tail = tail.pre;
			tail.next = null;
		}


	}


	static class LNode {
		Entry data;
		LNode pre;
		LNode next;

		LNode(Entry data) {
			this.data = data;
		}
	}

	static class Entry {
		int key;
		int value;

		Entry(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		MyLRUCache lRUCache = new MyLRUCache(2);
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
