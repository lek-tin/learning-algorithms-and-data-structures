You are given an `n x n 2D` matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image __in-place__, which means you have to modify the input 2D matrix directly. **DO NOT** allocate another 2D matrix and do the rotation.

**Example 1:**
```
Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
```
**Example 2:**
```
Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
```
**Solution:**
```python
class Solution:
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        size = len(matrix)
        maxIndex = size - 1
        for row in range(size//2):
            for col in range((size+1)//2):
                temp = matrix[maxIndex-col][row]
                matrix[maxIndex-col][row] = matrix[maxIndex-row][maxIndex-col]
                matrix[maxIndex-row][maxIndex-col] = matrix[col][maxIndex-row]
                matrix[col][maxIndex-row] = matrix[row][col]
                matrix[row][col] = temp
```
