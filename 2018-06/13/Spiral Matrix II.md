Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

**Example:**
```
Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
```
**Solution:**
```python
class Solution:
    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        matrix = [ [ None for i in range(n) ] for j in range(n) ]
        pos = dict(x=0, y=0)
        direction = "right"
        counter = 0
        
        while counter < n**2:
            if matrix[pos["x"]][pos["y"]] == None:
                matrix[pos["x"]][pos["y"]] = counter+1

            if direction == "right":
                if pos["y"] < n-1 and matrix[pos["x"]][pos["y"]+1] == None:
                    pos["y"] += 1 
                else: 
                    pos["x"] += 1
                    direction = "down"
            elif direction == "down":
                if pos["x"] < n-1 and matrix[pos["x"]+1][pos["y"]] == None:
                    pos["x"] += 1 
                else: 
                    pos["y"] -= 1
                    direction = "left"
            elif direction == "left":
                if pos["y"] >= 0 and matrix[pos["x"]][pos["y"]-1] == None:
                    pos["y"] -= 1 
                else: 
                    pos["x"] -= 1
                    direction = "up"
            elif direction == "up":
                if pos["x"] >= 0 and matrix[pos["x"]-1][pos["y"]] == None:
                    pos["x"] -= 1 
                else: 
                    pos["y"] += 1
                    direction = "right"
            counter += 1
                                 
        return matrix
```
