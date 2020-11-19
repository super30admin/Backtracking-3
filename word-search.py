# Time Complexity: O((m*n)*3^l) - where l in length of word and m*n is number of cells
# Space Complexity: O(l) - Length of word
# Approach: Traverse over every cell and start a dfs at every letter that matches the first letter of the word. In the DFS function, mark the cell as visited (#), explore the neighbors.
# At every stage check if the neighbors are out of bounds or if the letter at the index does not match the letter of the word at the same index -> return False
# Undo/Backtrack at the end - revert # to the original value on the board.

class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        def getNeighbors(r, c, ROW, COLUMN):
        # ((up), (left), (down), (right))
            for nr, nc in ((r-1, c), (r, c-1), (r+1, c), (r, c+1)):           
                yield nr, nc
                    
        # DFS
        def dfs(row, col, index):
            # Base
            if index == len(word):
                return True
            if row < 0 or row >= ROW or col < 0 or col >= COLUMN or board[row][col] != word[index] or board[row][col] == '#':
                return False
            
            # Get current and mark it as visited - Action
            curr = board[row][col]
            board[row][col] = '#'
            
            # Call DFS on neighbors - Recurse
            for nr,nc in getNeighbors(row,col,ROW,COLUMN):
                if dfs(nr, nc, index+1):
                    return True
            
            # Backtrack
            board[row][col] = curr
            return False
                    
                    
        ROW = len(board)
        COLUMN = len(board[0])
        
        for r in range(ROW):
            for c in range(COLUMN):
                if word[0] == board[r][c]:
                    if dfs(r,c, 0):
                        return True
        return False
                   