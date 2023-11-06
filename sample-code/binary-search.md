# Binary Search

## Find the only occurance in an array of numbers without duplicates
```java
int left = 0, right = n - 1;
while (left + 1 < right) {
    int mid = left + (right - left) / 2;
    
    if (target > preSums[mid]) {
        left = mid + 1;
    } else {
        right = mid;
    }
}

if (target < nums[left]) return left;

return right;
```

## Find first occurance in an array of numbers with duplicates
```java
```

## Find last occurance in an array of numbers with duplicates
```java
```
