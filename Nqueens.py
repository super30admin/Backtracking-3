#Time Complexity : O(N!)
#Space Complexity : O(N^2)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.board = [[False for i in range(n)] for j in range(n)]
        self.result = []
        self.backtrack(0, n)
        return self.result
        
        
    
    def backtrack(self,row, n):
        
        #Base Case
        if(row == n):
            placement = []
            for i in range(n):
                eachRow = []
                for j in range(n):
                    if(self.board[i][j] == False):
                        eachRow.append(".")
                    else:
                        eachRow.append("Q")
                placement.append("".join(eachRow))
            self.result.append(placement)
            return
        
        
        #Condition
        for i in range(n):
            if(self.isSafe(row, i, n)):
                self.board[row][i] = True
                self.backtrack(row+1, n)
                self.board[row][i] = False
                
    def isSafe(self,r, c, n):
        #coloum up 
        for i in range(r,-1,-1):
            if(self.board[i][c] == True):
                return False
        #Diagonal Left  
        i = r
        j = c
        while(i >= 0 and j >= 0):
            if(self.board[i][j] == True):
                return False
            i -= 1
            j -= 1
        i = r
        j = c
        while(i >= 0 and j < n):
            if(self.board[i][j] == True):
                return False
            i -= 1
            j += 1
        return True
