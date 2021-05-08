# Start with each row to find a valid position of the queen.
# Recursively perform backtracking to find the possible position in the next row
# Return once found all the queen positions
# Time Complexity is O(N!)
# Space Complexity is O(N)
class Solution(object):
    def __init__(self):
        self.output = []
    def checkCol(self,i,j,board):
        for row in range(len(board)):
            if(board[row][j] == 'Q'):
                return False
        return True
    def checkDiag(self,i,j,board):
        tI = i
        tJ = j
        while(i>=0 and j < len(board)):
            if(board[i][j] == 'Q'):
                return False
            i-=1
            j+=1
        i,j=tI,tJ
        while(i>=0 and j >= 0):
            if(board[i][j] == 'Q'):
                return False
            i-=1
            j-=1
        return True
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        board = [['.' for i in range(n)] for i in range(n)]
        for j in range(n):
            board[0][j] = 'Q'
            self.backtrack(1,j,board,n)
            board[0][j] = '.'
        return self.output
    def backtrack(self,i,j,board,n):
        if(i == n):
            currOut = []
            for row in range(len(board)):
                currOut.append(''.join(board[row][:]))
            self.output.append(currOut)
            return
        for j in range(len(board)):
            if(self.checkCol(i,j,board) and self.checkDiag(i,j,board)):
                board[i][j] = 'Q'
                self.backtrack(i+1,j,board,n)
                board[i][j] = '.'