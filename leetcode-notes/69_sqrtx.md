## 69. x 的平方根

[69. Sqrt(x)](https://leetcode-cn.com/problems/sqrtx/)

### 方法一：库函数

```java
public int mySqrt(int x) {
    return (int)Math.sqrt(x);
}
```

### 方法二：二分查找

```java
public int mySqrt(int x) {
    int left = 0;
    int right = x;
    int ans = -1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if ((long) mid * mid <= x) {
            ans = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return ans;
}
```

### 参考题解：