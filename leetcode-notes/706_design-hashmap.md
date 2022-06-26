## 706. 设计哈希映射

[706. Design HashMap](https://leetcode-cn.com/problems/design-hashmap/)

### 方法一：巨型数组

```java
class MyHashMap {
    private final int INF = Integer.MAX_VALUE;
    private int[] map;

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[1000009];
        Arrays.fill(map, INF);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key] == INF ? -1 : map[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = INF;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
```

### 方法二：哈希拉链法

```java
class MyHashMap {
    private final int N = 1009;
    private LinkedList[] data;

    class Pair {
        private int key;
        private int value;
        
        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        data = new LinkedList[N];
        for (int i = 0; i < N; i++ ) {
            data[i] = new LinkedList<Pair>();
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = getHash(key);
        Iterator<Pair> iterator =  data[h].iterator();
        while (iterator.hasNext()) {
            Pair element = iterator.next();
            if (element.getKey() == key) {
                element.setValue(value);
            }
        }
        Pair pair = new Pair(key, value);
        data[h].offerLast(pair);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = getHash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair element = iterator.next();
            if (element.getKey() == key) {
                return element.getValue();
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = getHash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair element = iterator.next();
            if (element.getKey() == key) {
                iterator.remove();
            }
        }
    }

    private int getHash(int key) {
        int hash = Integer.hashCode(key);
        hash ^= hash >>> 16;
        return hash % N;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
```

### 参考题解：