# Time Complexity - O(N!)
# Space Complexity - O(N)
class Solution(object): 
    def __init__(self):
        self.result = []
    def makeOutput(self, board):
        array = []
        for i in range(0, len(board)):
            tempString = ""
            for j in range(0, len(board[i])):
                tempString += board[i][j]
            array.append(tempString)      
        return array
    
    def solveNQueens(self, n):
        chess = [["." for i in range(n)] for i in range(n)]
        self.backtrack(chess, n, 0)
        return self.result
    
    def backtrack(self, board, queensLeft, i):
        #  QueensLeft -  no of queens left to place in chess board
        #  i - On which row we are placing the queen 
        #  Output - can also be global
        if queensLeft <= 0:
            temp = self.makeOutput(board)
            self.result.append(temp)
            return 
        for j in range(0, len(board)):
            val = self.isValidLocation(board, i, j)
            if val:
                board[i][j] = "Q"
                self.backtrack(board, queensLeft-1, i+1)
                board[i][j] = "."
                
    def isValidLocation(self,board, x, y):
        row = x
        column = y
        # To check if the given cell is valid check for
        # UPPER COLUMN
        while row >= 0:
            if board[row][column] == "Q":
                return False
            row -= 1
        # LEFT DIAGONAL
        row = x
        column = y
        while row >= 0 and column >= 0:
            if board[row][column] == "Q":
                return False
            row -= 1
            column -= 1
        # RIGHT DIAGONAL
        row = x
        column = y
        while row >= 0 and column <= len(board[0])-1:
            if board[row][column] == "Q":
                return False
            column += 1
            row -= 1
        return True
       
