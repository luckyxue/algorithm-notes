## 61. 旋转链表

[61. Rotate List](https://leetcode-cn.com/problems/rotate-list/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 0;
        ListNode tail = head;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
            if (cur != null && cur.next == null) {
                tail = cur;
            }
        }
        k = n - k % n;
        cur = head;
        while (--k > 0) {
            cur = cur.next;
        }
        tail.next = head;
        head = cur.next;
        cur.next = null; 
        return head;
    }
}
```

### 参考题解：