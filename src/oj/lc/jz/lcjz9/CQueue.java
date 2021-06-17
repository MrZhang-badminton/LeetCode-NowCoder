package oj.lc.jz.lcjz9;

import java.util.Deque;
import java.util.LinkedList;

public class CQueue {

	private Deque<Integer> fromStack;

	private Deque<Integer> toStack;

	public CQueue() {
		fromStack = new LinkedList<>();
		toStack = new LinkedList<>();
	}

	public void appendTail(int value) {
		fromStack.push(value);
	}

	public int deleteHead() {
		if (!toStack.isEmpty()) {
			return toStack.pop();
		} else {
			while (!fromStack.isEmpty()) {
				toStack.push(fromStack.pop());
			}
			if (toStack.isEmpty()) {
				return -1;
			}
			return toStack.pop();
		}
	}

}
