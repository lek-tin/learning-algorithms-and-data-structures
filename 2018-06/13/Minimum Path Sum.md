Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

**Note:** You can only move either down or right at any point in time.

**Example:**
```
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
```
**Explanation:** Because the path 1→3→1→1→1 minimizes the sum.
**Solution:**
```python
class Solution:
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if (r == 0 and c != 0):
                    grid[r][c] += grid[r][c-1]
                if (r != 0 and c == 0):
                    grid[r][c] += grid[r-1][c]
                if (r != 0 and c != 0):
                    grid[r][c] += min(grid[r-1][c], grid[r][c-1])
                    
        return grid[len(grid) - 1][len(grid[0]) - 1]
```
