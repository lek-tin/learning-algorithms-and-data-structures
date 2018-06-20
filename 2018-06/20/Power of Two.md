Given an integer, write a function to determine if it is a power of two.

**Example 1:**
```
Input: 1
Output: true 
Explanation: 2**0 = 1
```
**Example 2:**
```
Input: 16
Output: true
Explanation: 2**4 = 16
```
**Example 3:**
```
Input: 218
Output: false
```
**Solution:**
```python
class Solution:
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n == 0:
            return False
        if n & (n - 1) == 0:
            return True
        return False
```
