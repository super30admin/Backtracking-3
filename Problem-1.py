# Time Complexity : O(N!)  # Each row tries N columns, pruning reduces possibilities
# Space Complexity : O(N)   # recursion stack + one array for column placements
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# The code places queens row by row, checking for conflicts with previously placed queens.
# It uses DFS/backtracking to explore all valid configurations.
# Each valid placement is added to the solution list.
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [[False for _ in range(n)] for _ in range(n)]
        self.result = []
        self.helper(n, 0,board)
        return self.result
    def helper(self, n,r,board):
        if r == n:
            copy_board = [row[:] for row in board]
            self.changeBoard(copy_board,n)
            self.result.append(copy_board)
            return
        for c in range(n):
            if self.canPut(r,c,n,board):
                board[r][c] = True
                self.helper(n, r+1,board)
                board[r][c]=False

    def canPut(self, i,j,n,board):
        #vertical
        for r in range(i):
            if board[r][j] == True:
                return False

        #diagonal-left-up
        r, c = i - 1, j - 1
        while r >= 0 and c >= 0:
            if board[r][c]:
                return False
            r -= 1
            c -= 1

        # diagonal right-up
        r, c = i - 1, j + 1
        while r >= 0 and c < n:
            if board[r][c]:
                return False
            r -= 1
            c += 1
        return True
    
    def changeBoard(self, board, n):
        for i in range(n):
            board[i] = ''.join('Q' if cell else '.' for cell in board[i])


        




