## 面试题 01.01. Is Unique LCCI

[面试题 01.01. Is Unique LCCI](https://leetcode-cn.com/problems/is-unique-lcci/)

### 方法一：哈希集合

```java
public boolean isUnique(String astr) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < astr.length(); i++ ) {
        if (set.contains(astr.charAt(i))) {
            return false;
        } else {
            set.add(astr.charAt(i));
        }
    }
    return true;
}
```

### 方法二：位运算

```java
public boolean isUnique(String astr) {
    int mark = 0;
    for (int i = 0; i < astr.length(); i++) {
        int move = astr.charAt(i) - 'a';
        if ((mark & 1 << move) != 0) {
            return false;
        } else {
            mark |= 1 << move;
        }
    }
    return true;
}
```