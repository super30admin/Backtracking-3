#time: O(n!) 
#Space: O(nxn)

class Solution:
    result=[]
    def solveNQueens(self, n: int) -> List[List[str]]:
        board=[[0 for i in range(n)] for i in range(n)]
        self.result=[]
        self.helper(board,0,n)
        return self.result
    
    def helper(self,board,r,n):
        if(r==n):
            queens=[]
            for i in range(n):
                level=""
                for j in range(n):
                    if(board[i][j]==0):
                        level+="."
                    else:
                        level+="Q"
                queens.append(level)
            self.result.append(queens)
            board=[[0 for i in range(n)] for i in range(n)]
            return

        for j in range(n):
            if(self.issafe(board,r,j,n)):
                board[r][j]=1

                self.helper(board,r+1,n)

                board[r][j]=0

    def issafe(self,board,r,c,n):
        for i in range(r):
            if(board[i][c]==1):
                return False
        i=r
        j=c
        while(i>=0 and j>=0):
            if(board[i][j]==1):
                return False
            i-=1
            j-=1
        i=r
        j=c     
        while(i>=0 and j<n):
            if(board[i][j]==1):
                return False
            i-=1
            j+=1
        return True

                
                
            