# Time Complexity : Exponential
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.board = board
        self.visited = [[False for _ in range(len(board[0]))] for _ in range(len(board))]
        # print(self.visited)
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.helper(i, j, word): return True
        return False
                
                
    def helper(self, i, j, word):
        # Base Case
        if i < 0 or i >= len(self.board) or j < 0 or j >= len(self.board[0]) or self.visited[i][j]:
            return False
        
        
        # Logic
        dirs = [(-1,0),(1,0),(0,-1),(0,1)]
        if self.board[i][j] == word[0]:
            if len(word) == 1:
                return True
            self.visited[i][j] = True
            for d in dirs:
                r = i + d[0]
                c = j + d[1]
                if (self.helper(r, c, word[1:])): return True
            self.visited[i][j] = False
        return False