"""
Time complexity O(N!)
space complexity O(M) -->recursive stack



"""


class Solution_Nqueens:
    def solveNQueens(self, n: int) -> List[List[str]]:
        if n==0:
            return []
        self.m=n
        self.res=[]
        self.board=[[0]*n for _ in range(n)]
        self.backtrack(0)
        return self.res
    
    def backtrack(self,r):
        if(r==self.m):
            temp=[]
            for i in range(self.m):
                s=''
                for j in range(self.m):
                    if(self.board[i][j]==1):
                        s+='Q'
                    else:
                        s+='.'
                temp.append(s)
            self.res.append(temp)
                        
        #logic
        for j in range(self.m): #col 
           
            if(self.isSafe(r,j)):
                 #action
                self.board[r][j]=1
                #recurse
                self.backtrack(r+1)
                #backtrack
                self.board[r][j]=0
    
    def isSafe(self,r,c):
        #column-up
        for i in range(r):
            if (self.board[i][c]==1):
                return False
        i=r
        j=c
        while(i>=0 and j>=0):
            if (self.board[i][j]==1):
                return False
            i-=1
            j-=1
        i=r
        j=c
        while(i>=0 and j<self.m):
            if (self.board[i][j]==1):
                return False
            i-=1