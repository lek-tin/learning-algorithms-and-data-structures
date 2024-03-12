package com.example.LRU;

import java.util.*;

/**
 * Source: https://gist.github.com/hemantsonu20/24d0597a62787312b5e0dae05e01b71f
 */
class LRUCacheTTL {

    private final DLL dll;
    private final Queue<Node> ttlQueue;
    private final Map<Integer, Node> map;
    private final int capacity;

    public LRUCacheTTL(int capacity) {
        this.dll = new DLL();
        this.ttlQueue = new PriorityQueue<>();
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        evictExpired();
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        dll.moveToHead(node);
        return node.val;
    }

    public void put(int key, int value, long delay) {
        evictExpired();
        Node newNode = new Node(key, value, delay);
        if (map.containsKey(key)) {
            Node oldNode = map.remove(key);
            dll.remove(oldNode);
            ttlQueue.remove(oldNode);
        } else {
            if (map.size() == capacity) {
                Node oldNode = dll.removeLast();
                map.remove(oldNode.key);
                ttlQueue.remove(oldNode);
            }
        }
        map.put(key, newNode);
        dll.addFirst(newNode);
        ttlQueue.offer(newNode);
    }

    public void evictExpired() {

        while (!ttlQueue.isEmpty() && ttlQueue.peek().expires < System.currentTimeMillis()) {
            Node expiredNode = ttlQueue.poll();
            map.remove(expiredNode.key);
            dll.remove(expiredNode);
        }
    }

    public static class DLL {

        private Node head, tail;

        public DLL() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public void addFirst(Node node) {

            Node next = head.next;

            node.prev = head;
            node.next = next;

            head.next = node;
            next.prev = node;
        }

        public boolean remove(Node node) {
            if (isEmpty()) {
                return false;
            }
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev = prev;
            return true;
        }

        public Node removeLast() {

            Node oldNode = tail.prev;
            this.remove(oldNode);
            return oldNode;
        }

        public void moveToHead(Node node) {

            this.remove(node);
            this.addFirst(node);
        }

        public boolean isEmpty() {
            return head.next == tail;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node tmp = head.next;
            sb.append("[");
            while (tmp != tail) {
                sb.append(tmp.val).append(", ");
                tmp = tmp.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static class Node implements Comparable<Node> {
        int key, val;
        long expires;
        Node prev, next;

        public Node() {
            this(-1, -1, -1);
        }

        public Node(int key, int val, long delay) {
            this.key = key;
            this.val = val;
            this.expires = System.currentTimeMillis() + delay;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.expires, o.expires);
        }

        public String toString() {
            return String.format("Node{%d}", val);
        }
    }

    public static void main(String[] args) throws Exception {
        LRUCacheTTL lruCacheTTL = new LRUCacheTTL(2);
        lruCacheTTL.put(1, 1, 1000);
        System.out.println(lruCacheTTL.get(1)); // 1, key:1 not expired yet
        Thread.sleep(1500);
        System.out.println(lruCacheTTL.get(1)); // -1, key:1 expired
        lruCacheTTL.put(2, 2, 5000);
        lruCacheTTL.put(3, 3, 5000);
        lruCacheTTL.put(4, 4, 1000);
        System.out.println(lruCacheTTL.get(2)); // -1, LRU hence removed
        System.out.println(lruCacheTTL.get(3)); // 3, key:3 not expired yet
        System.out.println(lruCacheTTL.get(4)); // 4, key:4 not expired yet
        Thread.sleep(1500);
        System.out.println(lruCacheTTL.get(3)); // 3, key:3 not expired yet
        System.out.println(lruCacheTTL.get(4)); // -1, key:4 expired
    }
}