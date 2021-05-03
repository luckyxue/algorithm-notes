## 633. 平方数之和

[633. 平方数之和](https://leetcode-cn.com/problems/sum-of-square-numbers/)

### 方法一：枚举

```java
public boolean judgeSquareSum(int c) {
    int s = (int)Math.sqrt(c);
    for (int i = 0; i <= s; i++) {
        double d = Math.sqrt(c - i * i);
        if (d == (int) d) {
            return true;
        }
    }
    return false;
}
```

### 方法二：双指针

```java
public boolean judgeSquareSum(int c) {
    int left = 0;
    int right = (int)Math.sqrt(c);
    while (left <= right) {
        int s = left * left + right * right;
        if (s == c) {
            return true;
        } else if (s > c) {
            right--;
        } else if (s < c) {
            left++;
        }
    }
    return false;
}
```
