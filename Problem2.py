class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        '''
        Time complexity - O(N * 3^L), N --> total number of cells in the board and L --> length of the word. As for each cell, we explore at most 3 directions (excluding the previous direction) and recurse for the length of the word.
        Soace complexity - O(L) due to the recursion stack used for backtracking
        '''
        if board is None:  # If the board is None, return False
            return False
        # Define the directions to move: right, down, up, left
        directions = [(0, 1), (1, 0), (-1, 0), (0, -1)]

        # Get the number of rows and columns in the board
        rows, cols = len(board), len(board[0])

        def backtrack(board, word, rows, cols, idx, i, j):
            if idx == len(word):  # If all characters of the word have been matched, return True
                return True
            if i < 0 or j < 0 or i == rows or j == cols or board[i][j] == '#':
                # If the current cell is out of bounds or has been visited before, return False
                return False
            # If the current cell matches the current character of the word
            if board[i][j] == word[idx]:
                board[i][j] = '#'  # Mark the cell as visited
                for direction in directions:  # Explore all directions
                    nr = direction[0] + i  # Calculate the new row
                    nc = direction[1] + j  # Calculate the new column
                    # Recur for the next character
                    if backtrack(board, word, rows, cols, idx + 1, nr, nc):
                        return True
                # Backtrack by restoring the cell's original value
                board[i][j] = word[idx]
            return False
        for i in range(rows):
            for j in range(cols):
                # Start the backtracking from each cell
                if backtrack(board, word, rows, cols, 0, i, j):
                    return True

        return False  # Return False if no valid path is found
