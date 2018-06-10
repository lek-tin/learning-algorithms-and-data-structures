Given n, how many structurally unique `BST`'s (binary search trees) that store values 1 ... n?

**Example:**
```
Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```
**Exaplanation:**
```
n = 3
root: 1     left: 0 right: 2    f(0)*f(2);
root: 2     left: 1 right: 1    f(1)*f(1);
root: 3     left: 2 right: 0    f(2)*f(0);
```
**Solution:**
```python
class Solution:
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        """
        res = [1]
        for i in range(1, n+1):
            for j in range(i):
                res.append(0)
                res[i] += res[j] * res[i - j - 1]
        return res[n]
```
