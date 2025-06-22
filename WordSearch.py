# time since at each neighbour we have 3 direction it is 3^L where L is the depth and 3 is the branchings also since we are iterating to find first chara it is m*n *3^L
# space : o(L) recursive stack space 

from typing import List
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m,n=len(board), len(board[0])
        self.dir = [[0,1], [0,-1], [1,0], [-1,0]]
        def helper(board, r, c, word, idx):
            #base
            if r < 0 or r >= m or c < 0 or c >= n or board[r][c] != word[idx]:
                return False
            #logic
            if idx == len(word)-1 : return True
            # action
            board[r][c] = "#"
            # recurse
            for x,y in self.dir:
                nr = r+x
                nc = c+y
                if helper(board, nr,nc,word, idx+1): return True
            board[r][c] = word[idx]
            return False
        for i in range(m):
            for j in range(n):
                if helper(board, i,j, word, 0):
                    return True
        return False
        