package algorithm.heap.a_146_lruCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 景行
 * @date 2021/05/30
 **/
class LRUCache {

    private static LinkedHashMap<Integer, Integer> map;



    public LRUCache(int capacity) {
        map = new LinkedHashMap(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return this.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
