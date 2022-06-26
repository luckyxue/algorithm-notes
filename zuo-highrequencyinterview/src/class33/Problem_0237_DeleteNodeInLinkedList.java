package class33;

public class Problem_0237_DeleteNodeInLinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
    }

}
