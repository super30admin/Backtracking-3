# Time Complexity : O(NXM) # Exponential
# Space Complexity : O(N) N-> size of recursion
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to Recurse all possible Queen position and backtrack not possible positions.

class Solution:
    def __init__(self):
        self.res=[]

    def solveNQueens(self, n: int) -> List[List[str]]:
        board=[["." for i in range(n)] for i in range(n)]
        self.backtrack(board, 0, n)
        return self.res

    def backtrack(self, board,i,n):
        if(i==n):
            self.res.append(["".join(i) for i in board])
            return                        

        for j in range(0,n):
            if(self.IsSafe(board, i , j,n)):
                board[i][j]="Q"
                self.backtrack(board, i+1, n)
                board[i][j]="."

    def IsSafe(self, board, r, c,n):
        for i in range(0, r):
            if(board[i][c]=="Q"):
                return False
        i=r
        j=c
        while(i>=0 and j>=0):
            if(board[i][j]=="Q"):
                return False
            i-=1
            j-=1
        i=r
        j=c
        while(i>=0 and j<n):
            if(board[i][j]=="Q"):
                return False
            i-=1
            j+=1
        return True