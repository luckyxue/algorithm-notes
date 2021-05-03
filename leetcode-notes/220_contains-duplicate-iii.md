## 220. 存在重复的元素III

### 方法一：线性搜索

```java
public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j <= i + k & j < nums.length; j++) {
            if (Math.abs((long)nums[i] - (long)nums[j]) <= (long)t) {
                return true;
            }
        }
    }
    return false;
}
```

### 方法二：二叉树搜索

```java
public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Long> treeSet = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
        Long ceiling = treeSet.ceiling((long)nums[i] - (long)t);
        if (ceiling != null && ceiling <= (long)nums[i] + (long)t) {
            return true;
        }
        treeSet.add((long)nums[i]);
        if (treeSet.size() > k) {
            treeSet.remove((long)nums[i - k]);
        }
    }
    return false;
}
```