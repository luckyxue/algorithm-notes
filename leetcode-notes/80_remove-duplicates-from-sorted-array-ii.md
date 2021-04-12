## 80. 删除有序数组中的重复项 II

[80. Remove Duplicates from Sorted Array II](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/)


### 方法一：快慢指针

```java
public int removeDuplicates(int[] nums) {
    if (nums.length < 2) {

    }
    // 这里因为slow不是指索引，而是第2个元素
    int fast = 2;
    int slow = 2;
    while (fast < nums.length) {
        if (nums[slow - 2] != nums[fast]) {
            nums[slow] = nums[fast];
            slow++;
        }
        fast++;
    }
    return slow;
}
```