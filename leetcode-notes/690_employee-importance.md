## 690. 员工的重要性

[690. Employee Importance](https://leetcode-cn.com/problems/employee-importance/)

### 方法一：DFS

```java
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    private int sum = 0;

    public int getImportance(List<Employee> employees, int id) {
        int count = 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        if (map.containsKey(id)) {
            // count += map.get(id).importance;
            // Employee e = map.get(id);
            // for (int eId : e.subordinates) {
            //     count += map.get(eId).importance;
            // }
            dfs(map.get(id), map, count);
        }
        return sum;
    }

    private void dfs (Employee e, Map<Integer, Employee> map, int count) {
        sum += e.importance;
        for (int eId : e.subordinates) {
            // count += map.get(eId).importance;  
            // System.out.println(count);  
            dfs(map.get(eId), map, count);
        }
    }
}
```

### 方法二：DFS

```java 
class Solution {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        int sum = dfs(id, map);
        return sum;
    }

    private int dfs (int id, Map<Integer, Employee> map) {
        Employee e = map.get(id);
        int sum = e.importance;
        for (int eId : e.subordinates) {
            sum += dfs(eId, map);
        }
        return sum;
    }
}
```