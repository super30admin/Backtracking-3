# 51. N-Queens

# TC : O(N!), where N is the board size
    # This is because for the first row, we have N options, for the second row we have at most N-1 options, and so on
    # In practice, it's better than N! because our pruning of invalid positions significantly reduces the search space
    # The actual complexity is closer to O(N^N), but it's commonly approximated as O(N!)
# SC : O(N), not counting the output
    # We use O(N) space for the recursion stack (maximum depth N)
    # We use O(N) space for the three sets tracking columns and diagonals
    # The board representation requires O(N²) space, but this is dominated by the output size

# Did this code successfully run on Leetcode : Yes

# Approach :
# Row-by-Row Placement: We place one queen per row, trying each column position.
# Efficient Attack Checking: Instead of checking the entire board for attacks after each placement, we use sets to track occupied columns and diagonals:
    # For columns: Simply track column indices
    # For positive diagonals: Elements where row + column is constant
    # For negative diagonals: Elements where row - column is constant
# Pruning: We skip positions that would result in queen attacks, dramatically reducing the search space.
# Result Format: We convert each valid board configuration to the required string format.

from ast import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        # Initialize result list to store all valid board configurations
        result = []
        
        # Create an empty board filled with '.' characters
        board = [['.' for _ in range(n)] for _ in range(n)]
        
        # Sets to keep track of occupied columns, positive diagonals, and negative diagonals
        cols = set()
        pos_diags = set()  # r + c remains constant for a positive diagonal
        neg_diags = set()  # r - c remains constant for a negative diagonal
        
        def backtrack(row):
            # Base case: if we've placed queens in all rows, we have a valid solution
            if row == n:
                # Convert the board configuration to the required string format
                solution = [''.join(row) for row in board]
                result.append(solution)
                return
            
            # Try placing a queen in each column of the current row
            for col in range(n):
                # Check if the position is under attack
                if col in cols or (row + col) in pos_diags or (row - col) in neg_diags:
                    continue
                
                # Place a queen at this position
                board[row][col] = 'Q'
                cols.add(col)
                pos_diags.add(row + col)
                neg_diags.add(row - col)
                
                # Recursively try to place queens in the next row
                backtrack(row + 1)
                
                # Backtrack: remove the queen from this position
                board[row][col] = '.'
                cols.remove(col)
                pos_diags.remove(row + col)
                neg_diags.remove(row - col)
        
        # Start the backtracking process from the first row
        backtrack(0)
        return result