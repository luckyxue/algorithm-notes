## 150. 逆波兰表达式求值

[150. Evaluate Reverse Polish Notation](https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/)

```java
public int evalRPN(String[] tokens) {
    Stack<String> stack = new Stack<>();
    String cur = "";
    for (int i = 0; i < tokens.length; i++) {
        if (tokens[i].equals("+")) {
            String pre = stack.pop();
            String prepre = stack.pop();
            cur = String.valueOf(Integer.parseInt(prepre) + Integer.parseInt(pre));
            stack.push(cur);
        } else if (tokens[i].equals("-")) {
            String pre = stack.pop();
            String prepre = stack.pop();
            cur = String.valueOf(Integer.parseInt(prepre) - Integer.parseInt(pre));
            stack.push(cur);
        } else if (tokens[i].equals("*")) {
            String pre = stack.pop();
            String prepre = stack.pop();
            cur = String.valueOf(Integer.parseInt(prepre) * Integer.parseInt(pre));
            stack.push(cur);
        } else if (tokens[i].equals("/")) {
            String pre = stack.pop();
            String prepre = stack.pop();
            cur = String.valueOf(Integer.parseInt(prepre) / Integer.parseInt(pre));
            stack.push(cur);
        } else {
            cur = tokens[i];
            stack.push(cur);
        }
    }
    if (!stack.isEmpty()) {
        return Integer.parseInt(stack.pop());
    } else {
        return 0;
    }
}
```

```java
public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }
```

### 参考题解：