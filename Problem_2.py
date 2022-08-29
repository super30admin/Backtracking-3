"""
Problem2
Word Search(https://leetcode.com/problems/word-search/)
"""

# Approach = 1
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        """
        using DFS and backtracking
        Time Complexity : O(m*N 2^l) l = len of word; and m= no of rows; m = no of col
        Spac ecomplexity : O(l)
        """
        if board == None or len(board) == 0 : return False
        
        m = len(board)
        n = len(board[0])
        dirs = [(1,0), (0,1),(-1, 0),(0,-1)]
        
        def backtrack_helper(board, i, j, word, idx):
            # base case
            if idx == len(word): return True
            if i < 0 or i == m or j < 0 or j==n or board[i][j]=="#" : return False
            
            
            # logic
            if board[i][j] == word[idx]:
                    
                    # Action
                    board[i][j] = "#"
                    # Recurse
                    for d in dirs:
                        nr = d[0] + i
                        nc = d[1] + j
                        if (backtrack_helper(board, nr, nc, word, idx + 1)): return True
                    # Back track
                    board[i][j] = word[idx]
        
        
        
        for i in range(m):
            for j in range(n):
                if word[0] == board[i][j]:
                    if (backtrack_helper(board, i, j, word, 0)== True): return True
                    
        return False
        