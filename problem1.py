#Time Complexity : O(n^n)
#Space Complexity :O(n^n)
#Did this code successfully run on Leetcode : yes

from ast import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        board = ["."*n for _ in range(n)]
        self.solve(0, board, n, res)
        return res
    
    def solve(self, col , board, n, res):
        if col == n:
            res.append(list(board))
            return
        for row in range(n):
            if self.isSafeQueen(row, col, board, n):
                board[row] = board[row][:col] + 'Q' + board[row][col+1:]
                self.solve(col+1, board, n, res)
                board[row] = board[row][:col] + '.' + board[row][col+1:]
                
    def isSafeQueen(self, row, col, board, n):
        r1 = row
        c1 = col

        while row >= 0 and col >= 0:
            if board[row][col] == 'Q':
                return False
            row -= 1
            col -= 1
        
        row = r1
        col = c1

        while col >= 0:
            if board[row][col] == 'Q':
                return False
            col -= 1
        row = r1
        col = c1

        while row < n and col >= 0:
            if board[row][col] == 'Q':
                return False
            row += 1
            col -= 1
        
        return True