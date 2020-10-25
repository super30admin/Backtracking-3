"""
Problem: 51. N-Queens
Leetcode: https://leetcode.com/problems/n-queens/
Solution: Backtracking
Time complexity : O(N!), There are N possibilities to put the first queen,
    - not more than N (N - 2) to put the second one, not more than N(N - 2)(N - 4) for the third one etc.
    - In total that results in O(N!) time complexity.
Space complexity : O(N) to keep an information about diagonals and rows.
Does this code run on Leetcode: Yes
"""


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        # Initialize the board with '.'
        board = [["." for i in range(n)] for j in range(n)]
        output = []

        self.backtracking(output, board, n, 0)
        return output

    def backtracking(self, output, board, n, r):
        # base condition
        if n <= 0:
            output.append(self.constructOutput(board))
            return

        # iterate through rows recursively
        for c in range(0, len(board)):
            if (self.isValidPosition(board, r, c)):
                board[r][c] = "Q"
                self.backtracking(output, board, n - 1, r + 1)
                board[r][c] = "."

    def isValidPosition(self, board, i, j):
        r = i
        c = j
        # upper column
        while (r >= 0):
            if board[r][c] == "Q":
                return False
            r -= 1

            # right diagonal
        r = i
        c = j
        while (r >= 0 and c < len(board)):
            if board[r][c] == "Q":
                return False
            r -= 1
            c += 1

        # left diagonal
        r = i
        c = j
        while (r >= 0 and c >= 0):
            if board[r][c] == "Q":
                return False
            r -= 1
            c -= 1

        return True

    def constructOutput(self, board):
        retList = []
        for i in range(0, len(board)):
            temp = ""
            for j in range(0, len(board)):
                temp += board[i][j]
            retList.append(temp)
        return retList


