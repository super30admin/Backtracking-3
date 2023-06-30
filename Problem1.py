class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        '''
        Time complexity - O(N!), N --> size of the chessboard (nxn)
        Space complaexity - O(N^2) --> Size of board
        '''
        board = [
            ['.'] * n for _ in range(n)]  # Initialize the result matrix with all dots
        result = []  # Initialize the result list to store the valid configurations

        def backtrack(board, row, n):
            if row == len(board):  # If all rows have been processed, a valid configuration is found
                configuration = []  # Initialize a list to store the configuration
                for r in range(len(board)):
                    # Convert each row to a string and add to configuration list
                    configuration.append(''.join(board[r]))
                # Add the configuration to the result list
                result.append(configuration)
                return

            for col in range(n):
                if isSafe(board, row, col):  # Check if placing a queen at current position is safe
                    board[row][col] = 'Q'  # Place a queen at current position
                    backtrack(board, row + 1, n)  # Recur for the next row
                    board[row][col] = '.'  # Backtrack by removing the queen

        def isSafe(board, r, c):
            # Check if a queen can be placed at position (r, c) without breaking the 3 rules

            # Check if there is a queen in the same column
            for i in range(r):
                if board[i][c] == 'Q':
                    return False

            # Check if there is a queen in the left diagonal
            i, j = r, c
            while i >= 0 and j >= 0:
                if board[i][j] == 'Q':
                    return False
                i -= 1
                j -= 1

            # Check if there is a queen in the right diagonal
            i, j = r, c
            while i >= 0 and j < n:
                if board[i][j] == 'Q':
                    return False
                i -= 1
                j += 1

            return True

        backtrack(board, 0, n)  # Start backtracking from the first row
        return result  # Return the list of valid configurations
