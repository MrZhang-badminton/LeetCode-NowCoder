package oj.lc.q500.lc146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private class LNode {
		private int key;
		private int value;
		private LNode pre;
		private LNode next;

		LNode() {
		}

		LNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private int capacity;
	private int size;
	private Map<Integer, LNode> map = new HashMap<>();
	private LNode head, tail;

	LRUCache(int capacity) {
		this.capacity = capacity;
		size = 0;
		head = new LNode();
		tail = new LNode();
		head.next = tail;
		tail.pre = head;
	}

	public int get(int key) {
		LNode node = map.get(key);
		if(node == null){
			return -1;
		}
		removeNode(node);
		addToHead(node);
		return node.value;
	}

	public void put(int key, int value) {
		LNode node = map.get(key);
		if(node != null){
			node.value = value;
			moveToHead(node);
		}else {
			LNode newNode = new LNode(key,value);
			addToHead(newNode);
			map.put(key,newNode);
			size++;
			if(size>capacity){
				map.remove(removeTail().key);
				--size;
			}
		}
	}

	public void addToHead(LNode node) {
		node.next = head.next;
		head.next.pre = node;
		head.next = node;
		node.pre = head;
	}

	public void removeNode(LNode node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	public void moveToHead(LNode node) {
		removeNode(node);
		addToHead(node);
	}

	public LNode removeTail() {
		LNode res = tail.pre;
		removeNode(res);
		return res;
	}
}
