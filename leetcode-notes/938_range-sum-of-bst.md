## 938. 二叉搜索树的范围和

[938. 二叉搜索树的范围和](https://leetcode-cn.com/problems/range-sum-of-bst/)

### 方法一：中序遍历

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int ans;

    public int rangeSumBST(TreeNode root, int low, int high) {
        ans = 0;
        traverse(root, low, high);
        return ans;
    }

    private void traverse(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        traverse(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            ans += root.val;
        }
        traverse(root.right, low, high);
    }
}
```

### 方法二：DFS

```java
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
```

### 方法三：BFS

```java
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root == null) {
                continue;
            }
            if (root.val < low) {
                queue.offer(root.right);
            } else if (root.val > high) {
                queue.offer(root.left);
            } else {
                sum += root.val;
                queue.offer(root.left);
                queue.offer(root.right);
            }        
        }
        return sum;
    }
}
```