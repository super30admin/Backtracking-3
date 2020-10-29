"""
Time - O((n^3)n!)
Space - O(N^2)
Leetcode - Yes
Problems - No
"""

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [['' for _ in range(n)] for _ in range(n)]
        for i in range(n):
            for j in range(n):
                board[i][j] = '.'
                
        output = []
        self.helper(board, 0, output)
        return output
        
    def validate(self, board, row, col):
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                
                # Same row, left diag, right diag.
                if(board[i][j] == 'Q' and (i == row or col + i == row + j or i + j == row + col or j == col)):
                    return False
                
        return True
        
    def createOutput(self, board):
        
        result = []
        for i in range(len(board)):
            s = "".join(board[i])
            result.append(s)
        return result
        
    def helper(self, board, colIdx, output):
        
        if(colIdx >= len(board)):
            output.append(self.createOutput(board))
            return
        
        for i in range(len(board)):
            if self.validate(board, i , colIdx):
                board[i][colIdx] ='Q'
                self.helper(board,colIdx + 1 ,output)
                board[i][colIdx] = '.'
                    
        
        