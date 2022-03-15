# // Time Complexity : O(N!)
# // Space Complexity : O(N^2)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def solveNQueens(self, n: int):
        col = set()
        posDiag = set()
        negDiag = set()
        
        res = []
        board = [["."]*n for i in range(n)]
        
        def backtrack(r):
            
            # base case
            if r == n:
                copy = ["".join(row) for row in board]
                res.append(copy) # add the row to the result
                return 
            
            for c in range(n):
                
                # check the set for placing the Q
                if c in col or (r+c) in posDiag or (r-c) in negDiag:
                    continue
                    
                # add the value to the set, where not to place the Q in next row
                col.add(c)
                posDiag.add(r+c)
                negDiag.add(r-c)
                board[r][c] = "Q"
                
                backtrack(r+1)
                
                # remove the additions for the next function call 
                col.remove(c)
                posDiag.remove(r+c)
                negDiag.remove(r-c)
                board[r][c] = "."
                
        backtrack(0)
        return res