## 173. 二叉搜索树迭代器

[173. Binary Search Tree Iterator](https://leetcode-cn.com/problems/binary-search-tree-iterator/)


### 方法一：扁平化使用数组迭代器

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
class BSTIterator {

    private List<Integer> nums;
    private int index;

    public BSTIterator(TreeNode root) {
        index = 0;
        nums = new ArrayList<>();
        traversal(root, nums);
    }
    
    public int next() {
        return nums.get(index++);
    }
    
    public boolean hasNext() {
        // 是否还有下一个元素，所以是返回满足条件
        return index < nums.size();
    }

    private void traversal(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        traversal(root.left, nums);
        nums.add(root.val);
        traversal(root.right, nums);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
```

### 参考题解：