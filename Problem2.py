#Time Complexity :O(n!)
#Space Complexity :O(n^2) 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result=[]
        board=[[False for j in range(n)]for i in range(n)]
        self.helper(board,0,n)
        return self.result

    def helper(self,board,r,n):
        #base
        if r==n:
            li=[]
            for i in range(r):
                Qli=[]
                for j in range(n):
                    if board[i][j]==True:
                        Qli.append("Q")
                    else:
                        Qli.append(".") 
                li.append("".join(Qli))
            self.result.append(li)

        #logic
        for j in range(n):
            if self.safeCheck(board,r,j):
                board[r][j]=True
                self.helper(board,r+1,n)
                board[r][j]=False

    def safeCheck(self,board,r,c):
        for i in range(r):
            if board[i][c]==True:
                return False

        i=r
        j=c
        while(i>=0 and j<len(board)):
            if board[i][j]==True:
                return False
            i-=1
            j+=1

        i=r
        j=c
        while(i>=0 and j>=0):
            if board[i][j]==True:
                return False
            i-=1
            j-=1

        return True