## 179.最大数

[179. Largest Number](https://leetcode-cn.com/problems/largest-number/)

### 方法一：排序

```java
public String largestNumber(int[] nums) {
    String[] strs = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
        strs[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(strs, (a, b) -> {
        return (b + a).compareTo(a + b); 
    });
    if (strs[0].equals("0")) {
        // 检查前导0的特殊情况
        return "0"; 
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strs.length; i++) {
        sb.append(strs[i]);
    }
    return sb.toString();
}
```