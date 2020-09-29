# Leetcode problem link : https://leetcode.com/problems/n-queens/
# Time Complexity:    O(n!)
# Space Complexity:   O(n*n) for board
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
    1. Place one queen in the first row.
    2. Iterate through all the columns and check if queen can be placed. If yes proceed to next row. Else, backtrack and place queen in next column for previous row and repeat.
    3. If we have reached last row+1 then all the queens were placed succesfully, add it to output.

'''

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        if not n:
            return []
        board = [['.' for _ in range(n)] for _ in range(n)]
        output = []
        self.backtrack(n,output,0,board)
        return output
    
    def backtrack(self,n,output,i,board):
        if i == n:
            self.addToOutput(board,output)
            return
        for j in range(0,len(board)):
            if(self.canPlaceQueen(board,i,j)):
                board[i][j] = 'Q'
                self.backtrack(n,output,i+1,board)
                board[i][j] = '.'
    
    def canPlaceQueen(self,board,i,j):
        r = i
        c = j
        
        while r >= 0:
            if board[r][c] == 'Q':
                return False
            r -= 1
        
        r = i
        
        while r >= 0 and c >= 0:
            if board[r][c] == 'Q':
                return False
            r -= 1
            c -= 1
        
        r = i
        c = j
        
        while r >= 0 and c < len(board):
            if board[r][c] == 'Q':
                return False
            r -= 1
            c += 1
        
        return True
    
    def addToOutput(self,board,output):
        temp = []
        for i in range(len(board)):
            row = ""
            for j in range(len(board)):
                row += board[i][j]
            temp.append(row)
        output.append(temp)
            
        