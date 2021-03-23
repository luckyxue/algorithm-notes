## 42. 接雨水

[42. Trapping Rain Water](https://leetcode-cn.com/problems/trapping-rain-water/)

### 方法一：左右遍历+备忘录

```java
class Solution {
    public int trap(int[] height) {
        if (height.length ==  0) {
            return 0;
        }
        int ans = 0;
        int[] leftHeight = new int[height.length];
        int[] rightHeight = new int[height.length];
        leftHeight[0] = height[0];
        rightHeight[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            leftHeight[i] = Math.max(height[i], leftHeight[i - 1]);
            // System.out.println(leftHeight[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightHeight[i] = Math.max(height[i], rightHeight[i + 1]);
            // System.out.println(rightHeight[i]);
        }
        for (int i = 0; i < height.length; i++) {
            int hi = Math.min(leftHeight[i], rightHeight[i]) - height[i];
            if (hi > 0) {
                // System.out.println(hi);
                ans += hi;
            }
        }
        return ans;
    }
}
```