package topinterviewquestions;

public class Problem_0019_RemoveNthNodeFromEndofList {

	public static class ListNode {
		public int val;
		public ListNode next;
	}

	/**
	 * 少了一个变量
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode cur = head;
		ListNode pre = null;
		while (cur != null) {
			n--;
			if (n == -1) {
				pre = head;
			}
			if (n < -1) {
				pre = pre.next;
			}
			cur = cur.next;
		}
		if (n > 0) {
			return head;
		}
		// 刚好是删除倒数第N个节点也就是头节点
		if (pre == null) {
			return head.next;
		}
		pre.next = pre.next.next;
		return head;
	}

	/**
	 * 双指针(快慢指针)
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode _removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0, head);
		ListNode first = head;
		ListNode second = dummy;
		for (int i = 0; i < n && first != null; i++) {
			first = first.next;
		}
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
	}
}
