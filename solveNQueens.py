#Time Complexity:O(n!)
#Space Complexity:O(n^2), n - #queens, result array takes n^2 space
#Did it run successfully on Leetcode:yes


class Solution:
    # class Solution:
    # @return a list of lists of string
    def solveNQueens(self, n):
        self.result=[]
        self.n=n
        self.board=[["." for x in range(n)]for x in range(n)]
        self.placeQueens(0)
        return self.result
    def placeQueens(self,row):
        # this assumes that the last row has been reached and hence the queens are placed in all rows
        if row==self.n:
        # to push the placement of nqueens to the resultant array like 
            solution=[]
            for row in self.board:
                string=""
                for char in row:
                    string+=char
                solution.append(string)
            self.result.append(solution)
            return
        
        for col in range(self.n):#this is coz we want to place the queen in every column and check whether the answer is feasible or not for all the queens 
            if self.isSafe(row,col):#check if the current col is valid or not 
                self.board[row][col]='Q'
                self.placeQueens(row+1)#check for the subsequent row i.e. if the subsequent row can contain a queen 
                self.board[row][col]='.'#if not valid then backtrack or set it as previous .
            } # repeat the above for every column and hence every row till it is equal to n
       
        
        
        
    def isSafe(self,row,col):
        for r in range(row):# check if the column had a queen before.
            if self.board[r][col]=='Q': return False
        # #check if the 135° diagonal had a queen before.
        i=row-1
        j=col+1
        while i>=0 and j<self.n:
            if self.board[i][j]=='Q':
                return False
            i-=1
            j+=1
        #check if the 45° diagonal had a queen before.
        i=row-1
        j=col-1
        while i>=0 and j>=0:
            if self.board[i][j]=='Q':
                return False
            i-=1
            j-=1
        return True
