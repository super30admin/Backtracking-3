# Time Complexity : Exponential but find it difficult to compute
# Space Complexity : Exponential but find it difficult to compute
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

class Solution:
    def __init__(self):
        self.dx = [-1,0,1,0]
        self.dy = [0,1,0,-1]
        
    def exist(self, board: List[List[str]], word: str) -> bool:
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0]:
                    if self.helper(board, word, i, j,m,n, 0):
                        return True
        return False
        
        
    def helper(self, board, word, i, j,m,n, index):
        if index == len(word):
            return True
        
        if self.isValid(i,j,m,n) and word[index] == board[i][j]:
            
            c = board[i][j]
            board[i][j] = '.'
            
            for k in range(4):
                if self.helper(board, word, i+self.dx[k], j+self.dy[k],m,n, index+1):
                    return True
            board[i][j] = c
            return False
        
        
        
        
    def isValid(self, x, y,m,n):
        return x>=0 and x<m and y>=0 and y<n
        