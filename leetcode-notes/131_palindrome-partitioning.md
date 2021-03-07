## 131.分割字符串

[131. Palindrome Partitioning](https://leetcode-cn.com/problems/palindrome-partitioning/)

```java
时间复杂度：O(N * 2 ^ N)，因为总共有 O(2^N)种分割方法，每次分割都要判断是否回文需要 O(N) 的时间复杂度。
空间复杂度：O(2 ^ N)，返回结果最多有 O(2 ^ N) 种划分方法。
public List<List<String>> partition(String s) {
    List<List<String>> res = new LinkedList<>();
    LinkedList<String> path = new LinkedList<>();
    backtrack(s, res, path);
}

public void bakctrack(String s, List<<List<String>> res, Linked<String> path) {
    if (s.legnth() == 0) {
        // 深拷贝保存回溯结果
        res.add(new LinkedList(path));
    }
    // 这里的结束是s.length()，因为截取字符串是包前不包后
    for (int i = 1; i <= s.length(); i++) {
        if (isPalindrome(s.substring(0, i))) {
            // 开始选择
            path.add(s.substring(O, i));
            // 执行选择
            backtrack(s, res, path);
            // 这里使用LinkedList来撤销选择
            path.removelast();
        }
    }
}

// 双指针从两边
public boolean isPalindrome(String s) {
    if (s == null || s.length() == 0) {
        return true;
    }
    int start = 0;
    int end = s.length() - 1;
    while(start < end) {
        if(s.charAt(start) != s.chatAt(end)) {
            return false;
        }
        start++；
        end--;
    }
    return true;
}
```