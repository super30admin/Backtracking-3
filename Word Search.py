class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m, n = len(board), len(board[0])
        found = False
        
        def backtrack(i, j, k):
            nonlocal m,n,found
            if found:
                return
            if i < 0 or i >= m or j < 0 or j >= n:
                return
            if board[i][j] == "#":
                return
            if board[i][j] != word[k]:
                return
            if k == len(word) -1:
                found = True
                return
            old_val = board[i][j]
            board[i][j] = "#"
            for di, dj in [(0,-1),(-1,0),(0,1),(1,0)]:
                backtrack(i+di, j+dj, k+1)
            board[i][j] = old_val
            
        for i in range(0, m):
            for j in range(0, n):
                if board[i][j] == word[0]:
                    backtrack(i, j, 0)
                if found:
                    break
                    
        return found