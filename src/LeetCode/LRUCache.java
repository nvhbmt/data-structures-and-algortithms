package LeetCode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        map = new LinkedHashMap<>();

        head.next = tail;
        tail.prev = head;

        this.capacity = capacity;
    }

    private void remove(Node removeNode) {
        map.remove(removeNode.key);
        removeNode.prev.next = removeNode.next;
        removeNode.next.prev = removeNode.prev;
    }

    private void insert(Node insertNode) {
        map.put(insertNode.key, insertNode);
        Node headNext = head.next;
        head.next = insertNode;
        insertNode.prev = head;
        headNext.prev = insertNode;
        insertNode.next = headNext;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }
}
