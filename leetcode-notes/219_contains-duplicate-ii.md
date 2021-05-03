## 219. 存在重复元素II

[219. 存在重复元素 II](https://leetcode-cn.com/problems/contains-duplicate-ii/)

### 方法一：线性搜索

```java
public boolean containsNearbyDuplicate(int[] nums, int k) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j <= i + k && j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                return true;
            }
        }
    }
    return false;
}
```

### 方法二：二叉搜索树

```java
public boolean containsNearbyDuplicate(int[] nums, int k) {
    TreeSet<Integer> treeSet = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
        if (treeSet.contains(nums[i])) {
            return true;
        }
        treeSet.add(nums[i]);
        if (treeSet.size() > k) {
            treeSet.remove(nums[i - k]);
        }
    }
    return false;
}
```