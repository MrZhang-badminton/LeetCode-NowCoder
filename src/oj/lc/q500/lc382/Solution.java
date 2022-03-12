package oj.lc.q500.lc382;

import utils.LinkedListUtils;
import utils.node.ListNode;

import java.util.Random;

/**
 * @Description:
 * @Author: zhanghua
 * @Date: 2022/3/12 10:57 上午
 */
public class Solution {

	private ListNode head;
	private int count;


	public Solution(ListNode head) {
		this.head = head;
		this.count = calculateCount(head);
	}

	private int calculateCount(ListNode head) {
		int count = 0;
		ListNode p = head;
		while (p != null) {
			count++;
			p = p.next;
		}
		return count;
	}

	public int getRandom() {
		int move = new Random().nextInt(count);
		ListNode p = this.head;
		while (p != null && move-- > 0) {
			p = p.next;
		}
		return p.val;
	}

	public static void main(String[] args) {
		System.out.println(new Solution(LinkedListUtils.createList(new int[]{1, 2, 3})).getRandom());
		;
	}


}
