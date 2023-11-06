# Binary Search

## Find the only occurance in an array of numbers without duplicates
```java
int left = 0, right = n - 1;
while (left + 1 < right) {
    int mid = left + (right - left) / 2;

    if (nums[mid] == target) {
        // Found the target element
        return mid;
    } else if (nums[mid] < target) {
        // Adjust left boundary
        left = mid + 1;
    } else {
        // Adjust right boundary
        right = mid - 1;
    }
}

// target does not exist in nums
return -1;
```

## Find first occurance in an array of numbers with duplicates
```java
```

## Find last occurance in an array of numbers with duplicates
```java
```
