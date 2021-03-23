## 1047. 删除字符串中的所有相邻重复项

[1047. Remove All Adjacent Duplicates In String](https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/)

### 方法一：栈

```java
public String removeDuplicates(String S) {
    StringBuilder sb = new StringBuilder();
    int top = -1;
    for (int i = 0; i < S.length(); i++) {
        if (top != -1 && S.charAt(i) == sb.charAt(top)) {
            sb.deleteCharAt(top);
            top--;
        } else {
            sb.append(S.charAt(i));
            top++;
        }
    }
    return sb.toString();
}
```

### 参考题解：