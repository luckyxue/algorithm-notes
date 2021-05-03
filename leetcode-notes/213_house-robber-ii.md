## 213. 打家劫舍 II

[213. House Robber II](https://leetcode-cn.com/problems/house-robber-ii/)

### 方法一：动态规划

```java
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robDp(nums, 0, nums.length - 2), 
        robDp(nums, 1, nums.length - 1));
    }

    private int robDp(int[] nums, int start, int end) {
        int dp_i_1 = 0;
        int dp_i_2 = 0;
        int dp_i = 0;
        for (int i = end; i >= start; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
}
```