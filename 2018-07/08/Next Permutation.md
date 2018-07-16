Implement **next permutation**, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
`1,2,3` → `1,3,2`
`3,2,1` → `1,2,3`
`1,1,5` → `1,5,1`   
**Solution:**
```python
class Solution:
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        if nums == None or len(nums) == 0:
            return

        firstSmall = -1
        i = len(nums) - 2
        while i >= 0:
            # Find the first element that is greater than its next element
            if nums[i] < nums[i+1]:
                firstSmall = i
                break
            i -= 1
    
        # When the list is all the way, descending
        if firstSmall == -1:
            # Reverse the while list
            self.reverseTillEnd(nums, 0)
            return
        # Initiate a firstLarge element
        firstLarge = -1
        j = len(nums) - 1
        while j > firstSmall:
            if nums[j] > nums[firstLarge]:
                firstLarge = j
                break
            j -= 1
        # Swap firstSmall and firstLarge
        self.swap(nums, firstSmall, firstLarge)
        # Then reverse the part of the list that comes after firstSmall
        self.reverseTillEnd(nums, firstSmall+1)
    
    # Define the reverse function
    def reverseTillEnd(self, nums, start):
        end= len(nums) - 1
        while start < end:
            self.swap(nums, start, end)
            start += 1
            end -= 1
    # define the swap function
    def swap(self, nums, a, b):
        temp = nums[a]
        nums[a] = nums[b]
        nums[b] = temp
```
