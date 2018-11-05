Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

**Note:** You are not suppose to use the library's sort function for this problem.
**Example:**
```
Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```
**Follow up:**
1. A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
2. Could you come up with a one-pass algorithm using only constant space?
**Solution:**
```python
class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        if len(nums) == 0 and nums == None:
            return
            
        def swap(nums, i, j):
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        
        left, index, right = 0, 0, len(nums) - 1
                    
        while index <= right:
            if nums[index] == 0:
                swap(nums, index, left)
                index += 1
                left += 1
            elif nums[index] == 1:
                index += 1
            else:
                swap(nums, index, right)
                right -= 1
```
