## 4.寻找两个正序数组的中位数

[4. Median of Two Sorted Arrays](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/)

### 方法一：暴力合并排序

```java
// 合并排序然后取中位数
// 这种思路的时间复杂度是 O((m + n)log(m + n))，空间复杂度是O(m + n)
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] nums = new int[nums1.length + nums2.length];
    for (int i = 0; i < nums1.length; i++) {
        nums[i] = nums1[i];
    }
    for (int i = 0; i < nums2.length; i++) {
        nums[i + nums1.length] = nums2[i];
    }
    Arrays.sort(nums);
    if (nums.length % 2 == 0) {
        return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0F;
    } else {
        return nums[nums.length / 2];
    }
}
```

### 方法二：双指针合并

```java
// 使用归并的方式，合并两个有序数组，得到一个大的有序数组。大的有序数组的中间位置的元素，即为中位数。
// 这种思路的时间复杂度是 O(m+n)，空间复杂度是 O(m+n)
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] nums = new int[nums1.lenth + nums2.length];
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] < nums2[j]) {
            nums[k++] = nums1[i++];
        } else {
            nums[k++] = nums2[j++];
        }
    }
    while (i < nums1.length) {
        nums[k++] = nums1[i++];
    }
    while (j < nums2.length) {
        nums[k++] = nums2[j++];
    }
    if (nums.legnth % 2 == 0) {
        return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
    } else {
        return nums[nums.length / 2];
    }
}
```

### 参考题解：

[回溯解法](https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-fa-si-lu-yu-mo-ban-by-fuxuemingzh-azhz/)