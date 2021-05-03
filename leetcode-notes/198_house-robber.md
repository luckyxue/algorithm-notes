## 198. 打家劫舍

[198. House Robber](https://leetcode-cn.com/problems/house-robber/)

### 方法一：动态规划

```java
class Solution {
    public int rob(int[] nums) {
        int dp_i_1 = 0;
        int dp_i_2 = 0;
        int dp_i = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
}
```