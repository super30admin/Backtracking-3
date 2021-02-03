# Time Complexity : O(N!) where N is the input
# Space Complexity : O(N*N)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I go row by row and for each column in the row I check if row.column is safe. If Yes
# go to next row else next column. If all column are not safe go to next column in previous row

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [[0 for x in range(n)] for y in range(n)]
        self.result = []
        self.breachRow(board, n, 0)
        return self.result
    
    def breachRow(self, board, n, row):
        if row == n:
            mid = [["Q" if x == 1 else "." for x in y] for y in board]
            self.result.append(["".join(x) for x in mid])
            return
            
        for c in range(n):
            if self.is_safe(board, row, c, n):
                board[row][c] = 1
                self.breachRow(board, n, row+1)
                board[row][c] = 0
            
            
    def is_safe(self, board, row, column, n):
        c_row = row - 1
        c_column = column - 1
        
        while c_row >= 0:
            if board[c_row][column] == 1:
                return False
    
            c_row -= 1
            
        c_row = row - 1
        c_column = column - 1
        while c_row >= 0 and c_column >= 0:
            if board[c_row][c_column] == 1:
                return False
            
            c_row -= 1
            c_column -= 1
            
        c_row = row - 1
        c_column = column + 1
        while c_row >= 0 and c_column < n:
            if board[c_row][c_column] == 1:
                return False
            
            c_row -= 1
            c_column += 1
        
        return True