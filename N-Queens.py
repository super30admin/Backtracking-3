class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        self.n = n        
        self.board = [['.' for _ in range(n)] for _ in range(n)]   
        self.backtrack(0)
        return self.result
    
    
    def backtrack(self,r):
        #base
        if r == self.n:
            path = []
            for i in range(self.n):
                s=""
                for j in range(self.n):                    
                        s += self.board[i][j]
                path.append(s)
            self.result.append(path)
            
                
        #logic
        for c in range(0,self.n):
            if self.isSafe(r,c):
                self.board[r][c] = 'Q'
                self.backtrack(r+1)
                self.board[r][c] = '.'
    
    
    def isSafe(self,r,c):
        
        #upper cell
        i = r-1
        while i>=0:
            if self.board[i][c]== 'Q':
                return False
            i -=1
        
        #left check
        # j = c-1
        # while j>=0:
        #     if board[r][j]== 'Q':
        #         return False            
        #     j -=1
        
        
        #upperleft diagonal
        i,j = r-1, c-1
        while i>=0 and j >= 0:
            if self.board[i][j]=='Q':
                return False
            i -=1
            j -=1
        
        #upperright diagonal
        i,j = r-1, c+1
        while i>=0 and j < self.n:
            if self.board[i][j]=='Q':
                return False
            i -=1
            j +=1
        
        return True
