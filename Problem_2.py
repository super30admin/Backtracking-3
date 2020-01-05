# Runs on Leetcode
    # Runtime - exponential
    # Memory - O(m*n), where m and n are # or rows and cols respectively

class Solution:
    def exist(self,board: list, word: str) -> bool:
        self.m, self.n = len(board), len(board[0])
        visited = [[0] * self.n for _ in range(self.m)]
        for i in range(self.m):
            for j in range(self.n):
                if self.dfs(i, j, word, visited, board):
                    return True
        return False
    
    def dfs(self,i, j, word, visited, board):
            if word == '':
                return True
            if i < 0 or j < 0 or i >= self.m or j >= self.n:
                return False
            if visited[i][j]:
                return False
            if board[i][j] != word[0]:
                return False
            visited[i][j] = 1
            if self.dfs(i + 1, j, word[1:], visited, board) or self.dfs(i - 1, j, word[1:], visited, board) or self.dfs(i, j + 1, word[1:], visited, board) or self.dfs(i, j - 1, word[1:], visited, board):
                return True
            visited[i][j] = 0
            return False
