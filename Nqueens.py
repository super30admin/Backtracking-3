#Time Complexity : O(N!)
#Space Complexity : O(N^2)


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        board = [[False] * n for i in range(n)]
        self.helper(board, 0)
        return self.result

    def helper(self, board, row):
        # base
        if row == len(board):
            rBoard = []
            for r in range(len(board)):
                row = []
                for c in range(len(board)):
                    if board[r][c] == True:
                        row.append("Q")
                    else:
                        row.append(".")
                rBoard.append("".join(row))
            # print(rBoard)
            self.result.append(rBoard)
            return

            # logic
        for i in range(len(board[0])):
            if (self.isSafe(board, row, i)):
                # action
                board[row][i] = True

                self.helper(board, row + 1)

                board[row][i] = False
        return

    def isSafe(self, board, row, col):
        cr = row
        cC = col
        # upper Col
        for i in range(row):
            if board[i][col]:
                return False
        # left diagonal
        while cr >= 0 and cC >= 0:
            if board[cr][cC]:
                return False
            cr -= 1
            cC -= 1
        cr = row
        cC = col
        # rightDiagonal
        while cr >= 0 and cC != len(board):
            if board[cr][cC]:
                return False
            cr -= 1
            cC += 1
        return True