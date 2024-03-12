Time Complexity of Heap oprations
![](static/images/time-complexity-of-building-a-heap.png)

```java
// Ref: ChatGPT
import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MinHeap() {
        this.heap = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void insert(int value) {
        ensureCapacity();
        heap[size++] = value;
        heapifyUp();
    }

    public int extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return min;
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > heap[index]) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = leftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = rightChildIndex(index);
            }

            if (heap[index] < heap[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }
    }

    private void ensureCapacity() {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private int leftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return parentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return heap[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return heap[rightChildIndex(index)];
    }

    private int parent(int index) {
        return heap[parentIndex(index)];
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(4);
        minHeap.insert(2);

        System.out.println("Min Heap: ");
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.extractMin());
        }
    }
}

```