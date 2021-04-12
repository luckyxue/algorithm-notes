## 263.丑数

[263. Ugly Number](https://leetcode-cn.com/problems/ugly-number/)

### 方法一：数学

```java
public boolean isUgly(int n) {
    if (n <= 0) {
        return false;
    }
    while (n % 5 == 0) {
        n /= 5;
    }
    if (n == 1) {
        return true;
    }
    while (n % 3 == 0) {
        n /= 3;
    }
    if (n == 1) {
        return true;
    }
    while (n % 2 == 0) {
        n /= 2;
    }
    if (n == 1) {
        return true;
    }
    return n == 1;
}
```