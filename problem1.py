# Backtracking-3

## Problem1 
# N Queens(https://leetcode.com/problems/n-queens/)

# Approach
# Create n*n board. Recursively call helper function and pass i(row) and n. In helper function, traverse through the column. 
# if board[i][j] is safe , set it to true and call helper(i+1,n). In isSafe function, check column up, column left, column right before i,j.
# If i == n, if board[r][c] == True, append 'Q', else append '.'. append row to li list and once complete append li to res. return res

# Time Complexity: O(N * N!)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def isSafe(self, i, j,n):
        # column up
        r = i
        c = j
        while (r>= 0):
            if self.board[r][c] == True:
                return False
            r -= 1
        
        # column left
        r = i
        c = j
        while(r>=0 and c >= 0):
            if self.board[r][c] == True:
                return False
            r -= 1
            c -= 1

        # column right
        r = i
        c = j
        while(r>=0 and c < n):
            if self.board[r][c] == True:
                return False
            r -= 1
            c += 1
        return True

    def helper(self, i, n):
        # base 
        if i == n:
            li = []
            for r in range(n):
                row = []
                for c in range(n):
                    if self.board[r][c] == True:
                        row.append('Q')
                    else:
                        row.append('.')
                li.append(''.join(row))
            
            self.res.append(li)
            return

        # logic
        for j in range(n):
            if self.isSafe(i,j,n):
                self.board[i][j] = True
                self.helper(i+1,n)
                self.board[i][j] = False


    def solveNQueens(self, n: int) -> List[List[str]]:
        self.res = []
        self.board = []
        for i in range(n):
            row = []
            for j in range(n):
                row.append(False)
            self.board.append(row)
      

        self.helper(0,n)
        return self.res