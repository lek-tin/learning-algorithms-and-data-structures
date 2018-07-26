Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy **all of the following rules:**

Each of the digits `1-9` must occur exactly once in each row.
Each of the digits `1-9` must occur exactly once in each column.
Each of the the digits `1-9` must occur exactly once in each of the 9 `3x3` sub-boxes of the grid.
Empty cells are indicated by the character `'.'`.

![Sudoku Puzzle](https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png)
A sudoku puzzle...

![Sudoku Puzzle](https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png)

...and its solution numbers marked in red.

**Note:**

The given board contain only digits `1-9` and the character `'.'`.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always `9x9`.

**Solution:**
```python
class Solution:
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        if board == None or len(board) == 0:
            return
        self.solve(board)
        
    def solve(self, board):
        size = 9
        for row in range(size):
            for col in range(size):
                if board[row][col] == '.':
                    for char in list('123456789'):
                        if self.isValid(board, row, col, char):
                            board[row][col] = char
                            if self.solve(board):
                                return True
                            else:
                                board[row][col] = '.'
                    return False
        return True    
    
    def isValid(self, board, row, col, char):
        size = 9
        for i in range(size):
            if board[i][col] == char:
                return False
            if board[row][i] == char:
                return False
            tempCubeSlot = board[3 * (row // 3) + i // 3][3 * (col // 3)  + i % 3]
            if tempCubeSlot != '.' and tempCubeSlot == char:
                return False
        return True
```
