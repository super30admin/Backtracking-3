class Solution:
    
    """
         Student : Shahreen Shahjahan Psyche
         Time : O(MN*3^L) [Where M*N is the size of the board and L is the length of the word]
         Space: O(1)
         
         Passed Test Cases in LC : Yes
    
    """
    
    def dfs(self, board, word, row, col, index):
        
        # base case
        if row >= len(board) or row < 0 or col >= len(board[0]) or col < 0 or board[row][col] == '#':
            return False
        
        
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        # action
        if board[row][col] == word[index]:
            temp_cal = board[row][col]
            board[row][col] = '#'
            if index == len(word) - 1:
                return True
            # recurse
            for d in dirs:
                if self.dfs(board, word, row+d[0], col+d[1], index + 1):
                    return True
            
            #backtrack
            board[row][col] = temp_cal
        return False
        
    
    
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        if not board:
            return True
        
        
        row = len(board)
        col = len(board[0])
        
        # iterating through the board
        for i in range(row):
            for j in range(col):
                if self.dfs(board, word, i, j, 0):
                    return True 
                    
        return False
