# Time Complexity : O(3^L)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])
        self.dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]
        
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == word[0]:
                    if self.dfs(board, word, i, j, 0):
                        return True
        return False
    
    def dfs(self, board, word, r, c, idx):
        if idx == len(word):
            return True
        
        if r < 0 or c < 0 or r == self.m or c == self.n or board[r][c] == '#':
            return False
        
        if word[idx] == board[r][c]:
            temp = board[r][c]
            board[r][c] = '#'
            
            for dir in self.dirs:
                nr = r + dir[0]
                nc = c + dir[1]
                if self.dfs(board, word, nr, nc, idx + 1):
                    return True
            
            board[r][c] = temp
        
        return False