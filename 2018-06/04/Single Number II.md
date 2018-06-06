Given a **non-empty** array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

**Note:**

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

**Example 1:**
```
Input: [2,2,3,2]
Output: 3
```
**Example 2:**
```
Input: [0,1,0,1,0,1,99]
Output: 99
```
**Solution:**
```python
class Solution:
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # https://blog.csdn.net/karen0310/article/details/78226261
        ones, twos = 0, 0
        for _, num in enumerate(nums):  
            ones = (ones ^ num) & ~twos  
            twos = (twos ^ num) & ~ones
            print(bin(num), "ones: ", bin(ones), "twos: ", bin(twos))
        return ones
```
