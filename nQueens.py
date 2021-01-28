# Time Complexity : O(N!)
# Space Complexity : O(N*N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        """
        Place queen on first row.
        Go next row and put it in safe spot
        Go next row and see if theres safe.. if not backtrack to prev. if at 
        prev we placed in each col..backtrack further.
            - Only need to check cells above from the queen currently checking
        """
        
        res = []
        
        board = [[0 for j in range(n)] for i in range(n)]
        self.backtrack(0, board, res)
        return res
    
    def backtrack(self, row, board, res):
        #reached end of the board..make it to string
        if row == len(board):  
            string = ['' for i in range(len(board))]
            
            for i in range(len(board)):
                for j in range(len(board)):
                    if board[i][j] == 'Q':
                        string[i] += 'Q'
                    else:
                        string[i] += '.'
            res.append(string)
            return 
        
        for col in range(0, len(board)):
            #place only if its valid
            if self.noConflict(row, col, board):
                board[row][col] = 'Q'
                
                self.backtrack(row+1, board, res)
                
                board[row][col] = '.'
        
        return
        
    def noConflict(self, row, col, board):
        #check col and diagonals
        for i in range(row):
            if board[i][col] == 'Q':
                return False
        #upleft diag
        r = row - 1
        c = col - 1
        while r >= 0 and c >= 0:
            if board[r][c] == 'Q':
                return False 
            r -= 1
            c -= 1
        
        #upright diag
        r = row - 1
        c = col + 1
        while r >= 0 and c < len(board):
            if board[r][c] == 'Q':
                return False
            r -= 1
            c += 1
        
        return True
        