# 51. N-Queens


# Code:

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        
        matrix = [['.' for i in range(n)] for j in range(n)]
        output = []
        self.backtrack(matrix, n, 0, output)
        
        return output
        
    
    
    def backtrack(self,board, QueenstoPlace, row, output): 
        
        # base case:
        if QueenstoPlace==0:
            output.append(self.makeStr(board))
            return
        
        # recursive case
        for col in range(len(board)):
            if self.isvalid(board, row, col):
                board[row][col] = "Q" #set
                self.backtrack(board, QueenstoPlace-1, row+1, output) #Backtrack
                board[row][col] = "." #reset
        return
        
    
    
    def makeStr(self, board):
        
        res = []
        
        for i in range(len(board)):
            out = ""
            for j in range(len(board)):
                out+=board[i][j]
            res.append(out)
        
        return res
        
    
    def isvalid(self, board, i, j):
        r,c = i,j
        # up
        while r>=0:
            if board[r][c]=='Q':
                return False
            r-=1
        
        r,c = i,j
        # left diagonal
        while r>=0 and c>=0:
            if board[r][c]=='Q':
                return False
            r-=1
            c-=1
            
        r,c = i,j
        # right diagonal
        while r>=0 and c<len(board):
            if board[r][c]=='Q':
                return False
            r-=1
            c+=1
            
        return True

Time Complexity: O(n*n)
Space Complexity: O(n)
Acceppted on Leetcode: Yes