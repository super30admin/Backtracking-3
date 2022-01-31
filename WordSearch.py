# Recursive Approach without dictionary
# // Time Complexity : O(N^N) or O(N!)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this 

class Solution:
    dirs = list()
    m = int()
    n = int()
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])
        self.dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        
        if board == None or len(board) == 0:
            return False
        
        for i in range(self.m):
            for j in range(self.n):
                if self.backtrack(board, i, j, 0, word):
                    return True
    
    def backtrack(self,board, i, j, index, word):
        # base
        # positioning of this condition Also matters
        if index == len(word):
            return True
        
        if i < 0 or j < 0 or i == self.m or j == self.n or board[i][j] =='#':
            return False
        
        # logic
        if board[i][j] == word[index]:
            # action
            ch = board[i][j]
            board[i][j] = '#'
            for direction in self.dirs:
                r = i + direction[0]
                c = j + direction[1]
                # recurse
                if self.backtrack(board, r, c, index+1, word):
                    return True
            # backtrack    
            board[i][j] = ch
            
        return False
                
                
            