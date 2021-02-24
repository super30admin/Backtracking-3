#TimeComplexity:O(N Factorial) Max Bound 
#SpaceComplexity: O(N*M)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution:
    #output=[]
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.output=[]
        board=[['.']*n for _ in range(n)]
        self.recur(board,0,n)
        return self.output
    
    def recur(self,board,i,n):
        if n==0 :
            self.output.append(self.returnOutput(board))
            return
        for j in range(len(board)):
            if (self.isValid(board,i,j)):
                board[i][j]='Q'
                self.recur(board,i+1,n-1)
                board[i][j]='.'
    def returnOutput(self,board):
        List=[]
        for row in board:
            List.append(''.join(row))
        return List
    def isValid(self,board,i,j):
        #check upward
        r=i;c=j
        while(r>=0):
            if board[r][c]=='Q':
                return False
            r-=1
        #check left diagonal
        r=i;c=j
        while(r>=0 and c>=0 ):
            if board[r][c]=='Q':
                return False
            r-=1
            c-=1
        #check right diagonal
        r=i;c=j
        while(r>=0 and c<len(board)):
            if board[r][c]=='Q':
                return False
            r-=1
            c+=1
        return True
            