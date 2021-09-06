"""
Time Complexity : O(N!) where N is thr number of Queens give 
Space Complexity : O(N^2) where N is thr number of Queens give 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.grid = [[0]*n for i in range(n) ]
        self.result = []
        if n == 0:
            return self.result
        self.backtrack(n, 0)
        return self.result
    def backtrack(self, n, row):
        # Base
        if row == n:
            sols = []
            for i in range(n):
                # New string to capture a possible n queen solution
                newStr = ""
                for j in range(n):
                    if(self.grid[i][j]):
                        newStr += "Q"
                    else:
                        newStr += "."
                sols.append(newStr)
            self.result.append(sols)
            return
        # Logic
        for i in range(n):
            if (self.isSafe(n, row, i)):
                # Action
                self.grid[row][i] = True
                # Recurse
                self.backtrack(n, row + 1)
                # Backtrack
                self.grid[row][i] = False
    def isSafe(self, n, row, col):
        # Check upper row
        for i in range(row):
            if(self.grid[i][col]):
                return False
        # Check for upper left diagonal
        i = row
        j = col
        while i >= 0 and j >= 0:
            if(self.grid[i][j]):
                return False
            i -= 1
            j -= 1
        # Check for upper right diagonal
        i = row
        j = col
        while i >= 0 and j < n:
            if(self.grid[i][j]):
                return False
            i -= 1
            j += 1
        return True