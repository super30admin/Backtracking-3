# Time: O(N!) - O(n) to go throught the board and O(n) to create the board as well. Then N! for all the possible arrangements for a particular queen. i.e. for the first queen we have n options, for the second we have n-2 options and so on.
# Space: O(N^2) - for the board

# Question: To place n queens on an n x n chessboard such that no two queens threaten each other. Return all distinct solutions to the n-queens puzzle.

# At first we initialize the board with all False values, indicating no queens are placed initially.
# then we call the backtrack function starting from the first row (row 0). 
# The backtrack function will try to place a queen in each column of the current row 
# But first we need to check if it's safe to place it there using the isSafe function. If it's safe, we mark that position as True (indicating a queen is placed) and recursively call backtrack for the next row. After exploring that path, we backtrack by marking that position as False again, allowing us to explore other possibilities. 
# the base case is when row equals n, it means we've successfully placed queens in all rows, and we construct the board configuration and add it to the result list.
# The isSafe function just check the column above the current position, the diagonal left and the diagonal right to ensure that no other queen is threatening the current position.
# At the end we the return the result.
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        board = [[False for _ in range(n)]for _ in range(n)]
        self.backtrack(board,0,res,n)
        return res
    def backtrack(self,board,row,res,n):
        # base case
        if row == n:
            path = []
            for i in range(n):
                rw_str = ''
                for j in range(n):
                    if board[i][j]: rw_str += 'Q'
                    else: rw_str += '.'
                path.append(rw_str)
            res.append(path)
            return

        # Logic
        for c in range(n):
            if self.isSafe(board,row,c):
                # action
                board[row][c] = True
                # recurse
                self.backtrack(board,row+1,res,n)
                # backtrack
                board[row][c] = False

    def isSafe(self,board,rw,cl):
        # column up
        for i in range(rw-1,-1,-1):
            if board[i][cl]: return False

        # diagonal left
        i,j = rw, cl
        while i >= 0 and j >= 0:
            if board[i][j]: return False
            i -= 1
            j -= 1
        
        # diagonal right
        i,j = rw, cl
        while i >= 0 and j < len(board):
            if board[i][j]: return False
            i -= 1
            j += 1
        return True