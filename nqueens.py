'''
Time Complexity: O(N!)
Space Complexity: O(N**2)
'''
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        op = []
        g = [[False for j in range(n)] for i in range(n)]
        def isSafe(row, col, grid):
            # Check Cols
            for i in range(row-1, -1, -1):
                if(grid[i][col]==True):
                    return False
            # Left Diagonals
            tempr = row-1
            tempc = col-1
            while(tempr>=0 and tempc>=0):
                if(grid[tempr][tempc]==True):
                    return False
                tempr -= 1
                tempc -= 1
            # Right Diagonals
            tempr = row-1
            tempc = col+1
            while(tempr>=0 and tempc<n):
                if(grid[tempr][tempc]==True):
                    return False
                tempr -= 1
                tempc += 1
            return True
            
            
        def backtrack(row, grid):
            if(row==n):
                strarr = []
                for i in range(n):
                    temp = ""
                    for j in range(n):
                        if(grid[i][j]==True):
                            temp = temp+"Q"
                        else:
                            temp = temp+"."
                    strarr.append(temp)
                op.append(strarr)
                return
            for col in range(n):
                if(isSafe(row, col, grid)):
                    grid[row][col] = True
                    backtrack(row+1, grid)
                    grid[row][col] = False
                    
            return
        backtrack(0, g)
        return op
        