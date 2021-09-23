# // Time Complexity :O(n!),n*(n-2)*(n-3)
# // Space Complexity :O(n^2),to build the board
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach



import copy
class Solution:
    def __init__(self):
        self.result=[]
        self.board=None
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.board=[[False for j in range(n)]for i in range(n)]
        self.helper(0)
        return self.result
    def helper(self,r):
        #base
        if r==len(self.board):
            li=[]
            for i in range(len(self.board)):
                st=""
                for j in range(len(self.board)):
                    if self.board[i][j]==True:
                        st=st+'Q'
                    else:
                        st=st+'.'
                li.append(st)
            temp=copy.copy(li)
            self.result.append(temp)
            
                
            return
        #logic
        for c in range(len(self.board)):
            
            if self.isSafe(r,c):
            
                self.board[r][c]=True
                self.helper(r+1)
                self.board[r][c]=False
    def isSafe(self,r,c):
        
        for i in range(0,r):
            
            if self.board[i][c]==True:
                return False
            
        i=r
        j=c
        while(i>=0 and j>=0):
            
            if self.board[i][j]==True:
                return False
            i=i-1
            j=j-1
            

        i=r
        j=c
        while(i>=0 and j<len(self.board)):
            
            if self.board[i][j]==True:
                return False
            i=i-1
            j=j+1
            
    
        return True
            
            
                
                
            
        