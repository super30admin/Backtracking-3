# Time Complexity : O(n!), where n is the number of queens
#   - At each row, we try placing a queen in n positions, pruning invalid ones
#   - Worst-case explores all valid permutations, similar to factorial time
#
# Space Complexity : O(n^2 + n), dominated by n²
#   - O(n^2) for the board
#   - O(n) for the sets: column, positive diagonal, negative diagonal
#   - Recursion depth is O(n)
#
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        board = [["."] * n for _ in range(n)]

        col_up = set()
        left_up_diagonal = set()      # r - c
        right_up_diagonal = set()     # r + c

        def isSafe(r: int, c: int) -> bool:
            return (
                c not in col_up and
                (r - c) not in left_up_diagonal and
                (r + c) not in right_up_diagonal
            )

        def backtrack(r: int):
            if r == n:
                res.append(["".join(row) for row in board])
                return

            for c in range(n):
                if isSafe(r, c):
                    # action: place queen
                    col_up.add(c)
                    left_up_diagonal.add(r - c)
                    right_up_diagonal.add(r + c)
                    board[r][c] = "Q"

                    # recurse: move to next row
                    backtrack(r + 1)

                    # backtrack: remove queen and free sets
                    col_up.remove(c)
                    left_up_diagonal.remove(r - c)
                    right_up_diagonal.remove(r + c)
                    board[r][c] = "."

        backtrack(0)
        return res


# --------------------------------------------
# Classic Approach (with board scans)
# Time Complexity : O(n!) - still factorial, but more overhead due to checking entire columns and diagonals
# Space Complexity : O(n^2) for board + O(n) recursion stack
#
# class Solution:
#     def solveNQueens(self, n: int) -> List[List[str]]:
#         res = []
#         board = [["."] * n for _ in range(n)]

#         def backtrack(r):
#             # base case
#             if r == n:
#                 copy = []
#                 for row in board:
#                     joined_row = "".join(row)
#                     copy.append(joined_row)
#                 res.append(copy)
#                 return

#             # logic
#             for c in range(n):
#                 if self.isSafe(r, c, board):
#                     # action: place queen
#                     board[r][c] = "Q"
#                     # recurse: move to next row
#                     backtrack(r + 1)
#                     # backtrack: remove queen
#                     board[r][c] = "."

#         backtrack(0)
#         return res

#     def isSafe(self, r, c, board):
#         # up column check
#         row = r - 1
#         while row >= 0:
#             if board[row][c] == "Q":
#                 return False
#             row -= 1

#         # up left diagonal check
#         row = r - 1
#         col = c - 1
#         while row >= 0 and col >= 0:
#             if board[row][col] == "Q":
#                 return False
#             row -= 1
#             col -= 1

#         # up right diagonal check
#         row = r - 1
#         col = c + 1
#         while row >= 0 and col < len(board):
#             if board[row][col] == "Q":
#                 return False
#             row -= 1
#             col += 1

#         return True


# --------------------------------------------
# Main Testing Block
if __name__ == "__main__":
    sol = Solution()

    print("n = 0:")
    print(sol.solveNQueens(0))  # Expected: []

    print("\nn = 1:")
    print(sol.solveNQueens(1))  # Expected: [["Q"]]

    print("\nn = 4:")
    print(sol.solveNQueens(4))  # Expected: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]

    print("\nn = 5:")
    print(sol.solveNQueens(5))  # Output will be longer, shows multiple valid solutions
