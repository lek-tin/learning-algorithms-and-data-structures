Find all possible combinations of `k` numbers that add up to a number `n`, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:
```
Input: k = 3, n = 7
Output: [[1,2,4]]
```
Example 2:
```
Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
```
**Solution:**
```python
class Solution:
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        self.res = []
        self.backtrack([], 1, k, n)
        return self.res
    
    def backtrack(self, s, index, k, n):
        if k == 0:
            if sum(s) == n:
                self.res.append(list(s))
            return
        for i in range(index, 10):
            s.append(i)
            if sum(s) <= n:
                """ Key step in this algorithm: i+1, k-1"""
                self.backtrack(s, i+1, k-1, n)
            """Delete the wrong number"""
            s.pop()
        return
```
**Note:**
Order doesn't matter!
`[1, 2, 3, 5, 6, 7, 8, 9]`
 👇
`[2, 3, 5, 6, 7, 8, 9]`
 👇
`[3, 5, 6, 7, 8, 9]`
