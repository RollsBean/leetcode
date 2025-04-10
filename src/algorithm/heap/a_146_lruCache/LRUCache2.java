package algorithm.heap.a_146_lruCache;

import java.util.HashMap;
import java.util.Map;

class LRUCache2 {

    class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;
        public LinkedNode() {}
        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, LinkedNode> cacheMap = new HashMap();
    private LinkedNode tail, head;
    private int capacity;
    private int size;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    public int get(int key) {
        LinkedNode node = cacheMap.get(key);
        if (node != null) {
            move2Head(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            //更新
            LinkedNode node = cacheMap.get(key);
            node.value = value;
            move2Head(node);
        } else {
            // 不存在
            LinkedNode newNode = new LinkedNode(key, value);
            addFirst(newNode);
            size++;
            if (size > capacity) {
                removeLast();
            }
        }

    }

    private void move2Head(LinkedNode node) {
        LinkedNode next = node.next;
        LinkedNode prev = node.prev;

        next.prev = prev;
        prev.next = next;

        addFirst(node);

    }

    private void addFirst(LinkedNode newNode) {
        LinkedNode next = head.next;
        cacheMap.put(newNode.key, newNode);
        head.next = newNode;
        newNode.next = next;
        newNode.prev = head;
        next.prev = newNode;
    }

    private void removeLast() {
        LinkedNode prev = tail.prev;
        LinkedNode prev1 = prev.prev;
        prev1.next = tail;
        tail.prev = prev1;
        size--;
        cacheMap.remove(prev.key);
    }

    public static void main(String[] args) {
        LRUCache2 lruCache2 = new LRUCache2(2);
        lruCache2.put(1, 1);
        lruCache2.put(2, 2);
        lruCache2.get(1);
        lruCache2.put(3, 3);
        System.out.println(lruCache2.get(2));
    }
}
