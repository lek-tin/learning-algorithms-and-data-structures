package com.example.LRU;

import java.util.*;

/*
 * Solution: DDL, hashmap
 * Time: O(1) for get, O(1) for put
 * Space: O(N)
 */
public class LRUCache {
    private Node head, tail;
    private int sizeAvail;
    private Map<Integer, Node> cache = new HashMap<>();
    
    // Double linked list node
    private class Node {
        int key, val;
        Node prev, next;
        
        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    
    private void moveToHead(Node node) {
        // Clip node out
        node.next.prev = node.prev;
        node.prev.next = node.next;
        // Move node to beginning of the DLL.
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    private void evict() {
        Node curr = tail.prev;
        cache.remove(curr.key);
        
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        
        sizeAvail++;
    }
    
    public LRUCache(int capacity) {
        sizeAvail = capacity;
        head = new Node(-1, -1, null, null);
        tail = new Node(-1, -1, null, null);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        
        Node curr = cache.get(key);
        moveToHead(curr);
        
        return curr.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node curr = cache.get(key);
            curr.val = value;
            
            moveToHead(curr);
        } else {
            if (sizeAvail == 0) evict();
            
            Node newNode = new Node(key, value, head, head.next);
            head.next.prev = newNode;
            head.next = newNode;
            
            cache.put(key, newNode);
            
            sizeAvail--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
