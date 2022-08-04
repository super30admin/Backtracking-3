# Time Complexity = O(3^L * (m * n)), where 3 is the number of directions we are allowed to go, L is the length of the word, m * n is for traversing the board matrix

# Space Complexity = O(L)


class Solution:
    def exist(self, board: list[list[str]], word: str) -> bool:
        if board == None:
            return False
        
        m = len(board)
        n = len(board[0])
        
        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]       # Up down right left
            
                
        
        
        def backtrack(board, word, r, c, index):
            # Base Case
            if index == len(word):
                return True
            if r < 0 or c < 0 or r == m or c == n or board[r][c] == '#':
                return False
            
            
            # Logic
            # if the char in word is present in board, check its directions to start traversal
            if word[index] == board[r][c]:
                # Action
                # Changing the cell char to # if we have traversed it. Meanwhile storing the original char in ch, to backtrack/retrieve the val later on
                ch = board[r][c]
                board[r][c] = '#'
                
                for d in dirs:
                    nr = r + d[0]
                    nc = c + d[1]
                    
                    # Recursion
                    # If char at index is present, we move to char at index + 1
                    if backtrack(board, word, nr, nc, index + 1):
                        return True
                
                # Backtrack
                board[r][c] = ch
                
            
            return False
                
      
        
        
        for i in range(m):
            for j in range(n):
                # Calling the Backtracking function
                # i, j are for board matrix and index is for iterating over word
                if backtrack(board, word, i, j, 0):
                    return True                     # If the function returns a true => you were able to find the word
        
        
        
        return False