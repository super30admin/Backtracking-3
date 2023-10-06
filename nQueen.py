class Solution:
    def solveNQueens(self, n: int):
        self.res = []
        self.grid = [[False for i in range(n)] for j in range(n)]

        def backtrack(row):
            if row == n:
                ans = []
                for i in range(n):
                    str = ""
                    for j in range(n):
                        if self.grid[i][j] == True:
                            str += "Q"
                        else:
                            str += "."
                    ans.append(str)
                self.res.append(list(ans))
                return
                    

            for i in range(n):
                if isSafe(row, i):
                    self.grid[row][i] = True
                    backtrack(row+1)
                    self.grid[row][i] = False
        
        def isSafe(row,col):
            i = row
            while i >= 0:
                if self.grid[i][col] == True:
                    return False
                i -= 1

            i, j = row, col
            while i >= 0 and j >= 0:
                if self.grid[i][j] == True:
                    return False
                i -= 1
                j -= 1

            i, j = row, col
            while i >= 0 and j < n:
                if self.grid[i][j] == True:
                    return False
                j += 1
                i -= 1
            return True

        backtrack(0)
        return self.res

#TC: O(n!)
#SC: O(n^2)