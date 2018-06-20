Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

![Pascal's Triangle](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif "Pascal's Triangle")

In Pascal's triangle, each number is the sum of the two numbers directly above it.

**Example:**
```
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```
**Solution:**
```python
class Solution:
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        res = [[] for r in range(numRows)]
        for row in range(numRows):
            for col in range(row+1):
                if col == 0 or col == row:
                    res[row].append(1)
                else:
                    res[row].append(res[row-1][col] + res[row-1][col-1])
        return res
```
