## 705. 设计哈希集合

[705. Design HashSet](https://leetcode-cn.com/problems/design-hashset/)

### 方法一：巨型数组

```java
class MyHashSet {

    private boolean[] sets;

    /** Initialize your data structure here. */
    public MyHashSet() {
        sets = new boolean[1000009];
    }
    
    public void add(int key) {
        sets[key] = true;
    }
    
    public void remove(int key) {
        sets[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return sets[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
```

### 方法二：哈希拉链法

```java
private final int BASE = 1009;
    private LinkedList[] data;

    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            data[i] = new LinkedList<Integer>();
        }
    }
    
    public void add(int key) {
        int h = getHash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return;
            }
        }
        data[h].offerLast(key);
    }
    
    public void remove(int key) {
        int h = getHash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                data[h].remove(element);
                return;
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = getHash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    private int getHash(int key) {
        int hash = Integer.hashCode(key);
        hash ^= (hash >>> 16);
        return hash % BASE;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
```
