Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given `n = 3`, a solution set is:
```
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```

**Solution:**
```python
class Solution:
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        ans = []
        def backtrack(S = '', left = 0, right = 0):
            print(S)
            if len(S) == 2 * n:
                """Append one set of parenthesis to ans when len(S) == 2 * n"""
                ans.append(S)
                return
            if left < n:
                print("{:d}< n".format(left))
                backtrack(S+'(', left+1, right)
            if right < left:
                print("{:d}<{:d}".format(right, left))
                backtrack(S+')', left, right+1)

        backtrack()
        return ans
```
