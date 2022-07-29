# Time complexity: O(n!)
# Space complexity: O(n^2)
# Approach: create a nxn matrix to store the True and False values
# for each row, check for queen placement if its available or not by checking the all the previous row- same cols, diagonals, if safe- make it true
# also backtrack by making it false to know the other possibilities.


class Solution:
    result = []
    grid = []
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        self.n = n
        if n == 0:
            return result
        self.grid = [[False for j in range(n)] for i in range(n)]
        self.backtrack(0)
        return self.result
        
        
        
    def backtrack(self,row):
        if row == self.n:
            answer = []
            for i in range(0,self.n):
                string = str()
                for j in range(0,self.n):
                    if self.grid[i][j]== True:
                        string+='Q'
                    else:
                        string += '.'
                answer.append(str(string))
            self.result.append(answer)
                        
        
        
        
        #logic
        for i in range(self.n):
            if(self.issafe(row, i)==True):
                #action
                self.grid[row][i] = True
                #recursion
                self.backtrack(row+1)
                #backtrack
                self.grid[row][i] = False
        
    def issafe(self,row,col):
        #check column wise:
        for i in range(row-1,-1,-1):
            if self.grid[i][col]== True:
                return False
        # left diagonal:
        i , j = row , col
        while i >=0 and j >= 0:
            if self.grid[i][j] == True:
                return False
            i-=1
            j-=1
        # right diagonal
        i , j = row,col
        while i>=0 and j < self.n:
            if self.grid[i][j] == True:
                return False
            i-=1
            j+=1
        return True
                
        
            
    
                
                
                
        