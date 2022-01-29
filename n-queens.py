# Time Complexity : O(n!)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : yes

from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:

        cols = set()     # n positions
        posdiagonals = set()  # 2n-1 positions
        negdiagonals = set()  # 2n-1 positions

        # construct n x n board
        board = [['.'] * n for _ in range(n)]

        result = []

        def backtrack(row=0):

            # base case
            if row == n:
                str = [''.join(row) for row in board]
                result.append(str)
                return

            # for the row, try each col
            for col in range(n):

                # skip backtracking on anything that would conflict
                if col in cols or (row + col) in posdiagonals or (row - col) in negdiagonals:
                    continue

                cols.add(col)
                posdiagonals.add(row+col)
                negdiagonals.add(row-col)
                board[row][col] = 'Q'

                backtrack(row + 1)

                # reset
                cols.remove(col)
                posdiagonals.remove(row+col)
                negdiagonals.remove(row-col)
                board[row][col] = '.'

        backtrack()
        return result
