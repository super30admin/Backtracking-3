"""
Time - : O(n^2) 
Space - : O(n)
Leetcode - Yes
Problems - no
"""

class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        def helper(board, start, word, i, j):
                        
            if(start >= len(word)):
                return True
            
            if(i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] != word[start]):
                return False
            
            
            temp = board[i][j]
            board[i][j] = "#"
            
            dirs = [[1, 0], [0, 1], [0, -1], [-1, 0]]
            for d in dirs:
                next_i = i + d[0]
                next_j = j + d[1]
                
                if(helper(board, start + 1, word, next_i, next_j)):
                    return True
                
            board[i][j] = temp
            return False
        
        start = 0
        for i in range(len(board)):
            for j in range(len(board[0])):
                if(board[i][j] == word[start]):
                    if(helper(board, start, word ,i, j)):
                        return True
                    
        return False
        
            