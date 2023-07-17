# Time Complexity : O(m*n*(3^L))
# Space Complexity : O(L)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        if not board or not board[0]:
            return False
        
        if not word:
            return True

        dirs = [(1,0), (-1,0), (0,-1), (0,1)]
        m = len(board)
        n = len(board[0])

        def dfs(board, r, c, word, idx):
            if board[r][c] == word[idx]:
                # action
                board[r][c] = "#"
                if idx+1 == len(word):
                    return True
            
                # recurse
                for (dr, dc) in dirs:
                    nr, nc = r+dr, c+dc
                    if 0<=nr<m and 0<=nc<n and board[nr][nc] != "#":
                        if (dfs(board, nr, nc, word, idx+1)):
                            return True
                # backtrack
                board[r][c] = word[idx]



        for r in range(m):
            for c in range(n):
                if board[r][c] == word[0]:
                    if dfs(board, r, c, word, 0):
                        return True
        return False