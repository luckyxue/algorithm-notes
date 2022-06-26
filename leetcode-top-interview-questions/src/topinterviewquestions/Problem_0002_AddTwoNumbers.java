package topinterviewquestions;

public class Problem_0002_AddTwoNumbers {

	// 不要提交这个类描述
	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int value) {
			this.val = value;
		}
	}

	public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
		int ca = 0;
		int n1 = 0;
		int n2 = 0;
		int n = 0;
		ListNode c1 = head1;
		ListNode c2 = head2;
		ListNode node = null;
		ListNode pre = null;
		while (c1 != null || c2 != null) {
			n1 = c1 != null ? c1.val : 0;
			n2 = c2 != null ? c2.val : 0;
			n = n1 + n2 + ca;
			pre = node;
			node = new ListNode(n % 10);
			node.next = pre;
			ca = n / 10;
			c1 = c1 != null ? c1.next : null;
			c2 = c2 != null ? c2.next : null;
		}
		if (ca == 1) {
			pre = node;
			node = new ListNode(1);
			node.next = pre;
		}
		return reverseList(node);
	}

	public static ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	/**
	 * 将两个链表中数字相加生成一个新的链接
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode _addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode tail = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int val1 = l1 != null ? l1.val : 0;
			int val2 = l2 != null ? l2.val : 0;
			int sum = val1 + val2 + carry;
			ListNode node = new ListNode(sum % 10);
			if (head == null) {
				head = node;
				tail = node;
			} else {
				tail.next = node;
				tail = tail.next;
			}
			carry = sum / 10;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		// 这里的carry不一定是1
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}
		return head;
	}

}
