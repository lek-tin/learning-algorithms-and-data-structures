Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

**Example 1:**
```
Input: [1,3,5,6], 5
Output: 2
```
**Example 2:**
```
Input: [1,3,5,6], 2
Output: 1
```
**Example 3:**
```
Input: [1,3,5,6], 7
Output: 4
```
**Example 4:**
```
Input: [1,3,5,6], 0
Output: 0
```
**Solution:**
```python
class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        startPos, endPos = 0, len(nums) - 1
        # check this condition first, e.g., [1]
        if target <= nums[0]:
            return 0

        if target > nums[endPos]:
            return len(nums)

        while True:
            midPos = (startPos + endPos) // 2
            if nums[midPos] == target:
                return midPos
            if nums[startPos] < target and nums[endPos] >= target and (startPos + 1) == endPos:
                return startPos + 1
            if nums[midPos] < target:
                startPos = midPos
            if nums[midPos] > target:
                endPos = midPos
```
