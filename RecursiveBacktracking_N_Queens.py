# Recursive Approach without dictionary
# // Time Complexity : O(N^N)
# // Space Complexity : O(N*N)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this
class Solution:
    board = list()
    N = int()
    result = list()
    def isSafe(self,r,c):
        # check column up
        for i in range(r+1):
            if self.board[i][c]:
                return False
        
        # diagnal up left
        i = r
        j = c
        while(i >= 0 and j >= 0):
            if self.board[i][j]:
                return False
            i -= 1
            j -= 1
            
        # diagonal up right
        i = r
        j = c
        while(i >= 0 and j < self.N):
            if self.board[i][j]:
                return False
            i -= 1
            j += 1
        
        return True
    
    def backtrack(self,i):
        # base
        if i == self.N:
            li = list()
            for k in range(self.N):
                sb = ""
                for j in range(self.N):
                    if self.board[k][j]:
                        sb += "Q"
                    else:
                        sb += "."
                li.append(sb)
            self.result.append(li)
            return
                
        # logic
        for j in range(self.N):
            if self.isSafe(i,j):
                # action
                self.board[i][j] = True
                # recurse
                self.backtrack(i+1)
                # backtrack
                self.board[i][j] = False
                
    
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.board = [[0 for i in range(n)] for j in range(n)]
        self.N = n
        self.result = []
        
        self.backtrack(0)
        return self.result
            
                
        
        
        
        