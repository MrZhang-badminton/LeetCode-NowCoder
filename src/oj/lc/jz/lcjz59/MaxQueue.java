package oj.lc.jz.lcjz59;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {

	Deque<Integer> deque;
	Queue<Integer> queue;

	public MaxQueue() {
		this.deque = new LinkedList<>();
		this.queue = new LinkedList<>();
	}

	public int max_value() {
		if(deque.isEmpty()){
			return -1;
		}
		return deque.peek();
	}

	public void push_back(int value) {
		while(!deque.isEmpty() && deque.getLast() < value){
			deque.removeLast();
		}
		deque.offer(value);
		queue.add(value);
	}

	public int pop_front() {
		if(queue.isEmpty()){
			return -1;
		}
		int ans = queue.poll();
		if(ans == deque.getFirst()){
			deque.poll();
		}
		return ans;
	}
}
