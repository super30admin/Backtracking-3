# Time Complexity : O(3^L) where L is the length of the word
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.dirs = [(1,0), (0,1), (-1, 0), (0, -1)]
    def exist(self, board: List[List[str]], word: str) -> bool:
        if len(board) == 0 or len(word) == 0:
            return False
        
        for i in range(len(board)):
            for j in range(len(board[0])):  
                if self.dfs(board, i, j, word, 0):
                    return True
        return False
            
            
    def dfs(self, board, r, c, word, i):
        #base
        if i == len(word):
            return True
        if r < 0 or c < 0  or r == len(board) or c == len(board[0]) or board[r][c] == '#':
            return False
        
        #logic
        if board[r][c] == word[i]:
            temp = board[r][c]
            board[r][c] = '#'
            
            for d in self.dirs:
                nr = r + d[0]
                nc = c + d[1]
                if(self.dfs(board, nr, nc, word, i+1)):
                    return True
            board[r][c] = temp
            
        return False