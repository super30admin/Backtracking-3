"""
Problem : 1

Time Complexity : O(n!)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

On the n*n board, start putting the queen on the 1st index in 1st row, then iterating on next row, checking whether the new queen's path
clashes with the queen before it, if yes, iterating over next column in same row, if no cell found, then backtracking to previous queen
and changing its location to next available column and repeating the process until reached to the end of the board

"""

# N Queens

class Solution(object):
    def __init__(self):
        self.result=[]
        # self.board=None
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """

        board=[[False for _ in range(n)] for _ in range(n)]
        self.backtrack(board,0)
        return self.result

    def backtrack(self,board,i):

        # base
        if i==len(board):
            arr=[]
            for k in range(len(board)):
                arrstr=""
                for l in range(len(board[0])):
                    if board[k][l]:
                        arrstr+="Q"
                    else:
                        arrstr+="."
                arr.append(arrstr)
            self.result.append(arr)
            return



        # logic
        for j in range(len(board)):
            if self.isSafe(board,i,j):
                # action
                board[i][j]=True
                # recurse
                self.backtrack(board,i+1)
                # backtrack
                board[i][j]=False
    def isSafe(self,board,r,c):

        # column up
        for i in range(r):
            if board[i][c]:
                return False

        # diagonal up-left
        i=r
        j=c
        while i>=0 and j>=0:
            if board[i][j]:
                return False
            i-=1
            j-=1
        # diagonal up-right
        i=r
        j=c
        while i>=0 and j<len(board):
            if board[i][j]:
                return False
            i-=1
            j+=1
        return True