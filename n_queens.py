# Time Complexity: O(n!)
# Space Complexity: O(n^2) for the grid
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We find the total number different ways to place n queens on a nxn chessboard such that no queen 
can attack another queen by moving row by row. For each row we check if a particular cell can have 
the queen by deeming it isSafe. That is done by going through the columns before, and right and left 
diagonals before. If it is safe we place the queen and recurse to the next row. If we reach the end of 
the board we have found a valid solution and we add it to the answer. If we backtrack we remove the queen 
and try the next cell in the row.
"""

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        if n == None: return []
        self.answer = []
        self.grid = [[False for i in range(n)] for j in range(n)]
        self.backtrack(0, n)
        return self.answer

    def isSafe(self, row, col):
        # check for queens in the same col
        for i in range(row, -1, -1):
            if self.grid[i][col] == True:
                return False

        i= row ; j = col

        while i >= 0 and j >=0:
            if self.grid[i][j] == True:
                return False

            i-=1; j-=1

        i=row; j =col
        while i >= 0 and j < len(self.grid):
            if self.grid[i][j] == True:
                return False
            i-=1; j+=1

        return True

    def backtrack(self, row, n):
        #base
        if row == n:
            result = []
            for i in range(n):
                string=[]
                for j in range(n):
                    if self.grid[i][j] == True:
                        string.append('Q')
                    else:
                        string.append('.')
                result.append("".join(string))
            self.answer.append(result)
            return

        #logic
        for col in range(n):
            if self.isSafe(row, col):
                self.grid[row][col] = True
                #recurse
                self.backtrack(row+1, n)
                #backtrack
                self.grid[row][col] = False
