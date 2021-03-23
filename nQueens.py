'''
Time complexity: O(n!)
Space complexity: O(n^2)
'''
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.output = []
        if n == 0:
            return self.output
        board = [["." for i in range(n)] for j in range(n)]
        for i in range(len(board)):
            for j in range(len(board[0])):
                board[i][j] = '.'
        self.backtracking(board,0,n)
        return self.output
    
    def backtracking(self, board, i, n):
        if n==0:
            self.output.append(self.makeOutput(board))
            return
        
        for j in range(len(board[0])):
            if self.isValid(board, i, j):
                board[i][j] = 'Q'
                self.backtracking(board, i+1, n-1)
                board[i][j] = '.'
    
    def isValid(self, board, i, j):
        r=i
        c=j
        while(r >= 0):
            if(board[r][c] == 'Q'):
                return False
            r = r-1
            
        r=i
        c=j
        while(r >= 0 and c>=0):
            if(board[r][c] == 'Q'):
                return False
            r = r-1
            c = c-1
        
        r=i
        c=j
        while(r >= 0 and c < len(board[0])):
            if board[r][c] == 'Q':
                return False
            r = r-1
            c = c+1
        return True
    
    def makeOutput(self, board):
        temp = []
        for i in range(len(board)):
            str = ""
            for j in range(0, len(board[0])):
                str = str + board[i][j]
            temp.append(str)
        return temp