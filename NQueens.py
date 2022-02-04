# Time Complexity:N! (N factorial Time Compelexity)
# Space Complexity:o(N)

# Use Backtracking
#Traverse through every row and where the queen can be inserted. 



class Solution:
    
    def __init__(self):
        
        self.board = [[]]
        self.N = None
        self.result = []
        
    
    
    
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        self.board = [[None for _ in range(n)] for _ in range(n)]
        
        self.N = n
        
        
        
        self.backtrack(0)
        
        return self.result
    
    def backtrack(self , row):
        
#     Base Condition 
        if row == self.N:
        
            sol = []
            
            for  i in range(self.N):
                st = ""
                for j in range(self.N):
                    
                    if self.board[i][j] == True:
                        st += "Q"
                    else:
                        st+= "."
                        
                sol.append(st)
           
            self.result.append(sol)
                 
    
        for col in range(0,self.N):
            
            if (self.isSafe(row,col)):
#                 Action
                self.board[row][col] = True
#                 Recurse
                self.backtrack(row +1)
#                 Backtrack
                self.board[row][col] = None
     
#   Checking if the column above and elements diagnally to the top left and top right have any Queens 
    def isSafe(self, r , col):
        
        for i in range(r+1):
            if self.board[i][col] == True:
                return False
        
        i = r 
        j = col
        
        while(i>=0 and j>=0):
            if self.board[i][j] == True:
                return False
            i -=1 
            j-=1
        i = r 
        j = col
        
        while(i>=0 and j < self.N):
            if self.board[i][j] == True:
                return False
            i -=1
            j+=1
        return True
                
            
            
                
                
                
                
                
        
    
        
        
        
        