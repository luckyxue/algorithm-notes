## 154. 寻找旋转排序数组中的最小值 II

[154. Find Minimum in Rotated Sorted Array II](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/)

### 方法一：二分搜索

```java
public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] < nums[right]) {
            right = mid;
        } else if (nums[mid] > nums[right]){
            left = mid + 1;
        } else if (nums[mid] == nums[right]) {
            right = right - 1;
        }
    }
    return nums[left];
}
```