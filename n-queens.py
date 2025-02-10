# TC - O(n^2) as to create grid + O(n) for every row I have recursive call
# SC - O(n^2) for grid 
class Solution:
      ## Create a boolean grid with all value F
    def __init__(self):  
        self.grid = None
        self.result = []
    def solveNQueens(self, n: int) -> List[List[str]]:
        ## null check
        if n == 0:
            return []
        self.grid = [[False] * n for _ in range(n)] 
        self.backtrack(0,n)  
        return self.result
        ## Iterate through rows

    def backtrack(self,row,n):    
        ## base case
        if row == n:
            board = [] 
            for i in range(n):  
                row_string = "" 
                for j in range(n): 
                    if self.grid[i][j]:  
                        row_string += "Q" 
                    else:
                        row_string += "." 
                board.append(row_string)  
            self.result.append(board)  
            return


        ## logic
        for col in range(n):
            if self.isSafe(row,col,n):
                # action
                self.grid[row][col] = True
                # recurse
                self.backtrack(row+1,n)
                # backtract
                self.grid[row][col] = False

    def isSafe(self,row, col,n) -> bool:
        # col above check
        i =row-1
        while i>=0:
            if self.grid[i][col] == True:
                return False
            i-=1    

        # diagonal left check 
        i = row-1
        j= col-1
        while i>=0 and j>=0:
            if self.grid[i][j] == True:
                return False
            i-=1
            j-=1  

        # diagonal right check
        i = row-1
        j= col+1
        while i>=0 and j<n:
            if self.grid[i][j] == True:
                return False
            i-=1
            j+=1   
        return True        

        

        
