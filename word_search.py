# Time Complexity: O(m*n*3^n) where n is the length of word
# Space Complexity: O(n)
# Ran on Leetcode: Yes

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.found = False
        self.m = len(board)
        self.n = len(board[0])
        if not len(board):
            return False
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == word[0]:
                    self.helper(board, word, i, j, 0)
        return self.found
    
    def helper(self, board, word, i, j ,index):
        if index == len(word):
            self.found = True
            return
        if i < 0 or j < 0 or i >= self.m or j >= self.n:
            return
        
        if board[i][j] == word[index]:
            temp = board[i][j]
            board[i][j] = "#"
            direction = [[0, 1], [0, -1], [1, 0], [-1, 0]]
            for d in direction:
                self.helper(board, word, i + d[0], j + d[1], index + 1)
            board[i][j] = temp