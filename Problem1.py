## Time complexity :- O(n! ) n * n-2 *n-4 options on every row
## Space Complesity :- O(n^2) because of boolean grid that we create 


class Solution:
    mainList = []
    n = 0
    grid = []
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.mainList = []
        self.n = n 
        self.grid = []
        for i in range(n):
            self.grid.append([])
        for j in range(n):
            for k in range(n):
                self.grid[j].append(False)
        self.backTrack(0)
        return self.mainList
    
    def backTrack(self,row):

        if row == self.n:
            answer = [] 
            for i in range(self.n):
                nQueenWord = ''
                for j in range(self.n):
                    if self.grid[i][j] == True:
                        nQueenWord += "Q"

                    else:
                        nQueenWord += "."
                        
                answer.append(nQueenWord)
            self.mainList.append(answer)


        for col in range(self.n):
            if self.isSafe(row, col):
                self.grid[row][col] = True
                self.backTrack(row+1)
                self.grid[row][col] = False


    def isSafe(self, row, col):
        for i in range(row-1,-1,-1):
            print(i,col)
            if self.grid[i][col]== True:
                return False
        
        i, j  = row-1, col-1
        while i>=0 and j>=0:
            if self.grid[i][j]==True:
                return False
            i-=1
            j-=1
        
        i, j = row-1, col+1
        while i >=0 and j<self.n:
            if self.grid[i][j] == True:
                return False
            i-=1
            j+=1
        return True
            




