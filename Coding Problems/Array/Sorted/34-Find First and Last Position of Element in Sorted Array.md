
Given an array of integers `nums` sorted in ascending order, find the starting and ending position of a given `target` value.

Your algorithm's runtime complexity must be in the order of `O(log n)`.

If the target is not found in the array, return `[-1, -1]`.

**Example 1:**
```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```
**Example 2:**
```
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```
**Solution:**  
Time: O(logN)
```python
class Solution:
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if not nums or len(nums) == 0:
            return list([-1, -1])
        start = self.findFirst(nums, target)
        if start == -1:
            return list([-1, -1])
        end = self.findLast(nums, target)
        return list([start, end])
    
    def findFirst(self, nums, target):
        start = 0
        end = len(nums) - 1
        while start + 1 < end:
            mid = (end - start) // 2 + start
            if nums[mid] < target:
                start = mid
            else:
                end = mid
        if nums[start] == target:
            return start
        if nums[end] == target:
            return end
        return -1

    def findLast(self, nums, target):
        start = 0
        end = len(nums) - 1
        while start + 1 < end:
            mid = (end - start) // 2 + start
            if nums[mid] > target:
                end = mid
            else:
                start = mid
        if nums[end] == target:
            return end
        if nums[start] == target:
            return start
        return -1
```
