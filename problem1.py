
import copy
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        board = [[0 for i in range(n)] for j in range(n)]
        print(board)
        self.solve(board, n, 0)
        self.returnval = []
        for config in self.result:
            eachconfig = []
            for i in range(len(config)):
                s = ""
                for j in range(len(config[0])):
                    if config[i][j]== 0:
                        s = s + "."
                    elif config[i][j]==1:
                        s = s + "Q"
                eachconfig.append(s)
            self.returnval.append(eachconfig)
        return self.returnval





        print(self.result)
        return self.result

    def solve(self, board, n,row):
        if row == len(board):
            self.result.append(copy.deepcopy(board))
            return

        for i in range(n):
            if (self.safe(board,row,i,n)):
                board[row][i] = 1
                self.solve(board,n,row+1)
                board[row][i] = 0

    def safe(self,board,rows,column,n):

        col = column
        row = rows
        while(row>=0):
            if board[row][col]==1:
                return False
            row = row - 1
        col = column
        row = rows
        while(col<n and row>=0):
            if board[row][col]==1:
                return False
            row = row - 1
            col = col + 1
        col = column
        row = rows
        while(col>=0 and row>=0):
            if board[row][col]==1:
                return False
            row = row - 1
            col = col - 1
        return True






        
