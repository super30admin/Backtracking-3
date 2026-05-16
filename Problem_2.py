class Solution:
    def exist(self, board,word):
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        rows, cols = len(board), len(board[0])
        for r in range(rows):
            for c in range(cols):
                if board[r][c] == word[0]:
                    if self.dfs(r, c, board, word, 0, dirs):
                        return True
        return False

    def dfs(self, cr, cc, board, word, w_idx, dirs):
        if w_idx == len(word):
            return True
        if (
            0 > cr
            or cr >= len(board)
            or 0 > cc
            or cc >= len(board[0])
            or board[cr][cc] == "#"
        ):
            return False
        if board[cr][cc] != word[w_idx]:
            return False
        board[cr][cc] = "#"
        for x, y in dirs:
            nr, nc = cr + x, cc + y
            if self.dfs(nr, nc, board, word, w_idx + 1, dirs):
                return True
        board[cr][cc] = word[w_idx]
        return False
