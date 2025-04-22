# Time Complexity: O(3^L)
# Space Complexity: O(L)
# Does this code run on Leetcode? Yes
# Did you face any problems while coding this? No

from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                if self.dfs(board, i, j, word, 0):
                    return True
        return False
        
    def dfs(self, board, i, j, word, idx):
        dirs = [(-1,0), (1,0), (0,-1), (0,1)]
        if idx == len(word):
            return True

        if i<0 or j<0 or i== len(board) or j == len(board[0]) or board[i][j] == '#':
            return False
        if board[i][j] != word[idx]:
            return False
        temp = board[i][j]
        board[i][j] = '#'
        for x,y in dirs:
            r = i+x
            c = j+y
            if self.dfs(board, r, c, word, idx+1): 
              return True
        board[i][j] = temp
        return False