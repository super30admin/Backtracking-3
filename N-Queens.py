# Time Complexity : O(N!), where N is the size of the chessboard.
# Space Complexity : O(N)

from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def is_safe(row, col):
            for i in range(row):
                if board[i] == col or \
                   board[i] == col - (row - i) or \
                   board[i] == col + (row - i):
                    return False
            return True

        def place_queen(row):
            if row == n:
                solution = []
                for i in range(n):
                    s = '.' * board[i] + 'Q' + '.' * (n - board[i] - 1)
                    solution.append(s)
                result.append(solution)
                return

            for col in range(n):
                if is_safe(row, col):
                    board[row] = col
                    place_queen(row + 1)

        result = []
        board = [-1] * n
        place_queen(0)
        return result