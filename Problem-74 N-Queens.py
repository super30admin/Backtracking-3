# 51. N-Queens
# https://leetcode.com/problems/n-queens/

# Time Complexiety: O(n!)
# Space Complexiety: O(n)

class Solution:
    def __init__(self):
        self.res = []

    def isSafe(self, board, row, col, n):
        # We will not check the row as in each row only we will put one queen so it cannot have more queens.
        # We will not check below our current row and col because that part is yet to have a queen.

        # Checking column
        for i in range(row):
            if board[i][col] == True:
                return False
        
        # Major Diagonal
        i = row
        j = col
        while i >= 0 and j >= 0:
            if board[i][j] == True:
                return False
            i -= 1
            j -= 1

        # Minor Diagonal
        i = row
        j = col
        while i >= 0 and j < n:
            if board[i][j] == True:
                return False
            i -= 1
            j += 1

        return True

    def _helper(self, row, n,board):
        # Base
        if row == n:
            # Format result
            li = list()
            for i in range(n):
                s = []
                for j in range(n):
                    if board[i][j] == True:
                        s.append("Q")
                    else:
                        s.append(".")
                li.append("".join(s))
            self.res.append(li.copy())
            return
        
        for col in range(n):
            if self.isSafe(board, row, col, n):
                board[row][col] = True
                self._helper(row+1, n, board)
                board[row][col] = False

    def solveNQueens(self, n):
        board = [[False for i in range(n)] for i in range(n)]

        self._helper(0, n, board)
        return self.res
