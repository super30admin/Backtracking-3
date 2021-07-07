from typing import List


class Solution:

    def __init__(self):
        self.result = []
        self.N = None

    def solveNQueens(self, n: int) -> List[List[str]]:
        """
            https://leetcode.com/problems/n-queens/
            Time Complexity: O(n!)
                'n' is the size of the board
            Space Complexity: O(n) -> Recursive Stack Space
        """
        # edge case
        if not n:
            return self.result
        # no. of rows and cols
        self.N = n
        board = [[0 for _ in range(n)] for _ in range(n)]
        self._place_queen(board, 0)
        return self.result

    def _place_queen(self, board: List[List[int]], row: int) -> None:

        # base case
        # we reach out of bounds, done with all the rows
        if row == self.N:
            cur_result = []
            for r in range(self.N):
                cur_row = ''
                for c in range(self.N):
                    if board[r][c] == 1:
                        cur_row += 'Q'
                    else:
                        cur_row += '.'
                cur_result.append(cur_row)
            self.result.append(cur_result)
            return

        # logic
        # for each row in the board
        for col in range(self.N):
            # place queen at each position
            if self._is_safe(board, row, col):
                board[row][col] = 1
                # recursively placing at subsequent rows
                self._place_queen(board, row + 1)
                # backtrack
                board[row][col] = 0

    def _is_safe(self, board: List[List[int]], row: int, col: int) -> bool:

        # check current col, row changes
        for r in range(row):
            # if current position already has  a Queen
            if board[r][col] == 1:
                return False

        # check upper left diagonal
        r = row - 1
        c = col - 1
        while r >= 0 and c >= 0:
            if board[r][c] == 1:
                return False
            r -= 1
            c -= 1

        # check upper right diagonal
        r = row - 1
        c = col + 1
        while r >= 0 and c <= (self.N - 1):
            if board[r][c] == 1:
                return False
            r -= 1
            c += 1
        return True


if __name__ == '__main__':
    print(Solution().solveNQueens(4))
    print(Solution().solveNQueens(2))
    print(Solution().solveNQueens(3))
