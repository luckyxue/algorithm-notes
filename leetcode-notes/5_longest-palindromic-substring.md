## 5.最长回文子串

[5. Longest Palindromic Substring](https://leetcode-cn.com/problems/longest-palindromic-substring/)

### 方法一：暴力枚举

```java
public String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2) {
        return s;
    }
    // 最差只能获取单个字符的回文字符串
    int maxLen = 1;
    int start = 0;
    char[] ch = s.toCharArray();
    // 枚举s字符串中所有长度超过1的子字符串
    for (int i = 0; i < len - 1; i++) {
        for (int j = i + 1; j < len; j++) {
            if (isPalindrom(ch, i, j) && j - i + 1 > maxLen) {
                maxLen = j - i + 1;
                start = i;
            }               
        }
    }
    return s.substring(start, start + maxLen);
}

// 判断该字符串是否为回文字符串
public boolean isPalindrom(char[] ch, int start, int end) {
    while(start < end) {
        if(ch[start] != ch[end]) {
            return false;
        }
        start++;
        end--;
    }
    return true;
}
```

### 方法二：中心扩展法

```java
public String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2) {
        return s;
    }
    // 最差可以得到单个字符组成的字符串
    // 单个字符本身就是回文串
    int maxLen = 1;
    String maxStr = s.substring(0, 1);
    for (int i = 0; i < len - 1; i++) {
        String oddStr = centerExpand(s, i, i);
        String evenStr = centerExpand(s, i, i + 1);
        String curStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
        if (curStr.length() > maxLen) {
            maxLen = curStr.length();
            maxStr = curStr;
        }
    }
    return maxStr;
}

// 中心扩展法
public String centerExpand(String s, int left, int right) {
    int len = s.length();
    while(left >= 0 && right < len) {
        if (s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        } else {
            break;
        }
    }
    return s.substring(left + 1, right);
}
```

### 方法三：动态规划

```java
public String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2) {
        return s;
    }
    int maxLen = 1;
    int start = 0;
    // dp[i][j] 表示 s[i, j] 是否是回文串
    boolean[][] dp = new boolean[len][len];
    for (int i = 0; i < len; i++) {
        dp[i][i] = true;
    }
    for (int j = 1; j < len; j++) {
        for (int i = 0; i < j; i++) {
            if (s.charAt(i) != s.charAt(j)) {
                dp[i][j] = false;
            } else {
                if (j - i < 3) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
            }

            if (dp[i][j] && j - i + 1 > maxLen) {
                maxLen = j - i + 1;
                start = i;
            }
        }
    }
    return s.substring(start, start + maxLen);
}
```

### 参考题解：

[动态规划、中心扩散、Manacher 算法](https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/)