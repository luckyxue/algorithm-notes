package topinterviewquestions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_0023_MergeKSortedLists {

	public static class ListNode {
		public int val;
		public ListNode next;
	}

	public static class ListNodeComparator implements Comparator<ListNode> {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			return o1.val - o2.val;
		}

	}

	/**
	 * 归并排序
	 * 
	 * @param lists
	 * @return
	 */
	public static ListNode _mergeKLists(ListNode[] lists) {
		if (lists == null) {
			return null;
		}
		PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				heap.add(lists[i]);
			}
		}
		if (heap.isEmpty()) {
			return null;
		}
		ListNode head = heap.poll();
		ListNode pre = head;
		if (pre.next != null) {
			heap.add(pre.next);
		}
		while (!heap.isEmpty()) {
			ListNode cur = heap.poll();
			pre.next = cur;
			pre = cur;
			if (cur.next != null) {
				heap.add(cur.next);
			}
		}
		return head;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		return merge(lists, 0, lists.length - 1);
	}

	public ListNode merge(ListNode[] lists, int l, int r) {
		if (l == r) {
			return lists[l];
		}
		if (l > r) {
			return null;
		}
		int mid = (l + r) >> 1;
		return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));
	}

	public ListNode mergeTwoList(ListNode a, ListNode b) {
		if (a == null || b == null) {
			return a != null ? a : b;
		}
		ListNode head = new ListNode(0);
		ListNode tail = head;
		ListNode aPtr = a;
		ListNode bPtr = b;
		while (aPtr != null && bPtr != null) {
			if (aPtr.val < bPtr.val) {
				tail.next = aPtr;
				aPtr = aPtr.next;
			} else {
				tail.next = bPtr;
				bPtr = bPtr.next;
			}
			tail = tail.next;
		}
		tail.next = aPtr != null ? aPtr : bPtr;
		return head.next;
	}

}
