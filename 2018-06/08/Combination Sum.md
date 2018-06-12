Given a **set** of candidate numbers (`candidates`) **(without duplicates)** and a `target` number (target), find all unique combinations in candidates where the `candidate` numbers sums to `target`.

The same repeated number may be chosen from `candidates` unlimited number of times.

**Note:**

All numbers (including `target`) will be positive integers.
The solution set must not contain duplicate combinations.
**Example 1:**
```
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
```
**Example 2:**
```
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
```
**Solution:**
```python
class Solution:
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        def add(candidates, target, tempAns, i, sum):
            # clone a copy of tempAns
            ans = list(tempAns)
            # print("res:", res, "; ans:", ans, "; i:", i, "; sum", sum)
            if(sum>target):
                return
            if(sum==target):
                res.append(ans) 
                return
            if(i>=len(candidates)):
                return
            # recursive cases
            # Try current index again. so sum increases by a[i] and as that element can be choosen for unlimited times
            ans.append(candidates[i])
            add(candidates, target, ans, i, sum+candidates[i])
            # backtracking
            ans.pop()
            # excluding the current element
            add(candidates, target, ans, i+1, sum)
        add(candidates,target, [], 0, 0)
        return res
```
