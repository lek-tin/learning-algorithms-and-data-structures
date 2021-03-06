Determine if a `9x9` Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits `1-9` without repetition.
Each column must contain the digits `1-9` without repetition.
Each of the 9 `3x3` sub-boxes of the grid must contain the digits `1-9` without repetition.

![Valid Sudoku](https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png)
A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character `'.'`.

**Example 1:**
```
Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
```
**Example 2:**
```
Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
```
**Note:**
- A Sudoku board (partially filled) could be valid but is not necessarily solvable.
- Only the filled cells need to be validated according to the mentioned rules.
- The given board contain only digits `1-9` and the character `'.'`.
- The given board size is always `9x9`.
**Solution:**  
Long method
```python
class Solution:
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        size = 9
        for i in range(size):
            rowDict = {}
            colDict = {}
            cubeDict = {}
            for j in range(size):
                if board[i][j] is not '.' and rowDict.get(board[i][j]):
                    return False
                rowDict[board[i][j]] = True
                if board[j][i] is not '.' and colDict.get(board[j][i]):
                    return False
                colDict[board[j][i]] = True 
                
                rowIndex = 3 * (i // 3) + j // 3
                colIndex = 3 * (i % 3)  + j % 3
                if board[rowIndex][colIndex] is not '.' and cubeDict.get(board[rowIndex][colIndex]):
                    return False
                cubeDict[board[rowIndex][colIndex]] = True
        
        return True
```
Decoupled method
```python
class Solution:
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        size = 9
        for i in range(size):
            for j in range(size):
                if board[i][j] == '.':
                    continue
                if not self.isValid(board, i, j):
                    return False
        return True
    
    def isValid(self, board, i, j):
        for row in range(len(board)):
            if row == i:
                continue
            if board[row][j] == board[i][j]:
                return False
            
        for col in range(len(board)):
            if col == j:
                continue
            if board[i][col] == board[i][j]:
                return False
            
        for row in range((i // 3) * 3, (i // 3 + 1) * 3):
            for col in range((j // 3) * 3, (j // 3 + 1) * 3):
                if row == i and col == j:
                    continue
                if board[row][col] == board[i][j]:
                    return False
        return True
```
