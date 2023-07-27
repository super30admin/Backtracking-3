from ast import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.rows = len(board)
        self.cols = len(board[0])

        def backtrack(r, c, curr):
            # base condition
            if not (0 <= r < self.rows and 0 <= c < self.cols):
                return False
            
            if board[r][c] != word[curr]:
                return False
            
            if curr == len(word) - 1:
                return True
                
            temp = board[r][c]
            board[r][c] = "#"  # mark the cell as visited
            
            found = backtrack(r+1, c, curr+1) \
                    or backtrack(r, c+1, curr+1) \
                    or backtrack(r-1,c, curr+1) \
                    or backtrack(r,c-1, curr+1)
            
            board[r][c] = temp  # restore the cell
            
            return found
        
        # Iterate through each cell in the grid
        for r in range(self.rows):
            for c in range(self.cols):
                if board[r][c] == word[0] and backtrack(r, c, 0):
                    return True
                
        return False