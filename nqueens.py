# Time Complexity : O(N!) where N is the size of the board
# Space Complexity : O(N^2) where N is the size of the board
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am makeing a boolean grid to keep track of the queens placed on the board.
# I am using backtracking to place the queens on the board row by row.
# For each row, I am iterating through each column and checking if it is safe to place a queen there.
# If it is safe, I place the queen and call the backtrack function recursively for the next row.
# If I reach the end of the board, I add the current configuration to the result list.
# If it is not safe, I backtrack and try the next column.
# Finally, I return the result list.


from typing import List
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        grid = [[False]*n for _ in range(n)]
        result = []
        def backtrack(grid,r):
            if r == n:
                li = []
                for i in range(n):
                    sb = []
                    for j in range(n):
                        if grid[i][j]:
                            sb.append("Q")
                        else:
                            sb.append(".")
                    li.append("".join(sb))
                result.append(li)
                return 
                    
            for c in range(n):
                if isSafe(grid,r,c):
                    grid[r][c] = True
                    backtrack(grid,r+1)
                    grid[r][c] = False
        def isSafe(grid,r,c):
            i = r
            j = c
            while i >=0:
                if grid[i][j]:
                    return False
                i -= 1
            i = r
            j = c
            while i >= 0 and j >= 0:
                if grid[i][j]:
                    return False
                i -= 1
                j -= 1
            i = r
            j = c
            while i >= 0 and j < n :
                if grid[i][j] :
                    return False
                i -= 1
                j += 1
            return True
        backtrack(grid,0)
        return result

        