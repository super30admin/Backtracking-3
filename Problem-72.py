#Leet code = 51 - N-queens - https://leetcode.com/problems/n-queens/
# Time Complexity - Exponential
# it's a fundamental backtracking problem. if we are not able to place the queen in 3rd row then we backtrack the previous rows and check different possibilities.


class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        row=0
        res=[]
        board=[[0 for _ in range(n)] for _ in range(n)]
        self.placequeen(board,row,n,res)
        return res
        
    def placequeen(self,board,row,n,res):
        # base case
        if row==n:
            temp=[]
            for i in range(0,n):
                s=""
                for j in range(0,n):
                    if board[i][j]==1:
                        s=s+'Q'
                    else:
                        s+='.'
                temp.append(s)
            res.append(temp)
            return False
        
        
        #logic
        for i in range(n):#placing queen on a particular  columns at each row i is column here at each row
            if self.issafe(board,row,i):
                board[row][i]=1
                if self.placequeen(board,row+1,n,res): return True
            board[row][i]=0
        return False
                
                
    def issafe(self,board,row,col):
        for i in range(row):#since we placing horizontally on each row  i for row
            if board[i][col]==1:
                return False
        
    
        r=row-1
        c=col-1
        #left up diagonal
        while (r>=0 and c>=0):
            if board[r][c]==1:
                return False
            r=r-1
            c=c-1
        
        
        
            
        r=row-1
        c=col+1
            
        #right up diagonal
        while (r>=0 and c<len([board][0])):
            if board[r][c]==1:
                  return False
            r=r-1
            c=c+1
        return True