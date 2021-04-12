## 980. 不同路径 III

[980. Unique Paths III](https://leetcode-cn.com/problems/unique-paths-iii/)


### 方法一：回溯法

```java
public int uniquePathsIII(int[][] grid) {
    //当grid[i][j] == 2, stepNum++, 这里直接初始化为1
    int startX = 0, startY = 0, stepNum = 1;  
    //遍历获取起始位置和统计总步数
    for (int i = 0; i < grid.length; i++){
        for (int j = 0; j < grid[0].length; j++){
            if (grid[i][j] == 1){
                startY = i;
                startX = j;
                continue;
            }
            if (grid[i][j] == 0) stepNum++;
        }
    }
    return dfs(startX, startY, stepNum, grid);
}


public int backtrace(int x, int y, int stepSur, int[][] grid){
    //排除越界的情况和遇到障碍的情况
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) { 
        return 0;
    }
    if (grid[x][y] == 2) return stepSur == 0 ? 1 : 0;
    grid[x][y] = -1;  //已走过的标记为障碍
    int res = 0;
    res += backtrace(x - 1, y, stepSur - 1, grid);
    res += backtrace(x + 1, y, stepSur - 1, grid);
    res += backtrace(x, y - 1, stepSur - 1, grid);
    res += backtrace(x, y + 1, stepSur - 1, grid);
    grid[x][y] = 0;  //dfs遍历完该位置为起始位置的情况后，置零，以不影响后面的dfs
    return res;
}

作者：quantum-10
链接：https://leetcode-cn.com/problems/unique-paths-iii/solution/dfs-hui-su-shuang-bai-by-quantum-10/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
````