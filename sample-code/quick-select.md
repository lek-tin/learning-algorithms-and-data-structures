# Quick Select

Quickselect is an efficient algorithm for finding the kth smallest or largest element in an unsorted array
```java
import java.util.Random;

public class QuickSelect {

    public static int quickSelect(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException("Invalid value of k");
        }
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        int pivotIndex = partition(arr, left, right);
        
        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int randomPivotIndex = left + new Random().nextInt(right - left + 1);
        // randomPivot is now at right
        swap(arr, randomPivotIndex, right);
        int pivotValue = arr[right];

        int start = left;

        // Move smaller values to left
        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, start);
                // increment start to make sure for the next smaller item to be swapped.
                start++;
            }
        }

        swap(arr, start, right);
        return start;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4, 6};
        int k = 3;
        int kthSmallest = quickSelect(arr, k);
        System.out.println("The " + k + "th smallest element is: " + kthSmallest);
    }
}
```

The Quickselect algorithm has the following time and space complexity:

Time Complexity:
- Best Case: O(n) - This occurs when the pivot chosen in each step is always the k-th smallest element, resulting in a linear time complexity.
- Average Case: O(n) - On average, Quickselect also has a linear time complexity.
- Worst Case: O(n^2) - In the worst case, Quickselect can take quadratic time if the pivot selection consistently leads to poorly balanced partitions. However, by choosing a good pivot strategy (e.g., randomized pivot selection or median-of-medians), you can reduce the likelihood of the worst-case scenario and achieve an expected linear time complexity.

Space Complexity:
- Best Case: O(log n)
- Worst Case: O(n)
