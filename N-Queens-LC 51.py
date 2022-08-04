# Time Complexity = approx O(n!), sinvce with each row, the number of options to place the queen is decreasing
# Space Complexity = O(n * n)  + O(n), grid of n * n, recursive stack for n each row
#                  = O(n * n)


# For Loope based Recursion with Backtracking
class Solution:
    def solveNQueens(self, n: int) -> list[list[str]]:
        if n == 0:
            return [[]]
        
        self.result = []
        self.grid = [[False for j in range(n)] for i in range (n)]
        #self.grid = [[False] * n] * n
        
        self.backtrack(0)
        
        return self.result
    
    
    def backtrack(self, row):
        n = len(self.grid)
        # Base Case
        if row == n:
            answer = []
            for i in range(n):
                # create 1 string for each row
                sb = ""
                for j in range(n):
                    if self.grid[i][j] == True:
                        sb += 'Q'

                    else:
                        sb += "."
                
                answer.append(sb)
                
            self.result.append(answer)
            return
        
        
        # Logic
        for j in range(0, n):
            if (self.isSafe(row, j) == True):
                # Action
                # Add your queen
                self.grid[row][j] = True
                
                # Recurse
                self.backtrack(row + 1)
                
                # Backtrack
                self.grid[row][j] = False
                
                
    
    def isSafe(self, r, c):
        n = len(self.grid)
        
        # Column check
        for i in range(r - 1, -1, -1):
            if self.grid[i][c] == True:
                return False
        
        # Left Diagonal Check
        i = r
        j = c
        while (i >= 0 and j >= 0):
            if self.grid[i][j] == True:
                return False
            
            i -= 1
            j -= 1
            
        
        # Right Diagonal Check
        i = r
        j = c
        while(i >= 0 and j < n):
            if self.grid[i][j] == True:
                return False
            
            i -= 1
            j += 1
        
        
        return True
                
                
            