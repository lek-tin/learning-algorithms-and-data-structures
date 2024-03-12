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
		// pointer starts from the left
		int start = left;
		// Move smaller values to left
		for (int i = left; i < right; i++) {
			if (arr[i] < pivotValue) {
			swap(arr, i, start);			
			// move on to the element on the right
			start++;
		}
		// pivotValue is the middle (at start index): [smaller..., pivotValue, bigger...]
		swap(nums, start, right);
		
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


## Recursive

```
//This is an O(n) algorithm (linear)

Given an array A, of size n:

1. Pick a random index, p, as the pivot
2. Iterate through the array, comparing every element e to p, and counting the total number of elements before p
    a. if e < p, move e to the left of p
    b. if e > p, move e to the right of p
    c. if e == p, leave e where it is
3. count the number of elements before p
4. if k < p, recurse on a[0...p-1]
   if k > p, recurse on a[p+1...n]
   uf k == p, return p
```

## Iterative

```java
/**
 * Solution: quick select
 * Time: O(N)
 * Space: O(logN ~ N)
 */
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int left = 0, right = points.length - 1;
        
        while (left < right) {
            int mid = partition(points, left, right);
            
            if (mid == k) {
                break;
            } else if(mid < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return Arrays.copyOfRange(points, 0, k);
    }
    
    private int partition(int[][] points, int left, int right) {
        
        int[] pivot = points[left];
        
        while (left < right) {
            while (left < right && compareDist(points[right], pivot) >= 0) {
                right--;
            }
            points[left] = points[right];
            
            while (left < right && compareDist(points[left], pivot) <= 0) {
                left++;
            }
            points[right] = points[left];
        }
        
        points[left] = pivot;
        
        return left;
    }

    private int compareDist(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}
```


## Problems
- https://leetcode.com/problems/median-of-two-sorted-arrays/
- https://leetcode.com/problems/kth-largest-element-in-an-array
- 
