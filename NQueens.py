# TC = O(n!)
# SC = O(n**2)
# We examine row wise. Place Q(mark visited-1 in the aux board) at each position starting from the first position at each row, and go on to next rows and check which cell is safe for placing Q. When there is no possibilities we return back to parent call/s. At parent call we go to next element(using pivot pattern backtrack) while retaining required state of board by reversing the prior action taken. 
class Solution:
    def __init__(self):
        self.result = []
        self.board = []
        self.m = None
        
    def solveNQueens(self, n):
        self.m = n
        self.board = [[0 for i in range(n)] for y in range(n)] 
        self.helper(0)
        return self.result
    
    def helper(self, row):
        # base
        if row == self.m:
            # found word!
            # check board and form the required entry to be appended to the result array
            temp = []
            for i in range(self.m):
                sb = []
                for j in range(self.m): 
                    if self.board[i][j] == 1:
                        sb.append('Q')
                    else:
                        sb.append('.')
                s = "".join(sb)
                temp.append(s)
            self.result.append(temp)
        
        # logic
        for j in range(self.m):
            if self.isSafe(row, j):
                # action
                self.board[row][j] = 1
                # recurse
                self.helper(row+1)
                # backtrack
                self.board[row][j] = 0
    
    def isSafe(self, row, col):
        # col check
        for i in range(row):
            if self.board[i][col] == 1: return False
        
        # up-left diag check
        i, j = row, col
        while i >= 0 and j >= 0:
            if self.board[i][j] == 1: return False
            i-= 1
            j-= 1
        
        # bottom-right diag check
        i, j = row, col
        while i >= 0 and j < self.m:
            if self.board[i][j] == 1: return False
            i-= 1
            j+= 1
        return True 