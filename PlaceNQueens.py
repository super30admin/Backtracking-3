"""
Approach: use recursive solution with Backtracking
Algo:
- Create a Boolean board of nxn
- For each row - find a safe location to put the queen
- Increment the row count and call recursion
- Recusion ends when r count is == n
- At that point add solution to result
- Then backtrack, remove queens and start again
- Use is_safe function to check if queen can be placed safely, check vertically, diagonally in the rows above current row
TC O(n!) - N factorial because at each step we have decreasing order of choices available : 
e.g. N x (N-2) X (N-4)
SC O(NxN) for boolean board
"""
class Solution:
    def __init__(self):
        self.result = []
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [[False for _ in range(n)] for _ in range(n)]
        
        self.dfs(board, 0)
        
        return self.result

    def dfs(self, board, row):
        n = len(board)
        # base - populate s with Qs and dots and append to str_board
        # because if row == n - means we are at the end of the board and
        # we placed all queens successfully
        if row == n:
            str_board = []
            for i in range(n):
                s = []
                for j in range(n):
                    s.append('Q') if board[i][j] else s.append('.')
                str_board.append(''.join(s))
            self.result.append(str_board)        
        
        # logic
        # Go over all columns of the board, and for given row, check 
        # what all columns we can safely place queen at, and if we can
        # then recursively call dfs/backtrack to place queen in the next row
        # if we can't place the queen for a given row,column, we don't call recursion
        # we try next combination.
        for j in range(n):
            if self.is_safe(board,row,j):
                # action
                board[row][j] = True
                # recurse
                self.dfs(board, row+1)
                #backtrack
                board[row][j] = False
                
    
    def is_safe(self,board, r, c):
        # check column
        for j in range(r):
            if board[j][c]:
                return False
        # check upper left diagonal
        i, j = r,c
        while i >= 0 and j >= 0:
            if board[i][j]:
                return False
            i -= 1
            j -= 1
        # check upper right diagonal
        i,j = r,c
        while i >= 0 and j < len(board):
            if board[i][j]:
                return False
            i -= 1
            j += 1
        return True