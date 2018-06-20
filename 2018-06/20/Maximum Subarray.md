Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

**Example:**
```
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```
**Follow up:**
```
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
```
**Solution:**    
Iterative
```python
class Solution:
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Explanation: https://leetcode.com/problems/maximum-subarray/discuss/20193/DP-solution-and-some-thoughts
        dp, res = [], nums[0]
        dp.append(nums[0])
        for i in range(1, len(nums)):
            dp.append(nums[i] + (0 if dp[i-1] < 0 else dp[i-1]))
            res = max(res, dp[i])
        return res
```     
Divide and conquer
```python
class Solution:
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Explanation: https://leetcode.com/problems/maximum-subarray/discuss/20193/DP-solution-and-some-thoughts
        res=nums[0]
        sum=nums[0]
        
        for i in range(1, len(nums)):
            sum = max(nums[i], sum+nums[i])
            res = max(res, sum)
        return res
```    
            
