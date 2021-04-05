## 88. 合并两个有序数组

[88. Merge Sorted Array](https://leetcode-cn.com/problems/merge-sorted-array/)

### 方法一：合并排序

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    for (int i = 0; i < n; i++) {
        nums1[m + i] = nums2[i];
    }
    Arrays.sort(nums1);
}
```

### 方法二：双指针

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] nums = new int[m + n];
    int i = 0, j = 0;
    while (i < m || j < n) {
        if (i == m) {
            nums[i + j] = nums2[j++];
        } else if (j == n) {
            nums[i + j] = nums1[i++];
        } else if (nums1[i] < nums2[j]) {
            nums[i + j] = nums1[i++];
        } else {
            nums[i + j] = nums2[j++];
        }
    }
    for (i = 0; i < nums.length; i++) {
        // System.out.println(nums[i]);
        nums1[i] = nums[i];
    }
}
```

### 方法三：逆向双指针

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1;
    int tail = m + n - 1;
    int cur = 0;
    while (i >= 0 || j >= 0) {
        if (i== -1) {
            cur = nums2[j--];
        } else if (j == -1) {
            cur = nums1[i--];
        } else if (nums1[i] > nums2[j]) {
            cur = nums1[i--];
        } else {
            cur = nums2[j--];
        }
        nums1[tail--] = cur;
    }
}
```