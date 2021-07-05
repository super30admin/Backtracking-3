# Time Complexity : O(N!)
# Space Complexity : O(N^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.result=[]
        self.board=[]
        
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.board=[[False]*n for _ in range(n)]
        self.helper(0,n)
        return self.result

    def helper(self, r, n):
        if r==n:
            li=[]
            for k in range(n):
                sb=[]
                for l in range(n):
                    if self.board[k][l]==False:
                        sb.append(".")
                    else:
                        sb.append("Q")
                li.append("".join(sb))
            self.result.append(li)
            return

        for j in range(n):
            if self.isSafe(r, j, n):
                self.board[r][j]=True
                self.helper(r+1, n)
                self.board[r][j]=False

    def isSafe(self, r, c, n): 

        i=r
        j=c
        #diagnol left
        while i>=0 and j>=0:
            if self.board[i][j]:
                return False
            i-=1
            j-=1
        #diagnol right
        i=r
        j=c
        while i>=0 and j<n:
            if self.board[i][j]:
                return False
            i-=1
            j+=1
        #column
        for i in range(0,r):
            if self.board[i][c]:
                return False
        return True




