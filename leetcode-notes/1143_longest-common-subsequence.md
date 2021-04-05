## 1143. 最长公共子序列

[1143. Longest Common Subsequence](https://leetcode-cn.com/problems/longest-common-subsequence/)

### 方法一：递归+备忘录

```java
class Solution {
    private Map<String, Integer> memo = new HashMap<>();

    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, text2, text1.length() - 1, text2.length() - 1);
    }

    public int helper(String text1, String text2, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (memo.containsKey(i + " " + j)) {
            return memo.get(i + " " + j);
        }
        int res = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            res = helper(text1, text2, i - 1, j - 1) + 1;
            memo.put(i + " " + j, res);
            return res;
        } else {
            res =  Math.max(
                helper(text1, text2, i, j - 1), 
                helper(text1, text2, i - 1 ,j));
            memo.put(i + " " + j, res);
            return res;
        }
    }
}
```

### 方法二：动态规划

```java
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= text2.length(); j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
```

### 参考题解：