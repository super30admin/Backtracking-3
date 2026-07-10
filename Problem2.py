## Problem2
# Word Search(https://leetcode.com/problems/word-search/)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        # Get the dimensions of the board
        rows = len(board)
        cols = len(board[0])
        # Define the 4 possible directions of movement: Up, Left, Right, Down
        directions = [[-1, 0], [0, -1], [0, 1], [1, 0]]

        # Depth-First Search (DFS) helper function
        # r: current row, c: current column, i: current index in the word we are looking for
        def helper(r, c, i):
            nonlocal board, word, rows, cols, directions
            
            # Base Case 1: If we have matched all characters in the word, we found it!
            if i == len(word):
                return True
            
            # Base Case 2: Out of bounds OR cell already visited ('#')
            if r < 0 or c < 0 or r == rows or c == cols or board[r][c] == '#':
                return False
            
            # If the current cell matches the character we need
            if board[r][c] == word[i]:
                # Mark the current cell as visited to prevent reusing it in this path
                board[r][c] = '#'
                
                # Explore all 4 adjacent directions
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    # If any of the paths successfully find the rest of the word, return True
                    if helper(nr, nc, i + 1):
                        return True
                
                # Backtrack: Unmark the cell so it can be used in other search paths
                board[r][c] = word[i]
                
        # Iterate through every cell on the board to find a valid starting point
        for i in range(rows):
            for j in range(cols):
                # Only initiate the DFS if the first character matches
                if board[i][j] == word[0]:
                    if helper(i, j, 0):
                        return True
                        
        # If we check all possible starting points and find nothing, the word doesn't exist
        return False