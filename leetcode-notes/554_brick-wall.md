## 555. 砖墙

[554. Brick Wall](https://leetcode-cn.com/problems/brick-wall/)

### 方法一：哈希表

```java
public int leastBricks(List<List<Integer>> wall) {
    Map<Integer, Integer> map = new HashMap<>();
    for (List<Integer> w : wall) {
        int sum = 0;
        for (int i = 0; i < w.size() - 1; i++) {
            int wInt = w.get(i);
            sum += wInt;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
    }
    int maxVaule = Integer.MIN_VALUE;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() > maxVaule) {
            maxVaule = entry.getValue();
            // System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }
    return maxVaule == Integer.MIN_VALUE ? wall.size() : wall.size() - maxVaule;
}
```