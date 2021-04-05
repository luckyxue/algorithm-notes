## 781. 森林中的兔子

[781. Rabbits in Forest](https://leetcode-cn.com/problems/rabbits-in-forest/)

### 方法一：数学归纳法

```java
public int numRabbits(int[] answers) {
    Map<Integer, Integer> count = new HashMap<Integer, Integer>();
    for (int y : answers) {
        count.put(y, count.getOrDefault(y, 0) + 1);
    }
    int ans = 0;
    for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
        int y = entry.getKey(), x = entry.getValue();
        // ans += (int)Math.ceil((double)x / (y + 1) * (y + 1));
        ans += (x + y) / (y + 1) * (y + 1);
    }
    return ans;
}
```

### 参考链接

[【负雪明烛】找规律，附「向上取整」转「向下取整」的证明](https://leetcode-cn.com/problems/rabbits-in-forest/solution/fu-xue-ming-zhu-zhao-gui-lu-fu-xiang-sha-1yk3/)