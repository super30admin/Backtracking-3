# Problem1: N Queens(https://leetcode.com/problems/n-queens/)
# Time Complexity: O(n! * n),At row 0 there are up to n column choices, row 1 has fewer valid choices because of pruning from isvalid, and so on down the rows.
# Each isvalid check itself costs O(n) in the worst case (scanning up a column and two diagonals). So total work is roughly O(n! * n).
# Space Complexity: O(n^2), O(n^2) for the board itself, plus O(n) for the recursion call stack depth (one call per row), which is smaller than the board so it doesn't change the overall bound.
# Approach:
# Try placing a queen in each row, one row at a time (backtracking).
# For each row, try every column. If the column is safe (isvalid), place the queen, recurse into the next row, then undo the placement to try the next column. 
#When all n rows are filled, convert the board into the string format and save it as one solution.

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        # board[i][j] is True if a queen sits there, False if empty
        board = [[False] * n for _ in range(n)]
        self.helper(board, 0, n)
        return self.result

    def helper(self, board, row, n):
        # base case: every row has a queen, so this is one complete solution
        if row == n:
            row_strings = []
            for i in range(n):
                stringbuilder = []
                for j in range(n):
                    # convert each cell into "Q" or "." for the output format
                    if board[i][j]:
                        stringbuilder.append("Q")
                    else:
                        stringbuilder.append(".")
                # join the row's characters into a single string
                row_strings.append("".join(stringbuilder))
            # save this completed board as one valid solution
            self.result.append(row_strings)
            return

        # try placing a queen in every column of the current row
        for j in range(n):
            if self.isvalid(board, row, j, n):
                board[row][j] = True          # place the queen
                self.helper(board, row + 1, n)  # recurse to fill the next row
                board[row][j] = False         # backtrack, try next column

    def isvalid(self, board, i, j, n):
        # check straight up the same column
        r = i
        c = j
        while r >= 0:
            if board[r][c]:
                return False
            r -= 1

        # check the upper left diagonal
        r = i
        c = j
        while r >= 0 and c >= 0:
            if board[r][c]:
                return False
            r -= 1
            c -= 1

        # check the upper right diagonal
        r = i
        c = j
        while r >= 0 and c < n:
            if board[r][c]:
                return False
            r -= 1
            c += 1

        # no queen found in column or either diagonal, so this spot is safe
        return True