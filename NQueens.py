# Time Complexity: O(2^n)
# Space Complexity:O(n^2) 
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.output=[]
        board=[[False for j in range(0,n)] for i in range(0,n)]
        self.placeQueen(n, board,0)
        return self.output
         
    def placeQueen(self, n, board, row):
        if row==n:
            self.output.append(self.createOutput(board, n))
            return
        for j in range(0,n):
            if(not self.checkIfAnotherQueen(n,board,row,j) ):
                board[row][j]=True
                self.placeQueen(n,board,row+1)
                board[row][j]=False

    def checkIfAnotherQueen(self,n,board,row,column):
        for j in range(0,n):
            if(j!=column and board[row][j]==True):
                return True
        
        for i in range(0,n):
            if(i!=row and board[i][column]==True):
                return True
        nr=row
        nc=column
        #up right
        while(nr>=0 and nc<n):
            if board[nr][nc]==True:
                return True
            nr=nr-1
            nc=nc+1
        nr=row
        nc=column
        while(nr>=0 and nc>=0):
            if board[nr][nc]==True:
                return True
            nr=nr-1
            nc=nc-1
        return False
    
    def createOutput(self, board,n):
        outerList=[]
        for i in range(0,n):
            innerList=""
            for j in range(0,n):
                if board[i][j]==False:
                   innerList=innerList+"."
                else:
                   innerList= innerList+ "Q"
            outerList.append(innerList)
        return outerList