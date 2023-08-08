# Time Complexity: O(N!)
#Space Complexity: O(N^2)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        board = [['.' for _ in range(n)] for _ in range(n)]  # Initialize an empty n x n board
        self.helper(n, 0, board)
        return self.result

    def helper(self, n, row, board):
        if row == n:
            self.result.append([''.join(row) for row in board])  # Convert board to List[str] and add to results
            #return

        for col in range(n):
            if self.CheckCollision(board, row, col):
                # action
                board[row][col] = 'Q'
                # recurse
                self.helper(n, row + 1, board)
                # backtrack
                board[row][col] = '.'

    def CheckCollision(self, board, row, col):
        n = len(board)
        # Check column attack
        for i in range(row):
            if board[i][col] == 'Q':
                return False

        # Check top-left diagonal  
        i, j = row - 1, col - 1
        while i >= 0 and j >= 0:
            if board[i][j] == 'Q':
                return False
            i -= 1
            j -= 1

        # Check top-right diagonal
        i, j = row - 1, col + 1
        while i >= 0 and j < n:
            if board[i][j] == 'Q':
                return False
            i -= 1
            j += 1

        return True

