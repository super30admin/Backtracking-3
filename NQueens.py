# TC - O(N!)
# SC - O(N * N)
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """

        def placeQueens(visited_cols, row, left_d, right_d, board):
            if row == n:
                new_board = []
                for r in board:
                    new_board.append("".join(r))
                result.append(new_board)

            for col in range(n):
                left = row + col
                right = row - col

                if col not in visited_cols and left not in left_d and right not in right_d:
                    visited_cols.add(col)
                    left_d.add(left)
                    right_d.add(right)
                    board[row][col] = "Q"

                    placeQueens(visited_cols, row+1, left_d, right_d, board)

                    board[row][col] = "."
                    visited_cols.remove(col)
                    left_d.remove(left)
                    right_d.remove(right)

        board = [["."] * n for _ in range(n)]
        result = []
        visited_cols = set()
        left_diagonal = set()
        right_diagonal = set()
        placeQueens(visited_cols, 0, left_diagonal, right_diagonal, board)
        return result
