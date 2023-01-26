#Time Complexity: O(n!)
#Space Complexity: O(n*n)
#Successfully ran on leetcode

class Solution:
    def __init__(self):
        self.grid = []
        self.result = []     
    def solveNQueens(self, n: int) -> List[List[str]]:
        if n==0:
            return []
        for i in range(n):
            self.grid.append([])
            for j in range(n):
                self.grid[i].append(False)
        self.recurse(0,n)
        return self.result
    def recurse(self,row,n):
        #base
        if row==n:
            path = []
            for i in range(n):
                s = ""
                for j in range(n):
                    if self.grid[i][j]==True:
                        s+='Q'
                    else:
                        s+='.'
                path.append(s)
            self.result.append(path)
            return
        #logic
        for col in range(0,n):
            if self.isSafe(row,col,n):
                self.grid[row][col] = True
                self.recurse(row+1,n)
                self.grid[row][col] = False
    def isSafe(self,row,col,n):
        #checking upper rows
        for i in range(row-1,-1,-1):
            if self.grid[i][col]==True:
                return False
        #checking left upper columns
        i = row-1
        j = col-1
        while i>=0 and j>=0:
            if self.grid[i][j]==True:
                return False
            i-=1
            j-=1
        #checking right upper columns
        i = row-1
        j = col+1
        while i>=0 and j<n:
            if self.grid[i][j]==True:
                return False
            i-=1
            j+=1
        return True
        
