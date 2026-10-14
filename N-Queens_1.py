# Time Complexity : O(N!)
# Space Complexity : O(N2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using 3 sets for col, diag1, diag2 to store col, row-col and row+col in them
# Using for loop based recursion we check if the col,row-col,row+col is in those sets if not append col to path and add to sets
# Recurse with row+1
# Backtrack path.pop and remove from 3 sets
# Base condition if row == n create a board 
# For getting the output we used for loop to check col in path and then create [.* col + Q + .* n-col-1]
# Then append board to result

class Solution:
    def solveNQueens(self, n: int) -> list[list[str]]:
        self.result = []
        self.c = set()
        self.diag1 = set()
        self.diag2 = set()
        self.helper(n, 0, [])
        return self.result
    
    def helper(self, n, row, path):
        #base
        if row == n:
            board = []
            for col in path:
                board.append("." * col + "Q" + "." * (n-col-1))
            self.result.append(board)
            return
        for col in range(n):
            #action
            if col not in self.c and row-col not in self.diag1 and row+col not in self.diag2:
                path.append(col)
                self.c.add(col)
                self.diag1.add(row-col)
                self.diag2.add(row+col)
                #recurse
                self.helper(n, row+1, path)
                #backtrack
                path.pop()
                self.c.remove(col)
                self.diag1.remove(row-col)
                self.diag2.remove(row+col)



