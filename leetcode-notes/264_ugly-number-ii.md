## 264. 丑数 II

[264. 丑数 II](https://leetcode-cn.com/problems/ugly-number-ii/)

```java
public int nthUglyNumber(int n) {
    int[] dp = new int[n + 1];
    int p1 = 1;
    int p2 = 1;
    int p3 = 1;
    dp[1] = 1;
    int num1 = 1;
    int num2 = 1;
    int num3 = 1;
    for (int i = 2; i <= n; i++) {
        num1 = dp[p1] * 2;
        num2 = dp[p2] * 3;
        num3 = dp[p3] * 5;
        dp[i] = Math.min(num1, Math.min(num2, num3));
        if (dp[i] == num1) {
            p1++;
        }
        if (dp[i] == num2) {
            p2++;
        }
        if (dp[i] == num3) {
            p3++;
        }
    }
    return dp[n];       
}
```