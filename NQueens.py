# Time Complexity : O(N*N) Required for board and recursive stack.
# Space Complexity : O(H) Recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A

# Your code here along with comments explaining your approach

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def addSoln(res,board,n):
            tmp = []
            for row in range(n):
                string = ""
                for col in range(n):
                    string += '.' if board[row][col] == 0 else 'Q'
                tmp.append(string)
            res.append(tmp[:])
            
        #Checks whether it is safe to place a Q at board[row][col] or not - is it being attacked by any Q placed earlier in the recursion stack -
		#Remember we are moving column-by-column
        def isSafe(row,col,board,n):
            i=0
            while i <= col : # check in same row
                if board[row][i] == 1:
                    return False
                i+=1
            i,j=row,col
            while ((i>=0)&(j>=0)): # check in upwards diagonal till now
                if board[i][j] == 1:
                    return False
                i-=1
                j-=1
            i,j=row,col
            while ((i<n)&(j>=0)): # check in downwards diagonal till now
                if board[i][j] == 1:
                    return False
                i+=1
                j-=1
            return True
        
        def solve(col,res,board,n):
            # base case -  all Qs placed on the board
            if col == n:
                addSoln(res,board,n)
                return
            # logic for backtracking - put Q in all rows in the 1st col, recursion would give the all possible combinations for each 1st col placement of the Q
            for row in range(n):
                if isSafe(row,col,board,n):
                    board[row][col] = 1
                    solve(col+1,res,board,n)
                    board[row][col] -= 1
    
        res = []
        # building a board (2d matrix) - to flag if Q has already been placed at a position or not
        board = [[0 for i in range(n)] for j in range(n)]
        solve(0,res,board,n)
        return res