package topinterviewquestions;

public class Problem_0021_MergeTwoSortedLists {

	public static class ListNode {
		public int val;
		public ListNode next;
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		ListNode head = l1.val <= l2.val ? l1 : l2;
		ListNode cur1 = head.next;
		ListNode cur2 = head == l1 ? l2 : l1;
		ListNode pre = head;
		while (cur1 != null && cur2 != null) {
			if (cur1.val <= cur2.val) {
				pre.next = cur1;
				cur1 = cur1.next;
			} else {
				pre.next = cur2;
				cur2 = cur2.next;
			}
			pre = pre.next;
		}
		pre.next = cur1 != null ? cur1 : cur2;
		return head;
	}

	/**
	 * 合并两个有序链表
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public ListNode _mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode head = list1.val < list2.val ? list1 : list2;
		ListNode pre = head;
		ListNode cur1 = head.next;
		ListNode cur2 = head == list1 ? list2 : list1;
		while (cur1 != null && cur2 != null) {
			if (cur1.val < cur2.val) {
				pre.next = cur1;
				cur1 = cur1.next;
			} else {
				pre.next = cur2;
				cur2 = cur2.next;
			}
			pre = pre.next;
		}
		if (cur1 != null) {
			pre.next = cur1;
		} else {
			pre.next = cur2;
		}
		return head;
	}

}
