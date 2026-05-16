class Solution:
    def solveNQueens(self, n):
        result = []
        board = [[False for _ in range(n)] for _ in range(n)]
        self.helper(0, board, result)
        return result

    def helper(self, row, board, result):
        n = len(board)
        if row == n:
            temp = []
            for i in range(n):
                row_str = ""
                for j in range(n):
                    if board[i][j]:
                        row_str += "Q"
                    else:
                        row_str += "."
                temp.append(row_str)
            result.append(temp)
            return

        for j in range(n):
            if self.isSafe(row, j, board):
                board[row][j] = True
                self.helper(row + 1, board, result)
                board[row][j] = False

    def isSafe(self, r, c, board):
        for i in range(r, -1, -1):
            if board[i][c]:
                return False
        i, j = r, c
        while i >= 0 and j >= 0:
            if board[i][j]:
                return False
            i -= 1
            j -= 1

        i, j = r, c
        while i >= 0 and j < len(board):
            if board[i][j]:
                return False
            i -= 1
            j += 1

        return True
