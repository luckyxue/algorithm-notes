## 63. 不同路径 II

[63. Unique Paths II]((https://leetcode-cn.com/problems/unique-paths-ii/))

### 递归+备忘录

```java
private int[][] memo;

public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    if (m > 0 && n > 0 && obstacleGrid[0][0] == 1) {
        return 0;
    }
    memo = new int[m][n];
    for (int i = 0; i < m; i++) {
        Arrays.fill(memo[i], -1);
    }
    for (int i = 0; i < m - 1; i++) {
        if (obstacleGrid[i][0] == 1) {
            for (; i < m -1; i++) {
                memo[i + 1][0] = 0;
            }  
        }
    }
    for (int i = 0; i < n - 1; i++) {
        if (obstacleGrid[0][i] == 1) {
            for (; i < n -1; i++) {
                memo[0][i + 1] = 0;
            }
        }
    }
    return helper(m - 1, n - 1, obstacleGrid);
}

private int helper(int i, int j, int[][] obstacleGrid) {
    if (memo[i][j] != -1) {
        return memo[i][j];
    }
    if (i < 0 || j < 0 || obstacleGrid[i][j] == 1) {
        return 0;
    }
    if (i == 0 || j == 0) {
        return 1;
    }
    int ans = helper(i, j - 1, obstacleGrid) + helper(i - 1, j, obstacleGrid);  
    memo[i][j] = ans;
    return memo[i][j];
}
```