class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        board = [["." * n] for i in range(n)]
        diag = set()
        anti = set()
        cols = set()

        def bcktrk(row, board):
            # base
            if row == n:
                res.append(board.copy())
            # logic
            for col in range(n):
                if col in cols or (row - col) in diag or (row + col) in anti:
                    continue
                cols.add(col)
                diag.add(row - col)
                anti.add(row + col)
                board[row] = "." * (col) + "Q" + "." * (n - col - 1)
                bcktrk(row + 1, board)
                cols.remove(col)
                diag.remove(row - col)
                anti.remove(row + col)
                board[row] = "." * n

        bcktrk(0, board)
        return res
