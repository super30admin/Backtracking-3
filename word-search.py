class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def helper(board: List[List[str]], word, idx, r, c):
            # base case
            if idx == len(word):
                return True
            if r < 0 or c < 0 or r == len(board) or c == len(board[0]):
                return False 

            # logic
            if board[r][c] == word[idx]:
                # action
                board[r][c] = "#"
                # recurse
                for dir in dirs:
                    nr = r + dir[0]
                    nc = c + dir[1]
                    if helper(board, word, idx + 1, nr, nc):
                        return True
                # backtrack
                board[r][c] = word[idx]
            return False
        
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                if word[0] == board[i][j]:
                    if helper(board, word, 0, i, j):
                        return True
        return False