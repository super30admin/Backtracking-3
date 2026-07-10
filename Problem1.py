## Problem1 
# N Queens(https://leetcode.com/problems/n-queens/)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        # Time Complexity: O(N!)
        # Space Complexity: O(N^2)
        
        result = []
        # Initialize an NxN board to track queen placements. False = empty, True = Queen.
        board = [[False for _ in range(n)] for _ in range(n)]

        def isSafe(r, c):
            nonlocal n, board
            
            # Check the same column above the current row 'r'. 
            # We don't need to check below because we haven't placed queens there yet.
            for i in range(r):
                if board[i][c]:
                    return False

            # Check the upper-right diagonal for attacking queens
            i = r
            j = c
            while i >= 0 and j < n:
                if board[i][j]:
                    return False
                i -= 1
                j += 1

            # Check the upper-left diagonal for attacking queens
            i = r
            j = c
            while i >= 0 and j >= 0:
                if board[i][j]:
                    return False
                i -= 1
                j -= 1

            # If no conflicts are found in the column or diagonals, it is safe
            return True

        def helper(r):
            nonlocal result, board, n

            # Base Case: If we have successfully reached row 'n', 
            # we've placed N queens on the board.
            if r == n:
                possibility = []
                # Construct the valid board state into the string format LeetCode expects
                for i in range(n):
                    s = ''
                    for j in range(n):
                        if board[i][j]:
                            s += 'Q'
                        else:
                            s += '.'
                    possibility.append(s)
                
                result.append(possibility)
                return

            # Logic: Try placing a queen in each column 'c' for the current row 'r'
            for c in range(n):
                # Only proceed if placing a queen here doesn't cause a conflict
                if isSafe(r, c):
                    # Place the queen
                    board[r][c] = True
                    # Recurse to try placing a queen in the next row
                    helper(r + 1)
                    # Backtrack: Remove the queen so we can explore other valid branches
                    board[r][c] = False

        # Start the backtracking process at the very first row
        helper(0)
        return result