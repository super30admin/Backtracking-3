class Solution:
    result = []
    grid = []
    n = 0
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.grid = [[False]*n for _ in range(n)]
        self.result = []
        self.n = n
        
        self.backtrack(0) ## pass the row co-ordinates

        return self.result
    
    def backtrack(self,row):
        #base case
        if row == self.n:
            answer = []
            for i in range(self.n):
                mid_str = ""
                for j in range(self.n):
                    if self.grid[i][j] == False:
                        mid_str+= "."
                    else:
                        mid_str+= "Q" 
                answer.append(mid_str)           
            self.result.append(answer)

            return

        #logic

        for col in range(0,self.n):
            
            print(row)
            if self.isSafe(row , col):

                #action
                self.grid[row][col] = True

                #recurse
                self.backtrack(row+1)

                #backtrack
                self.grid[row][col] = False
    

    def isSafe(self, row , col):
       #checking upwards

        for i in range(row-1 , -1 , -1):
            if self.grid[i][col] == True:
                return False


        #checking up left
        i = row - 1
        j = col - 1

        while i >=0 and j >=0:
            if self.grid[i][j] == True:
                return False
            i-=1
            j-=1
        #checking up right

        i = row - 1
        j = col + 1

        while i >=0 and j < self.n:

            if self.grid[i][j] == True:
                return False
            i-=1
            j+=1

        return True




          
