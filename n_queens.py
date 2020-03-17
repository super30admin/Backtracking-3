// Time Complexity : O(n!)
// Space Complexity :o(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we have used backtracking in this problem.every time we place a queen at a position we check if it is a valid position or not.If yes we do check for remaining rows whther they are at the valid position or not and fill up the board. 

# DFS and Backtracking
class Solution(object):
    def __init__(self):
        self.result=[]
    
    def isvalid(self,board,row,col,n):
        #top side
        for i in range(row):
            if board[i][col]==1:
                return False
        # up left diagonal
        i=row-1
        j=col-1
        while i>=0 and j>=0:
            if board[i][j]==1:
                return False
            i=i-1
            j=j-1
        # up right diagonal
        i=row-1
        j=col+1
        while i>=0 and j<len(board[0]):
            if board[i][j]==1:
                return False
            i=i-1
            j=j+1
        return True
    
    def helper(self,board,r,n):
        # base case
        if r==n:
            list2=[]
            for i in range(n):
                list1=''
                for j in range(n):
                    if board[i][j]==1:
                        list1=list1+'Q'
                    else:
                        list1=list1+'.'
                list2.append(list1)
            self.result.append(list2)
            # return
        # logic
        for i in range(n):
            if self.isvalid(board,r,i,n): 
                board[r][i]=1 #ACtion
                self.helper(board,r+1,n) #Recursion
                board[r][i]=0 #Backtrack
                
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        if n==0:
            return []
        board=[[0 for i in range(n)]for j in range(n)]
        self.helper(board,0,n)
        return self.result