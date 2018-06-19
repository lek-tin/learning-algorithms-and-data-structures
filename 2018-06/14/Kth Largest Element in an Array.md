Find the `kth` largest element in an unsorted array. Note that it is the `kth` largest element in the sorted order, not the `kth` distinct element.

**Example 1:**
```
Input: [3,2,1,5,6,4] and k = 2
Output: 5
```
**Example 2:**
```
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
```
**Note:**
You may assume `k` is always valid, `1 ≤ k ≤ array's length`.
**Solution:**
```ptyhon
class Solution:
    def findKthLargest(self, nums, k):
        if (nums == None or len(nums) == 0):
            return 0

        left, right = 0, len(nums) - 1
        
        def swap(nums, i, j):
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        
        def partition(nums, left, right):
            pivot = nums[left]
            l = left + 1
            r = right
            while l <= r:
                if nums[l] < pivot and nums[r] > pivot:
                    swap(nums, l, r)
                    l += 1
                    r -= 1
                if nums[l] >= pivot:
                    l += 1
                if nums[r] <= pivot:
                    r -= 1
            swap(nums, left, r)
            return r

        while True:
            pos = partition(nums, left, right)
            if pos + 1 == k:
                return nums[pos]
            elif pos + 1 > k:
                right = pos - 1
            elif pos + 1 < k:
                left = pos + 1
```        
