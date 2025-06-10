"""
## Problem1 
N Queens(https://leetcode.com/problems/n-queens/)
"""


class Solution:
    """
    TC : O(N!)
    SC: O(N^2)
    """
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        cols = set()       # same col
        posDiag = set()   # row + col
        negDiag = set()   # col - row
        board = [-1] * n

        def dfs_helper(row):
            # base case
            if row == n:
                sol = []
                for i in range(n):
                    line = ["."] * n
                    line[board[i]] = "Q"
                    sol.append("".join(line))
                result.append(sol)
                return


            # logic
            for col in range(n):
                if col in cols or row+col in posDiag or col-row in negDiag:
                    continue

                # Action : place queen
    
                board[row] = col
                cols.add(col)
                posDiag.add(row + col)
                negDiag.add(col-row)

                # Recurse

                dfs_helper(row + 1)

                # Backtrack
                cols.remove(col)
                posDiag.remove(row + col)
                negDiag.remove(col-row)

        dfs_helper(0)

        return result


        