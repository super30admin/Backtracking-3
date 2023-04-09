# Time Complexity : O(N!)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        grid = []
        for i in range(n):
            temp = []
            for j in range(n):
                temp.append(False)
            grid.append(temp)

        # grid = [[False for i in range(n)] for j in range(n)]
        def backtrack(grid, row,n):
            
            #base
            if row == n:
                li = []
                for x in range(n):
                    temp = ""
                    for y in range(n):
                        if grid[x][y] == True:
                            temp += "Q"
                        else:
                            temp += "."
                    li.append(temp)
                result.append(li)
                return

            #logic
            for j in range(n):
                if isSafe(grid,row,j) == True:
                    #action
                    grid[row][j] = True
                    #recurse
                    backtrack(grid,row+1,n)
                    #backtrack
                    grid[row][j] = False

        def isSafe(grid,row,j):
            for i in range(row):
                if grid[i][j] == True:
                    return False

            i = row
            c = j
            while i >=0 and c >= 0:
                if grid[i][c] == True:
                    return False
                i -= 1
                c -= 1

            i = row
            c = j
            while i >= 0 and c < n:
                if grid[i][c] == True:
                    return False
                i -= 1
                c += 1

            

            return True
        
        backtrack(grid, 0,n)
        return result
