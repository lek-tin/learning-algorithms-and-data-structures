Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  `[0,1,2,4,5,6,7]` might become  `[4,5,6,7,0,1,2]`).

Find the minimum element.

You may assume no duplicate exists in the array.

**Example 1:**
```
Input: [3,4,5,1,2] 
Output: 1
```
**Example 2:**
```
Input: [4,5,6,7,0,1,2]
Output: 0
```
**Solution:**
```python
class Solution:
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return min(nums[0], nums[1])
        if nums[0] < nums[len(nums)-1]:
            return nums[0]
        if nums[len(nums)-2] > nums[len(nums)-1]:
            return nums[len(nums)-1]
        
        for i in range(1, len(nums)-1):
            if nums[i] < nums[i-1] and nums[i] < nums[i+1]:
                return nums[i]
    def bsFindMin(self, nums):
        while l < r:
                m = (l + r) // 2
                if nums[m] > nums[m - 1] and nums[m] > nums[m + 1]:
                    return nums[m + 1]
                if nums[m] < nums[m - 1] and nums[m] < nums[m + 1]:
                    return nums[m]
                if nums[m] >= nums[r]:
                    l = m
                else:
                    r = m
            return nums[0]
```
