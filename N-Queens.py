#// Time Complexity : 3^n
# // Space Complexity : stack space  
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        grid = [[False for i in range(n)]for j in range(n)] 
        result = []
        # print(grid)
        def issafe(grid,row,col):
            for i in range(row):
                if grid[i][col] == True:
                    return False
            #going up diagonally towards the right
            i = row 
            j = col
            while i >= 0 and j <n:
                if grid[i][j] == True:
                    return False
                i -= 1
                j += 1
            #going up diagonally towards the left 
            i = row 
            j = col
            while i >= 0 and j >= 0:
                if grid[i][j] == True:
                    return False
                i -= 1
                j -= 1
            return True

        def backtrack(grid,row):
            nonlocal result
            if row == len(grid):
                # print("in resulr")
                # print(grid)
                li = []
                for i in range(len(grid)):
                    s = ""
                    for j in range(len(grid)):
                        if grid[i][j] == True:
                            s += "Q"
                        else:
                            s += "."
                    li.append(s)
                print(result,"hello")
                result.append(li)
                return result
            
            for c in range(len(grid[0])):
                if issafe(grid,row,c):
                    # print("ello")
                    #action
                    grid[row][c] = True
                    #recurse
                    backtrack(grid,row+1) 
                    #backtrack 
                    grid[row][c] = False
        
        backtrack(grid,0)
        # print(result)
        return result
            
# Approach:
# We will use backtracking to solve this problem. We will start from the first row and first column
# and check if it is safe to place a queen there. If it is safe, we will place
# a queen there and then move to the next row and next column. If it is not safe,
# we will backtrack and try to place a queen in the previous row and previous column. We will
# continue this process until we have placed a queen in all the rows. Once we have placed a queen
# in all the rows, we will print the board and then backtrack to the previous row and previous column
        
        


           
        