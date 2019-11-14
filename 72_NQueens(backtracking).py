'''
Accepted on leetcode(51)
time - exponencial
This a fundamental backtracking problem. Here, as we go further in row and place queens we have to check for columns and diagnal as well, so if queen exists in those positions we have to backtrack and find out possible solutions to place queen safely in grid.
'''


class Solution:
    result = None

    def solveNQueens(self, n: int) -> List[List[str]]:
        Solution.result = []
        board = [[0 for i in range(n)] for j in range(n)]
        self.placeQueens(board, 0, n)
        return Solution.result

    # To place queens at particular position we use this method based on isSafe method output.
    def placeQueens(self, board, row, n):
        # Base case
        if row == n:  # if we reached last row then change the grid to list of strings.
            temp = []
            for i in range(n):
                s = ""
                for j in range(n):

                    if board[i][j] == 1:
                        s += "Q"
                    else:
                        s += "."
                temp.append(s[:])
            Solution.result.append(temp[:])
            return False

        # Logic
        for i in range(n):
            # place a queen at particular column inside row
            if self.isSafe(board, row, i):
                board[row][i] = 1
                # current row queen is placed safely go to next row else backtrack
                if self.placeQueens(board, row + 1, n):
                    return True
                # Backtrack
                board[row][i] = 0

        return False

    def isSafe(self, board, row, col):
        # this method is used to check vertically up and diagnals if the queen is safe to place or not.
        # for vertical up
        for i in range(row):
            if board[i][col] == 1: return False
        # check left up diagonal
        r = row - 1
        c = col - 1
        # check vertical up diagonal left
        while r >= 0 and c >= 0:
            if board[r][c] == 1:
                return False
            r -= 1
            c -= 1

        r = row - 1
        c = col + 1
        # check vertical up diagonal right
        while r >= 0 and c < len(board):
            if board[r][c] == 1:
                return False
            r -= 1
            c += 1
        return True