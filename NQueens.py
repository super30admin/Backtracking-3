from typing import List


class Solution:
    def solveNQueens_rowwise(self, n: int) -> List[List[str]]:
        def is_valid(board, row, col, n):
            # check col above
            for i in range(row):
                if board[i][col]:
                    return False
            # check upper-left diagonal
            i, j = row - 1, col - 1
            while i >= 0 and j >= 0:
                if board[i][j]:
                    return False
                i -= 1
                j -= 1
            # check upper-right diagonal
            i, j = row - 1, col + 1
            while i >= 0 and j < n:
                if board[i][j]:
                    return False
                i -= 1
                j += 1
            return True

        def helper(board, row, n):
            if row == n:
                temp = []
                for i in range(n):
                    temp.append("".join("Q" if board[i][j] else "." for j in range(n)))
                result.append(temp)
                return
            for j in range(n):
                if is_valid(board, row, j, n):
                    board[row][j] = True  # place queen
                    helper(board, row + 1, n)  # next row
                    board[row][j] = False  # backtrack

        result = []
        board = [[False] * n for _ in range(n)]
        helper(board, 0, n)
        return result

    def solveNQueens_columnwise(self, n: int) -> List[List[str]]:
        def is_valid(board, row, col, n):
            # check row on left
            for j in range(col):
                if board[row][j]:
                    return False
            # check upper-left diagonal
            i, j = row - 1, col - 1
            while i >= 0 and j >= 0:
                if board[i][j]:
                    return False
                i -= 1
                j -= 1
            # check lower-left diagonal
            i, j = row + 1, col - 1
            while i < n and j >= 0:
                if board[i][j]:
                    return False
                i += 1
                j -= 1
            return True

        def helper(board, col, n):
            if col == n:
                temp = []
                for i in range(n):
                    temp.append("".join("Q" if board[i][j] else "." for j in range(n)))
                result.append(temp)
                return
            for i in range(n):
                if is_valid(board, i, col, n):
                    board[i][col] = True  # place queen
                    helper(board, col + 1, n)  # next col
                    board[i][col] = False  # backtrack

        result = []
        board = [[False] * n for _ in range(n)]
        helper(board, 0, n)
        return result


if __name__ == "__main__":
    sol = Solution()
    n = 4

    for board in sol.solveNQueens_rowwise(n):
        print("".join(board))

    for board in sol.solveNQueens_columnwise(n):
        print("".join(board))
