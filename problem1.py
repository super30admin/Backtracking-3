#Time Complexity :O(n!)
#Space Complexity :O(n*m)
#Did this code successfully run on Leetcode : yes
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [[False for i in range(n)] for j in range(n)]
        print(board)
        res=[]
        self.backtrack(0,n,board,res)
        return res
    
    def backtrack(self,r,n,board,res):
        if r == n:
            li=[]
            for i in range(n):
                s=[]
                for j in range(n):
                    if board[i][j]==True:
                        s.append("Q")
                    else:
                        s.append(".")
                li.append("".join(s))
            res.append(li)
            return
        
        for c in range(n):
            #Action
            if self.isSafe(r,c,board,n):
                board[r][c]=True
            #Recurse
                self.backtrack(r+1,n,board,res)
            #Backtrack
                board[r][c]=False
                
 #Checks whether its safe to place the queen        
    def isSafe(self,r,c,board,n):
        for i in range(r):
            if board[i][c]==True:
                return False
            
        i=r
        j=c
        
        while i>=0 and j>=0:
            if board[i][j]:
                return False
            i-=1
            j-=1
            
        i=r
        j=c
        
        while i>=0 and j<n:
            if board[i][j]:
                return False
            i-=1
            j+=1
            
        return True