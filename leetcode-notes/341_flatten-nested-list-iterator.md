## 341. 扁平化嵌套列表迭代器

[341. Flatten Nested List Iterator](https://leetcode-cn.com/problems/flatten-nested-list-iterator/)

### 方法一：dfs深度优先遍历

```java
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> vals = new ArrayList<>();
    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
        this.iterator = vals.iterator();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger element : nestedList) {
            if (element.isInteger()) {
                vals.add(element.getInteger());
            } else {
                dfs(element.getList());
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
```