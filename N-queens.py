"""
Runtime Complexity:
O(n!)- once we place a queen in the first row the the option decreases for the second row and so on. Therefore it is factorial.
Space Complexity:
O(n^2) - grid of 'n' rows and columns respectively.
Yes, the code worked on leetcode.
Issues while coding - No 
"""


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        if n == 0:
            return [[]]
        self.result= []
        self.grid = [[False for i in range(n)]for j in range(n)]
        self.backtrack(0)
        return self.result
    
    def backtrack(self,row):
        n = len(self.grid)
        
        if row ==n: #base case(to output)
            ans = []
            for i in range(n):
                s = ""
                for j in range(n):
                    if self.grid[i][j] == True:
                        s+="Q"
                    else:
                        s+="."
                ans.append(s)
            self.result.append(ans)
            return
        
        for j in range(0,n):
            if(self.isSafe(row,j) == True):
                self.grid[row][j] = True    #can place a queen
                self.backtrack(row+1)       #increment and go to next row(action)
                self.grid[row][j] = False   #set the previous row to false(backtrack)
    
    def isSafe(self,r,c):
        n = len(self.grid)
        for i in range(r-1,-1,-1):      #column check
            if self.grid[i][c] == True:
                return False
        i = r
        j = c
        
        while(i>=0 and j>=0):           #left diagonal check
            if self.grid[i][j]==True:
                return False
            i-=1
            j-=1
        i = r
        j = c
        while(i>=0 and j<n):            #right diagonal check
            if self.grid[i][j] == True:
                return False
            i-=1
            j+=1
        return True
            
        