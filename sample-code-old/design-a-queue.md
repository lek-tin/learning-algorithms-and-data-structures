# Design A Queue

## Reference
- https://www.youtube.com/watch?v=TsS-dvG-OqU


## Basic queue
```java
// Lettcode version: https://leetcode.com/problems/design-circular-queue/
/*
 * Solution: design, queue
 * Time: O(1)
 * Space: O(N)
 */
class MyCircularQueue {
    private int[] numbers;
    private int front = 0;
    private int size = 0;
    private int capacity;
    
    public MyCircularQueue(int k) {
        numbers = new int[k];
        capacity = k;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        
        int index = (front + size) % capacity;
        numbers[index] = value;
        size++;  
        
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        
        numbers[front] = -1;
        front = (front + 1) % capacity;
        size--;
        
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        
        return numbers[front];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        
        int rearIndex = (front + size - 1 ) % capacity;

        return numbers[rearIndex];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
 ```
 
## Implement Queue using Stacks
```java
// Leetcode: https://leetcode.com/problems/implement-queue-using-stacks/
// Approach #1: two stack + lazy removal
```
 
## Blocking Queue with `Synchronized`
 ```java
 // Leetcode: https://leetcode.com/problems/design-bounded-blocking-queue/
 class BoundedBlockingQueue {
    private final Queue<Integer> queue;
    private int capacity;
    private final Object mutex = new Object();
    
    public BoundedBlockingQueue(int capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
        synchronized (mutex) {
            while (size() >= capacity) {
                mutex.wait();
            }
            
            queue.offer(element);
            mutex.notifyAll();
        }
    }
    
    public int dequeue() throws InterruptedException {
        int res;
        
        synchronized (mutex) {
            while (size() == 0) {
                mutex.wait();
            }
            
            res = queue.poll();
            mutex.notifyAll();
        }
        
        return res;
    }
    
    public int size() {
        return queue.size();
    }
}
 ```

## Blocking Queue with `ReentrantLock`
```java
/*
* Solution: ReentrantLock
* Time: O(1)
* Space: O(N)
*/
class BoundedBlockingQueue {
    private final Queue<Integer> queue;
    private int capacity;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition empty = lock.newCondition();
    private final Condition full = lock.newCondition();
    
    
    public BoundedBlockingQueue(int capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (size() == capacity) {
                full.await();
            }
            
            queue.offer(element);
            empty.signal();
        } finally {
            lock.unlock();
        }
    }
    
    public int dequeue() throws InterruptedException {
        int res;
        
        lock.lock();
        try {
            while (size() == 0) {
                empty.await();
            }
            
            res = queue.poll();
            full.signal();
        } finally {
            lock.unlock();
        }
        
        return res;
    }
    
    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }
}
```

## Basic Deque
```java
//Leetcode: https://leetcode.com/problems/design-circular-deque/
```


## Design Front Middle Back Queue
```java
//Leetcode: https://leetcode.com/problems/design-front-middle-back-queue/
/*
 * Solution: two deques, 
 * Time: O(1) for all operations
 * Space: O(N)
 */
class FrontMiddleBackQueue {
    
    private Deque<Integer> firstHalf;
    private Deque<Integer> secondHalf;
    
    public FrontMiddleBackQueue() {
        firstHalf = new ArrayDeque<>();
        secondHalf = new ArrayDeque<>();
    }
    
    private void adjustMiddle() {
        if (secondHalf.size() - firstHalf.size() > 1) {
            firstHalf.addLast(secondHalf.pollFirst());
        } else if (firstHalf.size() > secondHalf.size()) {
            secondHalf.addFirst(firstHalf.pollLast());
        }
    }
    
    private int size() {
        return firstHalf.size() + secondHalf.size();    
    }
    
    public void pushFront(int val) {
        firstHalf.addFirst(val);
        
        adjustMiddle();
    }
    
    public void pushMiddle(int val) {      
        firstHalf.addLast(val);
            
        adjustMiddle();
    }
    
    public void pushBack(int val) {
        secondHalf.addLast(val);
                
        adjustMiddle();
    }
    
    public int popFront() {
        if (size() == 0) return -1;
        
        int front = -1;
        
        if (firstHalf.size() > 0) {
            front = firstHalf.pollFirst();
        } else {
            front = secondHalf.pollFirst();
        }
        
        adjustMiddle();
        
        return front;
    }
    
    public int popMiddle() {
        if (size() == 0) return -1;
        
        int middle = -1;
        
        if (firstHalf.size() == secondHalf.size()) {
            middle = firstHalf.pollLast();
        } else {
            middle = secondHalf.pollFirst();
        }
        
        adjustMiddle();
        
        return middle;
    }
    
    public int popBack() {
        if (size() == 0) return -1;
        
        int back = -1;
        
        if (secondHalf.size() > 0) {
            back = secondHalf.pollLast();
        } else {
            back = firstHalf.pollLast();
        }
        
        adjustMiddle();
        
        return back;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
```
