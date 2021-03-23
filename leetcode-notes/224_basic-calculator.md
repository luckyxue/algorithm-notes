## 224. 基本计算器

[224. Basic Calculator](https://leetcode-cn.com/problems/basic-calculator/)

### 方法一：栈+递归

```java
class Solution {
    public int calculate(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            queue.offer(ch);
        }
        return dfs(queue);        
    }

    public int dfs(Deque<Character> queue) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int currentNum = 0;
        char operator = '+';
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            if (ch == '(') {
                currentNum = dfs(queue);
            }
            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + ch - '0';
            }
            if ((!Character.isDigit(ch) && !Character.isWhitespace(ch)) || queue.isEmpty()) {
                if (operator == '+') {
                    stack.push(currentNum);
                } else if (operator == '-') {
                    stack.push(-currentNum);
                } else if (operator == '*') {
                    stack.push(stack.pop() * currentNum);
                } else if (operator == '/') {
                    stack.push(stack.pop() / currentNum);
                }
                operator= ch;
                currentNum = 0;
            }
            if (ch == ')') {
                break;
            }
        }
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
```

### 参考题解：