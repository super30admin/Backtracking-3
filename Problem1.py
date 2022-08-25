# Time complexity : O(n!)
# Space complexity : (n * n)
# Leetcode : Solved and submitted

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.res = []
        # if n is 0 or null, return empty list
        if not n or n == 0:
            return self.res
        # making a board of boolean type of size n * n
        board = [[False for _ in range(n)] for _ in range(n)]
        # call the helper function with row as 0
        self.helper(board, 0, n)
        return self.res
    
    def helper(self, board, i, n):
        # base
        # if we have placed all n queens then we add the board to the resulting array
        if i == n:
            # make a string with n rows, add the value as Q if board at that index is true else add '.'
            st = ['' for _ in range(n)]
            for r in range(n):
                for c in range(n):
                    if board[r][c]:
                        st[r] += 'Q'
                    else:
                        st[r] += '.'
            # append the board generated to the final result
            self.res.append(st)
        # logic
        # we are doing row wise, so we do the for loop for columns where we have to place the queen
        for j in range(0,n):
            # for each col, we check if it is safe to put a queen here, based on the previous queens that we have placed if any
            if self.isSafe(board, i, j, n):
                #action
                # if we can place it, then make it true
                board[i][j] = True
                
                #recurse
                # recursively call the helper function by increasing the row as we can't place in the same row
                self.helper(board, i+1, n)
                
                # backtrack
                # remove the queen if there is a conflict with further queens to be placed
                board[i][j] = False
        
    # in this function, we check for diagonal left, diagonal right and top elements if they have queen
    def isSafe(self,board, r, c, n):
        a = 0
        b = 0
        # bottom up - column would be same
        for i in range(r):
            if board[i][c]:
                return False
        
        # diagonal left, we go to row - 1, col - 1 till we reach boundary condition
        a = r 
        b = c
        while a >= 0 and b >=0:
            if board[a][b]:
                return False
            a -= 1; b -= 1
        
        # diagonal right, we go to row - 1, col + 1 till we reach boundary condition
        i = r
        j = c
        while i >= 0 and j < n:
            if board[i][j]:
                return False
            i -= 1; j += 1
        
        return True
