package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.print();
        // return 1
        System.out.println("get(1): " + lRUCache.get(1));
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.print();
        // returns -1 (not found)
        System.out.println("get(2) : " + lRUCache.get(2));
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.print();
        // return -1 (not found)
        System.out.println("get(1): " + lRUCache.get(1));
        // return 3
        System.out.println("get(3): " + lRUCache.get(3));
        // return 4
        System.out.println("get(4): " + lRUCache.get(4));

    }
}

/*
LRU cache will use hash map with dbly linked list to store elements.
* new entry will add node to head, if already at capacity, then element from tail will be removed.
* when a node is accessed, it will be moved to head
* when a node is removed, it will be removed from tail
 */
class LRUCache {

    private Map<Integer, Node> hashmap;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashmap = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int result = -1;
        Node node = hashmap.get(key);
        if (node != null) {
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = hashmap.get(key);
        if (node != null) {
            node.val = value;
            remove(node);
            add(node);
        } else {
            //check for size b4 adding
            if (hashmap.size() >= this.capacity) {
                // evict element from tail
                hashmap.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            hashmap.put(key, newNode);
            add(newNode);
        }
    }

    public void add(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    public void remove(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }

    void print() {
        for(Integer n: hashmap.keySet()){
            System.out.println("key: " + n + " val: " + hashmap.get(n).val);
        }
    }
    class Node {
        private int key;
        private int val;
        private Node next;
        private Node prev;
    }
}
