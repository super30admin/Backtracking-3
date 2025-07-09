# Time Complexity : O(N!), where N is the size of the board — due to permutations of queen placements
# Space Complexity : O(N^2), for the board and the recursion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used backtracking to try placing a queen in each row.
# I made sure that no two queens attacked each other by tracking the columns, diagonals, and anti-diagonals.
# When I reached row == n, I added the current board configuration to the result.
# I backtracked after each recursive call by removing the queen and unmarking threats.

from typing import List

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        board = [['.' for _ in range(n)] for _ in range(n)]
        cols = set()
        diagonals = set()        # (row - col)
        anti_diagonals = set()   # (row + col)

        def backtrack(row: int):
            if row == n:
                # I converted the board to the required string format
                result.append(["".join(r) for r in board])
                return

            for col in range(n):
                if col in cols or (row - col) in diagonals or (row + col) in anti_diagonals:
                    continue

                board[row][col] = 'Q'
                cols.add(col)
                diagonals.add(row - col)
                anti_diagonals.add(row + col)

                backtrack(row + 1)

                # Backtrack
                board[row][col] = '.'
                cols.remove(col)
                diagonals.remove(row - col)
                anti_diagonals.remove(row + col)

        backtrack(0)
        return result
