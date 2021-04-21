package utils.ds;

public class ListNode {
	public int val;
	public ListNode next = null;
	public ListNode(){}
	public ListNode(int val) {
		this.val = val;
	}


	public static ListNode getList(int[] nums){
		ListNode pHead = new ListNode(-1);
		ListNode tail = pHead;

		for (int i = 0; i < nums.length; i++) {
			tail.next = new ListNode(nums[i]);
			tail = tail.next;
		}
		return pHead.next;
	}

	public static void printListNode(ListNode head){
		System.out.print("[");
		while(head != null){
			if(head.next != null){
				System.out.print(head.val + ", ");
			} else {
				System.out.print(head.val);
			}
			head = head.next;
		}
		System.out.print("]");
		System.out.println();
	}
}
