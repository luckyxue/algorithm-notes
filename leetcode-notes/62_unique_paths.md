## 62. 不同路径 I

[62. Unique Paths I](https://leetcode-cn.com/problems/unique-paths-i/)

### 方法一：递归+备忘录

```java
private int[][] memo;

public int uniquePaths(int m, int n) {
    memo = new int[m][n];
    for (int i = 0; i < m; i++) {
        Arrays.fill(memo[i], -1);
    }
    return helper(m - 1, n - 1);
}

public int helper(int i, int j) {
    if (i == 0 || j == 0) {
        return 1;
    }
    if (memo[i][j] != -1) {
        return memo[i][j];
    }
    int ans = helper(i - 1, j) + helper(i, j - 1);
    memo[i][j] = ans;
    return memo[i][j];
}
```

### 方法二：动态规划

```java
```