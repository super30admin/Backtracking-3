#Time complexity: exponential
#Space complexity: O(n^2)
class Solution:
    res=[]
    def solveNQueens(self, n: int):
        self.res=[]
        board=[[False for i in range(n)] for j in range(n)]
        self.NQueens(board,0,n)
        return self.res
    
    def NQueens(self,board,row,n):
        if row==n:
            lst=[]
            for i in range(n):
                stri=""
                for j in range(n):
                    if board[i][j]:
                        stri+="Q"
                    else:
                        stri+="."
                lst.append(stri)
            self.res.append(lst)
            return
                
        for j in range(n):
            if self.isSafe(row,j,board,n):
                board[row][j]=True
                self.NQueens(board,row+1,n)
                board[row][j]=False
    
    def isSafe(self,i,j,board,n):
        for r in range(i):
            if board[r][j]:
                return False
        r,c=i,j
        while r>=0 and c>=0:
            if board[r][c]:
                return False
            r-=1
            c-=1
        r,c=i,j
        while r>=0 and c<n:
            if board[r][c]:
                return False
            r-=1
            c+=1
        return True
            
        
                
        
        