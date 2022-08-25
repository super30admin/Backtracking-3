# Time Complexity: O(m*n*3^k) where k = len(word)
# Space Complexity: O(h) where h is the height of the tree which is k in this case
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board:
            return False
        m = len(board)
        n = len(board[0])
        
        if m == 1 and n==1:
            if board[0][0] == word:
                return True
            else:
                return False
        
        dirs = [(0,-1),(-1,0),(0,1),(1,0)]
        # visited = [[0 for _ in range(n)] for _ in range(m)]
        
        def backtrack(board,word,idx,r,c,m,n):
            # Base
            if r < 0 or c < 0 or r== m or c == n:
                return
            if idx ==len(word):
                return True
            # Logic
            if board[r][c] == word[idx]:
                temp = board[r][c]
                board[r][c] = '#'
                
                for d in dirs:
                    nr = r + d[0]
                    nc = c + d[1]
                    if backtrack(board,word,idx+1,nr,nc,m,n):
                        return True
                # Backtrack
                board[r][c] = temp
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0]:
                    if backtrack(board,word,0,i,j,m,n):
                        return True
        return False