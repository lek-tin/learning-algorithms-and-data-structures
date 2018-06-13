Given two integers `n` and `k`, return all possible combinations of k numbers out of `1 ... n`.

**Example:**
```
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```
**Solution:**
```python
class Solution:
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        res = []
        nums = list(range(1, n+1))
        def iterate(index, tempAns):
            ans = list(tempAns)
            if len(ans) > k:
                return
            if index < n:
                ans.append(index+1)
            
            print(ans)
            if len(ans) == k:
                res.append(ans)
                return
            for j in range(index+1, n):
                iterate(j, ans)
        for i in range(n-k+1):
            iterate(i, [])
            
        return res
```
