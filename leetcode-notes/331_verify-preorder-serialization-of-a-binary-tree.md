## 331. 验证二叉树的前序序列化

[331. Verify Preorder Serialization of a Binary Tree](https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/)

### 方法一：判断入度和出度

```java
public boolean isValidSerialization(String preorder) {
    if (preorder.equals("#")) {
        return true;
    }
    int indegree = 0;
    int outdegree = 0;
    String[] nodes = preorder.split(",");
    for (int i = 0; i < nodes.length; i++) {
        if (i == 0) {
            if (nodes[i].equals("#")) {
                return false;
            }
            outdegree += 2;
            continue;
        }
        if (nodes[i].equals("#")) {
            indegree += 1;
        } else {
            indegree += 1;
            outdegree += 2;
        }
        if (i != nodes.length - 1 && indegree >= outdegree) {
            return false;
        }
    }
    return indegree == outdegree;
}
```