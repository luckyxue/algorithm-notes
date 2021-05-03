## 87. 扰乱字符串

[87. 扰乱字符串](https://leetcode-cn.com/problems/scramble-string/submissions/)

### 方法一：递归加备忘录

```java
class Solution {
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        // 长度不等，必定不能变换
        if (s1.length() != s2.length()) {
            return false;
        }
        // 长度相等，先特判下
        if (s1.equals(s2)) {
            return true;
        }
        // 看一下字符个数是否一致，不同直接return false
        int n = s1.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }
        for (Character key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        if (memo.containsKey(s1 + "," + s2)) {
            return memo.get(s1 + "," + s2);
        }
        // 相同的话，开始判断判断，满足一个就能 return true
        for (int i = 1; i < n; i++) {
            boolean flag =
                    // S1 -> T1，S2 -> T2
                    (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) ||
                    // S1 -> T2，S2 -> T1
                    (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)));
            if (flag) {
                memo.put(s1 + "," + s2, true);
                return true;
            } else {
                memo.put(s1 + "," + s2, false);
            }
        }
        return false;
    }
}
```