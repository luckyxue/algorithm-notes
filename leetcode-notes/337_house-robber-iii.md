## 337. 打家劫舍 III

[337. House Robber III](https://leetcode-cn.com/problems/house-robber-iii/)

### 方法一：动态规划

```java
private Map<TreeNode, Integer> map = new HashMap<>();

public int rob(TreeNode root) {
    if (root == null) {
        return 0;
    }
    if (map.containsKey(root)) {
        return map.get(root);
    }
    int do_it = root.val +
        (root.left == null ? 0 : (rob(root.left.left) + rob(root.left.right))) +
        (root.right == null ? 0 : (rob(root.right.left) + rob(root.right.right)));
    int not_do_it = rob(root.left) + rob(root.right);
    int res = Math.max(do_it, not_do_it);
    map.put(root, res);
    return res;
}
```