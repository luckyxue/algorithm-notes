## 74. 搜索二维矩阵

[74. Search a 2D Matrix](https://leetcode-cn.com/problems/search-a-2d-matrix/)

## 循环+二分查找

```java
public boolean searchMatrix(int[][] matrix, int target) {
    int i = 0;
    for (; i < matrix.length; i++) {
        if (matrix[i][0] <= target && matrix[i][matrix[0].length - 1] >= target) {
            break;
        }
    }
    if (i == matrix.length) {
        return false;
    }
    int left = 0;
    int right = matrix[0].length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (matrix[i][mid] == target) {
            return true;
        } else if (matrix[i][mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return false;
}
```

### 方法二：两次二分查找

```java

```

### 方法三：一次二次查找

```java
public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    int low = 0, high = m * n - 1;
    while (low <= high) {
        int mid = (high - low) / 2 + low;
        int x = matrix[mid / n][mid % n];
        if (x < target) {
            low = mid + 1;
        } else if (x > target) {
            high = mid - 1;
        } else {
            return true;
        }
    }
    return false;
}
```

### 参考题解：