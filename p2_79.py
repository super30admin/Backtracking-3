# 79. Word Search

# TC : O(N × M × 4^L), where:
    # N is the number of rows in the board
    # M is the number of columns in the board
    # L is the length of the word
    # 4^L represents the maximum number of paths to explore from each starting cell
# SC :O(L), where:
    # L is the length of the word
    # This accounts for both the recursion stack depth and the visited set size
    # In the worst case, the visited set will contain L positions

# Did this code successfully run on Leetcode : Yes

# Approach :
# Early Validation: We only start the DFS from cells that match the first character of the word, avoiding unnecessary searches.
# Set for Visited Tracking: Using a set to track visited cells is faster than a matrix for checking membership.
# Path Pruning: The DFS immediately returns when encountering an invalid path (out of bounds, character mismatch, or already visited cell).
# Backtracking: We remove cells from the visited set when backtracking, allowing them to be used in different paths.
# Short-Circuit Evaluation: Using the logical OR operator for direction checks allows early return as soon as a valid path is found.


from ast import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        # Get dimensions of the board
        rows, cols = len(board), len(board[0])
        
        # Create a visited matrix to track used cells
        # Using a set instead of a matrix for more efficient checking
        
        # Define the backtracking function
        def dfs(r, c, index, visited):
            # Base case: if we've matched all characters in the word
            if index == len(word):
                return True
            
            # Check if current position is out of bounds, not matching, or already visited
            if (r < 0 or r >= rows or c < 0 or c >= cols or 
                board[r][c] != word[index] or (r, c) in visited):
                return False
            
            # Mark current cell as visited
            visited.add((r, c))
            
            # Try all four adjacent cells (up, right, down, left)
            # If any direction leads to a solution, return True
            if (dfs(r-1, c, index+1, visited) or  # Up
                dfs(r, c+1, index+1, visited) or  # Right
                dfs(r+1, c, index+1, visited) or  # Down
                dfs(r, c-1, index+1, visited)):   # Left
                return True
            
            # Backtrack: remove current cell from visited set
            visited.remove((r, c))
            return False
        
        # Try starting the search from each cell in the board
        for r in range(rows):
            for c in range(cols):
                if board[r][c] == word[0]:  # Only start search from cells matching first letter
                    if dfs(r, c, 0, set()):
                        return True
        
        # If no path found after trying all starting positions
        return False
        