#Time Complexity: O(n!)
#Space Complexity: O(n^2)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result=[]
        if n==0:
            return self.result
        #creating a board
        board = [[False]*n for i in range(n)]
        
        self.helper(board,0)
        return self.result
    
    def helper(self, board, row):
        #base
        if row==len(board):
            li=[]
            for i in range(len(board)):
                stringBuilder=""
                for j in range(len(board)):
                    if board[i][j]==True:
                        stringBuilder+='Q'
                    else:
                        stringBuilder+='.'
                li.append(stringBuilder)
                
            print(li)
            self.result.append(li)
                    
        #logic
        for j in range(len(board)):
            if self.isSafe(board, row, j):
                board[row][j]=True
                #recurse
                self.helper(board, row+1)
                #backtrack
                board[row][j]=False
    def isSafe(self, board, row, col):
        #up col
        for i in range(row):
            if board[i][col]==True:
                return False
        #diagonal up left
        i=row
        j=col
        while i>=0 and j>=0:
            if board[i][j]:
                return False
            i-=1
            j-=1
        #diagonal up right
        i=row
        j=col
        while i>=0 and j<len(board):
            if board[i][j]:
                return False
            i-=1
            j+=1
        return True
            
        
        
        
        
        