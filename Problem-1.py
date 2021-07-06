"""
Approach:
1) At each row, place the queen starting from left to right at each position.
2) complete all rows and if a valid placement if found for all N queens

TC: O(n^n)
SC: O(N*2)
"""
class Solution(object):
    def __init__(self):
        self.result = []

    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        board = [[False] * n for _ in range(n)]
        self.placeQueens(board, 0, n)
        return self.result

    def placeQueens(self, board, row, n):
        # base
        if row == n:
            filled_board = []
            placement = ""
            for r in range(n):
                for c in range(n):
                    if board[r][c] == True:
                        placement += 'Q'
                    else:
                        placement += '.'
                filled_board.append(placement)
                placement = ""
            self.result.append(filled_board)
            return

        # logic
        for col in range(n): # similar to palindrome problem, check if the current position satisfies the condition
            if self.canPlace(board, row, col, n):
                #action
                board[row][col] = True
                self.placeQueens(board, row + 1, n)
                #backtrack
                board[row][col] = False

    def canPlace(self, board, row, col, n):
        # check col
        for r in range(row):
            if board[r][col]: return False

        # check diagonals
        # left up
        r, c = row - 1, col - 1
        while r >= 0 and c >= 0:
            if board[r][c]: return False
            r -= 1
            c -= 1

        # right up
        r, c = row - 1, col + 1
        while r >= 0 and c < n:
            if board[r][c]: return False
            r -= 1
            c += 1

        return True


