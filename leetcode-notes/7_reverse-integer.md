## 7. 整数反转

[7. reverse integer](https://leetcode-cn.com/problems/reverse-integer/)

```java
public int reverse(int x) {
    long ans = 0;
    while (x != 0) {
        ans = ans * 10 + x % 10;
        x = x / 10;
        if (ans <= Integer.MIN_VALUE || ans >= Integer.MAX_VALUE) {
            return 0;
        }
    }
    return (int)ans;
}
```